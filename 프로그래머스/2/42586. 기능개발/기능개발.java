import java.util.*;

class Solution {
    public ArrayDeque<Integer> solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        int[]needs = new int[speeds.length];
        for(int i = 0; i < speeds.length; i++){
            needs[i] = (100-progresses[i]) / speeds[i];
            if((100-progresses[i]) % speeds[i] > 0)needs[i]++;
        }
        //for(int i : needs)
         //   System.out.print(i + " ");
        
        //System.out.println();
        
        ArrayDeque<Integer>time = new ArrayDeque<>();
        int wait = needs[0];
        int count = 1;
        
        for(int i = 1; i < speeds.length; i++){
            if(needs[i] > wait){
                time.add(count);
                count = 1;
                wait = needs[i];
            }else{
                count++;
            }
        }
        
        time.add(count);
        
        //System.out.println(time);
        
        
        return time;
    }
}