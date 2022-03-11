package L15_CaterpillarMethod;

import java.util.HashSet;
import java.util.Set;

//O(N) or O(N*log(N))
public class AbsDistinct {
	// 절대값이 다른 숫자의 갯수 count

	public int solution(int[] A) {
		// write your code in Java SE 8
		Set<Integer> aset = new HashSet<Integer>();
		for( int a : A) {
			a = Math.abs(a);
			aset.add(a);
		}
		return aset.size();
		
	}
	
	public static void main(String[] args) {
		int[] A = {-5,-3,-1,0,3,6};
		System.out.println(new AbsDistinct().solution(A));
	}


}
