import java.util.Scanner;

public class TwoStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, n, y, x;
        String s, t;
        n = sc.nextInt();
        for(i=0; i<n; i++){
            s = "_"+sc.next();
            t = "_"+sc.next();
            int sl = s.length();
            int tl = t.length();
            int[][] distance = new int[tl][sl];
            for(y=1; y<tl; y++){
                for(x=1; x<sl; x++){
                    if(s.charAt(x) == t.charAt(y)) distance[y][x] = distance[y-1][x-1]+1;
                    else distance[y][x] = Math.max(distance[y-1][x-1], Math.max(distance[y][x-1], distance[y-1][x]));
                }
            }
            int match = distance[tl-1][sl-1];
            System.out.println( ((sl-1-match)*15) + ((tl-1-match)*30) );
            //System.out.println(Arrays.deepToString(distance));
        }
    }
}
