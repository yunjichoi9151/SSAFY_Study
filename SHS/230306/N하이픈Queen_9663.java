package 이공이삼삼월.d230302;
//1차원 배열로 해결하는 방법 : 인덱스:열, 퀸 위치:행
//https://st-lab.tistory.com/118
//2차원배열 풀이 : https://iseunghan.tistory.com/251
import java.util.Scanner;

public class N하이픈Queen_9663 {

	static int[] arr;
	static int N;
	static int cnt;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];

		nQueen(0);
		System.out.println(cnt);

	}

	private static void nQueen(int depth) {
		//행을 다 채우면 리턴
		if (depth == N) {
			cnt++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			arr[depth] = i;

			if (isPossible(depth)) {
				nQueen(depth + 1);
			}
		}

	}

	private static boolean isPossible(int c) {

		for (int i = 0; i < c; i++) {
			//해당 col의 행과 i열의 행이 일치 = 같은행에 위치
			if (arr[c] == arr[i]) {
				return false;
			//대각선상 = (절대값) c-r == r-c 일 때
			} else if (Math.abs(c - i) == Math.abs(arr[c] - arr[i])) {
				return false;
			}
		}
		return true;
	}
}
