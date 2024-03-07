import java.io.*;
import java.util.*;


public class Main {
    static class comp{

        int scoreSum = 0;
        int count = 0;
        int[] problem = new int[101];
        int time;
        public comp(int p, int s, int t){
            if(problem[p] < s){
                problem[p] = s;
            }
            time = t;
            count++;
        }

        public void set(int p, int s, int t){
            if(problem[p] < s){
                problem[p] = s;
            }
            time = t;
            count++;
        }

        public void sum(int n){
            for (int i = 1; i <= n; i++) {
                scoreSum+=problem[i];
            }
//            System.out.println(scoreSum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        String[] in = br.readLine().split("");
        int one = 0;
        int zero = 0;
        for (String s : in) {
            if(s.equals("1")){
                one++;
            }else{
                zero++;
            }
        }

        int halfOne = one/2;
        int halfZero = zero/2;
        for (int i = 0; i < in.length; i++) {
            if(halfOne == 0)break;

            if(in[i].equals("1")){
                in[i] = "-1";
                halfOne--;
            }
        }

        for (int i = in.length - 1; i >= 0; i--) {
            if(halfZero == 0)break;

            if(in[i].equals("0")){
                in[i] = "-1";
                halfZero--;
            }
        }

        for (String s : in) {
            if(!s.equals("-1")){
                sb.append(s);
            }
        }
        System.out.println(sb);

    }


}
