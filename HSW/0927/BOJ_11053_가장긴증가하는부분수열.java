import java.util.Scanner;

public class BOJ_11053_가장긴증가하는부분수열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] dp = new int[N];          //arr[i]로 끝나는 부분수열의 길이

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            dp[i] = 1;
        }

        int max = Integer.MIN_VALUE;
        //arr[i] 기준값
        for (int i = 0; i < N; i++) {
            //arr[i]이전의 숫자(arr[j])들과 비교
            for (int j = 0; j <= i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
                if (max < dp[i])
                    max = dp[i];
            }
        }

        System.out.println(max);
    }
}
