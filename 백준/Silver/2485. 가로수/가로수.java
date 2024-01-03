
import java.io.IOException;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();

        int tree[] = new int[100001];
        int gap[] = new int[100001];

        int pastNum = scanner.nextInt();
        int startNum = pastNum;
        tree[0] = startNum;

        int nowNum = 0;
        int gapC = 1;
        tree[1] = scanner.nextInt();
        gap[0] = tree[1] - tree[0];
        pastNum = tree[1];

        int gapN = -1;

        for( int a = 2; a< n; a++){

            nowNum = scanner.nextInt();
            tree[a] = nowNum;
            gap[gapC] = nowNum - pastNum;
            pastNum = nowNum;

            if(gapN == -1){
                gapN = bigSmall(gap[0],gap[1]);
            }else{
                if((Math.max(gap[gapC],gapN) % Math.min(gap[gapC],gapN)) != 0){
                    gapN = bigSmall(gapN, gap[gapC]);
                }
            }
            gapC++;
        }


        int out = 0;

        int c = 0;
        int plusTree = startNum;
        while(plusTree<=nowNum){
            //System.out.println(tree[c] + " " + plusTree);
            if(tree[c] != plusTree){
                out++;
            }else{
                c++;
            }
            plusTree+=gapN;
        }

        System.out.println(out);

    }
    public static int bigSmall(int a, int b){
        while (b!=0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
