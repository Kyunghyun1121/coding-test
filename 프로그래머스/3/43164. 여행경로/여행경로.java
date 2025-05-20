import java.util.*;

class Solution {
    int n;
    String[][] ticket;
    String[] answer = {};
    boolean k = false;
    
    public void dfs(int num, boolean[]visited, String[] rem){

        
        if(num == n){
            compare(rem);
            return;
        }
        
        for(int i = 0; i < n; i++){
            if(!visited[i] && rem[num].equals(ticket[i][0])){
                rem[num + 1] = ticket[i][1];
                visited[i] = true;
                dfs(num + 1, visited, rem);
                visited[i] = false;
            }
        }
        
    }
    
    public void compare(String[] rem){
        //for(String s : rem)System.out.print(s + " ");
        //System.out.println();
        
        if(!k){
            for(int j = 0; j <= n; j++)answer[j] = rem[j];
            k = true;
            return;
        }
        
        for(int i = 0; i < n; i++){
            if(!answer[i].equals(rem[i])){
                //System.out.println(answer[i] + " " + rem[i] + " " + answer[i].compareTo(rem[i]));
                if(answer[i].compareTo(rem[i]) > 0){
                    for(int j = 0; j <= n; j++)answer[j] = rem[j];
                }
                return;
            }
        }
    }
    
    public String[] solution(String[][] tickets) {
        n = tickets.length;
        //answer = new String[n];
        ticket = tickets;
        String[] t = new String[n+1];
        answer = new String[n + 1];
        t[0] = "ICN";
        
        boolean[] v = new boolean[n+1];
        for(int i = 0; i < n; i++){
            if(ticket[i][0].equals("ICN")){
                t[1] = ticket[i][1];
                v[i] = true;
                dfs(1, v, t);
                v[i] = false;
            }
        }
        
        
        return answer;
    }
}