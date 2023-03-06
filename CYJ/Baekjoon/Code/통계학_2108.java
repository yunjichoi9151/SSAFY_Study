import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 통계학_2108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int max = 0;
        int max_2 = 0;
        int min = Integer.MAX_VALUE;
        int[] arr1 = new int[n];
        for(int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            arr1[i] = tmp;
            if(max < tmp) {
                max = tmp;
            }
            if(min > tmp) {
                min = tmp;
            }
            sum += tmp;
        }
        for(int i = 0; i < n; i++) {
            int tmp = Collections.frequency(Arrays.asList(arr1), arr1[i]);
            System.out.println("arr1[" + i + "] = " + arr1[i]);
            System.out.println("tmp is " + tmp);
            if(tmp > max_2) {
                max_2 = tmp;
            }
        }
        Arrays.sort(arr1);
        System.out.println(Math.round(((double)sum / (double)n)) + " " + arr1[n / 2] + " " + max_2 + " " + (max - min));
    }
}