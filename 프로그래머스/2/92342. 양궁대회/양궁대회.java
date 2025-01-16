import java.util.*;
class Solution {
    int[] apeach;
    int minus = 0;
    int[] answer = new int[11];
    
    public void dfs(int apeachSum, int lionSum, int lionLeft, int number, int[] lionRem){
        //System.out.println(number);
        if(number == 11){
            lionRem[10] += lionLeft;
            lionLeft = 0;
        }
        
        if(lionLeft == 0){
            for(int i = number; i < 11; i++)if(apeach[i]>0)apeachSum+= 10-i;
            
            if(minus < lionSum - apeachSum){
                for(int i = 0; i < 11; i++)answer[i] = lionRem[i];
                minus = lionSum - apeachSum;
            }else if(minus == lionSum - apeachSum){
                
                for(int i = 10; i >=0; i--){
                    if(answer[i] == lionRem[i])continue;
                    if(answer[i] > lionRem[i])return;
                    break;
                }
                
                for(int i = 0; i < 11; i++)answer[i] = lionRem[i];
                minus = lionSum - apeachSum;
            }
        }else{
            int s = 10 - number;
            int c = apeach[number] + 1;
            //System.out.println(number + " "+c);
            
            int rem = lionRem[number];
            
            if(apeach[number] > 0){
                lionRem[number] = 0;
                dfs(apeachSum+s, lionSum, lionLeft, number+1, lionRem);
            }else{
                dfs(apeachSum, lionSum, lionLeft, number+1, lionRem);
            }
            
            if(lionLeft - c >= 0){
                lionRem[number] = c;
                dfs(apeachSum, lionSum+s, lionLeft-c, number+1, lionRem);
            }
            
            
            
            lionRem[number] = rem;
        }
    }
    
    public int[] solution(int n, int[] info) {
        apeach = info;
        int[]fail = new int[1]; fail[0] = -1;
        
        dfs(0, 0, n, 0, new int[11]);
        
        if(minus == 0)return fail;
        else return answer;
    }
}