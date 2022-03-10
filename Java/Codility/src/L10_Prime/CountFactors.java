package L10_Prime;

public class CountFactors {

	//For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24. 
	// There are no other factors of 24.
	public int solution(int N) {
		// write your code in Java SE 8
		int ans = 2;
		if(N == 1) {
			return 1;
		}

		for( int i = 2; i< N ; i++ ) {
			if((N%i) == 0) {
				ans ++;
			}
		}

		return ans;
	}
	//O(sqrt(N))
	// 약수를 일반적인 O(N)의 방식대로 풀면 시간 초과난다/
	// O(sqrt(N))으로 줄여줘야한다.
	public int solution2(int N) {
		// write your code in Java SE 8
		
		if(N == 1) {
			return 1;
		}
		
		int factorCnt = 1;//1은 항상 포함
		
		for( int i =2; i<Math.sqrt(N) ; i++) {
			if(N% i== 0) {
				factorCnt ++;
			}
		}
		
		factorCnt = factorCnt *2;
		
		//정확히 제곱근 예 9일 경우 3을 카운트 해준다.
		if(Math.sqrt(N) % 1 == 0) {
			factorCnt ++;
		}
		
		return factorCnt;
	}


	public static void main(String[] args) {

	}



}
