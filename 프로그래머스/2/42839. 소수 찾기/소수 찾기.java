import java.util.*;

class Solution {
    char[] arr;
    int answer = 0;
    boolean[] c = new boolean[1000000000];
    
    public void turn(int k, int count, int[]a, boolean[] rem){
        if(count == k){
            String temp = "";
            for(int i : a)temp += arr[i];
            
            int n = Integer.valueOf(temp);
            
            if(!c[n] && check(n)){
                //System.out.println(temp + " " + n);
                answer++;
                c[n] = true;
            }
            
            return;
        }else{
            for(int i = 0; i < arr.length; i++){
                if(rem[i])continue;
                
                a[count] = i;
                rem[i] = true;
                turn(k, count + 1, a, rem);
                rem[i] = false;
            }
        }
    }
    
    
    public int solution(String numbers) {
        
        
        arr = numbers.toCharArray();
        for(int i = 1; i <= numbers.length(); i++){
            turn(i, 0, new int[i], new boolean[10]);
        }
        
        return answer;
    }
    
    public boolean check(int num){
        if(num == 0 || num == 1)return false;
        
        int t = (int)Math.sqrt(num) + 1;
        
        for(int i = 2; i <= t; i++){
            if(num != i && num % i == 0)return false;
        }
        
        return true;
    }
}