package week5_IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 종이자르기 {

	static int w; // 가로 길이
	static int h; // 세로 길이
	static int n; // 점선 개수
	static int maxW; // 최대 가로 길이
	static int maxH; // 최대 세로 길이
	static ArrayList<Integer> colCutList = new ArrayList<>(); // 세로로 자르기
	static ArrayList<Integer> rowCutList = new ArrayList<>(); // 가로로 자르기

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		// 처음, 마지막 선 추가
		colCutList.add(0);
		colCutList.add(w);
		rowCutList.add(0);
		rowCutList.add(h);

		n = Integer.parseInt(br.readLine());
		// 자르기 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken()); // 자르는 점선 타입

			// 가로로 자르기
			if (type == 0) {
				rowCutList.add(Integer.parseInt(st.nextToken()));
			}
			// 세로로 자르기
			else if (type == 1) {
				colCutList.add(Integer.parseInt(st.nextToken()));
			}
		}

		// 정렬
		Collections.sort(colCutList);
		Collections.sort(rowCutList);

		rowCut();
		colCut();
		System.out.println(maxW * maxH);

		br.close();
	}

	// 가로로 자르기
	public static void rowCut() {
		for (int i = 0; i < rowCutList.size() - 1; i++) {
			int dis = rowCutList.get((i + 1)) - rowCutList.get(i); // 두 점 사이의 거리
			maxH = Math.max(maxH, dis); // 간격 가장 넓은 것 찾기
		}
	}

	// 세로로 자르기
	public static void colCut() {
		for (int i = 0; i < colCutList.size() - 1; i++) {
			int dis = colCutList.get((i + 1)) - colCutList.get(i); // 두 점 사이의 거리
			maxW = Math.max(maxW, dis); // 간격 가장 넓은 것 찾기
		}
	}
}