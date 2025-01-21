import java.util.*;
class Solution {
    class want{
        char nameA; char nameB; char what;
        int num;
        public want(char a, char b,char d, int c){
            nameA = a;
            nameB = b;
            what = d;
            num = c;
        }
    }
    
    HashMap<Character, Integer>hash = new HashMap<>();
    Queue<want>datas = new ArrayDeque<>();
    String[]names = {"A", "C", "F", "J", "M", "N", "R", "T"};
    int answer = 0;
    int c = 0;
    
    public void dfs(int num, int[]arr, boolean[]use){
        if(num == 8){
            
            for(want i : datas){
                int aNum = arr[hash.get(i.nameA)];
                int bNum = arr[hash.get(i.nameB)];
                int diff = Math.abs(aNum-bNum) - 1;
                
                //if(c<10)System.out.println(i.nameA + " " + i.nameB +" " + diff);
                
                if(i.what == '<'){//이하
                    if(diff >= i.num) return;
                }else if(i.what == '='){//이상
                    if(diff != i.num)return;
                }else{
                    if(diff <= i.num)return;
                }
                
            }
            
            
            /*c++;
            if(c<50){for(int i = 0; i < 8; i++)System.out.print(arr[i]+" ");
            System.out.println();}*/
                       
            answer++;
            return;
        }
        
        int rem = arr[num];
        for(int i = 0; i < 8; i++){
            if(use[i])continue;
            arr[num] = i;
            use[i] = true;
            dfs(num+1, arr, use);
            use[i] = false;
        }
    }
    
    public int solution(int n, String[] data) {
        //int answer = 0;
        
        for(int i = 0; i < data.length; i++){
            char[]temp = data[i].toCharArray();
            datas.add(new want(temp[0], temp[2], temp[3], temp[4]-'0'));  
            //System.out.println(temp[0] + " " + temp[2]);
        }
        
        for(int i = 0; i < 8; i++)  hash.put(names[i].charAt(0), i);
        for(int i = 0; i < 8; i++)  dfs(0, new int[8], new boolean[8]);
        
        
        return answer/8;
    }
}