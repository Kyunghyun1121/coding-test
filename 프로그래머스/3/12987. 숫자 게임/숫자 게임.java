import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A); int aLast = A.length - 1; int aStart = 0;
        Arrays.sort(B); int bLast = aLast; int bStart = 0;
        
        while(bLast >= bStart){
            if(A[aLast] >= B[bLast]){
                aLast--; bStart++;
            }else{
                //System.out.println()
                aLast--; bLast--; answer++;
            }
        }
        
        
        return answer;
    }
}