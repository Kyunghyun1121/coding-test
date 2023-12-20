import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double absum = 0;
        double asum = 0;
        double subject = 0;
        double all = 0;

        for(int i = 0; i < 20 ; i++) {
            String s = sc.next();
            Double a = sc.nextDouble(); //학점
            String b = sc.next(); //과목평점
            sc.nextLine();

            if(b.equals("A+")){
                subject = 4.5;
            } else if(b.equals("A0")){
                subject = 4.0;
            } else if(b.equals("B+")){
                subject = 3.5;
            } else if(b.equals("B0")){
                subject = 3.0;
            } else if(b.equals("C+")){
                subject = 2.5;
            } else if(b.equals("C0")){
                subject = 2.0;
            } else if(b.equals("D+")){
                subject = 1.5;
            } else if(b.equals("D0")){
                subject = 1.0;
            } else if(b.equals("F")){
                subject = 0;
            } 
               
            if(!b.equals("P")) {
               asum += a; 
               absum += a*subject;
            }
            
            
                        
        }
        all = absum / asum;
        System.out.println(all);
    }
}
