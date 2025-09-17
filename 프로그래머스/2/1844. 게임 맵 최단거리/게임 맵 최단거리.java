import java.util.*;

class Solution {

    int[]dx = {0,0,-1,1};
    int[]dy = {-1,1,0,0};
    public class move{
        int x; int y;
        int len;
        public move(int a, int b,int c){
            y = a;
            x = b;
            len = c;
        }
    }
    
    public int solution(int[][] maps) {
        
        ArrayDeque<move>q = new ArrayDeque<>();
        boolean[][]visited = new boolean[maps.length][maps[0].length];
        q.add(new move(0,0,0));
        visited[0][0] = true;
        while(!q.isEmpty()){
            move t = q.remove();
            if(t.x == maps[0].length - 1&& t.y == maps.length - 1) return t.len + 1;
            for(int i = 0; i < 4; i++){
                int ty = t.y + dy[i];
                int tx = t.x + dx[i];
                if(tx >= 0 && tx < maps[0].length && ty >= 0 && ty < maps.length
                  && !visited[ty][tx] && maps[ty][tx] != 0){
                    visited[ty][tx] = true;
                    q.add(new move(ty, tx, t.len + 1));
                }
            }
        }
        return -1;
        
    }
}