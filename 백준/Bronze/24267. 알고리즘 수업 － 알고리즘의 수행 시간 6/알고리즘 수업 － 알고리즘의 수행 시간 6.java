import java.io.IOException;
import java.math.BigInteger;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int cas = scanner.nextInt();

        long sum = 0;
        for(int i = 1; i<=cas-2; i++){
            sum += i;
        }

        long out = 0;
        for(int i = cas -2; i > 0; i--){
            out +=sum;
            sum-=i;
        }

        System.out.println(out);
        System.out.println(3);
    }

}
