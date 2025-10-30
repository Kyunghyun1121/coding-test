
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int answer = 0;
        int num = Integer.parseInt(st.nextToken());
        LinkedList<String> list = new LinkedList<>();

        int oneNum = 0;
        int twoNum = 0;
        for(int i = 0; i < num; i++) {
            String temp = br.readLine();
            list.add(temp);
            if (temp.equals("KBS1")) oneNum = i;
            if (temp.equals("KBS2")) twoNum = i;
        }

        for (int i = 0; i < oneNum; i++) sb.append(1);
        for (int i = 0; i < oneNum; i++) sb.append(4);

        if(oneNum < twoNum){
            for (int i = 0; i < twoNum; i++) sb.append(1);
            for (int i = 0; i < twoNum - 1; i++) sb.append(4);
        }
        else{
            for (int i = 0; i < twoNum + 1; i++) sb.append(1);
            for (int i = 0; i < twoNum; i++) sb.append(4);
        }




        System.out.println(sb.toString());




    }



}
