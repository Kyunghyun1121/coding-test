import java.util.*;
class Solution {
    ArrayList<ArrayList<Integer>>arr = new ArrayList<>();
    int[]rem;
    boolean[]visited;
    public void dfs(int now, int len){
        if(rem[now] == 0 || rem[now] >= len)rem[now] = len;
        
        for(int i : arr.get(now)){
            //System.out.println(now + " " + i);
            if(rem[i] > len + 1 || rem[i] == 0){
                dfs(i, len + 1);
            }
        }
    }
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        for(int i = 0; i <= n; i++) arr.add(new ArrayList<>());
        for(int i = 0; i < edge.length; i++){
            arr.get(edge[i][0]).add(edge[i][1]);
            arr.get(edge[i][1]).add(edge[i][0]);
        }
        rem = new int[n+1];
        visited = new boolean[n+1];
        
        dfs(1,0);
        
        int maxNum = -1;
        for(int i = 2; i <= n; i++){
            if(rem[i] > maxNum){
                maxNum = rem[i];
                answer = 1;
            }else if(rem[i] == maxNum){
                answer++;
            }
        }
        
        
        return answer;
    }
}