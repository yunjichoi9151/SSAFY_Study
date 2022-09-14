package Silver_2.Java_files.Code;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Nth_Largest_Number_2075 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n * n; i++) {
            queue.offer(sc.nextInt());
        }
        for(int i = 0; i < n - 1; i++) {
            queue.poll();
        }
        System.out.println(queue.poll());
    }
}
