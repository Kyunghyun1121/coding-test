import javax.swing.*;
import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter sb = new BufferedWriter(new OutputStreamWriter(System.out));

        int cas = Integer.parseInt(br.readLine());
        for(int i =0 ; i<cas; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int casNum = Integer.parseInt(st.nextToken());
            ArrayList<Integer> students = new ArrayList<>();
            int back = 0;
            for(int j=0; j<20;j++){
                int stu = Integer.parseInt(st.nextToken());
                if(students.isEmpty())students.add(stu);
                else{
                    int c = 0;
                    for (Integer student : students) {
                        if(student > stu){
                            back+=students.size()-c;
                            break;
                        }
                        c++;
                    }
                    students.add(c, stu);
                }
            }
            sb.write(casNum+" "+back+'\n');
        }
        sb.flush();
    }


}
