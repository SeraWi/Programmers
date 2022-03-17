package ASCII;

public class Exercise1 {
	
	//아스키 코드 출력하기
	public static void ascii1(String S) {
		
		char a = S.charAt(0);
		
		System.out.println((int)a);
	}
	
	
	//로어케이스와 어퍼케이스 알파벳이 같이 들어있는 경우
	// 아스키 코드 가장 큰 값 리턴하기
	// A = 65 Z = 90 a = 97 z = 112 1= 48 
	public static char maxAscii(String S) {
		String answer = "";
		
		char[] cArr = S.toCharArray();
		int cnt= 0;
		for( int i= 0; i<cArr.length; i++) {
			
			cnt = Math.max(cnt, (int)cArr[i]);
		}
		
		return (char) cnt;
		
	}
	
	public static void main(String[] args) {
		ascii1("A"); //65
		ascii1("B"); //66
		ascii1("a");// 97
		
		System.out.println(maxAscii("ABCa"));
	}
}
