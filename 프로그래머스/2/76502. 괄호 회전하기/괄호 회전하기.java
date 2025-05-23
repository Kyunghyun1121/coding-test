import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(isRight(s))answer++;
            
            s = s.substring(1) + s.substring(0,1);
        }
        
        return answer;
    }
    
    
    public boolean isRight(String s){
        Stack<Character>find = new Stack<>();
        for(char i : s.toCharArray()){
            if(i == ']'){
                if(find.isEmpty())return false;
                if(find.peek() == '[') find.pop();
                else find.push(i);
            }else if(i == '}'){
                if(find.isEmpty())return false;
                if(find.peek() == '{') find.pop();
                else find.push(i);
            }else if( i == ')'){
                if(find.isEmpty())return false;
                if(find.peek() == '(') find.pop();
                else find.push(i);
            }else{
                find.push(i);
            }
        }
        
        if(find.isEmpty())return true;
        else return false;
    }
}