import java.util.*;

class Solution {
    boolean[]rem; 
    ArrayList<ArrayList<Integer>>arr = new ArrayList<>();
    int n = 0;
    
    public void dfs(int num){
        rem[num] = true;
        //System.out.println(num);
        while(!arr.get(num).isEmpty()){
            int temp = arr.get(num).remove(0);
            if(!rem[temp])dfs(temp);
        }
    }
    
    
    public int solution(int m, int[][] computer) {
        
        int answer = 0; n = m;
        for(int i = 0; i < n; i++)arr.add(new ArrayList<>());
        
        rem = new boolean[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j && computer[i][j] == 1){
                    arr.get(i).add(j);
                    arr.get(j).add(i);
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            if(!arr.get(i).isEmpty() && !rem[i]){
                //System.out.println();System.out.println();
                dfs(i);
                answer++;
            }
        }
        
        for(int i = 0; i < n; i++)if(!rem[i])answer++;
        
        return answer;
    }
}