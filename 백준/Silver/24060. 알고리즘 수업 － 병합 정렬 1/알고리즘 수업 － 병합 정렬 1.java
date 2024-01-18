import java.io.*;
import java.math.BigInteger;
import java.sql.Array;
import java.util.*;


public class Main {

    static int count = 0;
    static int target = 0;
    static int out = 0;
    static int tmp[] = new int[500001];

    static void merge_sort(int A[], int p, int r) {



        if (p < r)  {
            int q = (p+r)/2;
            merge_sort(A, p, q);
            merge_sort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }


    static void merge(int A[], int p,int q, int r) {

        int i = p; int j = q + 1; int t = 1;

        while (i <= q && j <= r) {
            if (A[i] <= A[j]){
                tmp[t] = A[i];
                i++;
            }else{
                tmp[t] = A[j];
                j++;
            }
            t++;

        }

        while (i <= q)
            tmp[t++] = A[i++];
        while (j <= r)
            tmp[t++] = A[j++];

        i = p; t = 1;
        while (i <= r){
            count++;
            if(count == target) out = tmp[t];
            A[i++] = tmp[t++];
        }



    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int cas = Integer.parseInt(stringTokenizer.nextToken());
        target = Integer.parseInt(stringTokenizer.nextToken());

        int arr[] = new int[500001];
        stringTokenizer = new StringTokenizer(br.readLine());
        for(int i = 0; i< cas; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }



        merge_sort(arr, 0, cas-1);
        if(count > target){
            System.out.println(out);
        }else{
            System.out.println("-1");
        }
        //System.out.println(count);
    }


}


