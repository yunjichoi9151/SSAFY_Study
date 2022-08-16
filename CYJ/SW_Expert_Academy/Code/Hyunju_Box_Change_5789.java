package Java_files.Code;

import java.util.Scanner;

public class Hyunju_Box_Change_5789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < q; i++) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                for(int j = l - 1; j <= r - 1; j++) {
                    arr[j] = i + 1;
                }
            }
            System.out.print("#" + tc + " ");
            for(int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        sc.close();
    }    
}
