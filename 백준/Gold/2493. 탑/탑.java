
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int answer = 0;
        int num = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[]ans = new int[num];
        int[]in = new int[num];

        for(int i = 0; i < num; i++){
            in[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();

        for(int i = num - 1; i >= 0; i--){
            //System.out.println(stack);

                while(!stack.isEmpty() && in[stack.peek()] < in[i]){
                    int temp = stack.pop();
                    ans[temp] = i + 1;
                }
                stack.push(i);

        }

        for(int i = 0; i < num; i++)    sb.append(ans[i]).append(" ");
        System.out.println(sb.toString());

    }



}
