package PRGRMS_1023;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 주차요금계산 {
	// 차량 번호가 작은 순서로
	public int[] solution(int[] fees, String[] records) {
		int lastTime = calMin("23:59");

		Map<String, Integer> parking = new HashMap<>(); // 현재 파킹 중인 차들
		Map<String, Integer> times = new HashMap<>(); // 차들의 누적 파킹시간
		List<String> cars = new ArrayList<>(); // 차들 list

		for (String record : records) {
			String[] rc = record.split(" ");

			int time = calMin(rc[0]);
			String car = rc[1];

			// 새로운차 등장
			if (!cars.contains(car)) {
				cars.add(car);
				times.put(car, 0);
			}

			if (parking.containsKey(car)) { // 현재 파킹이 되어 있다면 출차다
				times.put(car, times.get(car) + (time - parking.get(car)));
				parking.remove(car);
			} else { // 파킹이 안되어 있다면 입차다.
				parking.put(car, time);
			}
		}

		int[] parkingCar = new int[cars.size()];
		Collections.sort(cars); // 차번 순으로 정렬

		for (int i = 0; i < cars.size(); i++) {
			parkingCar[i] = fees[1]; // 기본요금
			String car = cars.get(i);
			int time = times.get(car) - fees[0]; // 누적시간중 기본요금 시간 제외

			if (parking.containsKey(car)) // 아직 출차가 안되었다면 마지막시간으로 정산
				time += (lastTime - parking.get(car));

			if (time > 0) // 요금 정산
				parkingCar[i] += (Math.ceil(time / (fees[2] * 1.0)) * fees[3]);
		}

		return parkingCar;
	}

	// 시간 -> 분
	public int calMin(String time) {
		String[] t = time.split(":");
		return Integer.valueOf(t[0]) * 60 + Integer.valueOf(t[1]);
	}
}