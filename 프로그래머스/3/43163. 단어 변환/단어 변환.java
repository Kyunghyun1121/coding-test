import java.util.*;

class Solution {
    class word{
        String word;
        int count = 0;
        public word(String a, int b){
            word = a;
            count = b;
        }
    }
    
    boolean compare(String a, String b){
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        
        int c = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] != B[i])
                c++;
            if(c > 1) return false;
        }
        
        //System.out.println(a + " " + b);
        return true;
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        ArrayDeque<word>q = new ArrayDeque<>();
        q.add(new word(begin, 0));
       
        HashSet<String>visit = new HashSet<>();
        
        while(!q.isEmpty()){
            word w = q.pop();
            if(w.word.equals(target)) return w.count;
            
            if(!visit.contains(w.word)){
                for(String s : words){
                    if(compare(s, w.word))
                        q.add(new word(s, w.count+1));
                }
            }
            
            visit.add(w.word);
        }
        
        return answer;
    }
}