import javax.swing.*;
import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter sb = new OutputStreamWriter(System.out);

        int num = Integer.parseInt(br.readLine());
        int[] cas = new int[num+5];

        cas[0] = 0;
        cas[1] = 1;
        cas[2] = 2;

        for(int i = 3; i<=num; i++){
            cas[i] = Math.min(cas[i-1]+1, cas[i-3]+1);
        }

        if(cas[num]%2==0){
            System.out.println("CY");
        }else{
            System.out.println("SK");
        }
    }


}
