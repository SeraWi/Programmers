package java1030;

import java.util.Arrays;

class Solution {
	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
//		int n = 5;
//		int [] lost = {1,2,3};
//		int [] reserve = {1,2,5};
		
		
		// 체육복 입고 수업에 참여할 수있는 학생 수
		answer = n - lost.length;
		
		//정렬 시키기
		Arrays.sort(lost);
		Arrays.sort(reserve);
		
		//여벌이 있는 학생이 도난당할 경우
		for(int i=0; i< lost.length; i++) {
			for(int j=0; j< reserve.length; j++) {
				
				// 숫자 같다 -> 여벌있는데 도난당함
				if(lost[i] == reserve[j]) {
					lost[i] = -1;
					reserve[j] = -1;
					System.out.println("도난당했지만  여벌있음");
					// 사람수 증가시키기 -> 수업참여가능
					answer++;
					// 안쪽 for문만 종료
					break;
				}
			}
		}
		
		
		for(int i=0; i< lost.length; i++) {
			for(int j=0; j< reserve.length; j++) {
				
				// 잃어버린 학생의 앞뒤 학생이 체육복 여벌이 있는가?
				if(lost[i]-reserve[j]==1 || reserve[j]- lost[i]==1) {
				
					reserve[j] = -1;
					
					//학생 수 증가
					answer++;
					
					//안쪽 for문 종료
					break;
				}
			}
		}


		return answer;
	}
	
	
	public static void main(String[] args) {
		//System.out.println(solution());
	}
}
