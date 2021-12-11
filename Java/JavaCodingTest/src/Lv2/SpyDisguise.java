package Lv2;

import java.util.HashMap;


// 해시/ 위장 문제 (정답통과)
// 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 
// 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
public class SpyDisguise {
	
	//스파이는 하루에 최소 한개의 이상은 입습니다.

	public static int solution(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> map = new HashMap<>();
		
		//카테고리에 해당하는 의상의 갯수는0으로 세팅
		int categoryCnt = 0;
		
		// 카테 고리 이름
		String categories;
		
		for( int i=0; i<clothes.length; i++) {
			
			// 카테고리 구하기
			categories = clothes[i][1];
			
			// map에 저장 ->중복되면 옆에 의상의 갯수가 바뀐다.
			if(map.containsKey(categories)) {
				//key에 이미 있는 옷 : 이미 존재하는 카테고리
				int currentCnt = map.get(categories); 
				//해당 카테고리에 의상 갯수 하나 증가
				categoryCnt = currentCnt +1;
				
				// 증가시킨뒤 map에 넣기
				map.put(categories, categoryCnt);
				
			}else {
				//처음 들어가는 옷 카테고리이다
				map.put(categories,1);
			}
		}
		
		//카테고리에 해당하는 옷의 갯수 +1 을 전부 곱한뒤 -1값을 return 한다
		
		for( Integer mapCnt : map.values()) {
			answer = answer *(mapCnt+1);
		}
		
		
		// 경우의 수를 모두 곱하기 하나도 안입게 되었을 경우를 1 빼준다.
		return answer-1;
		
	}
	public static void main(String[] args) {
		String[][]clothes = {{"yellowhat", "headgear"},
				{"bluesunglasses", "eyewear"},
				{"green_turban", "headgear"}
		};
		
		System.out.println(solution(clothes));
	}
}
