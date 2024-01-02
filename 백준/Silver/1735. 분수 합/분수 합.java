
import java.io.IOException;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        long As = scanner.nextInt();
        long Am = scanner.nextInt();
        long Bs = scanner.nextInt();
        long Bm = scanner.nextInt();

        long sumM = Am * Bm;
        long sumS = (As*Bm) + (Am*Bs);

        long out = 0;
        long temp = 0;
        long a = sumM;
        long b = sumS;

        while(b != 0){
            temp = a % b;
            a = b;
            b = temp;
        }

        System.out.println((sumS/a) + " " + (sumM/a));

    }
}

