import java.io.*;
import java.util.*;


public class Main {

    public static class ship{
        int height;
        int right;
        int cost;

        int past;

        public ship(int h, int r, int c, int p) {
            height = h;
            right= r;
            cost = c;
            past = p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][]route = new int[N+1][M+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                route[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Deque<ship> move = new ArrayDeque<>();
        for (int j = 0; j < M; j++) {
            move.add(new ship(0, j, route[0][j], -1));
        }

        int max = 1000000000;
        int[] canMove = {-1,0,1};
        while(!move.isEmpty()){
            ship temp = move.removeFirst();
            if(temp.height == N-1){
                max = Math.min(max, temp.cost);
                continue;
            }
            for (int i = 0; i < 3; i++) {
                int t = temp.right + canMove[i];

                if( t>=0 && t<M && temp.past!=i ){
                    int h = temp.height + 1;
                    move.add(new ship(h, t, temp.cost + route[h][t], i));
                }
            }
        }

        System.out.println(max);
    }


}
