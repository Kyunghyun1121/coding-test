import java.util.*;

class Solution {
    int[] moveX = {1,-1,0,0};
    int[] moveY = {0,0,1,-1};
    
    int[] turnXR = {1,-1,0,0,0,-1,0,-1, 1,-1,0,0};
    int[] turnXL = {1,-1,0,0,1,0,1,0    ,0,0,-1,1};
    int[] turnYR = {0,0,1,-1,0,1,0,-1,  1,1,0,0};
    int[] turnYL = {0,0,1,-1,1,0,-1,0   ,0,0,-1,-1};
    
    public class robot{
        int ry;
        int rx;
        int ly;
        int lx;
        int len;
        public robot(int b, int a, int d, int c, int e){
            ly = b; 
            lx = a;
            ry = d;
            rx = c;
            len = e;
            if((ly != ry && ly + lx < ry + rx) || (ly == ry && ly + lx > ry + rx)){
                ly = d;
                ry = b;
                rx = lx;
                lx = c;
            }
        }
    }
    
    public int solution(int[][] board) {
        int answer = 0;
        
        int len = board.length;
        Queue<robot> robotP = new ArrayDeque<>();
        boolean[][][][]visited = new boolean[len][len][len][len];
        
        robotP.add(new robot(0,0,0,1, 0));
        visited[0][0][0][1] = true;
        visited[0][1][0][0] = true;
        while(!robotP.isEmpty()){
            robot temp = robotP.remove();
            if((temp.rx == len-1 && temp.ry == len-1) ||
              (temp.lx == len-1 && temp.ly == len-1)){
                answer = temp.len;
                break;
            }
            
//             for(int i = 0; i < len; i++){
//                 for(int j = 0; j < len; j++){
//                     if(temp.ly == i && temp.lx == j)System.out.print("* ");
//                     else if(temp.ry == i && temp.rx == j)System.out.print("* ");
//                     else System.out.print(board[i][j] + " ");
//                 }
//                 System.out.println();
//             }
            
//             System.out.println(temp.ly + " " + temp.lx + "  " + temp.ry + " " + temp.rx);
//             System.out.println();
            int j = 12;
            for(int i = 0; i < j; i++){
                if(temp.ly == temp.ry){
                    j = 8; // 가로
                } 
                else {
                    j = 12;
                    if(i >= 4 && i < 8) continue;
                    // 세로
                }
                
                int drx = temp.rx + turnXR[i]; // 1 2
                int dlx = temp.lx + turnXL[i]; // 0 1
                int dry = temp.ry + turnYR[i]; // 0 0
                int dly = temp.ly + turnYL[i]; // 0 0
                
//                 if(dry == 2 && drx == 0){
//                         System.out.println(temp.ly + " " + temp.lx + "  " + temp.ry + " " + temp.rx);
//                         System.out.println(dly + " " + dlx + "  " + dry + " " + drx);
//                         System.out.println(i);
//             System.out.println();
//                     }
                
                if(drx >= 0 && drx < len &&
                  dlx >= 0 && dlx < len &&
                  dry >= 0 && dry < len &&
                  dly >= 0 && dly < len &&
                  !visited[dly][dlx][dry][drx] &&
                  !visited[dry][drx][dly][dlx] &&
                  board[temp.ly][dlx] == 0 &&
                  board[dly][temp.lx] == 0 &&
                  board[dry][temp.rx] == 0 &&
                  board[temp.ry][drx] == 0 &&
                  board[dly][dlx] == 0 &&
                  board[dry][drx] == 0
                  ){
                    
                    robotP.add(new robot(dly,dlx,dry,drx, temp.len+1));
                    visited[dly][dlx][dry][drx] = true;
                    visited[dry][drx][dly][dlx] = true;
                }
                
                
            }
            
            
            
        }
        
        return answer;
    }
}