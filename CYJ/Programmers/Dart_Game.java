public class Dart_Game {
    public int solution(String dartResult) {
        // dart : 배열로 만들어서 판별
        char[] dart = dartResult.toCharArray();
        // game : 1세트의 결과를 담음
        int[] game = new int[3];
        int idx = -1;
        for(int i = 0; i < dart.length; i++) {
            // 숫자라면
            if(dart[i] >= '0' && dart[i] <= '9'){
                idx++;
                // 10인 경우
                if(dart[i] == '1' && dart[i + 1] == '0') {
                    game[idx] = 10;
                    i++;
                }
                // 0~9인 경우
                else {
                    game[idx] = dart[i] - '0';
                }
            }
            // Double인 경우
            if(dart[i] == 'D') {
                game[idx] *= game[idx];
            }
            // Triple인 경우
            else if(dart[i] == 'T') {
                game[idx] *= game[idx] * game[idx];
            }
            // 스타상인 경우
            else if(dart[i] == '*') {
                if(idx > 0) {
                    // 첫번째 기회가 아닌 경우에서 나왔을 때
                    game[idx - 1] *= 2;
                }
                game[idx] *= 2;
            } else if(dart[i] == '#') {
                game[idx] *= -1;
            }
        }
        // 답 return
        return game[0] + game[1] + game[2];
    }
}
