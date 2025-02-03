import java.util.*;
class Solution {

    public long solution(int[] diffs, int[] times, long limit) {
        long answer = 0;
        
        int[]rem = new int[diffs.length];
        for(int i= 0; i < diffs.length; i++) rem[i] = diffs[i];
        Arrays.sort(rem);
        
        long start = 1; long end = rem[diffs.length-1];
        
        while(start <= end){
            long mid = (start + end) / 2;
            
            long time = calcTime(mid, diffs, times);
            //System.out.println(start + " " + end + " " + time);
            
            if(time > limit){
                start = mid + 1;
            }else{
                answer = mid;
                end = mid - 1;
            }
        }

        return answer;
    }
    
    
    public long calcTime(long level, int[] diffs, int[] times){
        long time = times[0];
        for(int i = 1; i < diffs.length; i++){
            if(diffs[i] > level){
                time += ((diffs[i] - level) * (times[i] + times[i-1]));
            }
            
            time += times[i];
        }
        
        return time;
    }
}