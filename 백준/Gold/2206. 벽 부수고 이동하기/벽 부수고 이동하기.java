import java.io.*;
import java.util.*;


public class Main {

    static int height, width, nx, ny;
    static int[] mx = {0,0,1,-1};
    static int[] my = {1,-1,0,0};
    static int [][] wall = new int[1002][1002];

    static class xy{
        int x, y;
        int destroy,count = 0;
        xy(int x, int y, int destroy, int c){
            this.x = x; this.y = y;
            this.destroy = destroy;
            count = c;
        }
    }
    static Deque<xy> move = new ArrayDeque<>();
    static int minCount = 10000001;
    static int[][][] visited = new int[1003][1003][2];



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());


        for(int i = 1; i<= height; i++){
            String[] in = br.readLine().split("");
            for (int j = 0; j < width; j++) {
                wall[i][j+1] = Integer.parseInt(in[j]);
            }
        }


        move.add(new xy(1,1,0,1));
        while (!move.isEmpty()){
            xy temp = move.removeFirst();

            if(minCount < temp.count)continue;

            if((temp.x == width) && (temp.y == height)){
                minCount = Math.min(minCount, temp.count);
                continue;
            }

            if((visited[temp.y][temp.x][temp.destroy] == 0) || (visited[temp.y][temp.x][temp.destroy] > temp.count)){

                visited[temp.y][temp.x][temp.destroy] = temp.count;
                for(int i = 0; i<4; i++) {
                    nx = temp.x + mx[i];
                    ny = temp.y + my[i];

                    if(nx > width || ny > height || nx == 0 || ny == 0)continue;
                    if (wall[ny][nx] == 0) {
                        move.add(new xy(nx, ny, temp.destroy, temp.count+1));
                    } else if(temp.destroy == 0){
                        move.add(new xy(nx, ny, 1,temp.count+1));
                    }
                }
            }
        }


        if(minCount == 10000001) System.out.println(-1);
        else System.out.println(minCount);
    }



}
