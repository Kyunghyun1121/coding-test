import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String in = br.readLine();
        while (!in.equals("end")){
            boolean check = true;
            int check1 = 5;
            int check2m = 3;
            int check2z = 3;

            char[] word = in.toCharArray();
            char before = word[0]; boolean start = true;

            for (char c : word) {
                if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                    check1--;
                    check2z = 3;
                    check2m--;
                }else{
                    check2m = 3;
                    check2z--;
                }

                if(check2z==0||check2m==0){
                    check=false; break;
                }
                if(before == c && !start && c!='e' && c!='o'){
                    check=false; break;
                }
                start = false;
                before = c;
            }
            if(check1==5)check=false;

            if(check){
                sb.append("<").append(in).append("> is acceptable.\n");
            }else{
                sb.append("<").append(in).append("> is not acceptable.\n");
            }
            in = br.readLine();
        }

        System.out.println(sb);
    }


}
