import java.io.*;
import java.util.*;


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] life = new int[1001];
        boolean[] robot = new boolean[1001]; int robotCount = 0;
        int start = 1;
        while (st.hasMoreTokens()){
            life[start] = Integer.parseInt(st.nextToken());
            start++;
        }

        int zero = 0;
        int level = 0;

        while (zero < K){
            level++;

            int temp = life[N*2];
            for (int i = N*2; i > 1; i--) {
                life[i] = life[i-1];
            }
            life[1] = temp;

            for (int i = N; i > 1; i--) {
                robot[i] = robot[i-1];
            }
            robot[1] = false;
            robot[N] = false;

            for (int i = N; i > 0; i--) {
                if(!robot[i] && robot[i-1] && life[i] > 0){
                    robot[i] = true;
                    robot[i-1] = false;
                    life[i]--;
                    if(life[i]==0)zero++;
                }
            }
            robot[N] = false;

            if(life[1] > 0){
                robot[1] = true;
                life[1]--;
                if(life[1]==0)zero++;
            }



        }
        System.out.println(level);
    }


}
