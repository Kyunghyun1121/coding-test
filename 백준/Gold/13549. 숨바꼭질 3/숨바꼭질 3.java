import java.io.*;
import java.util.*;


public class Main {


    public static class subin{
        int where;
        int time;
        public subin(int a, int b){
            where = a; time = b;
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        Deque<subin>bfs = new ArrayDeque<>();
        int[] check = new int[100001];

        bfs.add(new subin(N, 0));
        while (!bfs.isEmpty()){
            subin temp = bfs.removeFirst();
            if(temp.where == K){
                System.out.println(temp.time);
                break;
            }else if(temp.where < 0 || temp.where > 100000 || temp.time > Math.abs(N-K))continue;
            else if(check[temp.where] != 0 && temp.time > check[temp.where])continue;
            else{
                check[temp.where] = temp.time;
                bfs.add(new subin(temp.where*2, temp.time));
                bfs.add(new subin(temp.where-1, temp.time+1));
                bfs.add(new subin(temp.where+1, temp.time+1));

            }
        }


    }


}
