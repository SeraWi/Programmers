package kakao2021;

import java.util.Scanner;

// 두수의 합이 7인 경우의 수
public class BitOperationEx2 {
	
	static int N;
	static int[] Arr = new int [10];
	
	
	static int solve() {
		int ret = 0;
		
		for( int i= 0; i< (1<<N) ; ++i) {
			// bitcount : 1의 갯수 반환
			if(Integer.bitCount(i)!=2) {
				//원소의 갯수가 2개가 아닌경우
				continue;
			}
			
			int sum = 0;
			for( int j = 0; j<N; ++j) {
				if((i &1 << j)!=0) {
					sum += Arr[j];
				}
			}
			if(sum == 7) {
				++ret;
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 첫번째 입력 값 : 합
		N = sc.nextInt();
		
		for( int i= 0; i<N; ++i) {
			Arr[i] = sc.nextInt();
		}
		
		System.out.println(solve());
	}
}
