package week8_heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class K번째수_11004 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 입력받을 수 개수
		int K = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens())
			pq.add(Integer.parseInt(st.nextToken()));

		int cnt = 0;
		while (true) {
			if (cnt < K - 1) {
				pq.poll();
				cnt++;
				continue;

			} else {
				System.out.println(pq.poll());
				break;
			}
		}
	}
}
