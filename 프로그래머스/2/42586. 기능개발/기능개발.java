import java.util.*;

class Solution {

    
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[]arr = new int[speeds.length];
        for(int i = 0; i < speeds.length; i++){
            arr[i] = (100-progresses[i])/speeds[i]; 
            if((100-progresses[i])%speeds[i] != 0)arr[i]++;
        }
        
        Queue<Integer>temp = new ArrayDeque<>();
        for(int i = 0; i < speeds.length;){
            int day = arr[i]; int coun = 0;
            while(i < speeds.length && arr[i] <= day){
                coun++; i++;
            } 
            //System.out.println(coun);
            temp.add(coun);
        }
        answer = new int[temp.size()]; int c = 0;
        for(int i : temp){
            answer[c++] = i;
        }
        return answer;
    }
}