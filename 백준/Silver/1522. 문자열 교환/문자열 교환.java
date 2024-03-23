import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String in = br.readLine();
        String[]word = in.split("");

        int a = 0;
        for (int i = 0; i < in.length(); i++)
            if(word[i].equals("a")){
                a++;
            }

        //System.out.println(a);
        int count = 1001;
        for (int i = 0; i < in.length(); i++) {
            int temp = 0;
            for (int j = i; j < i + a; j++) {
                if(j<in.length()){
                    if(word[j].equals("b"))temp++;
                }else{
                    if(word[j - in.length()].equals("b"))temp++;
                }
            }
            count = Math.min(count, temp);
        }


        System.out.println(count);
    }


}
