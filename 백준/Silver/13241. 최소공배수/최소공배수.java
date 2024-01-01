
import java.io.IOException;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        long A = scanner.nextInt();
        long B = scanner.nextInt();
        long big = Math.max(A,B);
        long small = Math.min(A, B);

        long out = 0;
        long temp = 0;
        long a = big;
        long b = small;

        while(b != 0){
            temp = a % b;
            a = b;
            b = temp;
        }
        out = (A*B) / a;
        System.out.println(out);

    }
}


