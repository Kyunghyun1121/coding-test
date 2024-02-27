import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] in = br.readLine().toCharArray();
        boolean[] check = new boolean[N + 1];

        int out = 0;


        for (int j = 0; j < N; j++) {
            if (in[j] == 'H' || check[j]) continue;

            for (int i = K; i > 0; i--) {
                if (j - i >= 0 && in[j - i] == 'H' && !check[j - i]) {
                    out++;
//                    System.out.println(j);
                    check[j] = true;
                    check[j - i] = true;
                    break;
                }
            }
            if(check[j])continue;

            for (int i = 1; i <= K; i++) {
                if (j + i < N && !check[j + i] && in[j + i] == 'H') {
                    out++;
//                    System.out.println(j);
                    check[j] = true;
                    check[j + i] = true;
                    break;
                }
            }
        }


        System.out.println(out);

    }


}
