
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        String N;
        Scanner scanner = new Scanner(System.in);
        char out[][] = new char[6][16];
        int max = 0;

        for(int i=0; i<5;i++){
            N = scanner.next();
            out[i] = N.toCharArray();
            max = Math.max(out[i].length, max);
        }

        for(int i = 0; i< max; i++){
            for(int j = 0; j< 5; j++){
                if(out[j].length > i) System.out.print(out[j][i]);
            }
        }

    }
}


