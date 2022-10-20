package pracprac.programmers.study;
//https://happyeuni.tistory.com/68
//해시맵 정렬  TreeMap : 문자열 사전순으로 키 정렬
import java.util.*;

public class 주차요금계산 {
	public int[] solution(int[] fees, String[] records) {
		int[] answer;
		
		//현재 주차중인 차의 정보
		HashMap<String, Integer> parking = new HashMap<>();
		//출차한 차의 정보
		HashMap<String, Integer> result = new HashMap<>();

		for (String r : records) {
			//띄어쓰기 기준으로 쪼개서 배열에 저장
			String[] record = r.split(" ");
			//시간, 차량번호, 출입기록
			int t = getMin(record[0]);
			String n = record[1];
			String io = record[2];

			if (io.equals("IN")) {
				//key : 차량번호, value : 들어온 시간 분으로 바꾸기
				parking.put(n, t);

			} else {
				//기존에 들어왔던 차가 아니면
				if (!result.containsKey(n)) {
					//요금 청구할 시간을 저장
					result.put(n, t - parking.get(n));
				} else {
					//기록이 있는 경우 시간 누적
					result.put(n, result.get(n) + t - parking.get(n));
				}
				parking.remove(n);
			}
		}
		
		//주차장에 남아있는 출차하지 않은 차 요금 계산
		for (String key : parking.keySet()) {
			if (!result.containsKey(key)) {
				result.put(key, (23 * 60 + 59) - parking.get(key));
			} else {
				result.put(key, (23 * 60 + 59) - parking.get(key) + result.get(key));
			}
		}
		
		//차량번호순으로 정렬
		Map<String, Integer> sortedFee = new TreeMap<>(result);
		
		
		//저장된 요금 계산해서 출력
		answer = new int[result.size()];
		int i = 0;
		for (String car : sortedFee.keySet()) {
			int min = sortedFee.get(car);
			if (min <= fees[0]) {
				answer[i++] = fees[1];
				System.out.println(i + " " + car + "요금 : " + fees[1]);
			} else {
				answer[i++] = (int) (fees[1] + Math.ceil((double) (min - fees[0]) / fees[2]) * fees[3]);
				System.out.println(i + " " + car + "요금  : "
						+ (int) (fees[1] + Math.ceil((double) (min - fees[0]) / fees[2]) * fees[3]));
			}
		}
		return answer;
	}
	
	//문자열 int형으로 변환
	public static int getMin(String time) {
		String[] t = time.split(":");
		return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
	}

}
