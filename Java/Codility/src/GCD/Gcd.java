package GCD;

public class Gcd {
	//최대 공약수
	public static int getGcd(int a, int b) {
		
		if(b== 0) {
			return a;
		}
		
		// 			 b, 나눈 나머지
		return getGcd(b, a %b);
	}
	
	
	// 최소 공배수 == a *b  / 최대공약수
	
	public static void main(String[] args) {
		System.out.println(new Gcd().getGcd(6,8));
		System.out.println(new Gcd().getGcd(2,7));
		System.out.println(new Gcd().getGcd(15,5));
		
		System.out.println("=------------------");
		System.out.println( 6*8 / getGcd(6,8));
	}
}
