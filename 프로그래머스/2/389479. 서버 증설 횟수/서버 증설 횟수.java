import java.util.*;
class Solution {
    class time{
        int t = 0;
        int server = 0;
        public time(int a, int b){
            t = a; server = b;
        }
    }
    
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        time[]arr = new time[24];
        for(int i = 0; i<24; i++){
            arr[i] = new time(i, m);
        }
        // for(int j = 0; j < 24; j++)System.out.print(j%10+" ");
        // System.out.println();
        
        for(int i = 0; i< 24; i++){
            if(players[i] >= arr[i].server){
                int plus = arr[i].server - m;
                int n = players[i] / m;
                if(plus >= n)continue;
                
                int add = players[i] / m - plus;
                for(int j = i; j < i + k && j < 24; j++){
                    arr[j].server += add;
                }

                answer += add;
             }          //  System.out.print(i+ " ");
            // for(int j = 0; j < 24; j++)System.out.print(arr[j].server-m+" ");
            //     System.out.println();
        }
        
        
        return answer;
    }
    
}