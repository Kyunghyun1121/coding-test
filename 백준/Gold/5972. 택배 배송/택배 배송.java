
import java.io.*;
import java.util.*;

public class Main {
    static class barn{
        int to;
        int len;
        public barn(int to, int len){
            this.to = to;
            this.len = len;
        }
    }
    static int[]visit;
    static ArrayList<ArrayList<barn>> road = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int barns = Integer.parseInt(st.nextToken());
        int roads = Integer.parseInt(st.nextToken());
        visit = new int[barns+1];

        for (int i = 0; i <= barns; i++) {
            road.add(new ArrayList<barn>());
            visit[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < roads; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int len =  Integer.parseInt(st.nextToken());

            road.get(x).add(new barn(y, len));
            road.get(y).add(new barn(x, len));
        }

        visit[1] = 0;
        dfs(1, 0, barns);


        System.out.println(answer);
    }

    public static void dfs(int now, int sumLen, int end){
        PriorityQueue<barn>q = new PriorityQueue<>(new  Comparator<barn>() {
            @Override
            public int compare(barn o1, barn o2) {
                return o1.len -  o2.len;
            }
        });
        q.add(new barn(now, sumLen));

        while(!q.isEmpty()){
            barn temp =  q.poll();

            if(temp.to == end){
                answer = Math.min(answer, temp.len);
                return;
            }else{
                for(barn i : road.get(temp.to)){
                    if(visit[i.to] > temp.len + i.len){
                        visit[i.to] = temp.len + i.len;
                        q.add(new barn(i.to, visit[i.to]));
                    }
                }
            }
        }
    }


}
