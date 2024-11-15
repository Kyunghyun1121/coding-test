import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int little = 0; int big = 0;
        
        PriorityQueue<Integer>arr = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++){
            arr.add(scoville[i]);
        }

        
        while(arr.size() > 1 && arr.peek()<K){
            //System.out.println(little + " " + big);
            
            int a = arr.poll();
            int b = arr.poll();
            if(a >= K)break;
            arr.add(a+(b*2));
            answer++;
        }
        
        if(arr.size() < 2 && arr.peek() < K)answer = -1;
        return answer;
    }
}