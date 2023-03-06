import java.util.Scanner;

public class 골드바흐의_추측_9020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt();
            int n1 = 0;
            for(int i = 2; i <= n / 2; i++) {
                if(find(i) && find(n - i)) {
                    n1 = i;
                }
            }
            System.out.println(n1 + " " + (n - n1));
        }
        sc.close();
    }
    public static boolean find(int n) {
        if(n == 1) {
            return false;
        } else if(n == 2 || n == 3) {
            return true;
        }
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
