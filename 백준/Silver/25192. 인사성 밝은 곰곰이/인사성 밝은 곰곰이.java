import java.io.*;
import java.math.BigInteger;
import java.sql.Array;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder bw = new StringBuilder();

        int cas = Integer.parseInt(br.readLine());
        int out = 0;

        Deque<String> log = new ArrayDeque<>();
        HashSet<String> l = new HashSet<>();
        for( int i = 1; i<= cas; i++){
            String input = br.readLine();

            if(input.equals("ENTER")){
                l = new HashSet<>();
            }else{
                if(!l.contains(input)){
                    l.add(input);
                    out++;
                }
            }

        }

        bw.append(out);

        System.out.println(bw);
    }


}


