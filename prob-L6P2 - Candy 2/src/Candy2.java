import java.util.Scanner;


public class Candy2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, n, r, b, l, cr, cb, answer;
        l = sc.nextInt();
        char[] s = sc.next().toCharArray();
        answer = 0;
        r = 0;
        b = 0;
        for(char c : s){
            if(c == 'r') r++;
            if(c == 'b') b++;
        }

        if(Math.abs(r-b) > 1){
            if(r > b) answer += r - Math.ceil(l/2.0);
            else answer += b - Math.ceil(l/2.0);
        }

        cr = 0;
        cb = 0;
        for(i=0; i<l; i+=2){
            if(s[i] == 'r') cr++;
            if(s[i] == 'b') cb++;
        }
        if(cr >= cb) n = cr;
        else n = cb;
        answer += Math.ceil(l/2.0) - n;
        System.out.println(answer);
    }
}
