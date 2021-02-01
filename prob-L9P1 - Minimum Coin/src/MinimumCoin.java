import java.util.Scanner;

public class MinimumCoin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x, y, a, b, cost=0, c1, r2;
        x = sc.nextLong();
        y = sc.nextLong();
        a = sc.nextLong();
        b = sc.nextLong();
        while(x > 1){
            if(((double) x/y % 1) == 0){
                r2 = x-(x/y);
                if(r2 == 0) r2 = x-1;
                c1 = r2*a;
                if(b < c1 && y > 1){
                    cost += b;
                    x = x/y;
                }
                else{
                    cost += r2*a;
                    x -= r2;
                }
            }
            else{
                if(x>y){
                    cost += (x%y)*a;
                    x -= x%y;
                }
                else{
                    cost += (x-1)*a;
                    x -= x-1;
                }
            }
        }
        System.out.println(cost);
    }
}
