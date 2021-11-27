package Lv1;

import java.util.ArrayList;

public class AddAllNumbers {	
	//음양 더하기 문제 - 월간 코드 챌린지 시즌2
	// absolutes : 절댃값을 담은 정수 배열
	// signs : 불리언 배열을 담음, 양수이면 true, 음수이면 false
	// 원래 숫자를 다 더해서 return 하기
	//풀이1)
	public static int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;

		ArrayList<Integer> arr = new ArrayList<>();

		for(int i= 0; i<absolutes.length ; i++) {
			if(signs[i]) {
				// 트루이면 양수임
				arr.add(absolutes[i]);
			}else {
				//false이면 음수임
				arr.add(absolutes[i] * (-1));
			}
		}

		// arr 다 더해주기
		for(int numbers : arr) {
			answer += numbers;
		}

		return answer;
	}
	
	// 풀이2) 
	public int solution2(int[] absolutes, boolean[] signs) {
		int answer =0;
		for( int i=0; i<signs.length ; i++) {
			// 삼항연산 사용해서                                     true: 1, false : -1
			answer += absolutes[i] *(signs[i]? 1: -1);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[] absolutes = {4,7,12};
		boolean[] signs = {true,false,true};
		System.out.println(solution(absolutes,signs));
	}
}
