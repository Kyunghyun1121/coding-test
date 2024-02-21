import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long Tscore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if(N!=0){
            st = new StringTokenizer(br.readLine());
            long temp;
            int count = 0;
            int sameCount = 0;

            for (int i = 0; i < N; i++) {
                temp = Integer.parseInt(st.nextToken());
                if(Tscore < temp)count++;
                else if(Tscore == temp)sameCount++;
            }

            if((count+sameCount) >= P){
                System.out.println("-1");
            }else{
                System.out.println(count+1);
            }
        }else{
            System.out.println(1);
        }



    }


}
