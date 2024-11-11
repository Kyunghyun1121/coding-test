import java.io.*;
import java.util.*;

import static java.util.Arrays.sort;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        //st = new StringTokenizer(br.readLine());
        int[]arr = new int[num];
        for(int i = 0; i < num; i++)arr[i] = Integer.parseInt(br.readLine());

        int out = 0;
        Arrays.sort(arr);
        PriorityQueue<Integer>temp = new PriorityQueue<>();
        for(int i = 0; i < num; i++)temp.add(arr[i]);
        while(temp.size()>1){
            int a = temp.poll(); int b = temp.poll();
            temp.add(a+b);
            out += a+b;
            //System.out.println(a + " " + b);
        }


        System.out.println(out);
        return;
    }


}
