import java.io.*;
import java.math.BigInteger;
import java.sql.Array;
import java.util.*;


public class Main {

    static class data{
        int count = 1;
        int len = 0;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cas = Integer.parseInt(st.nextToken());
        int standard = Integer.parseInt(st.nextToken());

        Map<String, data> rem = new HashMap<>();


        for(int i = 0; i<cas; i++){
            String word = br.readLine();
            if(word.length() >= standard){
                if(rem.containsKey(word)){
                    rem.get(word).count++;
                }else{
                    data temp = new data();
                    temp.len = word.length();
                    rem.put(word, temp);
                }
            }
        }

        List<String> keySet = new ArrayList<>(rem.keySet());

        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int cmp = rem.get(o2).count - rem.get(o1).count;
                if(cmp == 0){
                    int cmp2 = o2.length() - o1.length();
                    if(cmp2 == 0){
                        return o1.compareTo(o2);
                    }else{
                        return cmp2;
                    }
                }else{
                    return cmp;
                }
            }
        });


        for (String s : keySet) {
            bw.append(s).append('\n');
        }

        bw.flush();
    }


}


