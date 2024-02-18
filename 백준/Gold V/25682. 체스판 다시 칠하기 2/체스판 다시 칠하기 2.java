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
        int K = Integer.parseInt(stringTokenizer.nextToken());

        long out = 1000000000;
        int cB[][] = new int[2001][2001];
        int cW[][] = new int[2001][2001];


        for(int i = 1; i<= N; i++){
            String in = br.readLine();

            for(int j =1; j<=M; j++){
                char line = in.charAt(j-1);
                cB[i][j] = cB[i-1][j] + cB[i][j-1] - cB[i-1][j-1];
                cW[i][j] = cW[i-1][j] + cW[i][j-1] - cW[i-1][j-1];

                if((i%2!=0 && j%2!=0) || (i%2==0 && j%2==0)){
                    if(line == 'B'){
                        cW[i][j]++;
                    }else{
                        cB[i][j]++;
                    }
                }else{
                    if(line == 'B'){
                        cB[i][j]++;
                    }else{
                        cW[i][j]++;
                    }
                }
            }
        }
        

        for(int i = 0; i+K<=N; i++){
            for(int j = 0; j+K<=M;j++){
                out = Math.min(out, cB[i+K][j+K]+cB[i][j]-cB[i+K][j]-cB[i][j+K]);
                out = Math.min(out, cW[i+K][j+K]+cW[i][j]-cW[i+K][j]-cW[i][j+K]);
            }
        }



        System.out.println(out);

    }

    

}
