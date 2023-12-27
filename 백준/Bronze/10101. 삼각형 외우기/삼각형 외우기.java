
import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        if((A+B+C) != 180){
            System.out.println("Error");
        }else if(A==B&&B==C&&C==60){
            System.out.println("Equilateral");
        }else if(A!=B && B!=C && A!=C){
            System.out.println("Scalene");
        }else{
            System.out.println("Isosceles");
        }





    }
}


