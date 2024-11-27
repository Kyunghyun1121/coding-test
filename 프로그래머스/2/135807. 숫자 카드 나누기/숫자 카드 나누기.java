import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        Arrays.sort(arrayA);    Arrays.sort(arrayB);

        
        int a = gcd(arrayA);

            boolean c = true;
            for(int i = 0; i < arrayB.length; i++){
                if(arrayB[i]%a==0){
                    c = false; break;
                }
            }
            if(c)answer = a;
        
        
        if(arrayB[0] <= answer)return answer;
        a = gcd(arrayB);
        
            c = true;
            for(int i = 0; i < arrayA.length; i++){
                if(arrayA[i]%a==0){
                    c = false; break;
                }
            }
            if(c)answer = Math.max(answer,a);
        
        
        return answer;
    }
    
    public int gcd(int[]a){

        int temp = a[0];
        for(int i = 1; i < a.length; i++){
            temp = gcd(temp, a[i]);
        }
        
        return temp;
    }
    
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}