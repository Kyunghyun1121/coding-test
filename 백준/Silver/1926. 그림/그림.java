import java.io.*;
import java.util.*;


public class Main {

    static class site{
        int x; int y;

        public site(int j, int i) {
            x = j; y = i;
        }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int sero = Integer.parseInt(st.nextToken());
        int garo = Integer.parseInt(st.nextToken());

        int [][]arr = new int[sero][garo];
        for (int i = 0; i < sero; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < garo; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int pictureCount = 0;
        int maxSize = 0;

        int moveY[] = {-1, 1, 0, 0};
        int moveX[] = {0, 0, -1, 1};

        boolean [][]visit = new boolean[sero][garo];

        for (int i = 0; i < sero; i++) {
            for (int j = 0; j < garo; j++) {
                if(arr[i][j] == 1 && !visit[i][j]){
                    ArrayList<site>bfs = new ArrayList<>();
                    bfs.add(new site(j, i));
                    int count = 0;
                    pictureCount++;

                    while (!bfs.isEmpty()){
                        site temp = bfs.remove(0);
                        if(visit[temp.y][temp.x])continue;
                        visit[temp.y][temp.x] = true;
                        count++;
                        for (int k = 0; k < 4; k++) {
                            int y = temp.y+moveY[k];
                            int x = temp.x+moveX[k];
                            if(y < 0 || x < 0 || y >= sero || x >= garo)continue;
                            if(!visit[y][x] && arr[y][x] == 1){
                                bfs.add(new site(x,y));
                            }
                        }
                    }

                    maxSize = Math.max(count, maxSize);
                }
            }
        }
        sb.append(pictureCount).append('\n').append(maxSize);
        System.out.println(sb);

    }


}
