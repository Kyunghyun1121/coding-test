import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cas = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        HashSet<String>peoples = new HashSet<>();
        for (int i = 0; i < cas; i++) {
            String human = br.readLine();
            peoples.add(human);
        }
        int man = peoples.size();


        switch (game){
            case "Y":
                System.out.println(man);
                break;
            case "F":
                System.out.println(man/2);
                break;
            case "O":
                System.out.println(man/3);
                break;
        }




    }


}
