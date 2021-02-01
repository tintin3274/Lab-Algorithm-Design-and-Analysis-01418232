import java.util.Scanner;

public class NumberSteps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = "";
        int i, n, n1, n2;
        n = sc.nextInt();
        for(i=0; i<n; i++){
            n1 = sc.nextInt();
            n2 = sc.nextInt();
            if(n1==n2 || n1-n2==2){
                if(n1%2==0) answer += (n1+n2)+"\n";
                else answer += (n1+n2-1)+"\n";
            }
            else answer += "No Number\n";
        }
        System.out.println(answer);
    }
}
