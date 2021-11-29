package DevMatching2021;

import java.util.Arrays;

// 민우가 구매한 로또 번호를 담은 배열 lottos, 
// 당첨 번호를 담은 배열 win_nums가 매개변수로 주어집니다. 
// 이때, 당첨 가능한 
// 최고 순위와 최저 순위를 차례대로 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
public class Lotto {
	public int[] solution(int[] lottos, int[] win_nums) {
		// lottos : 민우가 구매한 로또 번호를 담은 배열, 같은 숫자 없음
		// 낙서 된 번호는 0으로 들어간다
		// win_nums : 당첨 번호, 같은 숫자 없음
		// 로또 번호는 1~45 임 ,갯수는 6개
		
		// 최고순위와 최저순위를 담아서 return
		
		
		int cnt =0;
		int zeroCnt =0;
		//win_nums에 lottos의 숫자가 있는지 먼저 확인
		//cnt 증가 시키기
		
		// 오름차순 정렬
		Arrays.sort(lottos);
		Arrays.sort(win_nums);
		
		for( int j =0; j<6 ; j++ ) {
			for( int i=0; i<6; i++) {
				if(win_nums[j]==lottos[i]) {
					// 같으면 증가
					cnt++;
				}
				
			}
			
			if(lottos[j] == 0) {
				zeroCnt ++;
			}
			
		}
		
		int max = wins(cnt, zeroCnt);
		int min = wins(cnt, 0);
		int[]answer = {max, min};
		
		
		return answer;
	}
	public int wins(int cnt, int zeroCnt) {
		int totalCnt = cnt+zeroCnt;
		
		if(totalCnt == 6) {
			return 1;
		}else if(totalCnt ==5) {
			return 2;
		}else if(totalCnt ==4) {
			return 3;
		}else if(totalCnt == 3) {
			return 4;
		}else if(totalCnt ==2) {
			return 5;
		}else {
			return 6;
		}
		
	}
	
	
}
