package 백준.boj_0411;

import java.util.Arrays;
import java.util.Scanner;

public class 모독 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   // 국회의원수

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        long ans = 0;
        if (arr[0] != 1) {
            ans += (arr[0] - 1);
            arr[0] = 1;
        }

        for (int i = 1; i < N; i++) {
            if (arr[i] > arr[i - 1]) {
                ans += arr[i] - (arr[i - 1] + 1);
                arr[i] = arr[i - 1] + 1;
            }
        }

        System.out.println(ans);
    }
}
