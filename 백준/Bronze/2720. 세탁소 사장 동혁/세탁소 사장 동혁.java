import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int time = scanner.nextInt();
        int kind[] = {25, 10, 5, 1};

        for (int i = 0; i < time; i++) {
            int price = scanner.nextInt();
            for(int j = 0; j < 4; j++){
                int div = price / kind[j];
                System.out.print(div + " ");
                price %= kind[j];
            }
            System.out.println();

        }

    }
}


