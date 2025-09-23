import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 10000;
        if(s.length()==1)return 1;
        
        for(int i = 1; i < s.length(); i++){
            StringBuilder temp = new StringBuilder();
            for(int j = 0; j + i <= s.length(); ){
                int count = 1;
                String t = s.substring(j, j + i);
                j+=i;
                while(j + i <= s.length() && t.equals(s.substring(j, j + i))){
                    j+=i;
                    count++;
                }
                
                //System.out.println("i: " + i + " j : " + j + " "+count+" " + t);
                if(count!=1) temp.append(count).append(t);
                else temp.append(t);
                
                if(j + i > s.length() && s.substring(j).length() < i){
                    temp.append(s.substring(j));
                    break;
                }  
            }
            //System.out.println(temp.toString());
            answer = Math.min(answer, temp.toString().length());
        }
        
        return answer;
    }
}