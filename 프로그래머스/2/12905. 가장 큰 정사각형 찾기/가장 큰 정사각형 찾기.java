import java.util.*;
class Solution
{
    public int solution(int [][]board)
    {
        int answer = 1234; int y = board.length;
        int x = board[0].length;
        int avail = 1; 
        int[][]dp = new int[y][x]; int max = 0;
        for(int i = 0; i< y; i++){
            for(int j = 0; j < x; j++){
                if(i==0 || j==0){
                    dp[i][j] = board[i][j]; 
                    max = Math.max(dp[i][j], max);
                    continue;
                }
                
                if(board[i][j] == 1){
                    int min = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                    if(min==0)dp[i][j] = 1;
                    else dp[i][j] = min+1;
                    max = Math.max(dp[i][j], max);
                }else{
                    dp[i][j] = 0;
                }
                
            }
        }
        

        

        return max*max;
    }
}