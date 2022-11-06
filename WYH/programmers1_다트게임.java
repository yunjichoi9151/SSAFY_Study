package day1030;

public class programmers1_다트게임 {
	public static void main(String[] args) {

	}

	public int solution(String dartResult) {
		int answer = 0;

		String tmp = "";
		int[] arr = new int[3];
		int idx = 0;

		for (int i = 0; i < dartResult.length(); i++) {
			switch (dartResult.charAt(i)) {
			case '*':
				arr[idx - 1] *= 2;
				if (idx > 1) {
					arr[idx - 2] *= 2;
				}
				break;
			case '#':
				arr[idx - 1] *= -1;
				break;
			case 'S':
				arr[idx] = (int) Math.pow(Integer.parseInt(tmp), 1);
				idx++;
				tmp = "";
				break;
			case 'D':
				arr[idx] = (int) Math.pow(Integer.parseInt(tmp), 2);
				idx++;
				tmp = "";
				break;
			case 'T':
				arr[idx] = (int) Math.pow(Integer.parseInt(tmp), 3);
				idx++;
				tmp = "";
				break;
			default:
				tmp = String.valueOf(dartResult.charAt(i));
				break;

			}
		}
		
		for(int i=0;i<arr.length;i++) {
			answer += arr[i];
		}
		return answer;
	}
	
	
	// 점수 나오고 S, D, T 중 하나 나옴
    // 옵션으로 *, #
    // * 나오면 앞의 점수 2배
    // # 나오면 앞의 점수 *(-1)
    // # 나오고 * 나오면 앞의 점수 (-1)*2
    // * 나오고 * 나오면 앞의 점수 4배
    
	
	// 오답
	
//    char[] result = new char[dartResult.length()];
//    for(int i=0;i<result.length;i++) {
//    	result[i] = dartResult.charAt(i);
//    }
//    for(int i=0;i<result.length;i++) {
//    	if(result[i]>='1' && result[i]<='9') {
//    		int score = result[i];
//    		answer += score;
//    	}
//    	if(i+1<result.length && result[i]=='1'&&result[i+1]=='0') {
//    		int score = (result[i]-'0')+(result[i+1]-'0');
//    		answer += score;
//    	}
//    	if(result[i] == '*') {
//    		answer *= 2;
//    	}
//    	if(result[i]=='#') {
//    		answer *= -1;
//    	}
//    }
}
