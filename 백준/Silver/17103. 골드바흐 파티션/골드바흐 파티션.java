import java.io.IOException;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int cas = scanner.nextInt();

        boolean smallNum[] = new boolean[1000001];
        int calNum = 0;

        for(int i =0; i < cas; i++){
            int num = scanner.nextInt();
            while (calNum < num){
                if(check(calNum) == true){
                    smallNum[calNum] = true;
                }
                calNum++;
            }
            int count = 0;
            for(int j = 2; j <= num/2; j++){
                if(smallNum[j] && smallNum[num-j]){
                    count++;
                }
            }
            System.out.println(count);
        }

    }
    public static boolean check(int s){
        for( int i = 2; i*i<=s; i++){
            if((s % i) == 0){
                return false;
            }
        }
        return true;
    }


}

