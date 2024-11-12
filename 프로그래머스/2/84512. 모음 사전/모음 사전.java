class Solution {
    int count = 0; boolean end = false; int answer = 0;
    char[] arr = {'A','E','I','O','U'};
    
    public void dfs(int c, String temp, String word){
        //if(count < 30)System.out.println(temp + " " + word);
        count++;
        
        
    
        if(temp.equals(word)){
            System.out.println(count); 
            answer = count - 1;
            end = true; return; 
        }
        if(c>4 || end)return;
        
        for(char s : arr){
            dfs(c+1, temp + s, word);
        }
    }
    
    public int solution(String word) {
        //int answer = 0; 
        dfs(0,"",word);
        
        
        return answer;
    }
}