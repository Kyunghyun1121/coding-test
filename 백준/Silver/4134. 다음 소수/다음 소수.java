import java.io.IOException;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        long cas = scanner.nextLong();
        
        for(long i =0; i< cas; i++){
            long num = scanner.nextLong();
            if(num == 1){
                System.out.println(2);
                continue;
            }else if( num == 0){
                System.out.println(2);
                continue;
            }
            while (check(num)!=true){
                num++;
            }
            System.out.println(num);
        }

    }
    public static boolean check(long s){
        for( long i = 2; i*i<=s; i++){
            if((s % i) == 0){
                return false;
            }
        }
        return true;
    }


}

