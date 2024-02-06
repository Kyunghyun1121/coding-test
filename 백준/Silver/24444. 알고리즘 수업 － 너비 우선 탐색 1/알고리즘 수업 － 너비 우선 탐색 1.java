import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int u,v;

        ArrayList<Integer> []num = new ArrayList[N+1];
        for(int i = 0; i<=N; i++){
            num[i] = new ArrayList<>();
        }

        for(int i = 0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            num[u].add(v);
            num[v].add(u);
        }

        for(int i = 0; i<=N; i++){
            if(num[i].isEmpty())continue;
            Collections.sort(num[i]);
        }



        boolean visited[] = new boolean[N+1];
        Deque<Integer>bfs = new ArrayDeque<>();
        bfs.add(R);

        int count = 1;
        int out[] = new int[N+1];
        while(!bfs.isEmpty()){
            int now = bfs.removeFirst();
            if(visited[now])continue;
            visited[now] = true;
            out[now] = count;
            count++;
            for (Integer integer : num[now]) {
                if(!visited[integer]){
                    bfs.add(integer);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=N; i++){
            sb.append(out[i]).append('\n');
        }
        System.out.println(sb);


    }



}
