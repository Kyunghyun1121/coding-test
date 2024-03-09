import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set keyword = new HashSet();
        for (int i = 0; i < N; i++) {
            keyword.add(br.readLine());
        }


        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine(), ",");
            while (st.hasMoreTokens()){
                String s = st.nextToken();
                if(keyword.contains(s))keyword.remove(s);
            }

            sb.append(keyword.size()).append('\n');
        }

        System.out.println(sb);




    }


}
