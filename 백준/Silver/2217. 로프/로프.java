import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        int []arr = new int[num];

        int min = 10001;
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int max = -1; int c = 0;
        for (int i = num - 1; i >= 0; i--) {
            c++;
            max = Math.max(max, arr[i] * c);
        }
        sb.append(max);
        System.out.println(sb);
    }

}
