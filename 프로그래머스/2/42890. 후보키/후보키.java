import java.util.*;

class Solution {
    ArrayList<ArrayList<Integer>>keys = new ArrayList<>();
    int answer = 0;
    ArrayList<ArrayList<Integer>>what = new ArrayList<>();
    String[][] relation;

    public void dfs(int now, int max, ArrayList<Integer> list){
        if(list.size() == max){
            //System.out.println(list);
            what.add(list);
            
            if(find(list)){
                answer++;
                //System.out.println(list);
                keys.add(new ArrayList<>(list));
            }
            
            return;
        } 
        for(int i = now + 1; i < relation[0].length; i++){
            
            list.add(i);
            dfs(i, max, list);
            list.remove(list.size() - 1);
        }
    }
    
    public int solution(String[][] relations) {
        relation = relations;
        what = new ArrayList<>();
        //check = new boolean[relations[0].length];
        
        for(int j = 1; j <= relations[0].length; j++){
            for(int i = 0; i < relations[0].length; i++){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                dfs(i, j, temp);
                //System.out.println(i + " " + j);
            }
        }
        
        return answer;
    }
    
    public boolean find(ArrayList<Integer> temp){
        HashSet<String>q = new HashSet<>();
        for(int i = 0; i < relation.length; i++){
            
            String now = "";
            for(int t : temp){
                now += " " + relation[i][t];
            }
            
            if(q.contains(now))return false;
            else q.add(now);
        }
        
        for(ArrayList<Integer> t : keys){
            if(temp.containsAll(t)) return false;
        }
        return true;
        
    }

}