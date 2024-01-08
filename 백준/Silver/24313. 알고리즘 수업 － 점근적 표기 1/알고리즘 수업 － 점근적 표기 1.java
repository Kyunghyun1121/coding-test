import java.io.IOException;
import java.math.BigInteger;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int a1 = scanner.nextInt();
        int a0 = scanner.nextInt();
        int c = scanner.nextInt();
        int n0 = scanner.nextInt();


//
//        if(a1<=c){
//            System.out.println(1);
//        }else if(a1 == c){
//            if(a0 < 0){
//                System.out.println(0);
//            }else{
//                System.out.println(1);
//            }
//        }else{
            for(int i = n0 + 1; i < 100000; i++){
                if(((a1*i) + a0) > c*i){
                    System.out.println(0);
                    return;
                }
            }
            System.out.println(1);
        //}





    }

}


