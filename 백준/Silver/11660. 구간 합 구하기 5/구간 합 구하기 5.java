import java.io.*;
import java.math.BigInteger;
import java.sql.Array;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        long out = 0;
        long sum[][] = new long[1025][1025];
        long rem[] = new long[1000001];


        for(int i = 1; i<= N; i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            for(int j =1; j<= N; j++){
                int num = Integer.parseInt(stringTokenizer.nextToken());
                sum[i][j] = sum[i-1][j] + num;
            }

        }

        int sx, sy, ex, ey;
        for(int i = 0; i< M; i++){

            stringTokenizer = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(stringTokenizer.nextToken());
            sy = Integer.parseInt(stringTokenizer.nextToken());
            ex = Integer.parseInt(stringTokenizer.nextToken());
            ey = Integer.parseInt(stringTokenizer.nextToken());

            out = 0;
            for(int j = sy; j <= ey; j++){
                out+=(sum[ex][j] - sum[sx-1][j]);
            }

            sb.append(out).append('\n');
        }


        System.out.println(sb);

    }




}
