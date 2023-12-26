import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int time = scanner.nextInt();

        long n = 2;
        long p = 1;

        for(int i = 0; i< time; i++){
            n += p;
            p *= 2;
        }
        System.out.println(n*n);




    }
}
