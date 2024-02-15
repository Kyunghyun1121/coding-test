import javax.swing.*;
import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter sb = new OutputStreamWriter(System.out);

        int cas = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>(cas+1);
        for(int i = 0; i<cas; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(st.hasMoreTokens()){
                int num = Integer.parseInt(st.nextToken());
                switch (order){
                    case "add":
                        arr.add(num);
                        break;
                    case "check":
                        if(arr.contains(num)) sb.append("1").append("\n");
                        else sb.append("0").append("\n");

                        break;
                    case "remove":
                        int c = arr.indexOf(num);
                        if(c!=-1)arr.remove(c);
                        break;
                    case "toggle":
                        if(arr.contains(num)) {
                            int j = arr.indexOf(num);
                            if(j!=-1)arr.remove(j);
                        }
                        else arr.add(num);
                        break;
                }
            }else{
                arr.clear();
                if(order.equals("all")){
                    for(int j=1; j<21;j++){
                        arr.add(j);
                    }
                }
            }


        }
        sb.flush();

    }


}
