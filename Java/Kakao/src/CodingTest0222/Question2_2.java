package CodingTest0222;

import java.util.Scanner;

//가장 많이 반복되는 문자
//시간 복잡동 O(N)
public class Question2_2 {
	// 1.25크기의 배열 만들기
	// 2. 배열의 각 요소는 배열의 인덱스로 아스키 값이 있는 문자의 갯수이다.
	//3. 인덱스의 아스키 값 인덱스에서 문자를 찾을 때마다 카운트 를 증가시킴
	
	public static String StringChallenge(String str) {
		String answer ="";
		int[] arr = new int[26]; //알파벳 갯수만큼 배열 선언
		
		int max = -1;
		
		for ( int i= 0; i<str.length(); i++) {
			int comp;
			if(str.charAt(i)-65 <=26) {
				comp= str.charAt(i) -65;
			}else {
				comp = str.charAt(i) -97;
			}
			arr[comp]++;
		}
		
		for( int i = 0; i<arr.length; i++) {
			if(max <arr[i]) {
				max = arr[i];
			   char answerc = (char)(i+'A');
			   answer = String.valueOf(answerc);
			}else if(max== arr[i]) {
				answer="?";
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		//Scanner s = new Scanner(System.in);
		System.out.print(StringChallenge("hello")); 
	}
}
