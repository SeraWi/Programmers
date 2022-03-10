package L6_Sorting;

import java.util.HashSet;
import java.util.Set;
//array 에 중복되지 않는 숫자 count
public class Distinct {
//that, given an array A consisting of N integers, returns the number of distinct values in array A.
	//O(N*log(N)) or O(N)
	public int solution(int[] A) {
		// write your code in Java SE 8
		
		Set<Integer> a = new HashSet<>();
		for(int num : A){
			a.add(num);
		}
		return a.size();
	}
	
	
	public static void main(String[] args) {
		
	}
}
