package Code;

import java.util.Scanner;
 
public class Samsung_Bus_Route_6485 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt();
            int[] arr1 = new int[5002];
            for(int i = 0; i < n; i++) {
                int ai = sc.nextInt();
                int bi = sc.nextInt();
                for(int j = ai - 1; j <= bi - 1; j++) {
                    arr1[j]++;
                }
            }
            int p = sc.nextInt();
            int[] arr4 = new int[p];
            for(int i = 0; i < p; i++) {
                arr4[i] = arr1[sc.nextInt() - 1];
            }
            System.out.print("#" + tc + " ");
            for(int i = 0; i < p; i++) {
                System.out.print(arr4[i] + " ");
            }
            System.out.println();
        }
        sc.close();
    }    
}