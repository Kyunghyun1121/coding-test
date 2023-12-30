import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N= scanner.nextInt();

        boolean plusArr[] = new boolean[10000001];
        boolean minusArr[] = new boolean[10000001];

        for(int a = 0; a<N; a++){
            int num = scanner.nextInt();
            if(num>=0){
                plusArr[num] = true;
            }else{
                num *= -1;
                minusArr[num] = true;
            }
        }


        int M = scanner.nextInt();

        for(int a=0;a<M;a++){
            int search = scanner.nextInt();
            if(search<0){
                search *= -1;
                if(minusArr[search]){
                    if(a!=M-1) System.out.print("1 ");
                    else System.out.print("1");
                }
                else{
                    if(a!=M-1) System.out.print("0 ");
                    else System.out.print("0");
                }
            }else{
                if(plusArr[search]){
                    if(a!=M-1) System.out.print("1 ");
                    else System.out.print("1");
                }else{
                    if(a!=M-1) System.out.print("0 ");
                    else System.out.print("0");
                }
            }
        }

        System.out.println();
    }
}
