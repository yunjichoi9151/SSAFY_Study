import java.util.Scanner;

public class Fibonacci_number_5_10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int numArr[] = new int[21];
        numArr[0] = 0;
        numArr[1] = 1;
        for (int i = 0; i < n - 1; i++)
            numArr[i + 2] = numArr[i] + numArr[i + 1];
        System.out.println(numArr[n]);
        sc.close();
    }
}
