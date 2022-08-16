import java.util.Scanner;

public class Star_2447 {
    static char[][] arr;
		public static void main(String[] args) {
				Scanner sc = new Scanner(System.in);
				// n번째 줄까지 별 출력
				int n = sc.nextInt();
				// n x n 크기의 배열
				arr = new char[n][n];
				// 시작은 (0, 0)부터 n만큼, 시작 부분은 blank 아니므로 false
				star(0, 0, n, false);
				StringBuilder sb = new StringBuilder();
				// arr에 결과 입력받기
				for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++)
								sb.append(arr[i][j]);
						sb.append('\n');
				}
				// 결과 출력
				System.out.print(sb);
        sc.close();
		}
		// 별 출력 재귀함수
		static void star(int x, int y, int n, boolean blank) {
				// n이 1일 경우(쪼갤 수 없는 블록) * 입력
				if (n == 1) {
						arr[x][y] = '*';
						return;
				}
				// 5번째 블록은 blank에 해당하므로 공백으로 채워주기
				if (blank) {
						for (int i = x; i < x + n; i++) {
								for (int j = y; j < y + n; j++) {
										arr[i][j] = ' ';
								}
						}
						return;
				}
				// 한 블록 사이즈
				int size = n / 3;
				int count = 0;
				for (int i = x; i < x + n; i += size) {
						for (int j = y; j < y + n; j += size) {
									count++;
									// 5번째 블록은 blank로 만들어주어야 하므로 blank = true
									if (count == 5)
											star(i, j, size, true);
									// 나머지 블록은 blank = false
									else
											star(i, j, size, false);
						}
				}
		}
}