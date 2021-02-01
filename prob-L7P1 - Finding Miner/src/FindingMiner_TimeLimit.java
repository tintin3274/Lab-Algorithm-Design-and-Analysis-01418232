import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class FindingMiner_TimeLimit {
    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        int w, l, d, x, y, z, mx, my, mz, mv, dx=0, dy=0, dz=0;
        String line;
        line = bi.readLine();
        String[] lineSplit = line.split(" ");
        w = Integer.parseInt(lineSplit[0]);
        l = Integer.parseInt(lineSplit[1]);
        d = Integer.parseInt(lineSplit[2]);
        int[][][] distance = new int[d][w][l];
        boolean[][][] visited = new boolean[d][w][l];
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
                    else if(s[x] == 'X') visited[z][y][x] = true;
                    else if(s[x] == 'M'){ dx = x; dy = y; dz = z; }
                }
            }
        }
        boolean find = true;
        while (!visit.isEmpty() && find){
            find = false;
            mx = 0; my = 0; mz = 0;
            mv = Integer.MAX_VALUE;
            for(String s : visit){
                String[] ss = s.split(" ");
                z = Integer.parseInt(ss[0]);
                y = Integer.parseInt(ss[1]);
                x = Integer.parseInt(ss[2]);
                if(!visited[z][y][x] && distance[z][y][x] < mv){
                    mx = x; my = y; mz = z;
                    mv = distance[z][y][x];
                    find = true;
                }
            }

            if(find){
                if(mx+1 < l && !visited[mz][my][mx+1] && mv < distance[mz][my][mx+1]) {distance[mz][my][mx+1] = mv+1; visit.add(mz+" "+my+" "+(mx+1));}
                if(mx-1 >= 0 && !visited[mz][my][mx-1] && mv < distance[mz][my][mx-1]) {distance[mz][my][mx-1] = mv+1; visit.add(mz+" "+my+" "+(mx-1));}
                if(my+1 < w && !visited[mz][my+1][mx] && mv < distance[mz][my+1][mx]) {distance[mz][my+1][mx] = mv+1; visit.add(mz+" "+(my+1)+" "+mx);}
                if(my-1 >= 0 && !visited[mz][my-1][mx] && mv < distance[mz][my-1][mx]) {distance[mz][my-1][mx] = mv+1; visit.add(mz+" "+(my-1)+" "+mx);}
                if(mz+1 < d && !visited[mz+1][my][mx] && mv < distance[mz+1][my][mx]) {distance[mz+1][my][mx] = mv+1; visit.add((mz+1)+" "+my+" "+mx);}
                if(mz-1 >= 0 && !visited[mz-1][my][mx] && mv < distance[mz-1][my][mx]) {distance[mz-1][my][mx] = mv+1; visit.add((mz-1)+" "+my+" "+mx);}
                visited[mz][my][mx] = true;
                visit.remove(visit.indexOf(mz+" "+my+" "+mx));
            }
            if(visited[dz][dy][dx]) find = false;
        }
        System.out.println(distance[dz][dy][dx]);
    }
}
