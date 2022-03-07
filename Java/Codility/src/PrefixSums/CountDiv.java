package PrefixSums;

public class CountDiv {
//given three integers A, B and K, 
//returns the number of integers within the range [A..B] that are divisible by K, i.e.:
// A 와 B사이의 숫자 중 K로 나누어 떨어지는 숫자의 갯수 return 
	
	//O(B-A) time error
	public static int solution(int A, int B, int K) {
        // write your code in Java SE 8
		int ans = 0;
		
		for( int i = A ; i<B+1 ; i++) {
			System.out.println(i);
			if((i % K) == 0) {
				ans++;
			}
		}
		
		return ans;
    }
	//O(1) , performance test 통과
	public int solution2(int A, int B, int K) {
		int count =0;
		if(A % K== 0) {
			count++;
		}
		// A = B이면  K f로 나눌 수 있는 수 없음
		if(A!=B) {
			// A포함해서 K배수 갯수
			int firstDivided = A/K;
			//B포함해서 K배수 갯수
			int secondDivided = B/K;
			//A에서 B사이의 K배수 갯수
			count += secondDivided - firstDivided;
		}
		return count;
		
	}
	public static void main(String[] args) {
		System.out.println(solution(6,11,2));
	}
}
