package java1027;

import java.util.Arrays;

public class SolutionWithFor {
	public String solution(String[] participant, String[] completion) {

		// 정렬 시키기(a~b)
		Arrays.sort(participant); //filipa, josipa, marina, nikola, vinko
		Arrays.sort(completion); // filipa, josipa, marina, nikola

		int i;
		// completion.length는 participant.length보다 1작다
		for ( i=0; i<completion.length; i++){
			//비교하기
			// 정렬 시켰기 때문에 index 같은걸로 비교
			//participant[0]과 completion[0]같나?
			if (!participant[i].equals(completion[i])){
				// 비교해서 다른 순간 바로 종료
				return participant[i];
			}
			// 비교해서 같다!->pass
		}
		//for문이 중간에 종료되지 않고 끝까지 실행한 경우 i++된 상태로 끝난다
		// for문이 중간 종료되지 않았다는 의미 : participant 중 가장 마지막 사람이 완주 못한거임
		// 즉 vinko를 return 해야함 i=4
		return participant[i];
	}
}
