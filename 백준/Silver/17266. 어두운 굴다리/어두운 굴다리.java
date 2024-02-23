import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int length = Integer.parseInt(br.readLine());
        int lightNum = Integer.parseInt(br.readLine());
        int []position = new int[lightNum+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        position[0] = Integer.parseInt(st.nextToken());
        int longest = position[0];

        for (int i = 1; i < lightNum; i++) {
            position[i] = Integer.parseInt(st.nextToken());
            int temp = position[i] - position[i-1];
            if(temp%2 == 0){
                temp /=2;
            }else{
                temp/=2; temp++;
            }
            longest = Math.max(longest, temp);
        }
        longest = Math.max(longest, length - position[lightNum-1]);

        System.out.println(longest);
    }


}
