import java.util.*;
class Solution {
    
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int start = 0;
        int end = 0;
        int remLen = 10000001;
        long sum = sequence[0];
        while(end < sequence.length && start <= end){
            //System.out.println(start + " " + end + " " + sum);
            
            if(start == end){
                if(sum == k){
                        if(remLen > end - start + 1){
                            answer[0] = start;
                            answer[1] = end;
                            remLen = end - start + 1;
                        }
                        sum -= sequence[start];
                        start++;
                    }
                if(end == sequence.length - 1){
                    break;
                }
                end++;
                sum += sequence[end];
            }
            
                if(sum == k){
                    //System.out.println(start + " " + end + " " + sum);
                    if(remLen > end - start + 1){
                        answer[0] = start;
                        answer[1] = end;
                        remLen = end - start + 1;
                    }
                    sum -= sequence[start];
                    start++;
                }else if(sum < k){
                    
                    end++;
                    if(end < sequence.length) sum += sequence[end];
                    
                }else{
                    sum -= sequence[start];
                    start++;
                }
            
            
            
        }
        
        return answer;
    }
}