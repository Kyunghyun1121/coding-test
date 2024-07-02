import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        int []A =new int[num];
        int []B = new int[num];
        int []big = new int[num];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(A);
        int []c = B;
        Arrays.sort(c);

        int sum = 0; int b = num - 1;
        boolean visit[] = new boolean[num];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if(c[b] == B[j] && !visit[j]){
                    visit[j] = true;
                    //System.out.println("A: " + A[i] + " " + "B: " + B[j]);
                    sum += B[j] * A[i];
                    b--;
                    break;
                }
            }
        }

        sb.append(sum);
        System.out.println(sb);

    }


}
