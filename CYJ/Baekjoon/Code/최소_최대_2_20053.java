import java.util.Scanner;

public class 최소_최대_2_20053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int tc = 1 ; tc <= t; tc++) {
            int n = sc.nextInt();
            int max =  -1000001;
            int min = 1000001;
            for (int i = 0 ; i < n; i++) {
                int a = sc.nextInt();
                if (max < a) {
                    max = a;
                }
                if (min > a) {
                    min = a;
                }
            }
            System.out.println(min + " " + max);
        }
        sc.close();
    }
}