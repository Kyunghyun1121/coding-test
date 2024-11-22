class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        int temp = 10;

        while(storey > 0){
            int t = storey % 10;
            storey/=10;
            
            if(t > 5 || (t == 5 && storey % 10 >= 5)){
                t = 10 - t;
                storey++;
            }
            answer += t;
            

            //System.out.println(storey + " " + answer);
            //if(storey < 10)break;
        }
        
        /*if(storey > 5){
            storey = 10 - storey + 1;
        }
        answer += storey;*/
            
        
        return answer;
    }
}