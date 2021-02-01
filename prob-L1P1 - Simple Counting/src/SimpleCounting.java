import java.util.Scanner;

public class SimpleCounting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int i, n, max;
        int count[] = new int[10];

        for(i=0; i<10; i++){
            count[i] = input.length() - input.replaceAll(i+"", "").length();
        }

        boolean more = false;
        max = 0;
        n = count[0];
        for(i=1; i<10; i++){
            if(count[i] > n){
                n = count[i];
                max = i;
                more = false;
            }
            else if(count[i] == n) more = true;
        }

        System.out.println(more?"more":max);
    }
}
