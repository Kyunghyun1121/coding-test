
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int sero = Integer.parseInt(st.nextToken());
        int garo = Integer.parseInt(st.nextToken());
        int answer = 0;

        int max = -1;
        st = new StringTokenizer(br.readLine());
        ArrayDeque<Integer> q = new ArrayDeque<>();

        while(st.hasMoreTokens()){
            int temp = Integer.parseInt(st.nextToken());
            if(max == -1){
                max = temp;
            }else{
                if(max <= temp){
                    int tempSum = (q.size()) * (max);
                    while(!q.isEmpty()){
                        tempSum -= q.removeFirst();
                    }
                    answer += tempSum;
                    //System.out.println(tempSum);
                    max = temp;
                }else{
                    q.addLast(temp);
                }
            }
        }

        q.addFirst(max);
        //14
        max = -1;
        ArrayDeque<Integer> q2 = new ArrayDeque<>();
        while(!q.isEmpty()){
            int temp = q.removeLast();
            if(max == -1){
                max = temp;
            }else{
                if(max <= temp){
                    int tempSum = (q2.size()) * (max);
                    while(!q2.isEmpty()){
                        tempSum -= q2.removeFirst();
                    }
                    answer += tempSum;
                    //System.out.println(tempSum);
                    max = temp;
                }else{
                    q2.addLast(temp);
                }
            }
        }

        System.out.println(answer);
    }
}
