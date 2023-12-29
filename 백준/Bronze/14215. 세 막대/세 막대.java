
import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        int big = Math.max(A, Math.max(B,C));
        int allSum = A + B + C;
        allSum-= big;
        if(allSum <= big){
            System.out.println(allSum + allSum - 1);
        }else if(A==B && B==C && A==C){
            System.out.println(A * 3);
        }else{
            System.out.println(A + B + C);
        }



    }
}


