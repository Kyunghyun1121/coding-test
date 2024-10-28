class Solution {
    public int solution(int n) {
        int answer = n+1;
        int c = count(n);
        
        while(count(answer) != c)answer++;
        
        return answer;
    }
    
    int count(int n){
        int out = 0;
        while(n>1){
            if(n%2==1)out++;
            n/=2;
        }
        if(n==1)out++;
        return out;
    }
}