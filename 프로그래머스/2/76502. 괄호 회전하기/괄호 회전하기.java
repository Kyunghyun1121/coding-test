import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        
        for(int i = 0; i < s.length(); i++){
            String temp = s.substring(i);
            if(i != 0)temp += s.substring(0, i);
            Stack<Character>arr = new Stack<>();
            //System.out.println(temp);
            
            for(int j = 0; j < temp.length(); j++){
                if(!arr.isEmpty() && check(arr.peek(),temp.charAt(j))) arr.pop();
                else arr.push(temp.charAt(j));
            }
            
            if(arr.isEmpty())answer++;
        }
        
        return answer;
    }
    
    public boolean check(char a, char b){
        if((a == '[' && b == ']') || (a == '{' && b == '}') || (a == '(' && b == ')')){
            return true;
        }
        return false;
    }
}