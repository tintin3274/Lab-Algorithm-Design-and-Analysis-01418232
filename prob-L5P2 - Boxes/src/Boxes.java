import java.util.*;

public class Boxes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, n, b;
        ArrayList<Integer> boxes = new ArrayList<>();
        n = sc.nextInt();
        for(i=0; i<n; i++){
            boxes.add(sc.nextInt());
        }
        boxes.sort((o1, o2) -> o2-o1);
        for(i=0; i<boxes.size(); i++){
            b = boxes.get(i);
            Iterator iterator = boxes.iterator();
            while(iterator.hasNext()){
                n = (int) iterator.next();
                if(n < b){
                    b = n;
                    iterator.remove();
                }
            }
        }
        System.out.println(boxes.size());
    }
}
