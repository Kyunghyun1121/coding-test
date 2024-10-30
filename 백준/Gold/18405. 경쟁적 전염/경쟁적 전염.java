import java.io.*;
import java.util.*;

import static java.util.Arrays.sort;


public class Main {
    static int[][]in = new int[201][201];
    static int[]dx = {0,0,-1,1};
    static int[]dy = {-1,1,0,0};

    public static class virus{
        public int getNum() {
            return num;
        }

        int x; int y; int time; int num;
        virus(int a, int b, int c, int d){
            x = a; y = b; num = c; time = d;
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //int num = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int virusNum = Integer.parseInt(st.nextToken());
        Queue<virus>now = new ArrayDeque<>();
        ArrayList<virus>check = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                in[i][j] = Integer.parseInt(st.nextToken());
                if(in[i][j] > 0)check.add(new virus(j,i,in[i][j],0));
            }
        }

        st = new StringTokenizer(br.readLine());
        int time  = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        Collections.sort(check, new Comparator<virus>(){
            @Override
            public int compare(virus a, virus b){
                return a.getNum() - b.getNum();
            }
        });

        for (virus virus : check) {
            now.add(virus);
        }


        while (!now.isEmpty()){
            virus temp = now.poll();
            if(temp.time >= time)continue;

            for (int i = 0; i < 4; i++) {
                int tx = temp.x + dx[i];
                int ty = temp.y + dy[i];

                if(tx >= 0 && ty >= 0 && tx < size && ty < size && in[ty][tx] == 0){
                    in[ty][tx] = temp.num;
                    now.add(new virus(tx, ty, temp.num, temp.time + 1));
                }
            }

            /*for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(in[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();*/
        }

        System.out.println(in[Y-1][X-1]);

        return;
    }


}
