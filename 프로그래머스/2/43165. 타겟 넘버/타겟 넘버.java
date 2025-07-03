import java.util.*;

class Solution {
    int count = 0;
    
    public void dfs(int num, int sum, int target, int[]numbers){
        if(num == numbers.length){
            if(sum == target) count++;
            return;
        }
        
        dfs(num+1, sum + numbers[num], target, numbers);
        dfs(num+1, sum - numbers[num], target, numbers);
        
    }
    
    public int solution(int[] numbers, int target) {
        dfs(0,0,target,numbers);
        return count;
    }
}