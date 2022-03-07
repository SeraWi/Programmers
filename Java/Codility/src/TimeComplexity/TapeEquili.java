package TimeComplexity;

//O(N * N)
public class TapeEquili {
	//that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.
	//N is an integer within the range [2..100,000];
	//each element of array A is an integer within the range [−1,000..1,000].
	public static int solution(int[] A) {
		// write your code in Java SE 8
		int answer = Integer.MAX_VALUE; //int 최대값
		//차이가 가장 작은 지점을 반환하라
		int sum = 0;
		for( int a: A) {
			sum +=a;
		}

		int before = 0;
		int after = sum - before;

		for( int i = 0; i<A.length; i++) {

			for( int j = 0; j< i+1; j++) {
				before += A[j];
			}

			int gap = Math.abs(before-after);
			System.out.println(gap);
			answer = Math.min(answer,gap);
			before = 0;
		}

		return answer;

	}
	// O(N)
	public int solution2(int[] A) {
		int left =0;
		int right = 0;
		for( int a: A) {
			right += a;
		}
		int ans = Integer.MAX_VALUE;
		int diff = 0;
		for ( int i = 0; i<A.length; i++) {
			left += A[i]; //왼쪽에는 더해주고
			right -=A[i]; // 오른쪽은 빼준다.
			diff = Math.abs(left- right);
			ans = Math.min(diff, ans);
		}

		return ans;
	}
	public static void main(String[] args) {
		int[]A = {3,1,2,4,3};
		System.out.println(solution(A));
	}
}
