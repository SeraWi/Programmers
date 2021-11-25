package Kakao2020Recruit;

public class RecursionFunction {
	public static void main(String[] args) {
		HelloWorld(5);
	}

	private static void HelloWorld(int n) {
		if(n == 0) {
			return;
		}
		
		System.out.println("Hello World");
		HelloWorld(n-1);
	}
}
