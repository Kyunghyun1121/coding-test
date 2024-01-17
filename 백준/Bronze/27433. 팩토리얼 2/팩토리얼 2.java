import java.io.*;
import java.math.BigInteger;
import java.sql.Array;
import java.util.*;


public class Main {

    static long cal(long num, long sum){
        if(num == 1){
            return sum;
        }else{
            return cal(num-1, sum) * num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int cas = Integer.parseInt(br.readLine());

        if(cas == 0){
            System.out.println(1);
        }else{
            System.out.println(cal(cas, 1));
        }


        //bw.flush();
    }


}
