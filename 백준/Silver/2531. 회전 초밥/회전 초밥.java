import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int plate = Integer.parseInt(st.nextToken());
        int kind = Integer.parseInt(st.nextToken());
        int doubleSusi = Integer.parseInt(st.nextToken());
        int coupon = Integer.parseInt(st.nextToken());

        int[] susi = new int[plate+1];
        for (int i = 1; i <= plate; i++) {
            susi[i] = Integer.parseInt(br.readLine());
        }


        int out = 0;
        for (int i = 1; i <= plate; i++) {

            boolean[] check = new boolean[kind+1];
            int count = 0; int success = 0;

            for (int j = i; j < i+doubleSusi; j++) {
                int temp;
                if(j > plate)temp = susi[j - plate];
                else temp = susi[j];
                //System.out.print(temp + " ");
                if(check[temp] == false){
                    check[temp] = true;
                    count++;
                }
            }
            if(check[coupon] == false){
                count++;
            }
            //System.out.println();
            out = Math.max(out, count);
        }


        System.out.println(out);
    }


}
