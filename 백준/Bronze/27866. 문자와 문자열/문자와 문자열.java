import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        String M;
        int N;
        Scanner scanner = new Scanner(System.in);

        M = scanner.next();
        N = scanner.nextInt();
        char out[] = M.toCharArray();

        System.out.println(out[N-1]);


    }
}
