import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cas = Integer.parseInt(br.readLine());
        for (int i = 0; i < cas; i++) {
            int in = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer>t = new ArrayList<Integer>();
            int[]team = new int[201];
            int[]score = new int[201];
            int[]five = new int[201];
            int teamCount = 0;

            for (int j = 1; j <= in; j++) {
                int num = Integer.parseInt(st.nextToken());
                t.add(num);
                if (team[num] == 0) teamCount++;
                team[num]++;
            }
            for (int j = 1; j <= teamCount; j++) {
                if(team[j]<6)t.removeAll(Arrays.asList(Integer.valueOf(j)));
            }

            int l = 1;
            int[]count = new int[201];
            for (Integer integer : t) {
                count[integer]++;
                if(count[integer]<=4)score[integer]+=l;
                if(count[integer]==5)five[integer] = l;
                l++;
            }

//            for (int j = 1; j <= teamCount; j++) {
//                System.out.println(score[j] + " " + five[j]);
//            }


            int winner = 0, winScore = 20100001;
            for (int j = 1; j <= teamCount; j++) {
                if(team[j]==6){
                    if(winScore > score[j] || ((winScore == score[j]) && five[j] < five[winner])){
                        winner = j;
                        winScore = score[j];
                    }
                }
            }
            sb.append(winner).append('\n');
        }


        System.out.println(sb);



    }


}
