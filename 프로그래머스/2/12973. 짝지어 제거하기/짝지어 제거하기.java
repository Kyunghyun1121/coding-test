import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        Stack<Character>arr = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            if(arr.size()==0)arr.add(s.charAt(i));
            else if(arr.peek() == s.charAt(i))arr.pop();
            else arr.add(s.charAt(i));
        }
        
        if(arr.size() == 0)answer = 1;
        return answer;
    }
}