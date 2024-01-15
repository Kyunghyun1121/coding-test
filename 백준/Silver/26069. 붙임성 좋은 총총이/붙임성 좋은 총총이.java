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


        HashSet<String> dance = new HashSet<>();
        dance.add("ChongChong");
        StringTokenizer st;

        for( int i = 0; i< cas; i++){
            st = new StringTokenizer(br.readLine());
            String one = st.nextToken();
            String two = st.nextToken();

            boolean oneIn = dance.contains(one);
            boolean twoIn = dance.contains(two);

            if(oneIn && twoIn){

            }else if(oneIn){
                dance.add(two);
                out++;
            }else if(twoIn){
                dance.add(one);
                out++;
            }


        }

        bw.append(out);

        System.out.println(bw);
    }


}


