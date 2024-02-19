import java.io.*;
import java.util.*;


public class Main {

    static class country {
        int num, gold, silver, bronze;
        country(int n, int g, int s, int b){
            num = n;
            gold = g;
            silver = s;
            bronze = b;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int countryCount = Integer.parseInt(st.nextToken());
        int find = Integer.parseInt(st.nextToken());

        ArrayList<country> arr = new ArrayList<>();
        country target = new country(0,0,0,0);
        for(int i = 0; i< countryCount; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int g =Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.add(new country(n,g,s,b));
            if(n==find)target=new country(n,g,s,b);
        }

        ArrayList<country> tempSilver = new ArrayList<>();
        ArrayList<country> tempBronze = new ArrayList<>();
        int rate = 1;
        for (country country : arr) {
            if(country.num!=find){
                if(country.gold > target.gold){
                    rate++;
                }else if(country.gold == target.gold){
                    tempSilver.add(country);
                }
            }
        }

        for (country country : tempSilver) {
            if(country.silver > target.silver){
                rate++;
            }else if(country.silver == target.silver){
                tempBronze.add(country);
            }
        }

        for (country country : tempBronze) {
            if(country.bronze > target.bronze){
                rate++;
            }
        }

        System.out.println(rate);

    }


}
