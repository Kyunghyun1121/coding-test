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
        st = new StringTokenizer(br.readLine());

        int[]arr = new int[num]; int c = num-1;int[]dp = new int[num];
        for (int i = 0; i < num; i++) {
            dp[i] = 1;
            arr[c--] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < num; i++) {
            int temp = arr[i];
            for (int j = 0; j < i; j++) {
                if(arr[j] < temp){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int out = -1;
        for(int i : dp) out = Math.max(out, i);
        System.out.println(num - out);;

    }


}
