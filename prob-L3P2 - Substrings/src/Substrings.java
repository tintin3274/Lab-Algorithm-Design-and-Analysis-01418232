import java.util.Scanner;

public class Substrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean sort = true;
        boolean answer = true;
        int i, n;
        n = sc.nextInt();
        String array[] = new String[n];
        String tmp;
        for(i=0; i<n; i++){
            array[i] = sc.next();
        }

        while (sort){
            sort = false;
            for(i=0; i<n && i+1<n; i++){
                if(array[i].length() > array[i+1].length()){
                    tmp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = tmp;
                    sort = true;
                }
            }
        }

        for(i=0; i<n && i+1<n; i++){
            if(array[i+1].contains(array[i])) continue;
            answer = false;
            break;
        }

        if(answer){
            System.out.println("YES");
            for(i=0; i<n; i++){
                System.out.println(array[i]);
            }
        }
        else System.out.println("NO");
    }
}
