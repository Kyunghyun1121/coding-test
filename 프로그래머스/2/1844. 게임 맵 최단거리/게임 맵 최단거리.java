import java.util.*;

class Solution {
    int[]dx = {0,0,-1,1};
    int[] dy = {-1,1,0,0};
    
    public class move{
        int x;
        int y;
        int len;
        public move(int a, int b, int c){
            y = a;
            x = b;
            len = c;
        }

    
    }
    
    public int solution(int[][] maps) {
        int answer = 100000;
        int xLen = maps[0].length;
        int yLen = maps.length;
        boolean[][]rem = new boolean[yLen+1][xLen+1];
        
        ArrayDeque<move>q = new ArrayDeque<>();
        q.add(new move(0,0,1));
        rem[0][0] = true;
        
        while(!q.isEmpty()){
            move temp = q.remove();
            
            if(temp.x == xLen -1 && temp.y == yLen -1){
                answer = Math.min(answer, temp.len);
                continue;
            }
            
            for(int i =0; i < 4; i++){
                int tx = temp.x + dx[i];
                int ty = temp.y + dy[i];
                if(tx >= 0 && tx < xLen &&  ty >= 0 && 
                  ty < yLen && !rem[ty][tx] 
                   && maps[ty][tx] == 1){
                    rem[ty][tx] = true;
                    q.add(new move(ty,tx,temp.len+1));
                }
            }
        }
        
        
        if(answer == 100000)answer = -1;
        return answer;
    }
}