package 프로그래머스.카카오;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기 {

    public static void main(String[] args) {
        int[] queue1 = {1,1};
        int[] queue2 = {1,5};

        System.out.println(solution(queue1, queue2));
    }

    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        long sum1 = 0;
        long sum2 = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            q1.offer(queue1[i]);

            sum2 += queue2[i];
            q2.offer(queue2[i]);
        }

        while (sum1 != sum2) {

            if (answer > queue1.length *3) {
                answer = -1;
                break;
            }

            if (sum1 < sum2) {
                int tmp = q2.poll();
                q1.offer(tmp);

                sum1 += tmp;
                sum2 -= tmp;
            } else if (sum1 > sum2) {
                int tmp = q1.poll();
                q2.offer(tmp);

                sum2 += tmp;
                sum1 -= tmp;
            }

            answer++;
        }

        return answer;
    }
}
