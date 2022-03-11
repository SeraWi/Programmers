package CodingTest;

public class Question3 {
	
	// 정확성 100%
	public String solution(int N) {
		// write your code in Java SE 8
		// 횟수 N 
		int a = N / 3; // 몫
		int b = N%3; //나머지
		String[] s = {"", "+", "+-"};
		String str = "+--";
		
		String answer = "";
		
		for( int i= 1; i<=a ; i++) {
			answer += str;
		}
		
		if(b != 0) {
			answer +=s[b];
		}
		
		return answer;
	}
	public static void main(String[] args) {
	}
}
