import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cas = Integer.parseInt(br.readLine());
        char[][] body = new char[1001][1001];
        for(int i = 0; i< cas; i++){
            String in = br.readLine();
            body[i] = in.toCharArray();
        }


        int heartX = -1;
        int heartY = -1;
        for (int i = 0; i < cas; i++) {
            for (int j = 0; j < cas; j++) {
                if(body[i][j]=='*'){
                    heartX = j;
                    heartY = i + 1;
                    sb.append(i+2).append(" ").append(j+1).append('\n');

                    int count = 0;//왼팔
                    for (int k = heartX-1; k >= 0; k--) {
                        if(body[heartY][k]=='*'){
                            count++;
                        }
                    }
                    sb.append(count).append(" ");

                    count = 0;//오른팔
                    for (int k = heartX+1; k < cas; k++) {
                        if(body[heartY][k]=='*'){
                            count++;
                        }else break;
                    }
                    sb.append(count).append(" ");

                    count = 0;
                    int bodyY = -1;
                    for (int k = heartY+1; k < cas; k++) {
                        if(body[k][heartX]=='*'){
                            count++;
                        }else{
                            bodyY = k;
                            break;
                        }
                    }
                    sb.append(count).append(" ");

                    count = 0;
                    for (int k = bodyY+1; k < cas; k++) {
                        if(body[k][heartX-1]=='*'){
                            count++;
                        }else{
                            break;
                        }
                    }
                    sb.append(count+1).append(" ");

                    count = 0;
                    for (int k = bodyY+1; k < cas; k++) {
                        if(body[k][heartX+1]=='*'){
                            count++;
                        }else{
                            break;
                        }
                    }
                    sb.append(count+1);
                    System.out.println(sb);
                    return;
                }

            }
        }


    }


}
