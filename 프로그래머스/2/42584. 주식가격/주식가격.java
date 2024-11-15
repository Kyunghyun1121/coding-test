import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length; i++){
            int j = i+1;
            while(j < prices.length-1 && prices[i] <= prices[j])j++;
            answer[i] = j - i;
        }
        answer[prices.length-1] = 0;
        return answer;
    }
}