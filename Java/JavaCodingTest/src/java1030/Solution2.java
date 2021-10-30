package java1030;

public class Solution2 {
	// 정답자 깔끔 풀이
	// Java Greedy
	public int solution(int n, int[] lost, int[] reserve) {
		// 사람 수 만큼 배열 만들기
		int[] people = new int[n];// 현재{0,0,0,0....}
		
		int answer = n;
		// 잃어버린 학생들 2,4 
		for (int l : lost) 
			people[l-1]--; // people[1] = -1 , people[3] =-1
		
		// 여분있는 학생 1,3 5
		for (int r : reserve) 
			people[r-1]++; // +1 people[0] = 1, people[2]= 1, people[4] =1 

		for (int i = 0; i < people.length; i++) {
			
			// 도난당한경우
			if(people[i] == -1) {
				
				if(i-1>=0 && people[i-1] == 1) {
					// 해당 index 보다 1 작은 index가 1인 경우 : 여분의 체육복 있기 때문에 빌릴 수 있음
					//i가 인경우는 index작은 사람한테 빌릴 수 없음
					
					// 빌리는 사람 ->-1에서 0으로 만들기
					people[i]++;
					//빌려준 사람 ->0으로 만들기
					people[i-1]--;
				}else if(i+1< people.length && people[i+1] == 1) {
					// 해당index보다 1큰 index 가 1인 경우 여분의 체육복 있기 때문에 빌릴 수 있음
					
					// 도난 당한 사람->0으로 만들기
					people[i]++;
					
					// 빌려주는 사람 -> 0으로만들기
					people[i+1]--;
				}else 
					//여기저기 속하지 않는 경우 도난당했지만 빌릴 수없음
					
					//최종 참여 인원 -1
					answer--;
			}
		}
		return answer;
	}
}
