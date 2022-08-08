package week1_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class N11651 {

	/*
	 * 시간제한 1초 메모리제한 256MB
	 * 
	 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
	 * 
	 * 입력 : BufferedReader 
	 * 동작 : Collections.sort() - Arrays.sort() 시간초과 
	 * 출력 : StringBuilder
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		ArrayList<int[]> list = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}

		// 정렬
		Collections.sort(list, (o1, o2) -> {
			if (o1[1] == o2[1])
				return o1[0] - o2[0];
			else
				return o1[1] - o2[1];
		});

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)[0] + " " + list.get(i)[1] + "\n");
		}

	}

}
