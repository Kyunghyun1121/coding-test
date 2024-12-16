import java.util.*;
class Solution {
    class sit{
        int x; int y;
        public sit(int a, int b){
            x = a; y = b;
        }
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int[]dx = {2,-2,0,0,1,1,-1,-1};
        int[]dy = {0,0,2,-2,1,-1,1,-1};
        
        
        for(int l = 0; l < places.length; l++){
            int[][]rem = new int[5][5];
            Queue<sit>arr = new ArrayDeque<>();
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    char t = places[l][i].charAt(j);
                    if(t=='P'){
                        rem[i][j] = 1;
                        arr.add(new sit(j,i));
                    }else if(t=='O'){
                        rem[i][j] = 0;
                    }else{
                        rem[i][j] = -1;
                    }
                }
            }

            boolean c = false;
            for(sit a : arr){
                for(int k = 0; k < 4; k++){
                    int y = a.y+(dy[k]/2); int x = a.x+(dx[k]/2);
                    if(check(y,x)&&rem[y][x]!=-1){
                        if(rem[y][x]==1){
                            c=true; break;
                        }
                            
                        if(check(a.y+dy[k],a.x+dx[k])&&rem[a.y+dy[k]][a.x+dx[k]]==1){
                            c=true; break;
                        }
                    }
                    
                            
                    y = a.y+dy[k+4]; x = a.x+dx[k+4];
                    if((check(x,1)&&rem[a.y][x] == 1) || (check(y,1) && rem[y][a.x] == 1) ||
                      (check(y,x) && rem[y][x]==1 && (rem[a.y][x] != -1 || rem[y][a.x] != -1))){
                        c=true; break;
                    }
                }
                if(c)break;
            }
            
            if(c)answer[l] = 0;
            else answer[l] = 1;
        }

        
        
        
        return answer;
    }
                       
    public boolean check(int a, int b){
        if(a>=0 && a<5 && b>=0 && b < 5)return true;
        else return false;
    }
}