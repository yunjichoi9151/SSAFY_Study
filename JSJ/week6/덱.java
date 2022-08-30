package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 덱 {

	static int[] deq;
	static int size = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 명령의 수
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();

			switch (a) {
			case "push_front":
				push_front(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				push_back(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				pop_front();
				break;
			case "pop_back":
				pop_back();
				break;
			case "size":
				size();
				break;
			case "empty":
				empty();
				break;
			case "front":
				front();
				break;
			case "back":
				back();
				break;
			}

		}
	}

	static void push_front(int x) {
		int[] tmp = new int[++size];
		for (int i = 1; i < size; i++) {
			tmp[i] = deq[i - 1];
		}
		tmp[0] = x;

		deq = new int[size];
		for (int i = 0; i < size; i++) {
			deq[i] = tmp[i];
		}
	}

	static void push_back(int x) {
		int[] tmp = new int[++size];
		for (int i = 0; i < size - 1; i++) {
			tmp[i] = deq[i];
		}
		tmp[size - 1] = x;

		deq = new int[size];
		for (int i = 0; i < size; i++) {
			deq[i] = tmp[i];
		}
	}

	static void pop_front() {
		if (size == 0)
			System.out.println(-1);
		else {
			int answer = deq[0];
			for (int i = 0; i < size - 1; i++) {
				deq[i] = deq[i + 1];
			}
			size--;

			System.out.println(answer);
		}
	}

	static void pop_back() {
		if (size == 0)
			System.out.println(-1);
		else {
			int answer = deq[size - 1];
			size--;
			System.out.println(answer);
		}
	}

	static void size() {
		System.out.println(size);
	}

	static void empty() {
		if (size == 0)
			System.out.println(1);
		else
			System.out.println(0);
	}

	static void front() {
		if (size == 0)
			System.out.println(-1);
		else
			System.out.println(deq[0]);
	}

	static void back() {
		if (size == 0)
			System.out.println(-1);
		else
			System.out.println(deq[size - 1]);

	}
}