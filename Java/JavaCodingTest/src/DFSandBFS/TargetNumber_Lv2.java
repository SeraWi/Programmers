package DFSandBFS;

public class TargetNumber_Lv2 {
	
	// DFS의 재귀함수 사용 풀이
	// 사용할 수 있는 숫자가 담긴 배열 numbers
	// 타켓넘버 target 
	// 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 
	
	 public int solution(int[] numbers, int target) {
	        int answer = 0;
	        
	        int current  = numbers[0];
	        //첫번째 인덱스 숫자 양수로 계산하기
	        answer +=dfs(current,1,numbers, target); 
	        // 음수로 계산하기
	        answer += dfs(-current,1, numbers, target);
	        
	        return answer;
	    }
	 
	 public int dfs(int prev, int index, int[]numbers, int target) {
		 
		 // prev: 이전에 탐색한 숫자 들의 합, 
		 // index : 이제 탐색할 숫자
		 
		 
		 //인덱스가 numbers.length와 같다 == numbers의 배열 원소들 다돌고 여기로 온거임
		 //마지막 숫자까지 다 돌고 난 뒤 prev을 target과 비교하기
		 
		 if(index >= numbers.length) {
			 // 타켓과 같으면 최종 1반환
			 if(target == prev) {
				 return 1;
			 }
			 return 0;
		 }
		 
		 
		 int cur1 = prev +numbers[index]; //양수부호 붙이기
		 int cur2 = prev - numbers[index]; // 음후 부호 붙이기
		 
		 int ans =0;// index끝까지 돌기전에는 계속 0을 반환하게 만듬
		 
		 // 다음 인덱스를 탐색할때, 이전에 탐색한 값을 음수, 양수 경우의 수로 재귀함수 호출
		 ans += dfs(cur1, index+1, numbers, target);
		 ans += dfs(cur2, index+1, numbers, target);
		 
		 return ans; 
	 }

}
