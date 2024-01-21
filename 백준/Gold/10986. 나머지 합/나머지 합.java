import java.io.*;
import java.math.BigInteger;
import java.sql.Array;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        long out = 0;
        long sum[] = new long[1000001];
        long rem[] = new long[1000001];
        stringTokenizer = new StringTokenizer(br.readLine());
        sum[0] = 0;
        for(int i = 1; i<= N; i++){
            int num = Integer.parseInt(stringTokenizer.nextToken());
            sum[i] = (num + sum[i - 1])%M;
            if(sum[i] == 0)out++;
            rem[(int) sum[i]]++;
        }

        for(int i = 0; i< M; i++){
            if(rem[i]!=0){
                out+=(rem[i]*(rem[i]-1))/2;
            }
        }


        System.out.println(out);

    }




}
