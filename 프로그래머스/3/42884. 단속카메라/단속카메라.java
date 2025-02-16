import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, new Comparator<>(){
            @Override
            public int compare(int[]a, int b[]){
                return a[1] - b[1];
            }
        });
        
        int m = routes[0][1]; answer++;
        for(int i = 1; i < routes.length; i++){
            if(m < routes[i][0]){
                answer++;
                m = routes[i][1];
            }
        }
        
        //for(int[]a : routes)System.out.println(a[0] + " " + a[1]);
        
        return answer;
    }
}