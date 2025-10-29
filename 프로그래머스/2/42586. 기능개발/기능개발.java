import java.util.*;

class Solution {
    public ArrayDeque<Integer> solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int days = 0;
        
        ArrayDeque<Integer>q = new ArrayDeque<>();
        int nowDay = 1;
        for(int i = 0; i < progresses.length;){
            int remain = 100 - progresses[i];
            if(speeds[i] * nowDay >= remain){
                if(i == progresses.length - 1){
                    q.add(days+1);
                }
                days++;
                i++;
            }else{
                if(days != 0){
                    q.add(days);
                    days = 0;
                }
                nowDay++;
            }
        }
        
        
        
        return q;
    }
}