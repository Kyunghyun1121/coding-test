import java.util.*;

class Solution {
    int t;
    int answer = 0;
    
    
    public void circle(int count, int sum, int[] numbers){
        if(count == numbers.length){
            if(t == sum)answer++;
            
            return;
        }
        
        circle(count + 1, sum + numbers[count], numbers);
        circle(count + 1, sum - numbers[count], numbers);
    }
    
    public int solution(int[] numbers, int target) {
        
        t = target;
        circle(0,0,numbers);
        
        
        
        return answer;
    }
}