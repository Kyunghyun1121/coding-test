import java.util.*;

class Solution {

    
    
    public int solution(int[] queue1, int[] queue2) {
        
        
        
        int answer = -2;
        int l = queue1.length;
        int[] q1 = new int[l*2];
        int[] q2 = new int[l*2];
        
        long os = 0;
        long ts = 0;
        for(int i = 0; i < l; i++){
            q1[i] = queue1[i];
            q2[i] = queue2[i];
            os += queue1[i];
            ts += queue2[i];
            
            q1[i+l] = queue2[i];
            q2[i+l] = queue1[i];
        }
        
        

        int i =0;
        int j = 0;
        int count = 0;
        
        while(i < l*2 || j < l*2){
            if(os > ts){
                if(i >= l*2)return -1;
                ts += q1[i];
                os -= q1[i];
                i++;
            }else if(os < ts){
                if(j >= l*2)return -1;
                ts -= q2[j];
                os += q2[j];
                j++;
            }else{
                return count;
            }
            count++;
        }
        
        return -1;
    }
}