import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int height = triangle.length;
        int len = 2;
        int[][]dp = new int[height][height];
        dp[0][0] = triangle[0][0];
        dp[0][height-1] = triangle[0][0];
        //System.out.println(height);
        
        int l = 1;
        for(int i = 1; i < height; i++) {
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            dp[i][l] = dp[i-1][l-1] + triangle[i][l++];
        }
        
 
        
        for(int i = 2; i < height; i++){
            for(int j = 1; j < len; j++){
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
            len++;
        }        

        
        for(int i = 0; i < height; i++)    answer = Math.max(answer, dp[height-1][i]);
        
        return answer;
    }
}