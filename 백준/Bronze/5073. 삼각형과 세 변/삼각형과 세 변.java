
import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        while(A!=0&&B!=0&&C!=0){
            int big = Math.max(A, Math.max(B,C));
            int allSum = A + B + C;
            allSum-= big;
            if(allSum <= big){
                System.out.println("Invalid");
            }else if(A!=B && B!=C && A!=C){
                System.out.println("Scalene");
            }else if(A==B && B==C && A==C){
                System.out.println("Equilateral");
            }else{
                System.out.println("Isosceles");
            }
            A = scanner.nextInt();
            B = scanner.nextInt();
            C = scanner.nextInt();
        }


    }
}


