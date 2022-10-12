package BOJ_1012;

import java.util.Scanner;

public class 쿼드트리 {

	public static int[][] arr; // 흑백 이미지
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		QuadTree(0, 0, N);
		System.out.println(sb);
	}

	public static void QuadTree(int r, int c, int size) {

		// 압축이 가능할 경우 하나의 색상으로 압축해준다.
		if (isPossible(r, c, size)) {
			sb.append(arr[r][c]);
			return;
		}

		int newSize = size / 2; // 압축이 불가능 할 경우 사이즈를 절반으로 나누어야 한다.

		sb.append('('); // 각 레벨(depth)에서 여는괄호로 시작해야한다.

		QuadTree(r, c, newSize); // 왼쪽 위
		QuadTree(r, c + newSize, newSize); // 오른쪽 위
		QuadTree(r + newSize, c, newSize); // 왼쪽 아래
		QuadTree(r + newSize, c + newSize, newSize); // 오른쪽 아래

		sb.append(')'); // 해당 레벨이 끝나면 닫는괄호도 닫아준다.
	}

	// 압축이 가능한지 해당 공간을 체크해주는 함수
	public static boolean isPossible(int x, int y, int size) {
		int value = arr[x][y];

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (value != arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}