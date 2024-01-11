import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {

    static Deque<Integer> out = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;
        StringBuilder sb = new StringBuilder();


        int cas = Integer.parseInt(br.readLine());
        for(int i = 0; i< cas; i++){

            stringTokenizer = new StringTokenizer(br.readLine());

            switch (stringTokenizer.nextToken()){
                case "1":
                    out.addFirst(Integer.valueOf(stringTokenizer.nextToken()));
                    break;
                case "2":
                    out.addLast(Integer.valueOf(stringTokenizer.nextToken()));
                    break;
                case "3":
                    if(out.peek() == null){
                        sb.append(-1).append('\n');
                    }else{
                        int temp = out.peekFirst();
                        out.removeFirst();
                        sb.append(temp).append('\n');
                    }
                    break;
                case "4":
                    if(out.peek() == null){
                        sb.append(-1).append('\n');
                    }else{
                        int temp = out.peekLast();
                        out.removeLast();
                        sb.append(temp).append('\n');
                    }
                    break;
                case "5":
                    sb.append(out.size()).append('\n');
                    break;
                case "6":
                    if(out.isEmpty()){
                        sb.append(1).append('\n');
                    }else{
                        sb.append(0).append('\n');
                    }
                    break;
                case "7":
                    if(out.peek() == null){
                        sb.append(-1).append('\n');
                    }else{
                        sb.append(out.peekFirst()).append('\n');
                    }
                    break;
                case "8":
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
