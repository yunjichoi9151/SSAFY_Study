package week5_IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 방배정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 수학여행 참가 학생 수
		int K = Integer.parseInt(st.nextToken()); // 한방에 배정할 수 있는 최대 인원 수

		int[][] room = new int[7][2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken()); // 성별 - 0:여자 1:남자
			int grade = Integer.parseInt(st.nextToken()); // 학년

			room[grade][gender]++;
		}

		int cnt = 0;

		for (int i = 1; i <= 6; i++) {
			for (int j = 0; j < 2; j++) {
				if (room[i][j] > 0 && room[i][j] <= K) { // 인원이 K명 이하일 때
					cnt++;
				} else if (room[i][j] % K == 0) { // 인원이 K명 초과, K의 배수일 때
					cnt += room[i][j] / K;
				} else if (room[i][j] % K > 0) { // K명 초과, K의 배수가 아닐 때
					cnt += room[i][j] / K + 1;
				}
			}
		}

		System.out.println(cnt);
	}
}
