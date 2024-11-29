import java.util.*;
class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char[][]arr = new char[m][n];
        for(int i = 0; i < m; i++){
            arr[i] = board[i].toCharArray();
        }
        
        boolean change = true;
        Queue<Character>a = new ArrayDeque<>();
        char[][]temp = new char[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                temp[i][j] = arr[i][j];
            }
        }
        while(change){
            change = false;
            

            
            for(int i = 0; i < m - 1; i++){
                for(int j = 0; j < n - 1; j++){
                    char s = arr[i][j];
                    if(s == '0')continue;
                    
                    if(s == arr[i][j+1] && s == arr[i+1][j] && s == arr[i+1][j+1]){
                        //change = true;
                        temp[i][j+1] = '0';
                        temp[i+1][j+1] = '0';
                        temp[i+1][j] = '0';
                        temp[i][j] = '0';
                    }

                }
            }
            
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(temp[i][j] != arr[i][j]){
                        answer++; change = true;
                    }
                }
            }
            
            if(!change)break;
            
            for(int j = 0; j < n; j++){
                for(int i = m - 1; i >= 0; i--){
                    if(temp[i][j] != '0')a.add(temp[i][j]);
                }
                
                int c = m-1;
                for(int i = m - 1; i >= 0; i--){
                    if(a.isEmpty()) arr[i][j] = '0';
                    else arr[i][j] = a.poll();
                    temp[i][j] = arr[i][j];
                }
                
            }
            
        }
        
        /*for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(arr[i][j]+" ");
            } System.out.println();
        }*/
        
        return answer;
    }
}