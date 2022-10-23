import java.util.ArrayList;

public class Crane_Claw_Machine_Game {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int idx = 0;
        for(int i = 0; i < moves.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[j][moves[i] - 1] != 0) {
                    // 배열에 제일 위쪽에 있는 인형 넣기
                    arr.add(board[j][moves[i] - 1]);
                    // 인형을 꺼냈으므로 0으로 만들어줌
                    board[j][moves[i] - 1] = 0;
                    // 인형이 배열에 담겼으므로 +1
                    idx++;
                    if(idx - 1 > 0) {
                        // 먼저 담긴 인형과 같은 경우
                        if(arr.get(idx - 1) == arr.get(idx - 2)) {
                            // 같은 인형 2개 삭제
                            arr.remove(idx - 1);
                            arr.remove(idx - 2);
                            // 두 개를 삭제해줬으므로 idx 값도 -2
                            idx -= 2;
                            // 인형을 삭제한만큼 answer은 +
                            answer += 2;
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
