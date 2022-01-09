package Sorting;

public class Es {
	public static void main(String[] args) {
		String a ="abcd";
		String b ="abcd";
		String c = new String("abcd");
		
		System.out.println(a == b); //true
		System.out.println(b == c); //false
		System.out.println(b.equals(c)); //true
		
	}
}
