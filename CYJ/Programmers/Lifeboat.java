    import java.util.Arrays;

    public class Lifeboat {
        public int solution(int[] people, int limit) {
            int answer = 0, idx = 0;
            Arrays.sort(people);
            // 제일 몸무게가 큰 사람부터 탐색함
            for(int i = people.length - 1; i >= idx; i--) {
                // 제일 큰 사람과 제일 작은 사람부터 탐색
                // 혼자 태워야 한다면, 보트 수만 증가
                if(people[i] + people[idx] > limit) {
                    answer++;
                }
                // 둘 다 태우는게 가능하다면, idx와 보트 수 모두 증가
                else {
                    idx++;
                    answer++;
                }
            }
            // 답 return
            return answer;
        }
    }
