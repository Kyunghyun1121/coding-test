import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Deque<Integer>arr = new ArrayDeque<>();
        int c = numbers.length - 1;
        
        for(int i = numbers.length - 1; i >=0; i--){
            int temp = numbers[i]; int out = 0;
            //System.out.println(arr.getLast());
            
            while(arr.size() > 0 && arr.getLast() <= temp){
                arr.removeLast();
            }
                
            if(arr.size() == 0){
                out = -1;
            }else{
                out = arr.getLast();
            }
            
            //System.out.println(out + " " + temp);
            arr.addLast(temp);
            answer[i] = out;
        }
        
        
        return answer;
    }
}