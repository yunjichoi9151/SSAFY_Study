package HSW;

import java.util.Arrays;
import java.util.Scanner;

public class 진기의최고급붕어빵_1860 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();  //Test case

        for(int k=1; k<=tc; k++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();

            int[] client = new int[N];

            for(int i=0; i<N; i++)
                client[i] = sc.nextInt();

            //손님이 온 시간을 오름차순으로 정렬해도 문제엔 지장없음
            Arrays.sort(client);

            StringBuilder sb = new StringBuilder();

            sb.append("#" + k + " ");

            boolean can = true;
            //손님이 온 시간 별로 분석
            for(int i=0; i<N; i++){
                //먼저 M으로 나누고 K로 곱해야만 함
                //2초마다 붕어빵이 3개씩 나오는데 영업개시 1초만에 손님이 오는 경우
                //(1/2)*3 = 0이지만 1/2*3 = 1이 됨
                if((client[i]/M)*K<i+1){
                    can = false;    //한번이라도 붕어빵 제공이 불가하면 false로 하고 break;
                    break;
                }
            }

            //boolean값 판단해서 po/im 선택
            if(can)
                sb.append("Possible");
            else
                sb.append("Impossible");

            System.out.println(sb);
        }
    }
}
