package java1104;

import java.util.Arrays;

public class MySolution2 {
	//부서별로 신청한 금액이 들어있는 배열 d와 예산 budget이 매개변수로 주어질 때, 
	//최대 몇 개의 부서에 물품을 지원할 수 있는지
	//return 하도록 solution 함수를 완성해주세요.

	public static int solution(int[] d, int budget) {
		// d: 부서별로 신청한 금액
		// budget : 예산
		
		// 부서별 신청한 금액을 정렬하기
		Arrays.sort(d); //[1,3,2,5,4] -->1,2,3,4,5
		// 물품 지원받는 부서 갯수
		int deptCnt = 0;
		
		for(int i =0; i<d.length ;i++) {
			if(budget- d[i] >=0) {
				// 예산에 넘치지 않으면 예산에 빼고 cnt증가
				budget -=d[i];
				deptCnt++;
			}
		}
		
		return deptCnt;
	}
	
	public static void main(String[] args) {
		int []d = {1,3,2,5,4};
		int budget = 9;
		
		
		System.out.println(solution(d,budget));
	}

}
