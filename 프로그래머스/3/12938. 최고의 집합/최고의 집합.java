import java.util.*;
class Solution {
    
    public int[] solution(int n, int s) {
        int[] answer = {};
        
        PriorityQueue<Integer>arr = new PriorityQueue<>();
        int divide = s / n;
        
        if(divide < 1){
            answer = new int[1];
            answer[0] = -1;
        }else{
            answer = new int[n];
            for(int i = 0; i < n; i++){
                answer[i] = divide;
            }
            divide = s % n;
            
            for(int i = n - 1; 0 < divide; i--){
                answer[i]++;
                divide--;
            }
        }
        
        
        return answer;
    }
}