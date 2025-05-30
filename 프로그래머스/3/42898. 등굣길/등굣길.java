import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        
        int[][]dp = new int[n][m];
        boolean[][]rem = new boolean[n][m];
        for(int i = 0; i < puddles.length; i++){
            dp[puddles[i][1]-1][puddles[i][0]-1] = 0;
            rem[puddles[i][1]-1][puddles[i][0]-1] = true;
        }
        
        for(int i = 0; i < m; i++){
            if(rem[0][i])break;
            dp[0][i] = 1;
        }
        for(int i = 0; i < n; i++){
            if(rem[i][0])break;
            dp[i][0] = 1;
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(!rem[i][j])
                    dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000007;
            }
        }
        
        /*for(int i= 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(dp[i][j]+" ");
            }System.out.println();
        }*/
        
        
        return dp[n-1][m-1] % 1000000007;
    }
}