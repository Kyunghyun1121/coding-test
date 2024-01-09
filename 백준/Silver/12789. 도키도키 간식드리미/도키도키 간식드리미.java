import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int cas = scanner.nextInt();
        int min = 1;
        Stack<Integer> right = new Stack<Integer>();
        Stack<Integer> down = new Stack<Integer>();

        for(int i = 0; i < cas; i++){
            int temp = scanner.nextInt();
            down.push(temp);
        }
        for(int i = 0; i < cas; i++){
            right.push(down.pop());
        }


        while(!right.empty() || !down.empty()){
            if(right.empty()){
                down.pop();
                min++;
            }else{
                if(!right.empty() && right.peek() == min){
                    right.pop();
                    min++;
                }else if(!down.empty() && down.peek() == min){
                    down.pop();
                    min++;
                }else{
                    if(!down.empty() && down.peek() < right.peek()){
                        break;
                    }else{
                        down.push(right.pop());
                    }
                }
            }


        }

        if(min == cas + 1) System.out.println("Nice");
        else System.out.println("Sad");

    }

}


