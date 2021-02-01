import java.util.Scanner;

public class CandyF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, n, r, b, l, cre, cbe, cro, cbo, answer;
        l = sc.nextInt();
        char[] s = sc.next().toCharArray();
        r = 0;
        b = 0;
        cre = 0;
        cbe = 0;
        cro = 0;
        cbo = 0;
        for(i=0; i<l; i++){
            char c = s[i];
            if(c == 'r') r++;
            if(c == 'b') b++;
            if(i%2==0){
                if(c == 'r') cre++;
                if(c == 'b') cbe++;
            }
            else{
                if(c == 'r') cro++;
                if(c == 'b') cbo++;
            }
        }
        System.out.println("cre"+ cre +"   cbe"+ cbe +"   cro"+ cro +"   cbo"+ cbo);
        if(Math.abs(r-b) > 1){
            int correct = (int) Math.ceil(l/2.0);
            if(cre == correct || cbe == correct) answer = Math.min(cro, cbo);
            else if(cro == correct || cbo == correct) answer = Math.min(cre, cbe);
            else answer = Math.min(Math.min(correct-cre, correct-cbe), Math.min(correct-cro, correct-cbo));
        }
        else {
            answer = Math.min(cre, cbe);
        }

        System.out.println(answer);
    }
}
