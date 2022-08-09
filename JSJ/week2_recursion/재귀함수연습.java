package week2_recursion;

public class 재귀함수연습 {
	public static void main(String[] args) {

		System.out.println("시작");
		System.out.println(recursion(1));

	}

	public static int recursion(int N) {

		System.out.println("in : " + N);
		if (N > 5) {
			System.out.println("end : " + N);
			return N;
		} else {
			System.out.println("out : " + N);
		}
		return recursion(N + 1);

	}
}
