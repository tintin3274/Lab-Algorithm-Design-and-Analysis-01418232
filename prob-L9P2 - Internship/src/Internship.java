import java.util.Scanner;

public class Internship {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, n, m, t, candidate, company, lessCandidate, lessCandidateIndex, lessRequest, lessRequestIndex, count;
        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();
        int[] numberRegistered = new int[n];
        boolean[] considered = new boolean[n];
        int[] numberApplicants = new int[m];
        boolean[][] checkApplication = new boolean[m][n];

        for(i=0; i<t; i++){
            candidate = sc.nextInt();
            company = sc.nextInt();
            numberRegistered[candidate-1] += 1;
            checkApplication[company-1][candidate-1] = true;
            numberApplicants[company-1] += 1;
        }
        boolean find = true;
        while(find){
            find = false;

            lessRequest = Integer.MAX_VALUE;
            lessRequestIndex = -1;
            for(i=0; i<n; i++){
                if(considered[i] == false && numberRegistered[i] < lessRequest){
                    lessRequest = numberRegistered[i];
                    lessRequestIndex = i;
                }
            }
            if(lessRequestIndex >= 0){
                considered[lessRequestIndex] = true;
                lessCandidate = Integer.MAX_VALUE;
                lessCandidateIndex = -1;
                for(i=0; i<m; i++){
                    if(checkApplication[i][lessRequestIndex] && numberApplicants[i] < lessCandidate){
                        lessCandidate = numberApplicants[i];
                        lessCandidateIndex = i;
                    }
                }
                if(lessCandidateIndex >= 0){
                    numberRegistered[lessRequestIndex] = Integer.MAX_VALUE;
                    numberApplicants[lessCandidateIndex] = Integer.MAX_VALUE;
                    for(i=0; i<m; i++){
                        if(checkApplication[i][lessRequestIndex] && numberApplicants[i] < Integer.MAX_VALUE) numberApplicants[i]--;
                    }
                }
                find = true;
            }
        }

        count = 0;
        for(i=0; i<n; i++){
            if(numberRegistered[i] < Integer.MAX_VALUE) count++;
        }
        System.out.println(count);
    }
}
