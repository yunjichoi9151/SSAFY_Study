package 백준;

import java.util.Scanner;

public class 틱택토 {
    static char[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String checkValid = "invalid";

            String str = sc.next();
            if (str.equals("end")) break;

            board = new char[3][3];

            int xCnt = 0;
            int oCnt = 0;

            for (int i = 0; i < 9; i++) {
                char now = str.charAt(i);

                if (now == 'X') xCnt++;
                else if (now == 'O') oCnt++;

                board[i / 3][i % 3] = now;
            }

            if (tictactoc()) {
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }
        }
    }

    private static boolean tictactoc() {
        int xCnt = 0;
        int oCnt = 0;
        int empty = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'X') {
                    xCnt++;
                } else if (board[i][j] == 'O') {
                    oCnt++;
                } else if (board[i][j] == '.') {
                    empty++;
                }
            }
        }

        if (xCnt < oCnt) {
            return false;
        }

        int sum = xCnt + oCnt;

        // 놓을 말이 없는 경우
        // 무조건 X가 이기거나 무승부여야 한다.
        if (sum == 9 && xCnt == oCnt + 1) {
            // O 말이 이기거나 둘다 이기면 return false
            if (isConnect('O') && !isConnect('X')) {
                return false;
            } else if (isConnect('O') && isConnect('X')) {
                return false;
            }
            return true;
        }

        // 아직 말이 남은 경우
        // X가 이긴경우 : X의 개수가 하나 더 많아야한다.
        // O가 이긴경우 : O와 X의 개수가 같아야한다.
        else {
            if (xCnt == oCnt + 1) {
                if (isConnect('X') && !isConnect('O')) {
                    return true;
                } else {
                    return false;
                }
            } else if (xCnt == oCnt) {
                if (isConnect('O') && !isConnect('X')) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        return false;
    }

    private static boolean isConnect(char c) {
        // 가로
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == c && board[i][1] == c && board[i][2] == c) {
                return true;
            }
        }
        // 세로
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == c && board[1][i] == c && board[2][i] == c) {
                return true;
            }
        }
        // 대각선
        if (board[0][0] == c && board[1][1] == c && board[2][2] == c) {
            return true;
        }

        if (board[2][0] == c && board[1][1] == c && board[0][2] == c) {
            return true;
        }
        return false;
    }
}
