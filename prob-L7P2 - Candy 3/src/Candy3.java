import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Candy3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, l, count=0;
        l = sc.nextInt();
        String s = sc.next();
        while (true){
            if(s.contains("RRR")){
                s = s.replaceFirst("RRR", "RGR");
                count++;
                continue;
            }
            else if(s.contains("GGG")){
                s = s.replaceFirst("GGG", "GBG");
                count++;
                continue;
            }
            else if(s.contains("BBB")){
                s = s.replaceFirst("BBB", "BRB");
                count++;
                continue;
            }
            break;
        }
        char[] sa = s.toCharArray();
        char before=' ', now=' ', future=' ';
        for(i=0; i<l; i++){
            now = sa[i];
            if(now == before){
                ArrayList<Character> RGB = new ArrayList<>(Arrays.asList('R', 'G', 'B'));
                RGB.remove(RGB.indexOf(before));
                if(i+1<l){
                    future = sa[i+1];
                    RGB.remove(RGB.indexOf(future));
                    sa[i] = RGB.get(0);
                }
                else {
                    if(before == 'R') sa[i] = 'G';
                    else if(before == 'G') sa[i] = 'B';
                    else if(before == 'B') sa[i] = 'R';
                }
                count++;
            }
            before = sa[i];
        }
        s = Arrays.toString(sa).replaceAll("\\[|]|,|\\s", "");
        System.out.println(count);
        System.out.println(s);
    }
}
