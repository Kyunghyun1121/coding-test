import java.io.*;
import java.util.*;


public class Main {

    static class Shortcut{
        int start;
        int end;
        int dist;
        Shortcut(int start, int end, int dist){
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int D = sc.nextInt();
        ArrayList<Shortcut> path = new ArrayList<>();

        for(int i = 0; i < N; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int dist = sc.nextInt();
            if (end > D)
                continue;
            if (end - start > dist)
                path.add(new Shortcut(start, end, dist));
        }

        Collections.sort(path, new Comparator<Shortcut>() {
            public int compare(Shortcut o1, Shortcut o2) {
                if (o1.start == o2.start){
                    return Integer.compare(o1.end, o2.end);
                }
                return Integer.compare(o1.start, o2.start);
            }
        });

        int[] distance = new int[D+1];
        int move = 0;
        int idx = 0;
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;


        while (move < D){
            if (idx < path.size()){
                Shortcut s = path.get(idx);
                if (move == s.start){
                    distance[s.end] = Math.min(distance[move] + s.dist, distance[s.end]);
                    idx++;
                } else {
                  distance[move + 1] = Math.min(distance[move + 1], distance[move] + 1);
                  move++;
                }
            } else {
                distance[move + 1] = Math.min(distance[move + 1], distance[move] + 1);
                move++;
            }
        }
        System.out.println(distance[D]);

    }

}
