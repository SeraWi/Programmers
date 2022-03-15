package L3_TimeComplexity;

public class Ex {
	
	// O(N)으로 풀자
	public static int solution(int[]A) {
		
		
		// 전체 sum구하기
		// 전체 sum에서 왼쪽으로 element하나씩 보내서
		// gap을 확인하기.
		
		
		int left = 0;
		int right = 0;
		
		// right에 sum
		for( int a : A) {
			right +=a;
		}
		
		// 최초에 가장 큰값 설정
		int answer = Integer.MAX_VALUE;
		int diff = 0;
		for( int i = 0 ; i<A.length; i++) {
			left += A[i] ; //왼쪽으로 하나 옮기기
			right -=A[i]; //오른쪽 하나 빼주기
			//차이를 절댓값으로
			diff =Math.abs(left- right);
			//리턴값 갱신
			answer = Math.min(answer, diff);
		}
		
		return answer;
	}
}
