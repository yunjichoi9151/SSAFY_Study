package pracprac.bj.study.d0824;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class bj2628 {
	//2차원배열 안쓰고 가로세로값을 그냥 리스트로 받아서 처리해도 될듯
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		int cut = sc.nextInt();
		
		ArrayList<Integer> rlist = new ArrayList<>();
		ArrayList<Integer> clist = new ArrayList<>();
		
		//첫번째 가위질 시 생기는 값이 최대일 경우를 고려해서 0 넣어주기
		rlist.add(0);
		clist.add(0);
		
		for(int i=0; i<cut; i++) {
			int drc = sc.nextInt();
			
			if(drc == 0) {
				rlist.add(sc.nextInt());
			}else {
				clist.add(sc.nextInt());
			}
		}
		//길이저장 반대로. 방향 주의
		rlist.add(c); 
		clist.add(r);
		
		//오름차순 정렬
		Collections.sort(rlist);
		Collections.sort(clist);
		
		//넓이 저장할 배열 생성
		ArrayList<Integer> sq = new ArrayList<>();
		
		//자르고 남은 값들로 곱한 값 저장
		for(int i=1; i<rlist.size(); i++) {
			int rr = rlist.get(i)-rlist.get(i-1);
			
			for(int j=1; j<clist.size(); j++) {
				int cc = clist.get(j)-clist.get(j-1);
				
				sq.add(rr*cc);
			}
		}
		
		//오름차순 정렬
		Collections.sort(sq);
		
		//최대값 출력
		System.out.println(sq.get(sq.size()-1));
		
	}

}



