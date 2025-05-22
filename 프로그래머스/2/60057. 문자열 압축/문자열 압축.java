import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 10000;
        
        int cutLen = s.length();
        while(cutLen > 0){
            int len = 0;
            if(cutLen > s.length() / 2){
                len = s.length();
            }else{
                int start = cutLen;
                int end = start + cutLen;
                String t = "";
                int count = 1;
                String compare = s.substring(0, cutLen);
                //System.out.println(compare);
                //if(end == s.length()) t += compare;
                
                while(end <= s.length()){
                   // System.out.println(cutLen + " " + t);
                    
                    String temp = s.substring(start, end);
                    if(!compare.equals(temp)){
                        //System.out.println(compare + " : " + temp);
                        if(count!=1)t += count;
                        t += compare;
                        compare = temp;
                        //System.out.println(compare);
                        count = 0;
                    }
                    
                    start = end;
                    end = start + cutLen;
                    count++;
                }
                if(count > 1) t+=count;
                
                t += compare;
                t += s.substring(start, s.length());
                //System.out.println(cutLen + " " + t);
                
                len = t.length();
            }
            
            answer = Math.min(answer, len);
            cutLen--;
        }
        
        return answer;
    }
}