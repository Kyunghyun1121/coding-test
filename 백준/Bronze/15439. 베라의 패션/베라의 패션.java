import java.io.*;
import java.math.BigInteger;
import java.sql.Array;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder bw = new StringBuilder();

        int cas = Integer.parseInt(br.readLine());
        long out = cas * (cas-1);
        bw.append(out);


        System.out.println(bw);
    }


}


