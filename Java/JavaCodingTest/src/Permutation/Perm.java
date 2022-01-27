package Permutation;

public class Perm {
	// 재귀 함수가 자기 자신을 부를 때 스택 영역에 계속 누적이 됨
	
	// 순열 예제 - 가장 큰 두가자리 수 구하기
	
	// 재귀 
	// 1) base case : 간단히 결과 반환하는 부분
	// 2) recursive case : 자기 자신을 호출하는 부분
	static int N = 4;
	static int[] Nums = {1,2,3,4};

	static int solve(int cnt, int used, int val) {
		if(cnt==2) {// 종료 조건 -> 결과 반환
			return val;
		}
		
		int ret = 0;
		for( int  i =0; i<N; i++) {
		
			if((used & 1 << i) != 0) {
				continue;
			}
			ret = Math.max(ret, solve(cnt+1, used| 1 << i, val * 10+Nums[i]));
		}
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(solve(0,0,0)); // 43
	}
}
