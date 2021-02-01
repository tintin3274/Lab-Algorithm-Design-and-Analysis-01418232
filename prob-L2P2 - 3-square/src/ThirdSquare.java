import java.util.ArrayList;
import java.util.Scanner;

public class ThirdSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, n, a, b, c;
        String output = "";

        ArrayList<Integer> input = new ArrayList<>();

        n = sc.nextInt();
        for(i=0; i<n; i++){
            input.add(sc.nextInt());
        }

        for(int k : input){
            boolean found = false;

            b = 0;

            for(a = 0; a <= b && !found; a++){
                for(b = a; (a*a)+(b*b) < k && !found; b++){
                    if(Math.sqrt(k-a*a-b*b)%1 == 0) {
                        c = (int) Math.sqrt(k-a*a-b*b);
                        found = true;
                        output += a+" "+b+" "+c+"\n";
                    }
                }
            }

            if(!found) output += "-1\n";
        }

        System.out.println(output);
    }
}


// --BF Code--
//            for(a = 0; a <= b && !found; a++){
//                for(b = a; b <= c && !found; b++){
//                    for(c = b; (a*a)+(b*b)+(c*c) <= k && !found; c++){
//                        //System.out.println("a:"+a+" / b:"+b+" / c:"+c);
//                        if((a*a)+(b*b)+(c*c) == k){
//                            found = true;
//                            output += a+" "+b+" "+c+"\n";
//                        }
//                    }
//                }
//            }
