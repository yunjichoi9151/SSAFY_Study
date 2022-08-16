import java.util.Scanner;

public class Word_Puzzle_1979 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt(), k = sc.nextInt(), sum = 0;
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    arr[i][j] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                int cnt1 = 0, cnt2 = 0;
                for (int j = 0; j < n; j++) {
                    if (j > 0 && (arr[i][j - 1] == 0)) {
                        if (arr[i][j] == 1) {
                            cnt1++;
                            System.out.println("case 1 cnt1++");
                        }
                    }
                    else {
                        if (arr[i][j] == 1) {
                            cnt1++;
                            System.out.println("case 2 cnt1++");
                        }
                        else {
                            if (cnt1 == k) {
                                sum++;
                                System.out.println("case 3 sum++");
                            }
                            cnt1 = 0;
                        }
                    }
                    if (j > 0 && (arr[j - 1][i] == 0)) {
                        if (arr[j][i] == 1) {
                            cnt2++;
                            System.out.println("case 4 cnt2++");
                        }
                    }
                    else {
                        if (arr[j][i] == 1) {
                            cnt2++;
                            System.out.println("case 5 cnt2++");
                        }
                        else {
                            if (cnt2 == k) {
                                sum++;
                                System.out.println("case 6 sum++");
                            }
                            cnt2 = 0;
                        }
                    }
                }
                if (cnt1 == k) {
                    sum++;
                    System.out.println("case 7 sum++");
                }
                if (cnt2 == k) {
                    sum++;
                    System.out.println("case 8 sum++");
                }
            }
            System.out.println("#" + tc + " " + sum);
        }       
        sc.close();
    }
}
