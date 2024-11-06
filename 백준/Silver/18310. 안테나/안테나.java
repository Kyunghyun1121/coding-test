import java.io.*;
import java.util.*;

import static java.util.Arrays.sort;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[]arr = new int[num];
        for(int i = 0; i < num; i++)arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        
        System.out.println(arr[(num-1)/2]);
        return;
    }


}
