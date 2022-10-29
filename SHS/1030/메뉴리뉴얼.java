package pracprac.programmers.study.d1030; 
//https://fbtmdwhd33.tistory.com/249
//조합에 해시맵 entry까지 알차게 써야하는 문제
//https://recordsoflife.tistory.com/314 : Map.Entry -> key, value하나씩 순차적으로 꺼내는



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class 메뉴리뉴얼 {
	static HashMap<String, Integer> map;
	
	//DFS
	public static void combination(String str, StringBuilder sb, int idx, int cnt, int n) {
		//종료 조건 : 각 코스요리의 개수만큼 조합시 더 추가 불가능
		if (cnt == n) {
			//조합 삽입 및 카운트
			map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
			return;
		}
		//조합 구하면서 재귀
		for (int i = idx; i < str.length(); i++) {
			sb.append(str.charAt(i));
			combination(str, sb, i + 1, cnt + 1, n);
			sb.delete(cnt, cnt + 1); //붙였던 메뉴를 다시 떼서 초기화
		}
	}
	
	//테케마다 갯수 변경되므로 ArrayList 사용이 편함
	public ArrayList<String> solution(String[] orders, int[] course) {
		ArrayList<String> answer = new ArrayList<>();
		
		//정렬 및 문자열로 변환해서 저장
		for (int i = 0; i < orders.length; i++) {
			char[] c = orders[i].toCharArray();
			Arrays.sort(c);
			orders[i] = String.valueOf(c);
		}
		
		//조합 구하기
		for (int i = 0; i < course.length; i++) {
			map = new HashMap<>();
			//가장 많이 주문된 횟수 저장하기
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < orders.length; j++) {
				StringBuilder sb = new StringBuilder();
				//코스요리 개수 <=문자열 길이인 경우 조합 탐색
				if (course[i] <= orders[j].length()) {
					combination(orders[j], sb, 0, 0, course[i]);
				}
			}
			//많이 주문한 횟수 max에 저장
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				max = Math.max(max, entry.getValue());

			}
			//최소 2번 이상 주문된 조합이고 횟수가 일치하는 조합을 ArrayList에 저장
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				if (max >= 2 && entry.getValue() == max)
					answer.add(entry.getKey());
			}
		}
		Collections.sort(answer);

		return answer;
	}

}
