package Kakao2018Recruit;

import java.util.ArrayList;

public class DartGame {
	//갓 입사한 무지는 코딩 실력을 인정받아 게임의 핵심 부분인 점수 계산 로직을 맡게 되었다. 
	//다트 게임의 점수 계산 로직은 아래와 같다.
	//옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 
	//아차상(#) 당첨 시 해당 점수는 마이너스된다.	
	//스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
	public static int solution(String dartResult) {
		int answer = 0; //answer는 scores의 합산
		char[] darts = dartResult.toCharArray();
		System.out.println(darts);
		
		if(darts[2]=='*' || darts[2] =='#') {
			
		}

		return answer;
	} // solution 함수끝
	
	

	public static void main(String[] args) {
		String dartResult ="1S*2D*3T";
		System.out.println(solution(dartResult));
	}
}
