package Lv1;

public class AddAllNumbers_Sol2 {
	public int solution(int[] numbers) {
		int sum = 45;
		
		for(int i : numbers) {
			sum -= i;
		}
		
		return sum;
	}
}
