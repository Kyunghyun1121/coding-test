import java.util.*;

class Solution {
    
    
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String>rem = new LinkedList<>();
        
        for(int i = 0; i < cities.length; i++){
            String s = cities[i].toLowerCase();
            
            if(rem.size() == 0){
                rem.addLast(s); answer += 5; continue;
            }
                
            if(rem.indexOf(s) != -1 && cacheSize > 0){
                answer++;
                rem.remove(rem.indexOf(s));
            }else{
                answer += 5;
                if(rem.size() >= cacheSize){
                    rem.remove();
                }
            }
            rem.addLast(s);
        }
        
        return answer;
    }
}