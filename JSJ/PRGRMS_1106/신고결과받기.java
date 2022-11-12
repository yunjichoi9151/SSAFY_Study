package PRGRMS_1106;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// 한번에 유저 1명 신고 가능
// 서로 다른 유저 계속 신고 가능
// 같은 유저 여러번 신고 가능 (한번으로 취급)
// k번 이상 신고된 유저는 게시판 이용 정지됨 (신고한 유저에게 정지 통지)

public class 신고결과받기 {
	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];

		// 사용자id-신고한 사용자id의 set을 가진 맵(동일유저에 대한 신고횟수는 1로 처리, 중복X)
		Map<String, HashSet<String>> map = new HashMap<>();
		// 사용자id-임의의 인덱스
		Map<String, Integer> idxMap = new HashMap<>();
		
		/*
		 * Map 초기화
		 * 사용자id를 key값으로 받고, value 값으로 새로운 HashSet을 생성하여 Map에 넣기
		 * idxMap을 통해 사용자id(key)에 임의의 인덱스(value)를 부여
		 */
		for (int i = 0; i < id_list.length; i++) {
			String name = id_list[i];
			map.put(name, new HashSet<>());
			idxMap.put(name, i);
		}

		/*
		 * 배열 report에 대해 반복문 실행
		 * "사용자id 신고한id"로 입력이 주어짐 (split(" ")을 이용해 구분)
		 * 각각의 배열을 생성하여 신고한 사용자id(from)와 신고당한 사용자id(to)를 저장
		 * 사용자id를 key값으로 저장한 map에서 key값이 배열 to의 원소일 때 from을 value인 HashSet에 저장
		 */
		for (String s : report) {
			String[] str = s.split(" ");
			String from = str[0];
			String to = str[1];
			map.get(to).add(from);
		}

		/*
		 * 새로운 HashSet을 생성하여 map에서 key값이 id_list의 원소인 value값을 저장
		 * HashSet의 크기가 k 이상일 때
		 * answer 배열의 인덱스가 idxMap의 key값대로 저장
		 */
		for (int i = 0; i < id_list.length; i++) {
			HashSet<String> send = map.get(id_list[i]);
			if (send.size() >= k) {
				for (String name : send) {
					answer[idxMap.get(name)]++;
				}
			}
		}
		return answer;
	}

}