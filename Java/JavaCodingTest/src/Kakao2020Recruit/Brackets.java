package Kakao2020Recruit;

public class Brackets {
	// 괄호 변환	
	// 균형잡힌 괄호 : (개수 == )개수
	// 올바른 괄 : ()맞을 때 열고 닫는게 맞을 때


	/*
	 * #p가 빈 문자열 일 경우 그대로 리턴 
	 * #1. p를 '(' 와 ')' 의 개수가 같은 u, 그 나머지인 v로 분리 
	 * #2-1. u가 닫힌 괄호일 경우 
		 * #1번으로 돌아가 p에 v를 넣어(=solution(v)) 결과 받기 
		 * #(u+위의 결과) 리턴 
	 * #2-2. u가 닫힌 괄호가 아닐 경우
		 * #'1번으로 돌아가 p에 v를 넣은(=solution(v)) 결과 임시 저장 
		 * #u의 앞뒤 문자를 제거하고 남은 모든 괄호를 뒤집는다( '('는 ')'로 ) 
		 * # "(" + v + ")" + 뒤집은 결과 를 리턴
	 */   


	public String solution(String p) {
		String answer = "";



		if(p.equals("")) {
			answer="";
		}else {
			// u와 v로 쪼개기
			String pSplit[] = split(p);

		}



		return answer;
	}

	public String[] split(String p) {

		String splits[] = new String[2];

		int left = 0 ; //( 갯수 카운트
		int right = 0; //) 갯수 카운트
		int i= 0;
		for(i= 0; i<p.length(); i++) {
			if(p.substring(i, i+1).equals("(")) {
				left++;
			}else {
				right++;
			}

			if(left==right) {
				break;
			}
		}

		splits[0]=p.substring(0,i+1);
		splits[1]=p.substring(i+1);

		return splits;	
	}
	// 올바른 괄호인지 확인
	private boolean isCorrectParenthesis(String p) {
		int strLen = p.length();
		int open = 0;
		for( int i= 0;i<strLen; i++) {
			if(p.charAt(i) == '(') {
				open++;
			}else {
				if(open == 0) {
					return false;
				}
				open--;
			}
		}
		return true;
	}
}
