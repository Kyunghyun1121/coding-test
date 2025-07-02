import java.util.*;

class Solution {
    
    public class work{
        int num;
        int startTime;
        int needTime;
        public work(int a, int b, int c){
            num = a;
            startTime = b;
            needTime = c;
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<work>q = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(work a, work b){
                if(a.needTime == b.needTime){
                    if(a.startTime == b.startTime)
                        return a.num - b.num;
                    else 
                        return a.startTime - b.startTime;
                }else{
                    return a.needTime - b.needTime;
                }
            }
        });
        
        PriorityQueue<work>remain = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(work a, work b){
                return a.startTime - b.startTime;
            }
        });
        
        
        for(int i = 0; i < jobs.length; i++)
            remain.add(new work(i, jobs[i][0], jobs[i][1]));
        

        
        for(int i = 0; i < 501000; ){
            //System.out.println(i);
            if(remain.isEmpty() && q.isEmpty())break;
            
            while(!remain.isEmpty()){
                work a = remain.remove();
                if(a.startTime > i){
                    remain.add(a);
                    break;
                }else{
                    q.add(a);
                }
            }
            
            if(!q.isEmpty()){
                work a = q.remove();
                i += a.needTime;
                answer += (i - a.startTime);
                System.out.println(a.num + " " + i);
            }else{
                i++;
            }
                
            
        }
        
        return answer / jobs.length;
    }
}