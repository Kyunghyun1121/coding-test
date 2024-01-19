import java.io.*;
import java.math.BigInteger;
import java.sql.Array;
import java.util.*;


public class Main {
    static int n;
    static StringBuilder answer;

    public static void func(int start,int size) {
        if(size==1) {
            return;
        }
        int newSize=size/3;
        
        for(int i=start+newSize; i<start+2*newSize; i++) {
            answer.setCharAt(i, ' ');
        }

        func(start, newSize); 
        func(start+2*newSize, newSize); 
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            n = Integer.parseInt(str);
            answer =new StringBuilder();
            int len = (int) Math.pow(3, n);
            //길이가 3^n 이고 '-'로 이루어진 문자열 미리 만들어 놓고, 재귀함수 시작하기
            for (int i = 0; i < len; i++) {
                answer.append("-");
            }

            func(0, len); // 시작 인덱스, 시작 길이
            System.out.println(answer);

        }
    }


}
