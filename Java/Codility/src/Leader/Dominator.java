package Leader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Dominator {
	
	//O(N*log(N)) or O(N)
	public int solution(int[] A) {
		// write your code in Java SE 8
		int answer = 0;
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		int size = A.length;
		for( int i = 0 ; i<size; i++) {
			if(map.containsKey(A[i])) {
				// 있다면 기존의 list가져오기
				ArrayList<Integer> list = map.get(A[i]);
				// 인덱스 저장
				list.add(i);
				// 다시 넣기
				map.replace(A[i], list);
			}else {
				//	Arrays.asList() : 일반배열을 ArrayList로 변환한다.
				map.put(A[i], new ArrayList<>(Arrays.asList(i)));
			}
			
		}
		for( Map.Entry<Integer, ArrayList<Integer>> element : map.entrySet()) {
			// Dominator인 경우
			if(element.getValue().size() >= (size/2) +1) {
				return element.getValue().get(0);
			}
		}
		return -1;
	}
}
