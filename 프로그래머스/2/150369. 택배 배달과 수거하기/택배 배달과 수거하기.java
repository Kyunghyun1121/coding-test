import java.util.*;
class Solution {
    LinkedList<box>delivery = new LinkedList<>();
    LinkedList<box>pickup = new LinkedList<>();
    int deliveryLast = 0;
    int pickupLast = 0;
    int cap = 0;;
    
    class box{
        int weight;
        int num;
        public box(int a, int b){
            weight = b; num = a;
        }
    }
    
    public long solution(int ca, int n, int[] deliveries, int[] pickups) {
        long answer = 0; cap= ca;

        for(int i = n-1; i >= 0; i--){
            if(deliveries[i]!=0)delivery.add(new box(i+1, deliveries[i]));
            if(pickups[i]!=0)pickup.add(new box(i+1, pickups[i]));
        }
        
        int go = 0; int come = 0;
        
            /*for(box a : delivery)System.out.print(a.weight+" ");
            System.out.println();
            for(box a : pickup)System.out.print(a.weight+" ");
            System.out.println();*/
        
        while(!delivery.isEmpty() && !pickup.isEmpty()){
            go = deliverBox();
            come = pickupBox(go);
            answer+= go + come;
            
            /*            System.out.println();
            System.out.println(go);System.out.println(come);System.out.println();
            
            for(box a : delivery)System.out.print(a.weight+" ");
            System.out.println();
            for(box a : pickup)System.out.print(a.weight+" ");
            System.out.println();
            System.out.println(answer);*/
        }
        
        while(!delivery.isEmpty())answer+= deliverBox()*2;
        
        while(!pickup.isEmpty())answer+= pickupBox(0);
        
        return answer;
    }
    
    
    public int deliverBox(){
        int sum = 0;
        int now = 0;    
        now = delivery.get(0).num;
        
        while(sum < cap && !delivery.isEmpty()){
            box goal = delivery.remove();
            
            sum += goal.weight;
            if(sum > cap){
                goal.weight = sum - cap;
                delivery.addFirst(goal);
                break;
            }
        }
        
        //System.out.println("delievery" + now);
        return now;
    }
    
    public int pickupBox(int s){
        int sum = 0; int now = s;
        if(s < pickup.get(0).num){
            now = pickup.get(0).num + pickup.get(0).num - s;
        } 
        
        while(sum < cap && !pickup.isEmpty()){
            box goal = pickup.remove();
            
            sum += goal.weight;
            if(sum > cap){
                goal.weight = sum - cap;
                pickup.addFirst(goal);
                break;
            }
        }
        
        //System.out.println("pickup" + now);
        return now;
    }
    
    
}