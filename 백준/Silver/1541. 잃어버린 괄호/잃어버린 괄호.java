import java.io.*;
import java.math.BigInteger;
import java.sql.Array;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] cas = br.readLine().split("-");
        int plusSum = 0;
        String[] start = cas[0].split("\\+");
        for(int j = 0; j<start.length; j++){
            plusSum+=Integer.parseInt(start[j]);
        }
        
        
        int minusSum = 0;

        for(int i =1; i< cas.length; i++){
            String[] plus = cas[i].split("\\+");

            for(int j = 0; j<plus.length; j++){
                minusSum+=Integer.parseInt(plus[j]);
            }
            plusSum -= minusSum;
            minusSum = 0;
        }

        System.out.println(plusSum);

    }




}
