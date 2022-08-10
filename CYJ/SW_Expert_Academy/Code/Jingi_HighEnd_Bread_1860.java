package Code;

import java.util.Scanner;
import java.util.Arrays;
  
public class Jingi_HighEnd_Bread_1860 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            String result = "Impossible";
            int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
            int[] arr = new int[n];
            for(int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            Arrays.sort(arr);
            for(int j = 0; j < n; j++) {
                int r = 0;
                if(arr[j] >= m) {
                    r = (arr[j] / m) * k - (j + 1);
                    if(r >= 0)
                        result = "Possible";
                    else {
                        result = "Impossible";
                        break;
                    }
                }
                else {
                    result = "Impossible";
                    break;
                }
            }
            System.out.println("#" + (i + 1) + " " + result);
        }
        sc.close();
    }
}