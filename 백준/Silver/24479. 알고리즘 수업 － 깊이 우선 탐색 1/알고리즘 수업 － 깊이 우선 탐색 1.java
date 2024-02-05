import java.io.*;
import java.util.*;


public class Main {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> []dot;
    static boolean[] visited;
    static int out[];
    static int R;
    static int count = 1;

    public static void dfs(int now){
        visited[now] = true;
        out[now] = count;
        count++;

        for(int i : dot[now]){
            if(!visited[i]){
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        int u,v;
        visited = new boolean[N+2];
        out = new int[N+2];
        dot = new ArrayList[N+2];

        for(int i = 1; i <= N; i++){
            dot[i] = new ArrayList<>();
        }


        for(int i = 0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            dot[u].add(v);
            dot[v].add(u);
        }



        for(int i = 1; i<= N; i++){
            if(dot[i].isEmpty())continue;
            Collections.sort(dot[i]);

        }

        dfs(R);

        for (int i = 1; i <= N; i ++){
            sb.append(out[i]).append('\n');
        }

        System.out.println(sb);

    }



}
