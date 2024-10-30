import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        
        HashMap<Integer,Integer>arr = new HashMap<>();
        

        for(int i = 0; i < tangerine.length; i++){
            if(arr.containsKey(tangerine[i]))arr.replace(tangerine[i],arr.get(tangerine[i])+1);
            else arr.put(tangerine[i],1);
        }
        List<Integer>key = new ArrayList<>(arr.keySet());
        key.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return arr.get(b).compareTo(arr.get(a));
            }
        });
        
        int sum = 0;
        for(Integer temp : key){
            //System.out.println(temp + " " + arr.get(temp));
            if(sum < k){
                sum += arr.get(temp); answer++;
            }else{
                break;
            }
        }
        
        return answer;
    }
}