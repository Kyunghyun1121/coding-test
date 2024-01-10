import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {

    static Deque<Integer> out = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;
        StringBuilder sb = new StringBuilder();


        int cas = Integer.parseInt(br.readLine());
        for(int i = 0; i< cas; i++){

            stringTokenizer = new StringTokenizer(br.readLine());

            switch (stringTokenizer.nextToken()){
                case "push":
                    out.add(Integer.valueOf(stringTokenizer.nextToken()));
                    break;
                case "pop":
                    if(out.peek() == null){
                        sb.append(-1).append('\n');
                    }else{
                        int temp = out.peek();
                        out.remove(temp);
                        sb.append(temp).append('\n');
                    }
                    break;
                case "size":
                    sb.append(out.size()).append('\n');
                    break;
                case "empty":
                    if(out.isEmpty()){
                        sb.append(1).append('\n');
                    }else{
                        sb.append(0).append('\n');
                    }
                    break;
                case "front":
                    if(out.peek() == null){
                        sb.append(-1).append('\n');
                    }else{
                        sb.append(out.peek()).append('\n');
                    }
                    break;
                case "back":
                    if(out.peek() == null) {
                        sb.append(-1).append('\n');
                    }
                    else {
                        sb.append(out.peekLast()).append('\n');
                    }
                    break;
            }


        }
        System.out.print(sb);

    }

}


