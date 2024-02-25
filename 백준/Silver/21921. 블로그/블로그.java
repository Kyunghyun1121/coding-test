import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] visitor = new int[N+1];
        int[] sum = new int[N+1];
        for (int i = 1; i <= N; i++) {
            visitor[i] = Integer.parseInt(st.nextToken());
            sum[i] = visitor[i] + sum[i-1];
        }
        int max = 0;
        int maxCount = 1;
        for (int i = 0; i + X <= N; i++) {
            int temp = sum[i+X]-sum[i];
            if(temp>max){
                maxCount = 1; max = temp;
            }else if(temp == max)maxCount++;
        }
        if(max == 0) System.out.println("SAD");
        else{
            System.out.println(max);
            System.out.println(maxCount);
        }

    }


}
