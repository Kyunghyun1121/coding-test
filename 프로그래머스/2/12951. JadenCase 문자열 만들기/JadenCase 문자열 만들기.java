import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        char[]arr = new char[s.length()];
        arr = s.toCharArray();
        
        for(int i = 0; i < s.length(); i++){
            //System.out.print(7);
            
            if(arr[i] == ' ')continue;
            if(arr[i] >= 'a' && arr[i] <= 'z')arr[i] -= 32;
            i++;
            while(i < s.length() && arr[i] != ' '){
                if(arr[i] >= 'A' && arr[i] <= 'Z')arr[i] += 32;
                i++;
                //System.out.print(i);
            } 
            
        }
        
        answer = String.valueOf(arr);
        return answer;

    }
}