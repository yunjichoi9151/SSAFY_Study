package PRGRMS_1030;

import java.util.Collections;
import java.util.PriorityQueue;

public class 야근지수 {
	public long solution(int n, int[] works) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 역순 정렬

		// 우선순위 큐에 값 넣기
		for (int work : works) {
			pq.offer(work);
		}

		// n만큼 반복 (남은 시간)
		for (int i = 0; i < n; i++) {
			int val = (int) pq.poll(); // 작업량
			if (val <= 0) // 작업량이 0보다 작아질 경우 break;
				break;
			pq.offer(val - 1); // 아닐 경우 잡업량 -1 해서 다시 pq에 넣기
		}

		// 야근지수 계산
		return Cal(pq);
	}

	long Cal(PriorityQueue<Integer> works) {
		long sum = 0;
		while (!works.isEmpty()) {
			sum += Math.pow(works.poll(), 2);
		}
		return sum;
	}
}