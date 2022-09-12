package pracprac.bj.study.d0912;
//유니온파인드로 풀어보고싶지만 뭔소린지 모르겠다
//그래서 결국 dfs를 쓰는데 그조차도 어렵다. 그냥 dfs가 아닌거같음
//https://dhbang.tistory.com/25
//https://dingcoding.tistory.com/201

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class bj4803 {
	
	//최대길이에 맞춰 501사이즈의 방문배열 및 그래프 생성(0번인덱스 안씀)
	static boolean visit [] = new boolean[501];
	static LinkedList<Integer>[] grp = new LinkedList[501];
	static int casecnt=0, treecnt =0, nodecnt=0, linecnt=0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			//입력 종료조건
			if(n==0 && m==0) {
				break;
			}
			
			//visit 전부 false로 초기화
			Arrays.fill(visit, false);
			
			//빈 그래프  생성
			for(int i=0; i<=n; i++) {
				grp[i] = new LinkedList<Integer>();
			}
			
			//그래프 안에 값 입력
			for(int i=0; i<m; i++) {
				
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				
				grp[n1].add(n2);
				grp[n2].add(n1);
			}
			
			//탐색 케이스 번호 			
			casecnt++;
			//트리 개수 초기화
			treecnt = 0;
			
			for(int i=1; i<=n; i++) {
				
				//방문한적 없을때 노드, 라인 갯수 초기화 후 dfs탐색
				if(visit[i]==false) {
					nodecnt=0;
					linecnt=0;
					DFS(i);
					
					//문제에 주어진 힌트 : 트리는 정점(노드수)가 n개일 때 간선수가 n-1개
					//이 때 간선간에 연결되어있고 방향이 없는 그래프가 주어졌으므로 간선수가 두배임
					//그러므로 노드수-1에 *2를 해준다
					//충족하면 트리
					if(linecnt == (nodecnt-1)*2) {
						treecnt++;
					}
				
				}
				
			}
			
			
			//출력
            if(treecnt>1){
                System.out.printf("Case %d: A forest of %d trees.\n",casecnt, treecnt);
            }
            else if(treecnt==1) {
                System.out.printf("Case %d: There is one tree.\n",casecnt);
            }
            else{
                System.out.printf("Case %d: No trees.\n", casecnt);
            }
			
		}
		
	}

	//깊이우선탐색. 전위순회한다고 생각하기
	private static void DFS(int n1) {
		
		//노드수를 세가며 해당 노드에 연결된 간선 수를 누적한다
		nodecnt++;
		linecnt+=grp[n1].size();
		//이후 방문처리
		visit[n1] = true;
		
		//그래프를 전부 돌면서 방문하지 않은 경우 dfs 탐색 지속
		for(int n2 : grp[n1]) {
			
			if(visit[n2]==false) {
				DFS(n2);
				
			}
		}
	}
	
	
	
}