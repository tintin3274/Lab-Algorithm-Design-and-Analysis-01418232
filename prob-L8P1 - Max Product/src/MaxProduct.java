import java.util.Scanner;

public class MaxProduct {
    public static long maxProduct(int[] nums) {
        long[] max = new long[nums.length];
        long[] min = new long[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        long max_value = nums[0];
        for(int i = 1; i < nums.length; i++){
            max[i] = Math.max(Math.max(max[i-1] * nums[i], min[i-1] * nums[i]), nums[i]);
            min[i] = Math.min(Math.min(max[i-1] * nums[i], min[i-1] * nums[i]), nums[i]);
            max_value = Math.max(max_value, max[i]);
        }
        return max_value;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, n;
        n = sc.nextInt();
        int[] number = new int[n];
        for(i=0; i<n; i++){
            number[i] = sc.nextInt();
        }
        System.out.println(maxProduct(number));
    }
}
