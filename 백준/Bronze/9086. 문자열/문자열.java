import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        int M;
        String N;
        Scanner scanner = new Scanner(System.in);

        M = scanner.nextInt();
        for(int i=0; i<M;i++){
            N = scanner.next();
            char temp[] = N.toCharArray();
            System.out.print(temp[0]);
            System.out.println(temp[temp.length-1]);
        }

    }
}