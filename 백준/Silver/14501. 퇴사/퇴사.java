import java.io.*;
import java.util.*;

import static java.lang.Math.max;
import static java.util.Arrays.sort;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        int[] use = new int[num];
        int[] money = new int[num];
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            use[i] = Integer.parseInt(st.nextToken());
            money[i] = Integer.parseInt(st.nextToken());
        }

        int out = 0;
        int[] dp = new int[num+10];
        for (int i = 0; i < num; i++) {
            out = max(out,dp[i]);
            if(use[i] + i <= num){
                
                dp[i + use[i]] = max(dp[i + use[i]], out + money[i]);

                //dp[i] = max(dp[i], out);
                //System.out.println(dp[i]);
            }
            dp[i] = out;
        }
        for (int i = 0; i <= num; i++) {
            out = max(out,dp[i]);
        }


        System.out.println(out);

    }


}
