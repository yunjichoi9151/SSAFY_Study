package Baekjoon.Programmers;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class PRG_구명보트 {
    //그리디?
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        Deque<Integer> deq = new LinkedList<>();
        int idx = Integer.MAX_VALUE;    //limit/2보다 높은 idx

        //무게가 limit/2보다 높은 것은 전부 1회
        //무게가 limit/2보다 낮은 것들만 카운트
        for (int i = 0; i < people.length; i++) {
            if (people[i] > limit / 2) {
                deq.add(i);
                if (idx > i)
                    idx = i;
            }
        }

        int cnt = deq.size();  //limit/2보다 무게가 많이 나가는 사람만큼 배가 있다
        //idx-1번째 사람이 가장 무거움
        //idx-1번째 사람이 idx번째 사람과 같이 못타면 그 뒤에 사람과도 탈 수 없음
        int last;
        //i : 탈사람, last : 그나마 가장 자리가 넓은 마지막 배

        int start = idx - 1;    //제일 무거운 사람부터 시작
        //같이 못타면?
        while (true) {
            if (start < 0) break;
            last = deq.peek();
            if (people[start] + people[last] > limit) {
                cnt++;      //같이 못타니까 새로운배를 추가
                // 더 가벼운 사람이 타기 때문에 먼저 꺼내야 하므로 addfirst
                // 이걸 위해 queue가 아닌 deque사용
                deq.addFirst(start);
                start--;
            }
            //같이 탈 수 있으면?
            else {
                deq.poll(); //이 배는 꺼내서 버림
                start--;    //다음 사람
            }
        }

        return cnt;
    }
}