import java.util.*;
class Solution {
    String[][] temp;
    boolean[] avail = new boolean[9];
    int column = 0;
    int row = 0;
    int answer = 0;
    HashSet<String>check = new HashSet<>();
    List<String>candidate = new ArrayList<>();
    Queue<String>key = new ArrayDeque<>();
    
    public void dfs(String keyNum){
        if(keyNum.length() > column || check.contains(keyNum))return;
        check.add(keyNum);
        candidate.add(keyNum);
        
        for(int i = 0; i < column; i++){
            if(!avail[i]){
                avail[i] = true;
                String t = keyNum + i;
                char[] tt = t.toCharArray();
                Arrays.sort(tt);
                dfs(String.valueOf(tt));
                avail[i] = false;
            }
        }
    }
    
    public void detect(String keyNum){
        char[] arr = keyNum.toCharArray();
        HashSet<String>find = new HashSet<>();
        
        
        for(int i = 0; i < row; i++){
            String s = "";
            for(int j = 0; j < arr.length; j++){
                s += temp[i][(int)arr[j] - '0'];
            }
            
            if(!find.add(s))return;
        }
        
        //System.out.println(keyNum);
        key.add(keyNum);
        answer++;
        return;

    }
    
    public int solution(String[][] relation) {
        temp = relation;
        
        column = relation[0].length;
        row = relation.length;
        
        
        for(int i = 0; i < column; i++){
            avail[i] = true;
            dfs(String.valueOf(i));
            avail[i] = false;
        }
        
        Collections.sort(candidate, new Comparator<>(){
            @Override
            public int compare(String a, String b){
                if(a.length() == b.length()) return a.compareTo(b);
                else return a.length() - b.length();
            }
        });
        
        for(String s : candidate){
            //System.out.println(s);
            char[]kk = s.toCharArray();
            boolean c = true;
            for(String l : key){ //이미 키인 애들
                char[]ttemp = l.toCharArray();
                int k = 0;
                for(int i = 0; i < l.length(); i++){
                    if(s.contains(String.valueOf(ttemp[i])))k++;
                }
                if(k==l.length()){
                    c = false;
                    break;
                }
            }
            
            if(c)detect(s);
        }
        
        //for(int i = 0; i < 9; i++)System.out.println(i + " " + avail[i]);
        
        
        return answer;
    }
}