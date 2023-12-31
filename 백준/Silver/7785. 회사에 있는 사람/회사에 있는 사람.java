
import java.io.IOException;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();


        Set<String>out = new HashSet<>();

        for( int i =0; i<N;i++){
            String what = scanner.next();
            String value = scanner.next();
            if(value.equals("enter")){
                out.add(what);
            }else if(value.equals("leave")){
                out.remove(what);
            }
        }
        List<String> o = new ArrayList<>(out);
                
        Collections.sort(o, Collections.reverseOrder());
        for (String s : o) {
            System.out.println(s);
        }

    }
}
