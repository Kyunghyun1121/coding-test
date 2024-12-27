import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        char[]arr = name.toCharArray();
        int len = name.length();
        int index=0;
        int move = 100000;
        
        for(int i = 0; i < name.length(); i++){
            answer += Math.min('Z'-arr[i]+1, arr[i]-'A');
            
            index = i + 1;
            while(index < len && name.charAt(index) == 'A'){
                index++;
            }
            
            move = Math.min(move, i * 2 + len - index);
            move = Math.min(move, (len - index) * 2 + i);
            
        }
        

        return answer + move;
    }
}