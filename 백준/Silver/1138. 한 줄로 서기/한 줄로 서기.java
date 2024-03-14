import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int cas = Integer.parseInt(br.readLine());
        int[] in = new int[11];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cas; i++) {
            in[i] = Integer.valueOf(st.nextToken());
        }

        int[]out = new int[cas+1];
        for (int i = 0; i < cas; i++) {
            out[i] = -1;
        }

        for (int i = 0; i < cas; i++) {
            int count = 0;
            int j = 0;
            while (count < in[i]){
                if(out[j] == -1)count++;
                j++;
            }
            while (out[j] != -1)j++;
//            System.out.println(j);
            out[j] = i;
        }

        for (int i = 0; i < cas; i++) {
            sb.append(out[i]+1).append(" ");
        }



        System.out.println(sb);
    }


}
