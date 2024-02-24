import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cas = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] budget = new int[cas];
        int saySum = 0;
        int max = -1;
        int min = 1000000001;
        for (int i = 0; i < cas; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
            saySum += budget[i];
            max = Math.max(max, budget[i]);
            min = Math.min(min, budget[i]);
        }

        int sumBudget = Integer.parseInt(br.readLine());
        int bound = sumBudget/cas;

        int outMax = -1;
        if(saySum <= sumBudget){
            outMax = max;
        }else if(sumBudget <= min){
            outMax = sumBudget/cas;
        }else{
            Arrays.sort(budget);
            for (int i = 0; i < cas; i++) {
                if(budget[i] <= bound){
                    sumBudget -= budget[i];
                    bound = sumBudget/(cas-i-1);
                }else{
                    outMax = bound;
                }
            }
        }
        System.out.println(outMax);
    }


}
