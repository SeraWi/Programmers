package L13_Fibonacci;

public class Fibonacci {
	
	// 반복문을 이용한 구현
	// O(N)
	public int fibonacciMethod(int n) {
		if(n == 0) {
			return 0;
		}
		if(n ==1) {
			return 1;
		}
		
		int a = 0;
		int b = 1;
		int c =1;
		for(int i = 0; i<n-2; i++) {
			a= b;
			b=c;
			System.out.println(c);
			c =a +b;
		}
		return c;
	}
	
	// 재귀로 구현하기 , 갯수 input
	// O(2^N) , 함수를 매우 많이 호출하게 된다.
	public static int fibo(int n) {
		if(n <=1) {
			// 재귀 종료 시점
			return n;
		}else {
			return fibo(n-2) + fibo(n-1);
		}
	}
	
	
	public static void main(String[] args) {
		int a = 0;
		int b = 1;
		int c ;

		for( int i =1; i<= 8; i++) {
			c = a+ b;
			//System.out.println(c);
			a= b;
			b = c;
		}
		
		//System.out.println(new Fibonacci().fibonacciMethod(10));
		System.out.println(fibo(10));
	}
}
