class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] sum = new int[n+1];
        sum[0] = 0;
        for(int i= 1; i <= n; i++){
            sum[i] = sum[i-1] + i;
        }
        
        int i = 0; int j = 1;
        while(i < j){
            if(j > n)break;
            int plus = sum[j] - sum[i];
            if(plus < n){
                j++;
            }else if(plus > n){
                i++;
            }else{
                j++; i++; answer++;
            }
        }
        
        return answer;
    }
}