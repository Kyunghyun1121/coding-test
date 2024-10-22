class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int[]dp = new int[sequence.length+1];
        dp[0] = sequence[0];
        
        for(int i = 1; i < sequence.length; i++){
            dp[i] = dp[i-1] + sequence[i];
        }
        
        int minCount = 1000001;
        /*for(int i = 0; i < sequence.length; i++){
            for(int j = i; j < sequence.length; j++){
                int sum = dp[j] - dp[i] + sequence[i];
                //System.out.println(i + " " + j + " " + sum + " " + minCount);
                if(sum == k && minCount > j - i + 1){
                    minCount = j - i + 1;
                    answer[0] = i; answer[1] = j;
                }
            }
        }*/
        int sum = 0;
        int start = 0; int end = 0;
        while(start <= end && end < sequence.length){
                sum = dp[end] - dp[start] + sequence[start];
                if(sum == k && minCount > end-start+1){
                    minCount = end-start+1;
                    answer[0] = start; answer[1] = end;
                }else if(sum < k){
                    end++;
                }else{
                    start++;
                }
        }

        return answer;
    }
}