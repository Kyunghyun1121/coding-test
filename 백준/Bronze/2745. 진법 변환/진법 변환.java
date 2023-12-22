
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        String N;
        Scanner scanner = new Scanner(System.in);

        N = scanner.next();
        char temp[] = N.toCharArray();
        int rule = scanner.nextInt();
        int sum = 0;
        int count = 1;


        for(int i = N.length()-1; i>=0; i--){
            if(temp[i] < 'A'){
                sum += (temp[i] - 48) * count;
            }else{
                sum += (temp[i] - 55) * count;
            }


            count *= rule;
        }
        System.out.println(sum);

    }
}


