import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[]arr = new int[N+1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0;
        int j = 0;
        int[]check = new int[100001];
        int out = -1;

        while(i<=j){
            int t = arr[j];

            if(j<N && check[t] < K){
                check[t]++;
                j++;
            }else if(check[t] == K){
                check[arr[i]]--;
                i++;
            }
//            System.out.println(i + " " + j + " " + check[t]);
            out = Math.max(out, j - i);
            if(j==N)break;
        }

        System.out.println(out);
    }


}
