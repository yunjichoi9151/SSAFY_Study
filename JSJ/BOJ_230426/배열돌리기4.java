package 백준.boj_0424;

import java.io.*;
import java.util.StringTokenizer;

public class 배열돌리기4 {

    static int N, M, K;
    static int[][] rotation;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rotation = new int[K][3];

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            rotation[k][0] = Integer.parseInt(st.nextToken());
            rotation[k][1] = Integer.parseInt(st.nextToken());
            rotation[k][2] = Integer.parseInt(st.nextToken());
        }

        permutation(0, new int[K], new boolean[K]);

        System.out.println(min);
    }

    public static void permutation(int cnt, int[] arr, boolean[] visited) {
        if (cnt == K) {
            rotate(arr);
            return;
        }
        for (int i = 0; i < K; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            arr[cnt] = i;
            permutation(cnt + 1, arr, visited);
            visited[i] = false;
        }
    }

    public static void rotate(int[] arr) {
        int[][] tmp = copyArr();

        for (int k = 0; k < K; k++) {
            int r = rotation[arr[k]][0];
            int c = rotation[arr[k]][1];
            int S = rotation[arr[k]][2];

            for (int s = 1; s <= S; s++) {
                //위
                int upTmp = tmp[r - s][c + s];
                for (int y = c + s; y > c - s; y--) {
                    tmp[r - s][y] = tmp[r - s][y - 1];
                }
                //오른쪽
                int rightTmp = tmp[r + s][c + s];
                for (int x = r + s; x > r - s; x--) {
                    tmp[x][c + s] = tmp[x - 1][c + s];
                }
                tmp[r - s + 1][c + s] = upTmp;
                //아래
                int leftTmp = tmp[r + s][c - s];
                for (int y = c - s; y < c + s; y++) {
                    tmp[r + s][y] = tmp[r + s][y + 1];
                }
                tmp[r + s][c + s - 1] = rightTmp;
                //왼쪽
                for (int x = r - s; x < r + s; x++) {
                    tmp[x][c - s] = tmp[x + 1][c - s];
                }
                tmp[r + s - 1][c - s] = leftTmp;
            }
        }

        findMinVal(tmp);
    }

    public static int[][] copyArr() {
        int[][] tmp = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                tmp[i][j] = arr[i][j];
            }
        }

        return tmp;
    }

    public static void findMinVal(int[][] tmp) {
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= M; j++) {
                sum += tmp[i][j];
            }
            if (min > sum) min = sum;
        }
    }
}