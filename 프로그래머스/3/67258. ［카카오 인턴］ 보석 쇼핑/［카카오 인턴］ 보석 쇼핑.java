import java.util.*;

class Solution {

    public void print(HashMap<String, Integer> arr){
        System.out.println(arr.size());
        for(String s : arr.keySet())System.out.print(s + arr.get(s) + " ");
        System.out.println();
    }
    
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        HashMap<String, Integer> gemArr = new HashMap<>();
        for(int i = 0; i < gems.length; i++)gemArr.put(gems[i],1);
        int kindSum = gemArr.size();
        System.out.println(gemArr.size());
        /*for(int i = 0; i < gems.length; i++)kindRem[i].print();*/
        HashMap<String, Integer> arr = new HashMap<>();
        
        int minCount = gems.length + 2;
        int start = 0;  int end = start;
        int count = 0;
        
        while(start <= end){
            if(arr.size() < kindSum && end == gems.length)break;
                
            int temp = arr.size();
            if(temp < kindSum){
                if(arr.containsKey(gems[end]))  arr.replace(gems[end], arr.get(gems[end]) + 1);
                else    arr.put(gems[end], 1);
                end++;  count++;
            }else{
                if(arr.get(gems[start]) != 1)  
                    arr.replace(gems[start], arr.get(gems[start]) - 1);
                else    arr.remove(gems[start]);
                start++;    count--;
            }
            
            if(arr.size() == kindSum && count < minCount){
                    //System.out.println(count + " " + start + " " + end);
                    minCount = count;
                    answer[0] = start + 1;
                    answer[1] = end;
            }//print(arr);
            
        }
        


        
        return answer;
    }
}