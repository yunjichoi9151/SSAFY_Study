package day0812;

import java.util.Arrays;

public class BOJ_2309_일곱난쟁이 {
	public static void main(String[] args) {
		int[] arr = { 20, 7, 23, 1, 10, 15, 25, 8, 13 };
		int r = 7;
		boolean[] selected = new boolean[arr.length];

		comb(arr, selected, 0, 0, r);

	}

	static void comb(int[] arr, boolean[] selected, int start, int depth, int r) {

		if (depth == r) {
			int sum = 0;
				for(int i=0;i<arr.length-1;i++) {
						if(arr[i]>arr[i+1]) {
							int tmp = arr[i];
							arr[i] = arr[i+1];
							arr[i+1] = tmp;
						}
					}
				
			

			for (int i = 0; i < arr.length; i++) {
				if (selected[i]) {
					sum += arr[i];
				}

			}
			if (sum == 100) {
				for (int i = 0; i < arr.length; i++) {

					if (selected[i])
						System.out.print(arr[i] + " ");

				}

				System.out.println();
			}
			
		

		}
		for (int i = start; i < arr.length; i++) {
			selected[i] = true;
			comb(arr, selected, i + 1, depth + 1, r);
			selected[i] = false;
		}

	}
}
