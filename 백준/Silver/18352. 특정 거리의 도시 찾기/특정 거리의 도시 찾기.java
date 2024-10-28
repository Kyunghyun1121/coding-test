import java.io.*;
import java.util.*;

import static java.util.Arrays.sort;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //int num = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int cityNum = Integer.parseInt(st.nextToken());
        int roadNum = Integer.parseInt(st.nextToken());
        int shortLength = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int[] remember = new int[cityNum + 1];

        for (int i = 0; i <= cityNum; i++) {
            arr.add(new ArrayList<>());
            remember[i] = 0;
        }

        for (int i = 0; i < roadNum; i++) {
            st = new StringTokenizer(br.readLine());
            arr.get(Integer.parseInt(st.nextToken())).add(Integer.valueOf(st.nextToken()));
        }
        boolean[]v = new boolean[cityNum+1];
        Queue<Integer> visit = new ArrayDeque<>();
        int count = 0;
        visit.add(start);v[0] = true;
        while (!visit.isEmpty()) {
            int now = visit.poll();
            v[now] = true;
            //System.out.println("now = "+ now );
            for (Integer integer : arr.get(now)) {
                //System.out.println("integer = "+integer);
                if(v[integer])continue;
                if (remember[integer] == 0) {
                    remember[integer] = remember[now] + 1;
                    //System.out.println("integer = "+integer+" length = "+remember[integer]);
                    visit.add(integer);
                }
            }
        }


        for (int i = 1; i <= cityNum; i++) {
            //System.out.println(remember[i]);
            if (remember[i] == shortLength) {
                System.out.println(i);
                count++;
            }
        }
        if (count == 0) {
            System.out.println(-1);
        }

    }

}
