package pracprac.bj.study.d0912;
//bfs dfs 개념을 공부한다고 생각하고 접근
//트리 상위의 개념 그래프를 생각. 이증 어레이리스트를 구현해서 순회하기 적합한 그래프를 그림
//해당 문제의 경우 bfs쪽이 이해가 더 잘돼서 bfs 선택


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj11725 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		//트리를 담기 위한 리스트속 리스트 형태 (그래프) 구현
		ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
		
		//빈 껍데기 만들기
		for(int i=0; i<N; i++) {
			
			tree.add(new ArrayList<>());
			
		}
		
		//주어진 숫자들을 그래프 안에 담기
		//-1을 해주는 이유는 인덱스가 0부터 시작하기 때문. 마지막 출력할때 +1을 해줘서 값 바꾸기
		//리스트속리스트의 인덱스 안에 각 숫자를 넣음
		for(int i=0; i<N-1; i++) {
			
			int N1 = sc.nextInt()-1;
			int N2 = sc.nextInt()-1;
			tree.get(N1).add(N2);
			tree.get(N2).add(N1);
			
		}
		System.out.println(tree);
		
		boolean[] visited = new boolean[N];
		//부모노드를 저장할 배열
		int[] parentNode = new int[N];
		
		//BFS 너비우선탐색 방식
		//노드를 순서대로 탐색하면서 해당 노드에 인접한 노드 전부 방문하기
		//루트노드부터 순서대로 내려가면서 점검. 이미 방문한 노드는 탐색에서 제외
		//예를 들어 예제1의 경우 루트노드 1과 인접하는 4,6의 부모노드는 1
		//그 다음 차례에 4와 인접한 노드는 1,2,7이고 이 중 이미 방문한 1을 제외한 두 노드는 4의 자식노드...
		Queue<Integer> q = new LinkedList<>();
		
		//탐색 시작 : 루트노드 1 (단 위에서 전부-1 했으므로 0으로 표기)
		q.add(0);
		visited[0] = true;
		
		while(!q.isEmpty()) {
			int v = q.remove();
			for(int node : tree.get(v)) {
				
				if(!visited[node]) {
					visited[node] = true;
					q.add(node);
					parentNode[node] = v;
				}
			}
			
		}
		
		//2번 노드의 부모부터 출력. 1번 노드는 루트노드이므로
		for(int i=1; i<N; i++) {
			System.out.println(parentNode[i]+1);
		}
		
		
		
	}

}
