import java.io.*;
import java.util.*;


public class Main {

    static class road{
        int x;
        int y;
        int cost;
        road(int x, int y,int c){
            this.x = x;
            this.y = y;
            cost = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[][] in = new int[y+1][x+1];
        int[][] out = new int[y+1][x+1];
        boolean[][] check = new boolean[y+1][x+1];
        int startX = 0, startY = 0;

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                in[i][j] = Integer.parseInt(st.nextToken());
                if(in[i][j] == 2){
                    startY = i;
                    startX = j;
                }
            }
        }

        Queue<road>arr = new ArrayDeque<>();
        arr.add(new road(startX, startY, 0));
        while (!arr.isEmpty()){
            road temp = arr.remove();
            if(temp.x<0 || temp.x>=x || temp.y<0 || temp.y>=y || in[temp.y][temp.x]==0)continue;
            if(!check[temp.y][temp.x]){
                out[temp.y][temp.x] = temp.cost;
                check[temp.y][temp.x] = true;
                arr.add(new road(temp.x-1, temp.y, temp.cost+1));
                arr.add(new road(temp.x+1, temp.y, temp.cost+1));
                arr.add(new road(temp.x, temp.y-1, temp.cost+1));
                arr.add(new road(temp.x, temp.y+1, temp.cost+1));
            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                int o = out[i][j];
                if(o == 0){
                    if(in[i][j] == 1)sb.append(-1).append(" ");
                    else sb.append(out[i][j]).append(" ");
                }else{
                    sb.append(out[i][j]).append(" ");
                }

            }
            sb.append('\n');
        }


        System.out.println(sb);
    }


}
