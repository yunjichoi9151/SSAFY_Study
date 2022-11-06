import java.util.Collections;
import java.util.PriorityQueue;

public class Night_Overtime_index {
    public long solution(int n, int[] works) {
        long answer = 0;
        // queue : 우선순위 큐(제일 작업량이 많은 순서대로)
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        // queue에 작업량 저장
        for(int i = 0; i < works.length; i++) {
            queue.offer(works[i]);
        }
        // n이 0이 될때까지 작업량-1을 차례대로 해주면서 queue에 저장
        while(n > 0) {
            int work = queue.poll();
            queue.offer(work - 1);
            n--;
        }
        // 야근 지수
        for(int i = 0; i < works.length; i++) {
            int a = queue.poll();
            if(a >= 0) {
                answer += (a * a);
            }
        }
        return answer;
    }
}
