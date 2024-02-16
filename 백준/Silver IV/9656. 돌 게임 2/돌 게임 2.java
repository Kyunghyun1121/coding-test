import javax.swing.*;
import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter sb = new OutputStreamWriter(System.out);

        int num = Integer.parseInt(br.readLine());
       

        if(num%2==0){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
    }


}
