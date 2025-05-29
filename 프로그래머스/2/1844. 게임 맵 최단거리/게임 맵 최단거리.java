import java.util.*;

class Solution {

    public class move{
        int x;
        int y;
        int count;
        public move(int a, int b, int c){
            x = b;
            y = a;
            count = c;
        }
    }
    int[]dx = {0,0,-1,1};
    int[]dy = {-1,1,0,0};
    
    public int solution(int[][] maps) {
        ArrayDeque<move>q = new ArrayDeque<>();
        q.add(new move(0,0,1));
        boolean[][]rem = new boolean[maps.length][maps[0].length];
        rem[0][0] = true;
        
        while(!q.isEmpty()){
            move temp = q.remove();
            if(temp.x == maps[0].length -1 && 
               temp.y == maps.length - 1){
                return temp.count;
            }
            
            for(int i = 0; i < 4; i++){
                int tx = temp.x + dx[i];
                int ty = temp.y + dy[i];
                if(tx >= 0 && tx < maps[0].length &&
                  ty >= 0 && ty < maps.length && 
                   maps[ty][tx] == 1 && !rem[ty][tx]){
                    q.add(new move(ty,tx,temp.count + 1));
                    rem[ty][tx] = true;
                }
            }
            
        }
        
        return -1;
        
    }
}