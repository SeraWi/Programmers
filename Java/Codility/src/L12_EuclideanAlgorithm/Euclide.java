package L12_EuclideanAlgorithm;

public class Euclide {
	
	// 최대공약수를 구하는 알고리즘
	public static int gcd(int a, int b) {
		if(b == 0) {
			return a; 
		}else {
			return gcd(b, a%b);
		}
		
	}
	public static void main(String[] args) {
		System.out.println(gcd(4,2));
		System.out.println(gcd(2,4));
		System.out.println(gcd(1071,1029)); //21
	}
}
