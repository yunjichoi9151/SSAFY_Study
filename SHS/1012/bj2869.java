package pracprac.bj.study.d1012;
//(A-B)/V 단순히 생각하면 이런데 정상에선 안미끄러짐
//그리고 미끄러지는건 밤중의 일이라고
//그니까 낮에 올라가는 것을 기준으로 날짜를 세야함
//낮의 최소일수를 먼저 구하고 마지막으로 올라간 낮에 남은 갈 길이 있으면 +1을 해줘야함
//그래서 한번 미끄러진 길이에서 나눠서 최소일수를 먼저 뽑아내고
//이렇게 나눴을때 나머지가 생기면 최소일수의 낮에 도달한 곳이 정상이 아니니까 하루 더 걸리는거임

import java.util.Scanner;

public class bj2869 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();
		
		int ans = (V-B)/(A-B);
		
		if((V-B)%(A-B)!=0) {
			ans++;
		}
		
		System.out.println(ans);
	}
	
}
