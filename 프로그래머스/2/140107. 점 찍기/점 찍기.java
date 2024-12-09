import java.util.*;
class Solution {
    public static long solution(int k, int d) {
        long answer = 0;

        // x 좌표를 k 배수만큼 증가
        for(int i=0; i<=d; i+=k){
            answer += (int)(Math.sqrt((long) d*d-(long) i*i))/ k + 1;
        }
        return answer;
    }



}