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


        int cas = Integer.parseInt(br.readLine());
        for (int i = 0; i < cas; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int teamNum = Integer.parseInt(st.nextToken());
            int problemNum = Integer.parseInt(st.nextToken());
            int myTeam = Integer.parseInt(st.nextToken());
            int out = 1;
            int m = Integer.parseInt(st.nextToken());
            comp[] teams = new comp[teamNum+1];


            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int teamId = Integer.parseInt(st.nextToken());
                int problem = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());
                if(teams[teamId] == null){
                    teams[teamId] = new comp(problem, score, j);
                }else{
                    teams[teamId].set(problem, score, j);
                }

            }

            teams[myTeam].sum(problemNum);
            for (int j = 1; j <= teamNum; j++) {
                if(j != myTeam){
                    teams[j].sum(problemNum);
                    if(teams[myTeam].scoreSum < teams[j].scoreSum
                    || (teams[myTeam].scoreSum == teams[j].scoreSum && teams[myTeam].count > teams[j].count)
                    || ((teams[myTeam].scoreSum == teams[j].scoreSum && teams[myTeam].count == teams[j].count) && teams[myTeam].time > teams[j].time)){
                        out++;
                    }
                }
            }
            System.out.println(out);


        }


    }


}
