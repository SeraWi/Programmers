package CodingTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Brackets2 {
	// 올바른 문자열 : 양 옆으로 잘 닫혀있음...
	// (){}[]
	// 올바른 문자열에서 딱 하나의 문자가 제거된 문자열 s
	
	
	//1. [, {, ( 중 어떤게 부족한지 확인하기
	//2. 그리고 부족한 문자를 어디에 넣어야 하는지 확인하기
	
	
	public static int solution(String s) {
		int answer = 0;
		char missString = miss(s); // 부족한 괄호 확인
		System.out.println(missString);
		
		
		for( int i= 0;i<s.length()+2; i++) {
			char[] sChar = s.toCharArray();
			sChar[i] = missString;
			
			s = sChar.toString();
			
			// 함수 호출
			if(isCorrect(s)) {
				answer++;
			}
		}
		
		return answer;
	}
	public static boolean isCorrect(String s) {
		List<String> sList = new ArrayList<>();
		
		for(int i = 0; i<s.length(); i++) {
			sList.add(s.substring(i,i+1));
		}
		
		
		Stack<String> sStack = new Stack<>();
		for (String sL : sList) {
			
			String top = sStack.peek();
			if(reverse(top).equals(sL)) {
				// 반대 괄호 찾음
				sStack.pop();
			}else {
				sStack.add(sL);
			}
			
			
		}
		
		
		
		
		return true;
	}
	public static String reverse(String u) {
		String r ="";
		if(u.equals("(")) {
			return ")";
		}else if(u.equals(")")) {
			return "(";
		}else if(u.equals("{")) {
			return "}";
		}else if(u.equals("}")) {
			return "{";
		}else if(u.equals("]")) {
			return "[";
		}else if(u.equals("[")) {
			return "]";
		}
		return r;
	}
	// 부족한 괄호 확인하기
	public static char miss(String s) {
		char bracket=' ' ;
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
		// 음수이면 ), }, ]가 더 많다는 의미
		
		if( open1 > 0) {
			bracket = ')';
		}else if (open1 < 0) {
			bracket ='(';
		}
		
		
		if( open2 > 0) {
			bracket = ']';
		}else if (open2 < 0) {
			bracket ='[';
		}
		
		
		if( open3 > 0) {
			bracket = '}';
		}else if (open3 < 0) {
			bracket ='{';
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
