import java.util.*;
class Solution {
    public int solution(String[] board) {
        int answer = 1;
        
        char[][]tik = new char[3][3];
        for(int i = 0; i < 3; i++)tik[i] = board[i].toCharArray();
        
        int oCount = 0; int xCount = 0;
        int oDone = 0; int xDone = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(tik[i][j] == 'O'){
                    oCount++;
                    if(i == 0)if(tik[i][j] == tik[i+1][j] && tik[i][j] == tik[i+2][j])oDone++;
                    if(j == 0)if(tik[i][j] == tik[i][j+1] && tik[i][j] == tik[i][j+2])oDone++; 
                }else if(tik[i][j] == 'X'){
                    xCount++;
                    if(i == 0)if(tik[i][j] == tik[i+1][j] && tik[i][j] == tik[i+2][j])xDone++;
                    if(j == 0)if(tik[i][j] == tik[i][j+1] && tik[i][j] == tik[i][j+2])xDone++;
                }
            }
        }
        if(tik[0][0] == tik[1][1] && tik[0][0] == tik[2][2]){
            if(tik[0][0] == 'O')oDone++;
            if(tik[0][0] == 'X')xDone++;
        }
        if(tik[0][2] == tik[1][1] && tik[0][2] == tik[2][0]){
            if(tik[0][2] == 'O')oDone++;
            if(tik[0][2] == 'X')xDone++;
        }
        //System.out.println(oDone +" "+ xDone);

        if(oCount - xCount != 1 && oCount - xCount != 0)answer = 0;
        if(oDone>0 && xDone>0)answer = 0;
        if(oDone>0 && xDone==0)if(oCount - xCount != 1)answer = 0;
        if(xDone>0 && oDone==0)if(oCount - xCount != 0)answer = 0;
        
        return answer;
    }
}