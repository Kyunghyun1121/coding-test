import java.io.*;
import java.util.*;

public class Main {
    public static class Move {
        int pos;
        int time;
        public Move(int p, int t){
            pos = p;
            time = t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int subinStart = Integer.parseInt(st.nextToken());
        int sisterStart = Integer.parseInt(st.nextToken());

        if (subinStart == sisterStart) {
            System.out.println(0);
            return;
        }

        final int MAX = 100000;
        boolean[] visited = new boolean[MAX + 1];
        ArrayDeque<Move> q = new ArrayDeque<>();

        q.add(new Move(subinStart, 0));
        visited[subinStart] = true;

        int answer = 0;
        while (!q.isEmpty()) {
            Move cur = q.poll();

            // 세 가지 이동
            int[] next = {cur.pos - 1, cur.pos + 1, cur.pos * 2};
            for (int nx : next) {
                if (nx < 0 || nx > MAX) continue;
                if (visited[nx]) continue;
                if (nx == sisterStart) {
                    System.out.println(cur.time + 1);
                    return;
                }
                visited[nx] = true;            // **enqueue 시점에 방문 표시**
                q.add(new Move(nx, cur.time + 1));
            }
        }

        // 만약 도달 불가능(문제 제약상 보통 여기로 안 옴)
        System.out.println(-1);
    }
}