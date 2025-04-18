import java.util.*;

class Solution {
    char[][]arr;
    boolean[][]rem;
    HashSet<point>edge = new HashSet<>();
    int n;
    int m;
    
    int[]dx = {0,0,1,-1};
    int[]dy = {1,-1,0,0};

    
    class point{
        int x;
        int y;
        public point(int a, int b){
            y = a; x = b;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
        
        @Override 
        public boolean equals(Object a){
            point b = (point) a;
            if(x == b.x && y == b.y)return true;
            else return false;
        }
        
    }
    
    public void delete(char a){
       for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] == a){
                    arr[i][j] = ' ';
                    edge.remove(new point(i, j));
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(findEdge(i,j)){
                    edge.add(new point(i, j));
                }
            }
        }
        
    }
    
    public void add(int y, int x){
        arr[y][x] = ' ';
        edge.remove(new point(y, x));
        
        for(int i= 0; i < 4; i++){
            int tx = x + dx[i];
            int ty = y + dy[i];
            if(tx < 0 || tx == m || ty < 0 || ty == n) continue;
            
            while(tx + dx[i] >= 0 && tx + dx[i] < m 
                  && ty + dy[i] >= 0 && ty + dy[i] < n 
               && arr[ty][tx] == ' '){
                tx += dx[i];
                ty += dy[i];
            }
                
                
            if(findEdge(ty, tx))
                edge.add(new point(ty, tx));
            //t.push(new point(ty,tx));
        }
        //System.out.println(x + " " + y + " " + t.size());
        // if(t.size() < 4){
        //     for(point temp : t){
        //         edge.add(new point(temp.y, temp.x));
        //     }
        // }
    }
    
    public boolean findEdge(int y, int x){
        ArrayDeque<point>find = new ArrayDeque<>();
        find.add(new point(y, x));
        if(x == 0 || x == m-1 || y == 0 || y == n-1)return true;
        
        rem = new boolean[n+1][m+1];
        while(!find.isEmpty()){
            point temp = find.pop();
            for(int i = 0; i < 4; i++){
                int tx = temp.x + dx[i];
                int ty = temp.y + dy[i];
                if(tx >= 0 && tx < m && ty >= 0 && ty < n && !rem[ty][tx]){
                    rem[ty][tx] = true;
                    if((tx == 0 || tx == m-1 || ty == 0 || ty == n-1) 
                       && arr[ty][tx] == ' ')
                            return true;
                    
                    if(arr[ty][tx] == ' ')
                        find.add(new point(ty, tx));
                }
            }
        }
        
        return false;
    }
    
    public void print(){
       for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(arr[i][j]);
            }
             System.out.println();
        }
        System.out.println();
    }
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        
        n = storage.length;
        m = storage[0].length();
        arr = new char[n+1][m+1];
        rem = new boolean[n+1][m+1];
        for(int i = 0; i < n; i++) arr[i] = storage[i].toCharArray();
        
        
        for(int i = 0; i < m; i++)edge.add(new point(0,i));
        for(int i = 0; i < m; i++)edge.add(new point(n-1,i));
        for(int i = 0; i < n; i++)edge.add(new point(i,0));
        for(int i = 0; i < n; i++)edge.add(new point(i,m-1));
        
        //for(point i : edge)System.out.println(i.x + " " + i.y);
        for(String order : requests){
            //print();
            
            char a = order.charAt(0);
            if(order.length() == 2){    
                delete(a);
            }else{
                ArrayDeque<point>t = new ArrayDeque<>();
                for(point temp : edge){
                    if(arr[temp.y][temp.x] == a){
                        arr[temp.y][temp.x] = ' ';
                        //t.push(new point(temp.y, temp.x));
                    }
                }
                
                // for(point temp : t){
                //     add(temp.y, temp.x);
                // }
                
                
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < m; j++){
                        if(arr[i][j] == ' '){
                            edge.remove(new point(i, j));
                        }
                        else if(findEdge(i,j)){
                            edge.add(new point(i, j));
                        }
                    }
                }
            }
             // for(point temp : edge){
             //         System.out.println(temp.y + " " + temp.x + " " + 
             //                           arr[temp.y][temp.x]);
             //     }
        }
        //print();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] != ' '){
                   answer++;
                }
            }
        }
        
        return answer;
    }
}