
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int answer = 0;
        int num = Integer.parseInt(st.nextToken());
        boolean[]rem = new boolean[130];
        for (int i = 0; i < num; i++) {
            String read = br.readLine();
            String[] temp =  read.toLowerCase().split(" ");
            int check = -1;

            int count = 0;
            for(String s : temp){
                if(!rem[s.charAt(0)]){
                    rem[s.charAt(0)] = true;
                    check = count;
                    break;
                }
                count+=s.length()+1;
            }

            if(check == -1){
                count = 0;
                for(char s : read.toLowerCase().toCharArray()){
                    if(!rem[s] && s != ' '){
                        rem[s] = true;
                        check = count;
                        break;
                    }
                    count++;
                }
            }

            if(check == -1){
                sb.append(read).append('\n');
                continue;
            }
            sb.append(read.substring(0, check)).append('[').append(read.substring(check, check+1))
                    .append(']').append(read.substring(check+1)).append('\n');

            //System.out.println(check);
            //System.out.println(sb.toString());

        }

        System.out.println(sb.toString());




    }



}
