package L12_EuclideanAlgorithm;

public class ChocolatesByNumbers {
	// Integer N represents the number of chocolates arranged in a circle, numbered from 0 to N − 1
	// M만큼 움직이며 먹다가 wrapper마주치면 먹는거 멈춘다.
	
	// 효율성 time error
	public int solution(int N, int M) {
		// write your code in Java SE 8
		
		if( M == 1) {
			return N;
		}
		
		//배열 할당 false로 초기화 된다.
		boolean[] eatCheck = new boolean[N];
		
		int i = 0;
		int cnt = 0;
		while(!eatCheck[i]) {
			eatCheck[i] = true;
			cnt++;
			i = (i+M)%N;
			
		}
		return cnt;
		
		
	}
	
	// N/GCD (N, M)
	public int solution2(int N, int M) {
		
		
		return N/gcd(N, M, 1);
	}
	
	//O(log(N + M))
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
	public static void main(String[] args) {
		System.out.println(gcd(10,1, 1));
		System.out.println(gcd(10,2, 1));
		System.out.println(gcd(10,3, 1));
		System.out.println(gcd(10,4, 1));
		System.out.println(gcd(10,5, 1));
		System.out.println(gcd(10,6, 1));
		System.out.println(gcd(10,7, 1));
		System.out.println(gcd(10,8, 1));
		System.out.println(gcd(10,9, 1));
		System.out.println(gcd(10,10, 1));
	}
}
