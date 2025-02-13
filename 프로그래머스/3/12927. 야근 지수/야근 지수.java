import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer>arr = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < works.length; i++)   arr.add(works[i]);
        
        
        for(int i = 0; i < n; i++){
            int temp = arr.remove();
            if(temp>0)arr.add(temp-1);
            else arr.add(temp);
        }
        
        for(int i : arr){
            answer += i*i;
        }
        
        
        return answer;
    }
}