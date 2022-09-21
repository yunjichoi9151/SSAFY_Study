package Gold_4.Java_files.Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Star_11_2448 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
		// 가로 n * 2, 세로 n 크기의 배열 생성
        char[][] arr = new char[n][n * 2];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n * 2; j++) {
				// 일단 다 공백으로 채움
                arr[i][j] = ' ';
            }
        }
		// 기준점 Node를 담을 list 생성 
        List<Node> list = new ArrayList<>();
		// 가장 첫 줄의 가운데 * list에 추가
        list.add(new Node(0, n - 1));
		// tmp의 첫 값은 n으로 넣어줌
        int tmp = n;
		// 입력값이 3보다 클 때만 도는 반복문
        while(true) {
			// 기준점 기준으로 양옆으로 tmp만큼, 밑으로 tmp만큼 간 값이 새로운 기준점이 될 것임
            tmp /= 2;
			// 3보다 작으면 break
            if(tmp < 3) {
                break;
            }
			// 현재 list size 변수로 저장
            int list_size = list.size();
			// list size만큼 반복
            for(int i = 0; i < list_size; i++) {
				// list에서 node 가져옴
                Node N = list.get(i);
				// 밑으로 tmp만큼, 왼쪽으로 tmp만큼 이동한 새로운 기준점 Node 추가
                list.add(new Node(N.y + tmp, N.x - tmp));
				// 밑으로 tmp만큼, 오른쪽으로 tmp만큼 이동한 새로운 기준점 Node 추가
                list.add(new Node(N.y + tmp, N.x + tmp));
            }
        }
		// 조건에 맞는 부분에 * 넣기
        for(int i = 0; i < list.size(); i++) {
			// 기준점 가져오기
            Node N = list.get(i);
			// 기준점은 무조건 *
            arr[N.y][N.x] = '*';
			// 가운데줄 왼쪽 *
            arr[N.y + 1][N.x - 1] = '*';
			// 가운데줄 오른쪽 *
            arr[N.y + 1][N.x + 1] = '*';
			// 마지막줄 양옆 +-2만큼 *
            for(int j = N.x - 2; j <= N.x + 2; j++) {
                arr[N.y + 2][j] = '*';
            }
        }
		// 출력
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2 * n; j++) {
				// 끝에 도달하면 다음줄로 넘어감
                if(i == n - 1 && j == 2 * n - 1) {
                    break;
                }
				// arr[i][j] 추가
                sb.append(arr[i][j]);
            }
			// 마지막 줄이 아니라면 줄바꿈 해줘야 함
            if(i != n - 1) {
                sb.append("\n");
            }
        }
		// 답 출력
        System.out.println(sb.toString());
        sc.close();
    }
	// Node에 y값, x값 담기(알아보기 쉽게 하려고 이 순서로 담음)
    public static class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
