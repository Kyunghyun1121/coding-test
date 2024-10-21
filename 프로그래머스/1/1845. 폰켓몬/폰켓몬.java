import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Arrays.sort(nums);
        
        int count = 0;
        boolean[]check = new boolean[nums[nums.length-1]+10];
        for(int i = 0; i < nums.length; i++){
            if(!check[nums[i]]){
                check[nums[i]] = true;
                count++;
            }
        }
        
        if(nums.length/2 <= count) answer = nums.length/2;
        else answer = count;
        return answer;
    }
}