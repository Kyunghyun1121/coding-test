import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        for(int i = citations[citations.length - 1]; i >=0; i--){
            int j = citations.length - 1; int count = 0;
            while(j >= 0 && citations[j--] >= i)count++;
            
            if(count >= i){
                answer = i; break;
            }
        }
        
        return answer;
    }
}