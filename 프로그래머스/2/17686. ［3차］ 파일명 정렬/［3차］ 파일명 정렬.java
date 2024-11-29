import java.util.*;
class Solution {
    class file{
        String head; int number; String tail; String full; int num;
        public file(String s, int num){
            full = s; this.num = num;
            char[]temp = s.toCharArray();
            int count = 0;
            for(; count < temp.length; count++){
                if(temp[count] - '0' >= 0 && temp[count] - '0' <= 9){
                    head = s.substring(0,count).toLowerCase();
                    s = s.substring(count);
                    break;
                }
            } 
            for(int i = 0; i < 5 && count < temp.length ; i++){

                //System.out.println(temp[count]);

                if(temp[count] < '0' || temp[count] > '9'){
                    //System.out.println(temp.length);
                    number = Integer.parseInt(s.substring(0,i));
                    s = s.substring(i);
                    break;
                }
                if(i == 4 || count == temp.length-1){
                    number = Integer.parseInt(s.substring(0,i+1));
                    s = s.substring(i+1);
                    break;
                }
                count++;
            }
            
            tail = s.toLowerCase();
            
        }
        

    }
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        file[]arr = new file[files.length]; int c = 0;
        
        for(int i = 0; i < files.length; i++){
            arr[c++] =  new file(files[i], i);
            //System.out.println(arr[c-1].head + " " + arr[c-1].number + " " + arr[c-1].tail);
        }
        
        Arrays.sort(arr, new Comparator<file>(){
            @Override
            public int compare(file a, file b){
                if(a.head.equals(b.head)){
                    if(a.number == b.number){
                        return a.num - b.num;
                    }else{
                        return a.number - b.number;
                    }
                }else{
                    return a.head.compareTo(b.head);
                }
                
            }
        });
        c = 0;
        for(file t : arr)answer[c++] = t.full;
        
        
        return answer;
    }
}