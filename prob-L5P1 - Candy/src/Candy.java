import java.util.ArrayList;
import java.util.Scanner;

public class Candy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, n, c;
        n = sc.nextInt();

        for(i=0; i<n; i++){
            ArrayList<Integer> candy = new ArrayList<>();
            candy.add(sc.nextInt());
            candy.add(sc.nextInt());
            candy.add(sc.nextInt());
            candy.sort((o1, o2) -> o2-o1);
            c = 0;
            while(candy.get(0) > 0 && candy.get(1) > 0){
                candy.set(0, candy.get(0)-1);
                candy.set(1, candy.get(1)-1);
                candy.sort((o1, o2) -> o2-o1);
                c++;
            }
            System.out.println(c);
            candy.clear();
        }
    }
}
