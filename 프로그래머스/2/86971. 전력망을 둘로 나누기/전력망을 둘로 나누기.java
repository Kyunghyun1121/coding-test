import java.util.*;

class Solution {

    
    public int solution(int n, int[][] wires) {
        int answer = 100000;
        
        ArrayList<ArrayList<Integer>>wire = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            wire.add(new ArrayList<Integer>());
            wire.get(i).add(101);
        }
            
        for(int i = 0; i < wires.length; i++){
            int one = wires[i][0] - 1;
            int two = wires[i][1] - 1;
            wire.get(one).add(two);
            wire.get(two).add(one);
        }
        //for(int i = 0; i < n; i++) System.out.println(i + " " + wire.get(i));
        
        for(int i = 0; i < wires.length; i++){
            Integer one = wires[i][0] - 1;
            Integer two = wires[i][1] - 1;
            
            wire.get(one).remove(two);
            wire.get(two).remove(one);
            
            boolean[]rem = new boolean[n];
            

                
                int count = 0;
                ArrayDeque<Integer>q = new ArrayDeque<>();
                q.add(0);
            rem[0] = true;
                while(!q.isEmpty()){
                    int now = q.remove();
                    count++;
                    //System.out.println(now + " " + count);
                    for(int k : wire.get(now)){
                        if(k != 101 && !rem[k]){
                            q.add(k);
                            rem[k] = true;
                        }
                    }
                }
                
                //System.out.println(count);
            //System.out.println();
                // if(compare == -1)compare = count;
                // else compare = Math.abs(compare - count);
                
            
            
            answer = Math.min(answer,  Math.abs(n - count - count));
            wire.get(one).add(two);
            wire.get(two).add(one);
        }
        
        return answer;
    }

    
}