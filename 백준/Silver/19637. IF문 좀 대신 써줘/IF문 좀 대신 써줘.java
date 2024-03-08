import java.io.*;
import java.util.*;


public class Main {
    static int name;
    static int character;
    static String []title = new String[1000000];
    static int[] range = new int[1000000];
    public static String find(int start, int end, int find){
        int mid = (start+end)/2;
        if(start >= end) return title[end];
        else {
            if(range[mid]<find){
                return find(mid+1,end, find);
            }else{
                return find(start, mid, find);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        StringTokenizer st = new StringTokenizer(br.readLine());
        name = Integer.parseInt(st.nextToken());
        character = Integer.parseInt(st.nextToken());


        for (int i = 0; i < name; i++) {
            st = new StringTokenizer(br.readLine());
            title[i] = st.nextToken();
            range[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < character; i++) {
            int check = Integer.parseInt(br.readLine());

            sb.append(find(0,name, check)).append('\n');

        }

        System.out.println(sb);

    }


}
