import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        int []arr = new int[num+1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = -1;

        int []dp = new int[num+1];
        dp[1] = arr[1];
        dp[2] = Math.max(arr[2], arr[1] * 2);
        for(int i = 3; i <= num; i++){
            dp[i] = arr[i];
            for(int j = 1; j < i; j++){
                int k = i / j;
                dp[i] = Math.max(dp[i], dp[i % j] + dp[j] * k);
                //System.out.println(j + " " + dp[i % j] + " " + k);
            }
            //System.out.println(dp[i]);
        }


        sb.append(dp[num]);
        System.out.println(sb);
    }

}
