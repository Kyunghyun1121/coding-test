import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
        Deque<Integer> a = new ArrayDeque<>();
        for(int i = 0; i < arr.length; i++){
            if(a.isEmpty() || a.getLast() != arr[i])a.add(arr[i]);
        }
        
        int i = 0; answer = new int[a.size()];
        for(int temp : a){
            answer[i++] = temp;
        }

        return answer;
    }
}