
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int len = 0;
  static int man = 0;
  static int fuel = 0;
  static int[][] map;
  static int[] dx = {0, -1, 0, 1};
  static int[] dy = {1, 0, -1, 0};



  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    len = Integer.parseInt(st.nextToken());
    man = Integer.parseInt(st.nextToken());
    fuel = Integer.parseInt(st.nextToken());
    map = new int[len][len];
    int anwser = -1;

    for (int i = 0; i < len; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < len; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine());
    int startY = Integer.parseInt(st.nextToken()) - 1;
    int startX = Integer.parseInt(st.nextToken()) - 1;

    customers[] mans = new customers[man];

    for (int i = 0; i < man; i++) {
      st = new StringTokenizer(br.readLine());

      int my = Integer.parseInt(st.nextToken()) - 1;
      int mx = Integer.parseInt(st.nextToken()) - 1;
      int ey = Integer.parseInt(st.nextToken()) - 1;
      int ex = Integer.parseInt(st.nextToken()) - 1;
      mans[i] = new customers(mx, my, ex, ey);
      map[my][mx] = i + 3; // 승객
      if(mans[i].len == -1){
        System.out.println(-1);
        return;
      }
    }
    // 여기 까지가 입력 받기
    for (int i = 0; i < man; i++) {
      //System.out.println(startX + " " + startY);
      Queue<point> taxi = new ArrayDeque<>();
      taxi.add(new point(startX, startY, 0));
      boolean[][] visited = new boolean[len][len];
      int findMan = -1;
      int remLen = 10000000;

      while (!taxi.isEmpty()) {
        point cur = taxi.poll();
        if (map[cur.my][cur.mx] >= 3) {
          if (findMan == -1) {
            findMan = map[cur.my][cur.mx] - 3;
            remLen = cur.len;
          } else if (remLen < cur.len) {
            //System.out.println(i);
            break;
          } else {
            //System.out.println(cur.mx + " " + cur.my + " " + mans[findMan].mx + " " + mans[findMan].my);
            if (mans[findMan].compare(mans[map[cur.my][cur.mx] - 3]) < 0) {
              findMan = map[cur.my][cur.mx] - 3;
              remLen = cur.len;
            }
          }
        }

        for (int k = 0; k < 4; k++) {
          int tx = cur.mx + dx[k];
          int ty = cur.my + dy[k];
          if (tx >= 0 && tx < len && ty >= 0 && ty < len &&
              map[ty][tx] != 1 && !visited[ty][tx]) {
            taxi.add(new point(tx, ty, cur.len + 1));
            visited[ty][tx] = true;
          }
        }
      }



      if (findMan == -1) {
        fuel = -1;
        break;
      }
      if(fuel < remLen + (mans[findMan].len) ) {
        fuel = -1;
        break;
      }

      fuel = fuel - remLen + mans[findMan].len;
      startX = mans[findMan].ex;
      startY = mans[findMan].ey;
      map[mans[findMan].my][mans[findMan].mx] = 0;

    }

    System.out.println(fuel);

  }

  public static class point{
    int mx;
    int my;
    int len;

    public point(int mx, int my, int len) {
      this.mx = mx;
      this.my = my;
      this.len = len;
    }
  }

  public static class customers {
    int mx;
    int my;
    int ex;
    int ey;
    int len;

    public customers(int mx, int my, int ex, int ey) {
      this.mx = mx;
      this.my = my;
      this.ex = ex;
      this.ey = ey;
      len = dfs(mx, my, ex, ey);
    }

    public int compare(customers c1){
      if(this.my == c1.my){
        return c1.mx - this.mx;
      }else{
        return c1.my - this.my;
      }
    }
  }

  public static int dfs(int sx, int sy, int ex, int ey) {
    if(sx == ex && sy == ey) return 0;
    boolean[][] visited = new boolean[len][len];

    ArrayDeque<int[]> q = new ArrayDeque<>();
    q.add(new int[]{sx, sy, 0});
    visited[sy][sx] = true;

    while (!q.isEmpty()) {
      int[] curr = q.poll();
      if(curr[0] == ex && curr[1] == ey) return curr[2];

      for (int i = 0; i < 4; i++) {
        int nx = curr[0] + dx[i];
        int ny = curr[1] + dy[i];

        if (nx >= 0 && nx < len && ny >= 0 && ny < len && map[ny][nx] != 1 && !visited[ny][nx]) {
          visited[ny][nx] = true;
          q.add(new int[]{nx, ny, curr[2] + 1});
        }
      }
    }

    return -1;
  }

}
