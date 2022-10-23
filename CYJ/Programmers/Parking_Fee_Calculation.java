import java.util.Arrays;
import java.util.HashMap;

public class Parking_Fee_Calculation {
    public int[] solution(int[] fees, String[] records) {
        // fees : 주차 요금 배열
        // records : 자동차의 입/출차 내역을 나타내는 배열
        // isParking : 주차 요금
        HashMap<String, Integer> isParking = new HashMap<String, Integer>();
        // cars : 주차시간 누적
        HashMap<String, String> cars = new HashMap<String, String>();
        for(int i = 0; i < records.length; i++) {
            // tmp : 입/출차 기록 하나를 시각, 차량 번호, 내역으로 나눠서 담기
            String[] tmp = records[i].split(" ");
            // 차가 들어왔을 경우
            if(tmp[2].equals("IN")) {
                // cars에 차량 번호 & 입차 시각 넣어줌
                cars.put(tmp[1], tmp[0]);
            }
            // 차가 나가는 경우
            else if(tmp[2].equals("OUT")) {
                // inTime : 차량 번호에 해당하는 입차 시각. cars의 시각을 : 기준으로 구분하기
                String[] inTime = cars.get(tmp[1]).split(":");
                // 이미 입차 시각을 활용했으므로, 다음에 또 들어올 경우를 위하여 삭제
                cars.remove(tmp[1]);
                // outTime : 출차 시각. tmp의 시각을 : 기준으로 구분하기
                String[] outTime = tmp[0].split(":");
                // time : 주차장에 머물렀던 시간 계산
                int time = 0;
                // 시간과 분을 따로 계산해서 더하기
                time += ((Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0])) * 60) + (Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]));
                // 기존에 데이터가 존재하는 경우 계산한 time 더해서 누적하기
                if(isParking.containsKey(tmp[1])) {
                    isParking.replace(tmp[1], isParking.get(tmp[1]) + time);
                } else {
                    // 처음인 경우 isParking에 추가
                    isParking.put(tmp[1], time);
                }
            }
        }
        // 나간 기록이 없는 차들, 즉 끝까지 남아있는 차들 꺼내줌
        for(String key : cars.keySet()) {
            // 위의 '차가 나가는 경우'와 같은 절차로 진행됨
            String[] inTime = cars.get(key).split(":");
            int time = 0;
            // 시간 계산은 23:59분 기준
            time += ((23 - Integer.parseInt(inTime[0])) * 60) + (59 - Integer.parseInt(inTime[1]));
            if(isParking.containsKey(key)) {
                isParking.replace(key, isParking.get(key) + time);
            } else {
                isParking.put(key, time);
            }
        }
        // 차 번호 순서대로 정리하기
        Object[] sorting = isParking.keySet().toArray();
        Arrays.sort(sorting);
        int[] answer = new int[sorting.length];
        for(int i = 0; i < sorting.length; i++) {
            // 누적 시간 계산
            int finalTime = isParking.get(sorting[i]);
            int fee = 0;
            // 기본금 계산
            if(finalTime >= fees[0]) {
                finalTime -= fees[0];
                fee = fees[1];
            } else {
                finalTime = 0;
                fee = fees[1];
            }
            // 기본금 계산 후 남은 시간 계산
            if(finalTime > 0) {
                if(finalTime % fees[2] == 0) {
                    fee += finalTime / fees[2] * fees[3];
                } else {
                    // 단위 시간으로 나누어 떨어지지 않으면 올림
                    fee += (finalTime / fees[2] + 1) * fees[3];
                }
            }
            answer[i] = fee;
        }
        return answer;
    }
}
