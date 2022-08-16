package Java_files.Code;

import java.util.Scanner;

public class Successful_Plan_for_Performance_4789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc = 1; tc <= t; tc++) {
            String s = sc.next();
            int[] arr = new int[s.length()];
            int sum = 0, max = 0;
            for(int i = 0; i < s.length(); i++) {
                arr[i] = (int)s.charAt(i) - '0';
                System.out.println("arr[" + i + "] is " + arr[i]);
                if((arr[i] > 0) && (sum <= i - 1)) {
                    int tmp = Math.abs(sum - i);
                    System.out.println("tmp is " + tmp);
                    if(tmp > max) {
                        max = tmp;
                    }
                    System.out.println("max is " + max);
                }
                sum += arr[i];
            }
            System.out.println("#" + tc + " " + max);
        }
        sc.close();
    }
}
