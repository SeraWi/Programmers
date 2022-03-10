package L9_MaximumSliceProblem;

public class KadaneAlgorithm {
	//brute force solution : 완전 탐색 하며 max를 찾는 법
	// 무조건 연결된 원소
	//O(N*N)
	// 앞의 배열의 합 최대값을 저장하고
	// 현재의 값을 더해서 비교한뒤 저장한다.
	public static int solution(int A []) {
		
		int max_current = A[0];
		int globalMax = A[0];
		
		for( int i = 1; i<A.length ; i++) {
			//현재 element하나와 앞의 원소 더했을 때, 둘중 최대값
			max_current = Math.max(A[i], max_current+ A[i]);
			//max_current가 크면 globalMax 갱신
			if(globalMax < max_current) {
				globalMax = max_current;
			}
		}
		
		return globalMax;
	}
	
	public static void main(String[] args) {
		int A [] = {-2,3,2,-1};
		System.out.println(solution(A));
	}
}
