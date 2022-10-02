package Gold_5.Java_files.Code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Cable_2565 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        // 연결되는 위치 번호 담는 배열
        int[][] arr1 = new int[n][2];
        // A 기준으로 정렬한 후 B 담는 배열
        int[] arr2 = new int[n];
        // DP
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            // A 전봇대
            arr1[i][0] = sc.nextInt();
            // B 전봇대
            arr1[i][1] = sc.nextInt();
        }
        // A 전봇대 기준으로 정렬
        Arrays.sort(arr1, Comparator.comparingInt(o -> o[0]));
        for(int i = 0; i < n; i++) {
            // 정렬된 후 B전봇대 번호 arr2에 담기
            arr2[i] = arr1[i][1];
            // dp 1로 초기화
            dp[i] = 1;
        }
        // 처음부터 돌면서 판별
        for(int i = 0; i < n; i++) {
            // 반복문을 i 전까지 돌기
            for(int j = 0; j < i; j++) {
                // arr2[i]의 값이 arr2[j]보다 크다면
                if(arr2[j] < arr2[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    // 설치 가능한 전선 개수가 가장 큰 경우를 구함
                    if(max < dp[i]) {
                        max = dp[i];
                    }
                }
            }
        }
        // 철거해야할 개수 = 전체 전선 개수 - 설치 가능한 전선 개수
        System.out.println(n - max);
        sc.close();
    }
}
