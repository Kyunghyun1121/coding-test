class Solution
{
    public int solution(int[][]matrix)
    {
        int answer = 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int[][]dp = new int[m+1][n+1];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 1)
                    dp[i][j] = 1;
            }
        }

        for(int i = 1; i < m; i++){
            for(int j = 1 ; j < n; j++){

                int t = matrix[i-1][j] + matrix[i][j-1] 
                + matrix[i-1][j-1] + matrix[i][j];

                if(t == 4){
                    int min = Math.min(
                        Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]);
                    dp[i][j] = min + 1;
                }
                
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] *= dp[i][j];
                answer = Math.max(dp[i][j], answer);
            }
        }

        return answer;
    }
}