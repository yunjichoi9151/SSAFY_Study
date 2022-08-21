package pracprac.bj.study.d0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10158 {
	
	public static void main(String[] args) throws IOException {
		
		//빡빡한 시간제한
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());
	
		//https://hanstemcell.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EA%B0%9C%EB%AF%B8?category=672485
		//https://lovelyunsh.tistory.com/25
		//x, y 각각 2w, 2h 만큼 움직일때마다 0으로 돌아옴
		//즉 (p+t)%2w, (q+t)%2h만큼 움직인다 생각
		int x = (p+t)%(2*w);
		int y = (q+t)%(2*h);
		
		//최종 좌표는 각각 w, h와 비교해서 작을때는 그 값이고 클 때는 2w, 2h에서 차감한 값
		x = w - Math.abs(w-x);
		y = h - Math.abs(h-y);
		
		System.out.println(x+" "+y);
				
	}

}
