import java.util.*;

class Solution {
    
    int all = 0;
    ArrayList<ArrayList<Integer>>wire = new ArrayList<>();
    int out = 100000;
    
    public int solution(int n, int[][] wires) {
        int answer = -1;
        all = n;
        int root = -1;
        
        for(int i = 0; i <= n; i++){
            wire.add(new ArrayList<>());
        }
        
        for(int i = 0; i < wires.length; i++){
            int one = wires[i][0];
            int two = wires[i][1];
            wire.get(one).add(two);
            wire.get(two).add(one);
        }
        
        root = 1;
        for(int i = 0; i <= n; i++){
            if(root == i)continue;
            if(wire.get(root).size() < wire.get(i).size())root = i;
        }
        int t = dfs(root, new boolean[n+1]);
        
        return out;
    }
    
    
    public int dfs(int num, boolean[]rem){
        int answer = 1;
        rem[num] = true;
        for(int t : wire.get(num)){
            if(!rem[t]){
                answer += dfs(t, rem);
            }
        }
        rem[num] = false;
        out = Math.min(out, Math.abs(all - answer - answer));
        
        return answer;
        
    }
}