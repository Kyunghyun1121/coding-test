import javax.swing.*;
import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int count = 0;
        for(int i = 0; i < H; i++){
            count++;
            i += N;
        }

        int rcount = 0;
        for(int i = 0; i < W; i++){
            rcount++;
            i += M;
        }
        System.out.println(count*rcount);

    }


}
