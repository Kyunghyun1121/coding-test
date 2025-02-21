import java.util.*;

class Solution {
    ArrayList<ArrayList<String>>q = new ArrayList<>();
    ArrayList<ArrayList<String>>finish = new ArrayList<>();
    int out = 0;
    
    public boolean check(String user, String bann){
        if(user.length() != bann.length())return false;
        for(int i = 0; i < user.length(); i++){
            if(bann.charAt(i) == '*')continue;
            else if(bann.charAt(i) != user.charAt(i)) return false;    
        }
        return true;
    }
    
    public boolean compare(ArrayList<String> a, ArrayList<String> b){
        
        for(String s : a) if(!b.contains(s))return true;
        
        return false;
    }
    
    public void dfs(ArrayList<String>rem, int num){
        if(rem.size() == q.size()){
            
            for(ArrayList<String> temp : finish){
                if(!compare(temp, rem)) return;
            }
            
            
            /*for(ArrayList<String> temp : finish){
                for(String s : temp)System.out.print(s + " ");
                System.out.println();
            }*/

            //System.out.println(finish.size());
            ArrayList<String> in = new ArrayList<>();
            for(String s : rem){
                in.add(s);
            }
            finish.add(in);
            out++;  return;
        }
        
        
        for(String s : q.get(num)){
            if(!rem.contains(s)){
                rem.add(s);
                dfs(rem, num+1);
                rem.remove(s);
            }
        }
        
    }
    
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        
        HashMap<String, Integer>count = new HashMap<>();
        for(int i = 0; i < banned_id.length; i++)
            q.add(new ArrayList<>());
        
        for(int j = 0; j < user_id.length; j++){
            for(int i = 0; i < banned_id.length; i++){
                if(check(user_id[j],banned_id[i])){
                    q.get(i).add(user_id[j]);
                }
            }
        }
        
        /*for(int i = 0; i < banned_id.length; i++){
            ArrayList<String> temp = q.get(i);
            System.out.print(banned_id[i] + " " + temp.size());
            for(String t : temp)System.out.print(" " + t);
            System.out.println();
        }*/
        
        dfs(new ArrayList<>(),0);
        
            
        return out;
    }
}