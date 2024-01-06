import java.io.IOException;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int cas = scanner.nextInt();

        long out = 0;
        for(int i = 0; i < cas; i++){
            out += i;
        }
        System.out.println(out);
        System.out.println(2);
    }

}

