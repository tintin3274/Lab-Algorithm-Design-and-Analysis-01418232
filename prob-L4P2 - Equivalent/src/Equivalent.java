import java.util.Scanner;

public class Equivalent {
    public static boolean Equivalent(String a, String b){
        if(a.length() > 1 && b.length() > 1){
            String a1, a2, b1, b2;
            a1 = a.substring(0, a.length()/2);
            a2 = a.substring(a.length()/2);
            b1 = b.substring(0, b.length()/2);
            b2 = b.substring(b.length()/2);

            return ((Equivalent(a1, b1) && Equivalent(a2, b2)) || (Equivalent(a1, b2) && Equivalent(a2, b1)));
        }

        if(a.equals(b)) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a, b;
        a = sc.next();
        b = sc.next();
        if(Equivalent(a, b)) System.out.println("YES");
        else System.out.println("NO");
    }
}