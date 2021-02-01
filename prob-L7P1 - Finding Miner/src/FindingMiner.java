import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class FindingMiner {
    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        int w, l, d, x, y, z, v, dx=0, dy=0, dz=0;
        String line;
        line = bi.readLine();
        String[] lineSplit = line.split(" ");
        w = Integer.parseInt(lineSplit[0]);
        l = Integer.parseInt(lineSplit[1]);
        d = Integer.parseInt(lineSplit[2]);
        int[][][] distance = new int[d][w][l];
        LinkedList<String> visit = new LinkedList<>();
        for(z=0; z<d; z++){
            for(y=0; y<w; y++){
                line = bi.readLine();
                char[] s = line.toCharArray();
                for(x=0; x<l; x++){
                    distance[z][y][x] = Integer.MAX_VALUE;
                    if(s[x] == 'S'){
                        distance[z][y][x] = 0;
                        visit.add(z+" "+y+" "+x);
                    }
                    else if(s[x] == 'X') distance[z][y][x] = -1;
                    else if(s[x] == 'M'){ dx = x; dy = y; dz = z; }
                }
            }
        }
        boolean find = true;
        while (!visit.isEmpty() && find){
            String[] ss = visit.getFirst().split(" ");
            z = Integer.parseInt(ss[0]);
            y = Integer.parseInt(ss[1]);
            x = Integer.parseInt(ss[2]);
            v = distance[z][y][x];

            if(x+1 < l && Integer.MAX_VALUE == distance[z][y][x+1]) {distance[z][y][x+1] = v+1; visit.add(z+" "+y+" "+(x+1));}
            if(x-1 >= 0 && Integer.MAX_VALUE == distance[z][y][x-1]) {distance[z][y][x-1] = v+1; visit.add(z+" "+y+" "+(x-1));}
            if(y+1 < w && Integer.MAX_VALUE == distance[z][y+1][x]) {distance[z][y+1][x] = v+1; visit.add(z+" "+(y+1)+" "+x);}
            if(y-1 >= 0 && Integer.MAX_VALUE == distance[z][y-1][x]) {distance[z][y-1][x] = v+1; visit.add(z+" "+(y-1)+" "+x);}
            if(z+1 < d && Integer.MAX_VALUE == distance[z+1][y][x]) {distance[z+1][y][x] = v+1; visit.add((z+1)+" "+y+" "+x);}
            if(z-1 >= 0 && Integer.MAX_VALUE == distance[z-1][y][x]) {distance[z-1][y][x] = v+1; visit.add((z-1)+" "+y+" "+x);}
            visit.removeFirst();

            if(distance[dz][dy][dx] != Integer.MAX_VALUE) find = false;
        }
        System.out.println(distance[dz][dy][dx]);
    }
}
