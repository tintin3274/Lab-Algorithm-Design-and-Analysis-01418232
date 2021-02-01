import java.util.Scanner;

public class Minesweeper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w, l, n, q, i, x, y;
        String output = "";
        w = sc.nextInt();
        l = sc.nextInt();
        n = sc.nextInt();
        q = sc.nextInt();
        int map[][] = new int[l][w];

        for(i=0; i<n; i++){
            y = sc.nextInt();
            x = sc.nextInt();
            map[y][x] = -1;
        }

        for(i=0; i<q; i++){
            int count = 0;
            y = sc.nextInt();
            x = sc.nextInt();

            if(map[y][x] == -1){
                output += "Bomb\n";
                continue;
            }

            if(x-1>=0 && map[y][x-1] == -1) count++;
            if(x+1<w && map[y][x+1] == -1) count++;
            if(y-1>=0 && map[y-1][x] == -1) count++;
            if(y-1>=0 && x-1>=0 && map[y-1][x-1] == -1) count++;
            if(y-1>=0 && x+1<w && map[y-1][x+1] == -1) count++;
            if(y+1<l && map[y+1][x] == -1) count++;
            if(y+1<l && x-1>=0 && map[y+1][x-1] == -1) count++;
            if(y+1<l && x+1<w && map[y+1][x+1] == -1) count++;
            output += count+"\n";
        }

        System.out.println(output);
    }
}
