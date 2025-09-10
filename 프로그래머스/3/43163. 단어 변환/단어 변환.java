import java.util.*;

class Solution {
    public class Word{
        String word;
        int count;
        public Word(String a, int b){
            word = a; count = b;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        HashMap<String, Integer>dict = new HashMap<>();
        for(int i = 0; i < words.length; i++) dict.put(words[i], i);
        if(!dict.containsKey(target)) return 0;
        
        ArrayList<ArrayList<String>>list = new ArrayList<>();
        for(int i = 0; i < words.length; i++) list.add(new ArrayList<>());
        
        for(int i = 0; i < words.length; i++){
            for(int j = i + 1; j < words.length; j++){
                if(changeable(words[i], words[j])){
                    int a = dict.get(words[i]);
                    int b = dict.get(words[j]);
                    list.get(a).add(words[j]);
                    list.get(b).add(words[i]);
                }
            }
        }
        
        boolean[]visit = new boolean[words.length + 1];
        ArrayDeque<Word> q = new ArrayDeque<>();
        for(String temp : words){
            if(temp.equals(begin)){
                q.add(new Word(temp, 0));
            }
            else if(changeable(begin, temp)){
                q.add(new Word(temp, 1));
            }
        }

        
        while(!q.isEmpty()){
            Word t = q.remove();
            //System.out.println(dict.get(t.word));
            if(t.word.equals(target)) return t.count;
            if(visit[dict.get(t.word)]) continue;
            
            
            for(String temp : list.get(dict.get(t.word))){
                if(temp.equals(target)) return t.count + 1;
                if(!visit[dict.get(temp)]){
                    visit[dict.get(t.word)] = true;
                    q.add(new Word(temp, t.count + 1));   
                }
            }
        }
        
        //System.out.println(list);
        
        return answer;
    }
    
    public boolean changeable(String a, String b){
        char[]at = a.toCharArray();
        char[]bt = b.toCharArray();
        int count = 0;
        for(int i = 0; i < at.length; i++){
            if(at[i] != bt[i]){
                count++;
                if(count >= 2) return false;
            } 
        }
        return true;
    }
}