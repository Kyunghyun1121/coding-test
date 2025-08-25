import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        ArrayDeque<Character>q = new ArrayDeque<>();
        for(char n : s.toCharArray()){
            if(q.isEmpty()){
                q.add(n);
            }else{
                if(n == ')'){
                    if(q.getLast() == '(') q.removeLast();
                    else return false;
                }else if(n == ']'){
                    if(q.getLast() == '[') q.removeLast();
                    else return false;
                }else if(n == '}'){
                    if(q.getLast() == '{') q.removeLast();
                    else return false;
                }else{
                    q.add(n);
                }
            }
        }

        if(q.isEmpty())return true;
        else return false;
    }
}