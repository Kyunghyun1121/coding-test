import java.io.*;
import java.util.*;


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        char[] plain = br.readLine().toCharArray();
        Stack<String>left = new Stack<>();
        Stack<String>right = new Stack<>();
        for (char c : plain) {
            left.add(String.valueOf(c));
        }

        int cas = Integer.parseInt(br.readLine());

        for (int i = 0; i < cas; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("L")){
                if(!left.isEmpty())right.push(left.pop());
            }else if(s.equals("D")){
                if(!right.isEmpty()){
                    left.push(right.pop());
                }
            }else if(s.equals("B")){
                if(!left.isEmpty())left.pop();
            }else{
                left.push(st.nextToken());
            }
        }

        while(!left.isEmpty())
            right.push(left.pop());

        while(!right.isEmpty())
            sb.append(right.pop());
        System.out.println(sb);

    }


}

