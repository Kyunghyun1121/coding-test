import java.util.*;
class Solution {
    public int solution(int sticker[]) {
        int answer = -1;

        //System.out.println("Hello Java");
        int len = sticker.length;
        
        if(len == 1)return sticker[0];
        
        boolean[]rem = new boolean[len];
        int[][]dp = new int[len][3];    //0은 자기자신을 고르기, 1은 자기를 안고르기
        //for(int i = 0; i < len; i++)dp[i][0] = sticker[i];        
        for(int i = 1; i < len; i++){
            dp[i][0] = dp[i - 1][1] + sticker[i];
            dp[i][1] = dp[i - 1][2];
            dp[i][2] = Math.max(dp[i][0], dp[i][1]);
        }
        
        int[][]d = new int[len][3];
        d[0][0] = sticker[0];
        d[0][2] = sticker[0];
        for(int i = 1; i < len - 1; i++){
            d[i][0] = d[i - 1][1] + sticker[i];
            d[i][1] = d[i - 1][2];
            d[i][2] = Math.max(d[i][0], d[i][1]);
        }
        
        answer = Math.max(d[len-2][2], dp[len-1][2]);
        return answer;
    }
}