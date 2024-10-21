import java.io.*;
import java.util.*;

import static java.util.Arrays.sort;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String in = br.readLine();
        char[]num = in.toCharArray();
        //st = new StringTokenizer(br.readLine());
        //System.out.println(num);

        int zero = 0; int one = 0;
        boolean check = false;
        for(int i = 0; i < in.length();){
            if(num[i] == '1'){
                one++;
                while(i < in.length() && num[i] == '1')i++;
            }else{
                zero++;
                while(i < in.length() && num[i] == '0')i++;
            }

        }




        System.out.println(Math.min(one,zero));
    }

}
