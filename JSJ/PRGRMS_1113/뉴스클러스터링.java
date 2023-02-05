package PRGRMS_1113;

import java.util.HashMap;

public class 뉴스클러스터링 {
	public int solution(String str1, String str2) {
		int jacard = 0;	// 교집합 / 합집합 * 65536

		double inter = 0;	// 각 집합에서 중복되는 문자 개수의 min
		double union = 0;	// 각 집합에서 중복되는 문자 개수의 max

		HashMap<String, Integer> map1 = new HashMap<>();
		HashMap<String, Integer> map2 = new HashMap<>();

		// 대문자 치환
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();

		// str1, str2를 2문자씩 잘라 해당 map에 넣기 (key : 문자 / value : 해당 문자의 개수)
		for (int i = 0; i < str1.length()-1; i++) {
			// 2글자씩 자르기
			String s = str1.substring(i, i + 2).replaceAll("[^A-Z']", "");
			// 특수문자가 포함되면 길이가 2보다 작음 -> 글자 쌍 버림
			if (s.length() < 2)
				continue;
			// 특수문자 포함X일 경우 해당 map 갱신 : getOrDefault(key, DefaultValue) -> 해당 key의 value값이 없는 경우 지정한 default 값 반환
			map1.put(s, map1.getOrDefault(s, 0) + 1);
		}
		for (int i = 0; i < str2.length() - 1; i++) {
			String s = str2.substring(i, i + 2).replaceAll("[^A-Z']", "");
			if (s.length() < 2)
				continue;
			map2.put(s, map2.getOrDefault(s, 0) + 1);
		}

		// 둘 다 공집합일 경우 자카드 유사도 = 1
		if (map1.size() == 0 && map2.size() == 0)
			return 65536;

		for (String key : map1.keySet()) {
			if (map2.containsKey(key)) {	// 교집합
				inter += Math.min(map1.get(key), map2.get(key));	// 교집합
				union += Math.max(map1.get(key), map2.get(key));	// 합집합
				map2.remove(key);	// 비교 완료 집합 지움
			} else {	// 합집합
				union += map1.get(key);	
			}

		}

		for (String key : map2.keySet()) {
			union += map2.get(key);	// map2로 합집합 갯수 갱신
		}

		jacard = (int) Math.floor((inter / union) * 65536);
		
		return jacard;
	}
}