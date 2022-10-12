package Gold_4.Java_files.Code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Make_Constellation_4386 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 별의 개수
        int n = sc.nextInt();
        // list : 각 별의 x, y값
        List<Node> list = new ArrayList<>();
        // dis : 두 점 사이의 거리 저장
        double[][] dis = new double[n][n];
        // minCost : 각 최소비용 저장
        double[] minCost = new double[n];
        // visit : 방문여부 저장
        boolean[] visit = new boolean[n];
        // res : 최소비용 합 저장
        double res = 0;
        // list에 Node(x, y) 저장
        for(int i = 0; i < n; i++) {
            list.add(new Node(sc.nextDouble(), sc.nextDouble()));
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                // 두 점이 다른 경우만
                if(i != j) {
                    // 두 점 사이의 거리 구하기(공식 사용)
                    dis[i][j] = (double) Math.sqrt(Math.pow((list.get(j).x - list.get(i).x), 2) + Math.pow((list.get(j).y - list.get(i).y), 2));
                }
            }
        }
        // minCost에 int max값들 넣어줌
        Arrays.fill(minCost, Integer.MAX_VALUE);
        // 처음 값 0으로 지정
        minCost[0] = 0;
        for(int i = 0; i < n; i++) {
            // min에 int max 값 넣어줌
            double min = Integer.MAX_VALUE;
            // minIdx 초기값 지정
            int minIdx = 0;
            for(int j = 0; j < n; j++) {
                // 방문하지 않았고, 최솟값보다 작다면
                if(!visit[j] && minCost[j] < min) {
                    // min에 최솟값 저장
                    min = minCost[j];
                    // minIdx에 현재 j 저장
                    minIdx = j;
                }
            }
            // 결과값에 min 값 저장
            res += min;
            // minIdx의 방문여부 true로 바꿔줌
            visit[minIdx] = true;
            for(int j = 0; j < n; j++) {
                // 방문한 적이 없고, 거리가 0(자기 자신)이 아니고, minCost보다 거리가 짧은 경우
                if(!visit[j] && dis[minIdx][j] != 0 && minCost[j] > dis[minIdx][j]) {
                    // minCost에 저장
                    minCost[j] = dis[minIdx][j];
                }
            }
        }
        // 소수점 둘째자리까지 출력
        System.out.println(String.format("%.2f", res));
        sc.close();
    }
    // 별의 x, y 좌표 담는 Node
    public static class Node{
        double x;
        double y;

        Node(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
