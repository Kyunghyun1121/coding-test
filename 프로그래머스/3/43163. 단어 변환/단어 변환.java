import java.util.*;

class Solution {

    public boolean avail(String a, String b){
        int count = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                count++;
                if(count >= 2)return false;
            }
        }
        return true;
    }
    
    public class word{
        int count;
        HashSet<String> rem;
        String now;
        public word(HashSet<String> a,String c, int b){
            rem = a;
            now = c;
            rem.add(c);
            count = b;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        ArrayDeque<word>q = new ArrayDeque<>();
        q.add(new word(new HashSet<String>(), begin, 0));
        while(!q.isEmpty()){
            word temp = q.remove();
            System.out.println(temp.now + " " + temp.count);
            
            if(temp.now.equals(target)) return temp.count;
            for(String t : words){
                if(!temp.rem.contains(t) && avail(temp.now, t)){
                    q.add(new word(temp.rem, t, temp.count + 1));
                }
            }
        }
        
        
        return answer;
    }
}