import java.util.*;

class Solution {
    String[] word;
    int ansC = 100000001;
    HashSet<String>check = new HashSet<>();
    public void dfs(String now, String target, int count){
        if(now.equals(target)){
            //System.out.println(ans);
            if(ansC > count){
                ansC = count;
            }
            return;
        }
        
        for(String temp : word){
            if(changeAble(temp, now) && !check.contains(temp)){
                if(!target.equals(temp))check.add(temp);
                dfs(temp, target, count + 1);
            }
        }
    }
    
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        word = words;
        boolean c = false;
        for(String s : words)   if(target.equals(s)) c = true;
        if(!c) return 0;
        
        dfs(begin, target, 0);
        if(ansC == 100000001)return 0;
        return ansC;
    }
    
    public boolean changeAble(String a, String b){
        int count = 0;
        char[] at = a.toCharArray();
        char[] bt = b.toCharArray();
        for(int i = 0; i < at.length; i++){
            if(at[i] != bt[i]) count++;
            if(count > 1) return false;
        }
        return true;
        
    }
    

}