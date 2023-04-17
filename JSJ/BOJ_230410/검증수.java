package 백준.boj_0410;

import java.util.Scanner;

public class 검증수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = 0;
        for (int i = 0; i < 5; i++) {
            int tmp = sc.nextInt();
            k += (tmp * tmp);
        }

        System.out.println(k % 10);
    }
}
