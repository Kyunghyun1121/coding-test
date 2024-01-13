import java.io.*;
import java.math.BigInteger;
import java.sql.Array;
import java.util.*;


public class Main {

    static boolean what[] = new boolean[100001];
    static Deque<Long>out = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder bw = new StringBuilder();

        int cas = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i< cas; i++){
            if(Integer.parseInt(st.nextToken()) == 0){
                what[i] = true;
            }
        }

        long in[] = new long[100001];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< cas; i++){
            long s = Integer.parseInt(st.nextToken());
            if(what[i]){
                out.addLast(s);
            }
        }


        int pin = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        long x = 0;

        for(int i =0; i< pin; i++){
            x = Integer.parseInt(st.nextToken());
            out.addFirst(x);
            bw.append(out.peekLast()).append(" ");
            out.removeLast();
        }

        System.out.println(bw);
    }


}


