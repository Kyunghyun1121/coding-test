import java.io.*;
import java.math.BigInteger;
import java.sql.Array;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder bw = new StringBuilder();

        int cas = Integer.parseInt(br.readLine());
        int out = 1;
        for( int i = 1; i<= cas; i++){
            out*=2;
        }
        bw.append(out);


        System.out.println(bw);
    }


}