import java.util.*;

class Solution {
    char[]arr;
    boolean[]rem;
    
    int answer = 0;
    boolean[]ansRem = new boolean[10000001];
    
    public void dfs(int num, int n){
        if(n > arr.length) return;
        
        if(!ansRem[num]){
            if(check(num)){
                ansRem[num] = true;
                answer++;
            }
        }
        
        //System.out.println(num);

        for(int i = 0; i < arr.length; i++){
            if(rem[i])
                continue;
            
            int now = arr[i] - '0';
            rem[i] = true;
            
            dfs(num*10 + now, n+1);

            rem[i] = false;
            
        }
    }
    
    public int solution(String numbers) {
        arr = numbers.toCharArray();
        rem = new boolean[numbers.length()];
        
        for(int i = 0; i < numbers.length(); i++){
            rem[i] = true;
            dfs(numbers.charAt(i) - '0', 1);
            rem[i] = false;
        }
        
        
        
        return answer;
    }
    public boolean check(int num){
        if(num == 1 || num == 0)return false;
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0)
                return false;
        }
        
        return true;
    }
    
}