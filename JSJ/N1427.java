package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class N1427 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] arr = br.readLine().toCharArray();
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i] - '0');
		}

		Collections.sort(list, Collections.reverseOrder());

		StringBuilder sb = new StringBuilder();
		for (Integer i : list) {
			sb.append(i);
		}

		System.out.println(sb.toString());

	}
}
