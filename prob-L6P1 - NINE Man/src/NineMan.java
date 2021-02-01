import java.util.*;

public class NineMan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, vertex, edge, start, destination, weight, index, length;
        vertex = sc.nextInt();
        edge = sc.nextInt();
        int[][] graph = new int[vertex][vertex];
        int[] node_distance = new int[vertex];
        for(i=0; i<vertex; i++){
            node_distance[i] = Integer.MAX_VALUE;
        }
        for(i=0; i<edge; i++){
            start = sc.nextInt();
            destination = sc.nextInt();
            weight = sc.nextInt();
            graph[start][destination] = weight;
            graph[destination][start] = weight;
        }
        start = sc.nextInt();
        destination = sc.nextInt();

        node_distance[start] = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for(i=0; i<vertex; i++){
            queue.add(i);
        }

        while(!queue.isEmpty()){
            index = queue.getFirst();
            length = node_distance[index];

            for(int q : queue){
                if(node_distance[q] < length){
                    index = q;
                    length = node_distance[q];
                }
            }
            queue.remove((Integer) index);
            if(length != Integer.MAX_VALUE){
                for(i=0; i<vertex; i++){
                    if(queue.contains(i) && graph[index][i] > 0){
                        if(length + graph[index][i] < node_distance[i]) {
                            node_distance[i] = length + graph[index][i];
                        }
                    }
                }
            }
        }
        if(node_distance[destination] < Integer.MAX_VALUE) System.out.println(node_distance[destination]);
        else System.out.println(-1);
        //System.out.println(Arrays.toString(node_distance));
    }
}
