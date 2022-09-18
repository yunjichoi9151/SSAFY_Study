package pracprac.bj.study.d0918;
//처음에 뭔소린가함
//최단거리니 일단 bfs
//오르락내리락 하면서 탐색

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj5014 {
	
	//인덱스 0 버림
	static int[] dis = new int[1000001];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
        int F = sc.nextInt(); // 층수
        int S = sc.nextInt(); // 강호
        int G = sc.nextInt(); // 스타 링크
        int U = sc.nextInt(); // 위로 몇층
        int D = sc.nextInt(); // 아래로 몇층

        BFS(F, S, G, U, D);
        
        int answer = dis[G] - 1; // 방문 체크를 위해서 1부터 시작했기 때문에 -1
        
        //다 돌고 목표층 인덱스 저장값-1이 버튼누른 횟수
        //도달 불가능할 시에는 0 -> -1
        if(answer == -1) {
        	System.out.println("use the stairs"); 
        }
        else {
        	System.out.println(answer);
        
        }
        
	}

	private static void BFS(int f, int s, int g, int u, int d) {
		
		Queue<Integer> q = new LinkedList<>();
        
		q.add(s);
        
		//강호 위치 
		dis[s] = 1;
        
		while(!q.isEmpty()) {
			
            int size = q.size();
            //큐 사이즈만큼 돌기
            for(int i = 0; i < size; i++) {
            	
                int cur = q.poll();
                
                //목표층에 도달하면 끝
                if(s == g) return;
                
                int up = cur + u;
                int down = cur - d;
                
                //도달한 층수 좌표에 들른 횟수를 저장해주면 방문체크 따로 안해도 됨
                
        		// 올라갈 때 범위 : 건물의 최대 높이까지
                if(up <= f && dis[up] == 0) {
                    q.add(up);
                    dis[up] = dis[cur] + 1;
                }

                // 내려갈 때 범위 : 건물의 최소 높이(1) 까지
                if(down >= 1 && dis[down] == 0) {
                    q.add(down);
                    dis[down] = dis[cur] + 1;
                }
            }
        }
		
	}

}
