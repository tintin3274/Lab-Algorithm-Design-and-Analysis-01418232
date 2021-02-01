import java.util.ArrayList;
import java.util.Scanner;

public class IPAddress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, n, j, k, length, count;
        String s_new, s1, s2, s3, s4;
        n = sc.nextInt();
        ArrayList<String> ip = new ArrayList<>();
        for(i=0; i<n; i++){
            ip.add(sc.next());
        }

        for(String s: ip) {
            length = s.length();
            s_new = s;
            count = 0;

            for(i = 1; i < length - 2; i++ ) {
                for(j = i + 1; j < length - 1; j++ ) {
                    for(k = j + 1; k < length; k++ ) {
                        s_new = s_new.substring(0, k) +
                                "." + s_new.substring(k);
                        s_new = s_new.substring(0, j) +
                                "." + s_new.substring(j);
                        s_new = s_new.substring(0, i) +
                                "." + s_new.substring(i);

                        String[] ip_array = s_new.split("[.]");
                        s1 = ip_array[0];
                        s2 = ip_array[1];
                        s3 = ip_array[2];
                        s4 = ip_array[3];

                        if(s1.length() < 4 && s2.length() < 4 && s3.length() < 4 && s4.length() < 4){
                            String t1 = ""+Integer.parseInt(s1);
                            String t2 = ""+Integer.parseInt(s2);
                            String t3 = ""+Integer.parseInt(s3);
                            String t4 = ""+Integer.parseInt(s4);
                            if((t1.length() == s1.length() && Integer.parseInt(s1) < 256) &&
                                    (t2.length() == s2.length() && Integer.parseInt(s2) < 256) &&
                                    (t3.length() == s3.length() && Integer.parseInt(s3) < 256) &&
                                    (t4.length() == s4.length() && Integer.parseInt(s4) < 256))
                                //System.out.println(s1+"."+s2+"."+s3+"."+s4);
                                count++;
                        }
                        s_new = s;
                    }
                }
            }
            System.out.println(count);
        }
    }
}


