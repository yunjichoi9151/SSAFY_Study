package pracprac.programmers.study.d1030;
//배열의 숫자에서 전체 n만큼 빼서 평탄화 하고

//각 수의 제곱의 합을 구하면 됨
//우선순위 큐를써서 큰 값부터 줄여주기 반복

/*
 *         int size= pq.size();
        for(int i = 0; i<size; i++) {
            int j = pq.poll();
            answer += j*j;
        }
 * 
 */
import java.util.Collections;
import java.util.PriorityQueue;

public class 야근지수 {
	public long solution(int n, int[] works) {
		//우선순위큐 기본 오름차순 정렬이므로 내림차순으로 받기
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		//우선순위큐에 works 값 저장
		for (int i = 0; i < works.length; i++) {
			pq.offer(works[i]);
		}
		//큰 수부터 n만큼 빼서 평탄화
		while (n > 0) {
			int work = pq.poll();
			if (work == 0) {
				break;
			}
			work -= 1;

			pq.offer(work);
			n -= 1;
		}

		long answer = 0;
		
		//향상된 for 문 쓰는게 간단
		//평탄화된 우선순위큐에 저장된 값들 제곱해서 합산
		for (int i : pq) {
			answer += i * i;
		}

		return answer;
	}
}
