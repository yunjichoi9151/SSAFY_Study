package PRGRMS_1106;

// 5, 10 틀림
public class 프렌즈4블록 {

	static char[][] map;
	static boolean[][] visited;

	public static int solution(int m, int n, String[] board) {
		int answer = 0;

		// 보드 채우기
		// 라이언(R), 무지(M), 어피치(A), 프로도(F), 네오(N), 튜브(T), 제이지(J), 콘(C)
		// 없앴다면 X

		map = new char[m][n];
		for (int i = 0; i < m; i++) {
			map[i] = board[i].toCharArray();
		}

		while (true) {
			int cnt = countBlock(m, n);
			if (cnt == 0)
				break;

			answer += cnt;
			mapClear();
		}

		return answer;

	}

	static void boxCheck(int r, int c) {

		// 4블록 빙고가 아닌 경우
		for (int i = r; i < r + 2; i++) {
			for (int j = c; j < c + 2; j++) {
				if (map[i][j] != map[r][c]) {
					return;
				}
			}
		}

		// 4블록 빙고일 경우
		for (int i = r; i < r + 2; i++) {
			for (int j = c; j < c + 2; j++) {
				if (map[i][j] == map[r][c]) {
					visited[i][j] = true;
				}
			}
		}

	}

	// 4블록 빙고처리 된 블럭 개수
	static int countBlock(int m, int n) {
		visited = new boolean[m][n];
		int cnt = 0;

		for (int i = 0; i < m - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				// 빈칸이 아닐때
				if (map[i][j] != 'X') {
					// 1번 위치 기준 4콤보 가능 탐색
					boxCheck(i, j);

				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j]) {
					cnt++;
					map[i][j] = 'X'; // 빙고판 X 처리
				}
			}
		}

		return cnt;
	}

	// 보드 재정렬
	static void mapClear() {

		for (int i = 0; i < map[0].length; i++) {
			for (int j = 1; j < map.length; j++) {
				if (map[j][i] == 'X') {
					map[j][i] = map[j - 1][i];
					map[j - 1][i] = 'X';
				}
			}
		}
	}

	// main
	public static void main(String[] args) {

		int m = 4; // 세로 r
		int n = 5; // 가로 c
		String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };

//		int m = 6;
//		int n = 6;
//		String[] board = { "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ" };

		System.out.println(solution(m, n, board));
	}
}