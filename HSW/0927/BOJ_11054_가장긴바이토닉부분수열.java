import java.util.Scanner;

/*
    가장 긴 증가하는 부분수열을 오름차순 내림차순 2번 구해서 더해주면 된다
    12345  54321 이런식으로 2번 구하므로 두 길이를 더한 값에서 -1을 해준게 최종 길이
    그 길이 중 최댓값을 구하면 되는 문제
 */

public class BOJ_11054_가장긴바이토닉부분수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] dp_left = new int[N];
        int[] dp_right = new int[N];
        int max = Integer.MIN_VALUE;


        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            dp_left[i] = 1;
            dp_right[i] = 1;
        }

        //증가하는 부분수열(오름차순)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp_left[i] < dp_left[j] + 1) {
                    dp_left[i] = dp_left[j] + 1;
                }
            }
        }

        //감소하는 부분수열(내림차순)
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if (arr[i] > arr[j] && dp_right[i] < dp_right[j] + 1) {
                    dp_right[i] = dp_right[j] + 1;
                }
            }
        }

        //두 부분수열의 길이를 더하고 최댓값 구하기
        for (int i = 0; i < N; i++) {
            dp_left[i] += dp_right[i];

            if (dp_left[i] > max)
                max = dp_left[i];
        }

        System.out.println(max - 1);
    }
}
