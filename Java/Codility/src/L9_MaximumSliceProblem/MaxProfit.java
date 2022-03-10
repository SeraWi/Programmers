package L9_MaximumSliceProblem;

public class MaxProfit {
	// 완전탐색하는 방법
	// 최소값과 최대값을 찾기

	// 시간 복잡도 O(N*N), time error
	public int solution(int[] A) {
		// write your code in Java SE 8

		// profit 이 없으면 -1 return 

		int ans = 0;

		for( int i = 0; i<A.length-1; i++) {
			for( int j= i ; j<A.length; j++) {
				ans = Math.max(ans, A[j]-A[i]);
			}
		}

		if(ans  < 0) {
			ans =-1;
		}

		return ans;
	}

	// Kadane's Algorithm
	// O(N)
	// [0,20000]의 경우 틀림
	public static int solution2(int[]A) {
		int minPrice=  A[0]; //인덱스 보다 작은 가장 작은 price를 저장
		int localMaxProfit = 0;
		int globalMaxProfit =0;
		
		// * The function should return 0 if it was impossible to gain any profit.
		//element 가 없거나 1개인 경우 -> profit 구할 수 없다.
		if(A.length == 1 | A.length== 0) {
			return 0;
		}
		//index 1부터 시작하기
		for ( int i= 1; i<A.length; i++) {
			localMaxProfit = A[i] - minPrice;

			//minPrice 갱신, 현재값과 비교해서 !
			if(A[i] < minPrice) {
				minPrice = A[i];
			}

			globalMaxProfit = Math.max(localMaxProfit, globalMaxProfit);
		}
		// * The function should return 0 if it was impossible to gain any profit.
		// profit 자체가 음수가 되는 경우
		if(globalMaxProfit < 0 ) {
			return 0;
		}

		return globalMaxProfit;
	}
	
	public int solution3(int[]A) {
		int maxProfit = 0;
		int cumulativeProfit = 0;
		
		for( int i  =1 ; i<A.length ; i++) {
			int profitThisDay =A[i] -A[i-1];
			if(profitThisDay > maxProfit) {
				maxProfit = profitThisDay;
			}
			
			cumulativeProfit +=profitThisDay;
			if(cumulativeProfit > 0) {
				if(cumulativeProfit > maxProfit) {
					maxProfit = cumulativeProfit;
				}
			}else {
				cumulativeProfit = 0;
			}
			
		}
		return  maxProfit;
	}

	public static void main(String[] args) {
		
		int[] A = {23171,21011,21123,21366,21013,21367};
		int[] B = {0,200000};
		System.out.println(solution2(B));
		System.out.println(new MaxProfit().solution(B));
		
	}
}	
