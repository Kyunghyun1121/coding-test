class Solution
{ //2 1   4 2 8 3 16 4
    public int solution(int n, int a, int b)
    { //1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
        int answer = 0;
        int start = 1; int end = n;
        while(start < end){
            int half = (start + end) /2;
            if(half < a && half < b){
                start = half + 1;
            }
            else if(half >= a && half >= b){
                end = half;
            }else{
                //System.out.println("damn");
                answer = cal(end - start + 1); break;
            }
            //System.out.println(start + " " + end + " " + cal(half - start + 1));
        }
        
        return answer;
    }
    public int cal(int num){
        int c = 0;
        while(num > 1){
            num/=2; c++;
        }
        return c;
    }
}