import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        int M, N;
        Scanner scanner = new Scanner(System.in);

        M = scanner.nextInt();
        N = scanner.nextInt();
        int A[];
        A = new int[M+1];

        int start, end, num;
        for(int i = 0; i < N; i++){
            start = scanner.nextInt();
            end = scanner.nextInt();
            num = scanner.nextInt();
            for(int j = start; j<=end; j++){
                A[j] = num;
            }
        }
        for (int i = 1; i <= M; i++) {
            System.out.print(A[i] + " ");
        }



    }
}


