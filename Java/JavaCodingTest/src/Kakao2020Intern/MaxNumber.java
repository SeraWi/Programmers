package Kakao2020Intern;

import java.util.ArrayList;
import java.util.Arrays;

// 수식 최대화
public class MaxNumber {
	//참가자의 미션은 전달받은 수식에 포함된 연산자의 우선순위를 자유롭게 재정의하여 
	//만들 수 있는 가장 큰 숫자를 제출하는 것입니다.	
	//1. 연산자 두개가 동일한 우선순위를 가질수없다.
	//2. 같은 연산자가 두개 이상이면 앞에있는 연산자부터 계산을 해준다.
	
	//6가지 경우의 수 저장
	static String[][] operation = {
			{"*","+","-"},
			{"*","-","+"},
			{"+","-","*"},
			{"+","*","-"},
			{"-","*","+"},
			{"-","+","*"},
	};
	
	public static long solution(String expression) {
		long answer = 0;
		
		//연산자가 3개 이기 때문에 조합은 6개
		//-> expression에 대해 6개 경우의 수 중 절댓값이 가장 큰 값을 return 하면 된다.
		
		//1. 조합 6개를 돌리기
		//2. 그 때마다, 계산하는 메서드
		//3. 최종 계산 후 배열에 넣기
		
		ArrayList<String> ex = new ArrayList<>();
		
		for( int i= 0; i<expression.length(); i++) {
			
			ex.add(expression.substring(i, i+1));
		}
		
		
		int[] calNum = new int[6];
		
		//6가지 경우의 수에 대해서 계산하기
//		for( int i = 0; i< 6; i++) {
//			
//			String[] currentOp = operation[i]; // 연산자 순위가 나옴
//			
//			//연산자 순위에 따른 계산 하기
//			
//			// 계산 완료후 다시 배열에 넣기 ->배열에 넣을때 절댓값으로 넣기
//			
//			if(currentOp[0].equals("*")) {
//				
//			}
//			
//		}
		
		//내림차순 정렬하기
		
		multiple(ex);
		
		System.out.println(ex.toString());
		

		return answer;
	}
	
	//곱셈 연산하기
	public static ArrayList<String> multiple(ArrayList<String> ex){
		
		for( int i= 0; i<ex.size(); i++) {
			if( ex.get(i).equals("*") && i >0) {
				//*만나면 앞 뒤  숫자를 찾아
				int beforeNum = Integer.parseInt(ex.get(i-1));
				int afterNum = Integer.parseInt(ex.get(i+1));
				String result= String.valueOf(beforeNum * afterNum);
				
				ex.remove(i-1);
				ex.remove(i-1);
				ex.remove(i-1);
				ex.add(i-1, result);
			}
		}
		
		
		return ex;
	}
	
	
	public static void main(String[] args) {
		String ex= "100-200*300-500+20";
		System.out.println(solution(ex));
	}
	
}
