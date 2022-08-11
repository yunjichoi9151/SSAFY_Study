package HSW;

import java.util.Scanner;

public class 삼성시의버스노선_6485 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();  //Test case

        for(int k=1; k<=tc; k++){
            int N = sc.nextInt();

            int[][] ab = new int[N][2];

            for(int i=0; i<N; i++){
                ab[i][0] = sc.nextInt();    //A_i
                ab[i][1] = sc.nextInt();    //B_i
            }

            int P = sc.nextInt();
            int[] C = new int[P];
            for(int i=0; i<P; i++){
                C[i] = sc.nextInt();
            }

            ///////////////입력처리 끝///////////////////

            int[] bus_station = new int[5001];

            //버스 정류장 배열 생성
            for(int i=0; i<N; i++){
                for(int j=1; j<5001; j++){
                    //버스정류장 번호가 A_i와 B_i 사이에 있으면 ++
                    if(j>=ab[i][0] && j<=ab[i][1])
                        bus_station[j]++;
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#" + k + " ");
            for(int i=0; i<P; i++){
                sb.append(bus_station[C[i]]).append(" ");
            }

            System.out.println(sb);
        }
    }
}
