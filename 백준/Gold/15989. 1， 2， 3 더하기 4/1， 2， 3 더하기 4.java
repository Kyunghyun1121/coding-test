import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int cas = Integer.parseInt(st.nextToken());
        int[][] out = new int[10001][5];
        out[1][4] = 1;
        out[1][2] = 0;out[1][1] = 1;out[1][3] = 0;
        out[2][4] = 2;out[2][1] = 1;out[2][2] = 1;out[2][3] = 0;
        out[3][4] = 3;out[3][1] = 1;out[3][2] = 1;out[3][3] = 1;

        for (int i = 0; i < cas; i++) {
            int in = Integer.parseInt(br.readLine());

            if(out[in][4] != 0){
                sb.append(out[in][4]).append('\n');
            }else{
                for (int j = 4; j <= in; j++) {
                    out[j][1] = out[j-1][1];
                    out[j][2] = out[j-2][2] + out[j-2][1];
                    out[j][3] = out[j-3][4];
                    out[j][4] = out[j][1] + out[j][2] + out[j][3];
                }
                sb.append(out[in][4]).append('\n');
            }
        }

        System.out.println(sb);
    }


}
