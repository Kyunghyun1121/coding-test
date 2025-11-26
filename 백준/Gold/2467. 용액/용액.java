import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int left = 0;
        int right = N - 1;

        long bestSum = Long.MAX_VALUE;
        long ans1 = 0, ans2 = 0;

        while(left < right) {
            long sum = arr[left] + arr[right];

            // 0과 가장 가까운 값 갱신
            if(Math.abs(sum) < bestSum) {
                bestSum = Math.abs(sum);
                ans1 = arr[left];
                ans2 = arr[right];
            }

            // sum이 음수면 작은 수를 증가
            if(sum < 0) left++;
            else right--;
        }

        System.out.println(ans1 + " " + ans2);
    }
}