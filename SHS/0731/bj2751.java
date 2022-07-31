package pracprac.bj.study.d0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class bj2751 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//시간초과 주의
		//Scanner 안되고 그냥 배열 안됨
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list);
		
		for(int value : list) {	
			sb.append(value).append('\n');
		}
			System.out.println(sb);
	}

}
