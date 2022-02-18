package kakao2020;

import java.util.*;

// 2020 괄호 변환
// 괄호의 갯수가 같은 경우->균형잡힌 괄호 문자열 (()))(
// ()의 괄호짝도 모두 맞는 경우 -> 올바른 괄호 문자열 (())()



public class Brackets {
	int pos;
	
	// 올바른 문자열인지 확인하는 동시에 , 분리시점 pos(최초의 균형 잡힌 상태)에 저장
	// boolean : 올바른 문자열인지  
	boolean isCorrect (String str) {
		
		boolean ret = true;
		int left =0, right = 0;
		
		Stack<Character>mystack = new Stack<Character>();
		
		for(int i = 0; i<str.length(); i++) {
			if(str.charAt(i) == '(') {
				left++;
				mystack.push('(');
			}else {
				right++;
				if(mystack.empty()) {
					// 비어있으면 왼쪽이 없는 거임 -> 올바른 문자열이 아님
					ret = false;
				}else {
					// 비어 있지 않으면 pop하기
					mystack.pop();
				}
			}
			// 값이 같은 순간 : 최초로 균형 잡힌 괄호 문자열 -> 분리시점
			if(left == right) {
				// 분리하는 시점
				pos = i+1;
				//for 문 종료
				return ret;
			}
			
		}
		
		return true;
	}

	
	public String solution(String p) {
		
		if(p.isEmpty()) {
			return p;
		}
		
		boolean correct = isCorrect(p);
		
		//	분리시점전까지로 자르기
		String u = p.substring(0,pos);
		// v 부터 끝까지 자르기
		String v = p.substring(pos,p.length());
		
		
		// 올바른 문자열인 경우
		if(correct) {
			//  u에 v를 1단계부터 부터 반복한 결과를 붙여서 반환
			return u+ solution(v);
		}
		
		
		//올바른 문자가 아닌 경우
		String answer = "(" + solution(v) +")";
		
		// 반대로 뒤집는다.
		for(int i =1 ; i<u.length()-1 ;i++) {
			if(u.charAt(i)=='(') {
				answer +=")";
			}else {
				answer +="(";
			}
		}
		
		return answer;
	}
	

}
