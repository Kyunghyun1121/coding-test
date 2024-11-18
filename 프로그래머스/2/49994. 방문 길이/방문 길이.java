import java.util.*;

class Solution { 
    
    class rem{
        int nx,ny,fx,fy;
        public rem(int a, int b, int c, int d){
            nx = a; ny = b; fx = c; fy = d;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this.getClass() != obj.getClass()) return false;
            return (((rem) obj).nx == this.nx) && (((rem) obj).ny == this.ny
                        && ((rem) obj).fx == this.fx) && (((rem) obj).fy == this.fy);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nx, ny, fx, fy);
        }
    }
    
    public int solution(String dirs) {
        int answer = 0;
        
        HashSet<rem>arr = new HashSet<>();
        int x = 0; int y = 0; boolean c; int fx; int fy;
        for(char s : dirs.toCharArray()){
            fx = x; fy  = y;
            if(s == 'U'){
                fy++;
            }else if(s == 'D'){
                fy--;
            }else if(s == 'R'){
                fx++;
            }else{
                fx--;
            }
            if(fx > 5 || fx < -5 || fy > 5 || fy < -5 )continue;
            //System.out.println(arr.contains(new rem(x,y,fx,fy)));
            
            if(arr.add(new rem(x,y,fx,fy)) && arr.add(new rem(fx,fy,x,y))){
                answer++;
                //System.out.println(s +" "+ x +" "+ y +" "+ fx +" "+ fy );
            }
            x = fx; y = fy;
        }
        
        return answer;
    }
    

}