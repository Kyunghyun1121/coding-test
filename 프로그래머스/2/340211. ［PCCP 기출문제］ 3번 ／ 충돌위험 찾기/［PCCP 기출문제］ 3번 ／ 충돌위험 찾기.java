import java.util.*;

class Solution {
    int[][] points;
    class robot{
        int x; int y; int goalX; int goalY;
        ArrayDeque<Integer>goal = new ArrayDeque<>();
        public robot(ArrayDeque<Integer>r){
            int start = r.removeFirst() - 1;
            x = points[start][1]; y = points[start][0];
            for(int i : r)  goal.add(i);
            setGoal();
        }
        
        public void setGoal(){
            if(goal.isEmpty()){
                goalX = 0; goalY = 0;
            }else{
                int start = goal.removeFirst() - 1;
                goalX = points[start][1]; goalY = points[start][0];
            }
            
        }
    }
    
    
    public int solution(int[][] point, int[][] routes) {
        int answer = 0;
        points = point;
        
        int[][]rem = new int[105][105];
        ArrayDeque<robot>arr = new ArrayDeque<>();
        for(int i = 0; i < routes.length; i++){
            ArrayDeque<Integer>r =new ArrayDeque<>();
            for(int j : routes[i])  r.add(j);
            
            arr.add(new robot(r));
        }
        
        for(robot temp : arr){
                if(rem[temp.y][temp.x] == 1){
                    answer++;
                    rem[temp.y][temp.x]++;
                }else if(rem[temp.y][temp.x] != 1){
                    rem[temp.y][temp.x]++;
                }
        }
        

        int qq = 1;
        while(arr.size() > 1){
            int count = arr.size();
            rem = new int[105][105];
            

            /*System.out.println("move"+qq);  qq++;
            System.out.println(answer);
            print(arr);*/
            
            for(int i = 0; i < count; i++){
                robot temp = arr.removeFirst();
                if(temp.goalY == 0 && temp.goalX == 0){
                    continue;
                }
                else if(temp.goalY != temp.y){
                    if(temp.y < temp.goalY)temp.y++;
                    else temp.y--;
                }else if(temp.goalX != temp.x){
                    if(temp.x < temp.goalX)temp.x++;
                    else temp.x--;
                }
                
                if(temp.goalY == temp.y && temp.goalX == temp.x){
                    temp.setGoal();
                }
                arr.add(temp);
                
                if(rem[temp.y][temp.x] == 1){
                    answer++;
                    rem[temp.y][temp.x]++;
                }else if(rem[temp.y][temp.x] != 1){
                    rem[temp.y][temp.x]++;
                }
                
            }
            
            
            
        
        }
        
        return answer;
    }
    public void print(ArrayDeque<robot>arr){
        
        for(robot i : arr){
            System.out.println(i.x + " " + i.y + " || " + i.goalX + " " + i.goalY);
        }
        System.out.println();
        System.out.println();
    }
}