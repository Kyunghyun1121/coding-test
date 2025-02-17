import java.util.*;
class Solution {
    
    public int solution(int n, int[] stations, int w) {
        int answer = 0; 
        
        Arrays.sort(stations);
        int past = 1;   int wide = w * 2 + 1;
        for(int i = 0; i < stations.length; i++){
            int size = stations[i] - w - past;
            answer += size / wide;
            if(size % wide > 0)answer++;
            
            past = stations[i] + w + 1;
            //System.out.println(past);
        }
        
        if(stations[stations.length-1] + w < n){
            int size = n - (stations[stations.length-1] + w);
            answer += size / wide;
            if(size % wide > 0)answer++;
        }
            
        
        
        //for(int i : arr) System.out.print(i + " ");
        //System.out.println(wide);

        
        return answer;
    }
    
}