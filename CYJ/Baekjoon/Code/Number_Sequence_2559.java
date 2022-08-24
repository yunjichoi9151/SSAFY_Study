package Silver_3.Java_files.Code;

import java.util.Scanner;

public class Number_Sequence_2559 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] arr = new int[n];
        int[] arr2 = new int[n - k + 1];
        for(int tc = 0; tc < n; tc++) {
            arr[tc] = sc.nextInt();
            if(tc >= k - 1) {
                int tmp = 0;
                System.out.println("tmp is 0");
                for(int i = 0; i < k; i++) {
                    tmp += arr[tc - i];
                    System.out.println("tmp += arr[" + (tc - i) + "] and tmp is " + tmp);
                }
                arr2[tc - (k - 1)] = tmp;
                System.out.println("arr2[" + (tc - (k - 1)) + "] is " + arr2[tc - (k - 1)]);
            }
        }
        int max = arr2[0];
        for(int j = 0; j < arr2.length; j++) {
            if(max < arr2[j]) {
                max = arr2[j];
            }
        }
        System.out.println(max);
        sc.close();
    }
}
