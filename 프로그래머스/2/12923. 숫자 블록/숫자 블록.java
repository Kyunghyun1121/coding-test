import java.util.*;
class Solution {
    public long[] solution(long begin, long end) {
        int len = (int)(end - begin);
        long[] answer = new long[len+1];
        
        long num = begin;

        
        for(int i = 0; i <= len; i++){
            //System.out.println("num = " + num + " half = "+half);
            
            answer[i] = 1; long rem = 1;
            for(long j = 2; j <= (long)Math.sqrt(num); j++){
                if(num % j == 0){
                    if(num / j <= 10000000){
                        answer[i] = num / j;
                        break;
                    }
                    rem = j;
                }
            }
            if(answer[i] == 1)answer[i] = rem;
            num++;
        }
        
        if(begin == 1) answer[0] = 0;
        
        
        return answer;
    }
}