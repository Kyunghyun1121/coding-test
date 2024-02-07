import java.io.*;
import java.util.*;


public class Main {

    public static class square{
        int x;
        int y;
        int z;

        public square(int j, int k, int l) {
            z = j; y = k; x = l;
        }
    }






    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int garo = Integer.parseInt(st.nextToken());
        int sero = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int n = 0;
        int [][][]apple;

        Deque<square> box = new ArrayDeque<>();

        apple = new int[height+2][sero+2][garo+2];


        int in;

        for(int j = 1; j <= height; j++){
            for(int k = 1; k <= sero; k++){
                st = new StringTokenizer(br.readLine());
                for(int l = 1; l <= garo; l++){
                    in = Integer.parseInt(st.nextToken());
                    apple[j][k][l] = in;
                    if(in == 1)box.add(new square(j,k,l));
                    if(in == -1)n++;
                }
            }
        }




        int allSize = garo * sero * height;
        int count = box.size();


        int time = 0;
        int tx,ty,tz;
        int[] mx = {0,0,0,0,-1,1};
        int[] my = {0,0,1,-1,0,0};
        int[] mz = {1,-1,0,0,0,0};

        if(count==(allSize-n)){
            System.out.println(0);
        }else{
            int lastNum = box.size();
            while (!box.isEmpty()){
                square temp = box.removeFirst();
                lastNum--;
                
                for(int i = 0; i < 6; i++){
                    tz = temp.z + mz[i];
                    ty = temp.y + my[i];
                    tx = temp.x + mx[i];
                    if(tz > height || ty > sero || tx > garo || tz <=0 || ty <=0 || tx <=0)continue;
                    if(apple[tz][ty][tx] == 0) {
                        apple[tz][ty][tx] = 1;
                        count++;
                        box.add(new square(tz, ty, tx));
                    }
                }

                if(!box.isEmpty() && lastNum == 0){
                    time++;
                    lastNum = box.size();
                }

            }


            if(count!=(allSize-n)) System.out.println(-1);
            else{
                System.out.println(time);
            }
        }



    }



}
