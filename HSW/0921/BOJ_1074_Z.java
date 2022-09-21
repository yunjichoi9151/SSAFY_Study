import java.util.Scanner;

public class BOJ_1074_Z {
    static int[][] arr;
    static int N;
    static int r;
    static int c;

    //1<<N = 2^N
    public static void divcon(int row, int col, int num, int N) {
        if (N == 1) { // 2^1 = 2니까 2x2 배열까지 쪼개어졌을때
            if (r == row && c == col) System.out.println(num);
            else if (r == row && c == col + 1) System.out.println(num + 1);
            else if (r == row + 1 && c == col) System.out.println(num + 2);
            else if (r == row + 1 && c == col + 1) System.out.println(num + 3);
//            arr[row][col] = num;
//            arr[row][col + 1] = num + 1;
//            arr[row + 1][col] = num + 2;
//            arr[row + 1][col + 1] = num + 3;
            return; //분할정복 끝 병합 시작
        }

        int cap = 1 << (N - 1); //사분면 위치를 구분하기 위한 기준선

        //그냥 재귀로 했더니 시간초과
        //사분면으로 나눠서 계산해야 시간초과가 안 남
        //사분면 기준선이 매번 바뀜에 주의(r<cap col<cap이 아닌 r<row+cap c<col+cap)
        if (r < row + cap && c < col + cap)     //제2사분면(좌상)
            divcon(row, col, num, N - 1);
        else if (r < row + cap && c >= col + cap)   //제1사분면(우상)
            divcon(row, col + (1 << (N - 1)), num + (1 << 2 * (N - 1)), N - 1);
        else if (r >= row + cap && c < col + cap)   //제3사분면(좌하)
            divcon(row + (1 << (N - 1)), col, num + 2 * (1 << 2 * (N - 1)), N - 1);
        else    //제4사분면(우하)
            divcon(row + (1 << (N - 1)), col + (1 << (N - 1)), num + 3 * (1 << 2 * (N - 1)), N - 1);

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        //배열을 만들고 시작하면 메모리초과
//        arr = new int[1 << N][1 << N];

        divcon(0, 0, 0, N);

//        System.out.println(arr[r][c]);
    }
}