package L15_CaterpillarMethod;

import java.util.HashSet;
import java.util.Iterator;

public class CountDistinctSlices {
	//The goal is to calculate the number of distinct slices.
	// All integers in array A are less than or equal to M.


	HashSet<Integer> caterpillar = new HashSet<>();
	int catFront = 0;
	int catRear = 0;
	int[] A;
	
	
	//O(N)
	// 부분집합을 모두 구하지 않고 가능한가?
	public int solution(int M, int[] A) {
		// A안에 숫자들은 M보다 작거나 같다.
		int count =0;
		this.A  =A;
		while(A.length > catFront || A.length > catRear) {
			if(A.length > catFront  && !caterpillar.contains(A[catFront])) {
				moveHeadForward();
				outputCat();
				count+= caterpillar.size();
				if(count>1000000000) {
					return 1000000000;
				}
			}else {
				moveTailForward();
				outputCat();
			}
		}
		return count;
	}

	private void moveHeadForward() {
		caterpillar.add(A[catFront]);
		catFront++;
	}
	private void moveTailForward() {
		caterpillar.remove(A[catRear]);
		catRear++;
	}

	private void outputCat() {
		Iterator<Integer> iCat = caterpillar.iterator();
		String s = "";

		while(iCat.hasNext()) {
			s += iCat.next() +":";

		}
		System.out.println(s);
	}
	public static void main(String[] args) {
		//System.out.println(new CountDistinctSlices().solution(6, new int[] {3,4,5,5,2}));
		System.out.println(new CountDistinctSlices().solution(6, new int[] {1,2,3,4,5}));
	}


}
