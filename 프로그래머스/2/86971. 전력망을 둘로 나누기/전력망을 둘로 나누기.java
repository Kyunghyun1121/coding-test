import java.util.*;

class Solution {

    public int solution(int n, int[][] wires) {
        int answer = 100000;
        ArrayList<ArrayList<Integer>>list = new ArrayList<>();
        for(int i = 0; i <= n; i++) list.add(new ArrayList<Integer>());
        for(int i = 0; i < wires.length; i++){
            list.get(wires[i][0]).add(wires[i][1]);
            list.get(wires[i][1]).add(wires[i][0]);
        }
        
        for(int i = 0; i < wires.length; i++){
            boolean[]visit = new boolean[n + 1];
            list.get(wires[i][0]).remove((Object)wires[i][1]);
            list.get(wires[i][1]).remove((Object)wires[i][0]);
            ArrayDeque<Integer>q = new ArrayDeque<>();
            q.add(1);
            visit[1] = true;
            int one = 0;
            while(!q.isEmpty()){
                int t = q.remove();
                one++;
                for(int temp : list.get(t)){
                    if(!visit[temp]){
                        visit[temp] = true;
                        q.add(temp);
                    }
                }
            }
            
            answer = Math.min(answer, Math.abs((n - one) - one));
            
            
            list.get(wires[i][0]).add(wires[i][1]);
            list.get(wires[i][1]).add(wires[i][0]);
        }
        
        
        
        return answer;
    }

    
}