package pracprac.bj.study.d0907;

import java.util.Scanner;

public class bj4256 {
	//https://velog.io/@injoon2019/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-%ED%8A%B8%EB%A6%AC
	//전위순회 및 중위순회 배열
	static int PreOrder[]; //루트 왼 오
	static int InOrder[]; //왼 루트 오
	
	//원래 트리 구조가 어떻게 생겼는지 유추하기 
	//전위 순회의 시작 노드 = 루트노드, 그 뒤 중위순회에서 루트노드 기준 왼쪽 오른쪽값은 각각 왼쪽서브트리, 오른쪽 서브트리
	//양쪽 서브트리의 루트노드는 전위순회 결과에서 각 측면 노드 중 첫번째로 등장하는 노드이다.
	//같은 방식으로 다음 서브트리를 구한다.
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			
			int n = sc.nextInt();
			PreOrder = new int[n+1];
			InOrder = new int[n+1];
			
			for(int i=0; i<n; i++) {
				PreOrder[i] = sc.nextInt();
			}
			
			for(int i=0; i<n; i++) {
				InOrder[i] = sc.nextInt();
			}
			
			PostOrder(0, n, 0); //왼 오 루트
			System.out.println();
			
		}
	}
	
	//전위순회의 시작값(루트노드)은 후위순회의 맨 뒤 값임
	//전위순회의 좌 우 지점을 새로운 전위순회로 쪼갠다.
	static void PostOrder(int start, int end, int root) {
		
		//원래 트리구조를 루트부터 시작해서 찾아내고 쪼개진 트리의 루트값을 재귀호출로 출력하면 그게 후위순회
		for(int i=start; i<end; i++) {
			//중위순회의 i번째 인덱스가 전위순회의 루트노드와 같을 경우
			if(InOrder[i] == PreOrder[root]) {
				//i를 기준으로 좌우로 쪼개서 같은 방식으로 탐색 반복
				//좌측
				PostOrder(start, i, root+1);
				//우측
				PostOrder(i+1, end, root+i-start+1);
				//출력은 최대치로 쪼개진 트리의 루트노드부터 -> 왼쪽부터 오른쪽으로. 
				//마지막에는 원래 트리의 루트노드 출력. 즉 후위순회 방식의 출력으로 완성
				System.out.print(PreOrder[root] + " ");
			}
		}
	}
	
	

}
