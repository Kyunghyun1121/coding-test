import java.util.*;
class Solution {
    class job{
        String name;
        int time;
        int need;
        public job(String a, String b, String c){
            name = a; 
            time = Integer.valueOf(b.substring(0,2))*60 + Integer.valueOf(b.substring(3,5)); 
            need = Integer.valueOf(c);
        }
    }
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length]; int c = 0;
        Stack<job>arr = new Stack<>();
        job[]plan = new job[plans.length];
        for(int i = 0; i < plans.length; i++)
            plan[i] =  new job(plans[i][0], plans[i][1], plans[i][2]);
        Arrays.sort(plan, new Comparator<>(){
            @Override
            public int compare(job a, job b){
                return a.time - b.time;
            }
        });
        
        int now = plan[0].time; arr.push(plan[0]);
        for(int i = 1; i < plans.length; i++){
            //System.out.println(plan[i].name);
            job temp = plan[i];
            if(arr.size() == 0)now = temp.time;
            
            while(now < temp.time && arr.size() > 0){
                job p = arr.pop();
                if(p.need + now <= temp.time){
                    now += p.need;
                    answer[c++] = p.name;
                }else {
                    int avail = temp.time - now;
                    p.need -= avail;
                    now = temp.time;
                    arr.push(p);
                }
            }
            if(arr.size() == 0)now = temp.time;
            arr.push(temp);
            
            /*System.out.println(now/60 + ":" + now%60);
            for(job a : arr){
                System.out.println(a.name + " " + a.need);
            }System.out.println();*/
        }
        
        while(arr.size()>0)answer[c++] = arr.pop().name;
        
        return answer;
    }
}