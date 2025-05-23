import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int[] rem = new int[id_list.length];
        
        HashSet<String> sueRem = new HashSet<>();
        HashMap<String, Integer> bad = new HashMap<>();
        
        for(String i : report) sueRem.add(i);
        for(int i = 0; i < id_list.length; i++) bad.put(id_list[i], i);
        
        for(String i : sueRem){
            String[]who = i.split(" ");
            rem[bad.get(who[1])]++;
        }
        
        for(String i : sueRem){
            String[]who = i.split(" ");
            if(rem[bad.get(who[1])] >= k)
                answer[bad.get(who[0])]++;
        }
        
        
        return answer;
    }
}