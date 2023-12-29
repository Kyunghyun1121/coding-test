
import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int D = scanner.nextInt();
        int E = scanner.nextInt();
        int F = scanner.nextInt();

        for(int i = -999; i < 1000; i++){
            for(int j = -999; j < 1000; j++){
                if((((A*i) + (B*j)) == C) && (((D*i) + (E*j)) == F)){
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }


    }
}


