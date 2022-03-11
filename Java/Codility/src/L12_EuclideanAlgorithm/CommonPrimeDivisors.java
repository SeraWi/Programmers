package L12_EuclideanAlgorithm;

public class CommonPrimeDivisors {
	//O(Z * log(max(A) + max(B))**2)
	
	public int solution(int[] A, int[] B) {
		// write your code in Java SE 8
		
		int count =0;
		for( int i = 0; i<A.length ; i++) {
			if(hasAllPrimeFactors(A[i], B[i]) && hasAllPrimeFactors(B[i], A[i])) {
				count++;
			}
		}
		
		return count;
	
	}
	private boolean hasAllPrimeFactors(int x, int y) {
		
		if(y == 1) {
			return true;
		}
		
		int gcd = gcd(x, y, 1);
		
		// 최대공약수가 1이면 prime number임
		if(gcd == 1) {
			return false;
		}
		
		
		return hasAllPrimeFactors(x, y/gcd);
	}
	
	// 최대 공약수 구한다
	public static int gcd(int a, int b, int res) {
		if(a == b) {
			return res * a;
		}else if((a%2 == 0) && (b%2 ==0)) {
			return gcd(a/2, b/2, 2 *res);
		}else if(a %2 == 0) {
			return gcd(a /2, b, res);
		}else if(b %2 == 0) {
			return gcd(a,b/2, res);
		}else if(a>b) {
			return gcd(a-b, b, res);
		}else {
			return gcd(a,b-a, res);
		}
	}
}
