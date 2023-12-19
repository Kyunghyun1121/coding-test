import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        int A,B,C;
        Scanner scanner = new Scanner(System.in);

        A = scanner.nextInt();
        A /= 4;
        for(int i = 0; i < A; i++){
            System.out.print("long" + " ");
        }
        System.out.print("int");

        

    }
}