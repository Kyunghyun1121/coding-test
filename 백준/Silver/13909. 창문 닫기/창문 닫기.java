import java.io.IOException;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        long cas = scanner.nextLong();

        long count = 1;
        for(long i = 2; i*i<=cas; i++){
            count++;
        }
        System.out.println(count);
    }

}

