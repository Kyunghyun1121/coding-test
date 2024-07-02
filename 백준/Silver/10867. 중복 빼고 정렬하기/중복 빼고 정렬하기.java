import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        float []arr = new float[num];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Float.parseFloat(st.nextToken());

        }


        Arrays.sort(arr);
        boolean visitP[] = new boolean[1001];
        boolean visitM[] = new boolean[1001];
        for (int i = 0; i < num; i++) {
            int temp = Math.round(arr[i]);
            //System.out.println(temp);
            if(arr[i] < 0){
                if(!visitM[temp*-1]){
                    visitM[temp*-1] = true;
                    sb.append((int) arr[i]).append(" ");
                }
            }else{
                if(!visitP[(int) arr[i]]){
                    visitP[temp] = true;
                    sb.append(temp).append(" ");
                }
            }
        }
        System.out.println(sb);
    }


}
