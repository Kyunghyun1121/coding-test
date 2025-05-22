import java.util.*;
class Solution {
    
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int remStart = 0;
        int remEnd = 0;
        int minLen = 1000001;
        int sum = sequence[0];
        while(remStart <= remEnd && remEnd < sequence.length){
            //System.out.println(remStart + " " + remEnd + " " + sum + " " + minLen);
            if(remStart == remEnd)sum = sequence[remEnd];
            
            if(sum < k){
                remEnd++;
                if(remEnd < sequence.length)sum += sequence[remEnd];
            }else if(sum == k){
                if(minLen > remEnd - remStart){
                    answer[0] = remStart;
                    answer[1] = remEnd;
                    minLen = remEnd - remStart;
                }
                remEnd++;
                if(remEnd < sequence.length)sum += sequence[remEnd];
            }else{
                sum -= sequence[remStart];
                remStart++;
            }
        }
        
        remEnd = sequence.length - 1;
        while(remStart <= remEnd){
            //System.out.println(remStart + " " + remEnd + " " + sum + " " + minLen);
            
            if(sum == k){
                if(minLen > remEnd - remStart){
                    answer[0] = remStart;
                    answer[1] = remEnd;
                    minLen = remEnd - remStart;
                }
                break;
            }
            sum -= sequence[remStart];
            remStart++;
        }
        
        return answer;
    }
}