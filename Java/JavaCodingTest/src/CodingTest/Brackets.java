package CodingTest;

public class Brackets {
	// 올바른 문자열 : 양 옆으로 잘 닫혀있음...
	// (){}[]
	// 올바른 문자열에서 딱 하나의 문자가 제거된 문자열 s
	
	
	//1. [, {, ( 중 어떤게 부족한지 확인하기
	
	//2. 그리고 부족한 문자를 어디에 넣어야 하는지 확인하기
	
	
	public static int solution(String s) {
		int answer = 0;
		String missString = miss(s); // 부족한 괄호 확인
		
		
		
		return answer;
	}
	
	
	// 부족한 괄호 확인하기
	public static String miss(String s) {
		String bracket = "";
		int open1 = 0; //()
		//int close1 = 0;
		int open2 = 0; //[]
		//int close2 = 0;
		int open3 = 0; //{}
		//int close3 = 0;
		
		for( int i= 0; i<s.length(); i++) {
			if(s.charAt(i)=='(') {
				open1++;
			}else if(s.charAt(i)==')') {
				open1--;
			}else if(s.charAt(i)=='[') {
				open2++;
			}else if(s.charAt(i)==']') {
				open2--;
			}else if(s.charAt(i)=='{') {
				open3++;
			}else if(s.charAt(i)=='}') {
				open3--;
			}
		}
		
		// 양수이면 (, {, [ 가 더 많고
		// 음수이 ), }, ]가 더 많다는 의미
		
		if( open1 > 0) {
			bracket = ")";
		}else if (open1 < 0) {
			bracket ="(";
		}
		
		
		if( open2 > 0) {
			bracket = "]";
		}else if (open2 < 0) {
			bracket ="[";
		}
		
		
		if( open3 > 0) {
			bracket = "}";
		}else if (open3 < 0) {
			bracket ="{";
		}
		
		// 부족한 bracket 나옴
		
		return bracket;
	}
	
	public static void main(String[] args) {
		String s ="{([()]))}"; // (
		String p= "(()()()"; // )
		solution(s);
	}
}
