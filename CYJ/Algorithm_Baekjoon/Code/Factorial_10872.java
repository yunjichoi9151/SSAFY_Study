import java.util.Scanner;

public class Factorial_10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int fac = 1;
        for (int i = 1; i < n + 1; i++)
            fac *= i;
        System.out.println(fac);
        sc.close();
    }
}
