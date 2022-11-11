package pracprac.programmers.study.d1106;
//https://code-lab1.tistory.com/87
//겹치는 블록 처리를 어떻게 해야할지 모르겠음
//결론은 모든 블록을 각각 조사해서 일괄적으로 삭제해야한다는 것
//제거해야할 블록을 제외하고 큐에 넣은 뒤에 다시 블록을 쌓아주기 반복(2*2 없을 때까지)

import java.util.LinkedList;
import java.util.Queue;

public class 프렌즈4블록 {
	static boolean visited[][];

	public int solution(int m, int n, String[] board) {
		int answer = 0;
		char copy[][] = new char[m][n];
		for (int i = 0; i < m; i++) {
			copy[i] = board[i].toCharArray();
		}
		
		//2*2블록 남아있는지 여부
		boolean flag = true;
		while (flag) {
			visited = new boolean[m][n];
			flag = false;
			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					if (copy[i][j] == '#')
						continue;
					if (check(i, j, copy)) {
						visited[i][j] = true;
						visited[i][j + 1] = true;
						visited[i + 1][j] = true;
						visited[i + 1][j + 1] = true;
						flag = true;
					}
				}
			}
			answer += erase(m, n, copy);
			visited = new boolean[m][n];
		}
		return answer;
	}

	//2*2 블록인지 체크
	public static boolean check(int x, int y, char[][] board) {
		char ch = board[x][y];
		if (ch == board[x][y + 1] && ch == board[x + 1][y] && ch == board[x + 1][y + 1]) {
			return true;
		}
		return false;
	}
	
	//2*2 블록 제거
	public static int erase(int m, int n, char[][] board) {
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j])
					board[i][j] = '.';
			}
		}
		
		//큐를 이용해 세로방향 기준으로 제거
		for (int i = 0; i < n; i++) {
			Queue<Character> q = new LinkedList<>();
			for (int j = m - 1; j >= 0; j--) {
				if (board[j][i] == '.') {
					cnt++; //지워지는 블록은 큐에 넣지 않고 카운트
				} else {
					q.add(board[j][i]);
				}
			}
			//삭제된 블록 자리 채우기
			int idx = m - 1;
			while (!q.isEmpty()) {
				board[idx--][i] = q.poll();
			}
			//빈칸 채워주기
			for (int j = idx; j >= 0; j--) {
				board[j][i] = '#';
			}
		}

		return cnt;
	}
}
