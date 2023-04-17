package 백준.boj_0410;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 카드합체놀이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        PriorityQueue<Long> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            q.add(sc.nextLong());
        }

        while (m > 0) {
            long tmp = q.poll() + q.poll();
            q.add(tmp);
            q.add(tmp);
            m--;
        }

        long ans = 0;
        while (!q.isEmpty()) {
            ans += q.poll();
        }

        System.out.println(ans);
    }
}
