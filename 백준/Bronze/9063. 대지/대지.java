
import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int time = scanner.nextInt();

        int maxX = -10001;
        int minY = 10001;
        int maxY = -10001;
        int minX = 10001;
        for(int i =0; i< time;i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
        }
        int width = maxX- minX;
        int height = maxY - minY;
        System.out.println(width*height);




    }
}

