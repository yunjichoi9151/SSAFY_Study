package pracprac.bj.study.d1005;
//문자 뒤집는건 그냥 stringbuilder최고
import java.util.Scanner;

public class bj2908 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int ans;
		
		A = Integer.parseInt(new StringBuilder().append(A).reverse().toString());
		B = Integer.parseInt(new StringBuilder().append(B).reverse().toString());
		
		if(A>B) {
			ans = A;
		}else {
			ans = B;
		}
		
		System.out.println(ans);
	}
}
