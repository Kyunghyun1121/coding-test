import java.io.*;
import java.util.*;


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //int num = Integer.parseInt(br.readLine());
        int []arr = new int[4];
        st = new StringTokenizer(br.readLine());

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int timeNumO = arr[0]*1000 + arr[1]*100 + arr[2]*10 + arr[3];
        int timeNumT = arr[1]*1000 + arr[2]*100 + arr[3]*10 + arr[0];
        int timeNumTh = arr[2]*1000 + arr[3]*100 + arr[0]*10 + arr[1];
        int timeNumF = arr[3]*1000 + arr[0]*100 + arr[1]*10 + arr[2];
        int timeNum = Math.min(Math.min(timeNumO, timeNumF),Math.min(timeNumTh, timeNumT));
        //System.out.println(timeNum);
        
        boolean[][][][] rem = new boolean[10][10][10][10];
        for(int i = 1111; i < timeNum; i++){
            int t = i;
            int one = t /1000; t%=1000;
            int two = t/100; t%=100;
            int three = t/10; t%=10;
            int four = t;
            if(one == 0 || two == 0 || three == 0 || four == 0)continue;
            if(!rem[one][two][three][four]){
                sum++;
                rem[one][two][three][four] = true;
                rem[two][three][four][one] = true;
                rem[three][four][one][two] = true;
                rem[four][one][two][three] = true;
                //System.out.println(i);
            }

        }


        sb.append(sum+1);
        System.out.println(sb);
    }

}
