class Solution {
    String[]words;  String begin; String target;
    boolean[]rem; int len; int out = 10000000;
    
    public void dfs(String now, int next, int count){
        //System.out.println(now + "  " + count);
        if(now.equals(target)){
            out = Math.min(out, count); 
            return;
        }
        
        int sum = 0;
        for(int i = 0; i < now.length(); i++)if(now.charAt(i)!=words[next].charAt(i))sum++;
        if(sum > 1)return;
        
        rem[next] = true;
        for(int i = 0; i < len; i++){
            if(!rem[i]){
                dfs(words[next], i, count+1);
            }
        }
        rem[next] = false;
    }
    
    public int solution(String b, String t, String[] w) {
        int answer = 0; words = w; len = w.length;
        begin = b; target = t;
        
        rem = new boolean[w.length+10];
        for(int i = 0; i < len; i++){
            dfs(begin, i, 0);
        }
        
        if(out == 10000000)out = 0;
        return out;
    }
}