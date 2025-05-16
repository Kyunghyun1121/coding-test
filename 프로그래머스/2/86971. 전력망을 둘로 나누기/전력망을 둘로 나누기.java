import java.util.*;

class Solution {
    boolean[] visited = new boolean[101];
    ArrayList<ArrayList<Integer>>connect;
    
    public int dfs(int n){
        int sum = 1;
        
        visited[n] = true;
        //System.out.println( n + " " + connect.get(n));
        for(int i : connect.get(n)) {
            if(!visited[i]){
                //System.out.println(n + " " + dfs(i));
                sum += dfs(i);
            }
        }
        //System.out.println(n + " " + sum);
        return sum;
    }
    
    public int solution(int n, int[][] wires) {
        int answer = 100000;
        
        connect = new ArrayList<>();
        for(int j = 0; j <= n + 1; j++){
            connect.add(new ArrayList<Integer>());
            //connect.get(j).add(101);
        }
            
        
        //System.out.println(connect.size());
        for(int j = 0; j < wires.length; j++){
            //System.out.println(wires[j][0] + " " + wires[j][1]);
            connect.get(wires[j][0]).add(wires[j][1]);
            connect.get(wires[j][1]).add(wires[j][0]);
        }
        
        //print();
            
        
        for(int i = 0; i < wires.length; i++){
            int cutA = wires[i][0];
            int cutB = wires[i][1];
            //System.out.println(connect.get(cutB).remove(cutA));
            connect.get(cutA).remove((Integer)cutB);
            connect.get(cutB).remove((Integer)cutA);
            
            visited = new boolean[101];
            int one = -1;
            int two = -1;
            //print();
            
            for(int j = 1; j <= n; j++){
                if(!visited[j]){
                    if(one == -1) one = dfs(j);
                    else{
                       two = dfs(j); 
                        break;
                    } 
                }
            }
            
            // System.out.println();
            // System.out.println(one + " " + two);
            // System.out.println();
            
            answer = Math.min(answer, Math.abs(one - two));
            connect.get(cutA).add(cutB);
            connect.get(cutB).add(cutA);
        }
        
        return answer;
    }
    public void print(){
                int l = 0;
        for(ArrayList<Integer> i : connect){
            System.out.print(l + ": ");
            for(int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
            l++;
        }
    }
}