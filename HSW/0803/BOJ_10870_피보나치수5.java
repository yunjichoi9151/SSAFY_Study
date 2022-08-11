package HSW;

import java.util.Scanner;

public class BOJ_10870_피보나치수5 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();

        System.out.println(Fibonacci(n));

    }

    public static int Fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return (Fibonacci(n - 1) + Fibonacci(n - 2));
    }
}
