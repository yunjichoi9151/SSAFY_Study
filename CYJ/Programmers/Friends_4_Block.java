public class Friends_4_Block {
    public int solution(int m, int n, String[] board) {
        int ans = 0;
        // arr : 배치 정보 담을 배열
        char[][] arr = new char[m][n];
        // 한 글자씩 나누어서 한 줄에 담음
        for(int i = 0; i < board.length; i++) {
            arr[i] = board[i].toCharArray();
        }

        while(true) {
            // 지워지는 블록 개수 체크
            int cnt = count(arr, m, n);
            // 지워질 블록이 없다면 break
            if(cnt == 0) {
                break;
            }
            // 아니라면 ans에 cnt 더해서 저장
            ans += cnt;
            // 빈 공간만큼 위에 있던 블록들을 drop시켜줌
            drop(arr, m, n);
        }
        // 답 return
        return ans;
    }

    public static void isSame(char[][] arr, boolean[][] check, int i, int j) {
        // 4칸 비교
        for(int y = i; y < i + 2; y++) {
            for(int x = j; x < j + 2; x++) {
                // 같지 않은 항목이 있다면 여기서 return
                if(arr[i][j] != arr[y][x]) {
                    return;
                }
            }
        }
        // 만약 4칸이 모두 같을 경우
        for(int y = i; y < i + 2; y++) {
            for(int x = j; x < j + 2; x++) {
                // 해당 4칸의 check를 true로 바꿔줌
                check[y][x] = true;
            }
        }
    }

    public static int count(char[][] arr, int m, int n) {
        // isEmpty : 공백인 부분 확인
        boolean[][] check = new boolean[m][n];
        int cnt = 0;
        // i ~ i + 1행과 j ~ j + 1열까지 비교해야 하므로 각각 m - 1, n - 1 전까지
        for(int i = 0; i < m - 1; i++) {
            for(int j = 0; j < n - 1; j++) {
                if(arr[i][j] != ' ') {
                    // 공백이 아니라면 주변 항목 체크
                    isSame(arr, check, i, j);
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // isSame에서 true로 판별된 칸이라면
                if(check[i][j]) {
                    // 지워줌
                    arr[i][j] = ' ';
                    // 지워지는 블록 개수 +
                    cnt++;
                }
            }
        }
        // cnt return
        return cnt;
    }

    public static void drop(char[][] arr, int m, int n) {
        // 세로 한 줄씩 탐색
        for(int j = 0; j < n; j++) {
            // 밑에서부터 위로 탐색
            for(int i = m - 1; i >= 0; i--) {
                // 비어있는 곳이라면
                if(arr[i][j] == ' ') {
                    // 해당 줄의 위쪽을 차례로 탐색
                    for(int k = i - 1; k >= 0; k--) {
                        // 만약 비어있지 않은 항목이 나오면
                        if(arr[k][j] != ' ') {
                            // 지금 비어있는 곳에 해당 항목의 값을 넣어줌
                            arr[i][j] = arr[k][j];
                            // 원래 비어있지 않았던 곳은 비워줌
                            arr[k][j] = ' ';
                            break;
                        }
                    }
                }
            }
        }
    }
}
