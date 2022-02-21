package kakao2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//메뉴 리뉴얼(Lv2)

/*
1. 요리세트 최대 카운트 수를 담는 배열
2. 모든 요리세트의 경우의 수를 담는 List
3. List의 인덱스는 요리세트 안의 음식 갯수로 작용, list안에 Map으로 요리세트와 요리세트 중복 횟수를 저장
4. 손님이 주문한 orders에 대해 만들 수 있는 모든 course를 list에 저장
5. 겹치는 경우 getOrDefault 메서드로 value 값이 cnt를 증가 시킨다.
6. 경우의 수를 넣을 때 마다 cnt의 최대값을 확인해서 배열에 저장한다.
7. 모든 경우의 수와 카운트 수를 담은 list가 만들어진다.
8. course elelmet 의 수는 곧 list의 인덱스와 동일하기 때문에 순회하면서 maxcnt에 해당하는 요리세트를 새로운 list에 담는다.
*/


public class MenuRenewal {
	/*
	 * orders : 각 손님들이 주문한 단품 메뉴들이 문자열 형태로 2~20
	 * course : 코스요리를 구성하는 단품 메뉴들의 개수가 담긴 배열 2~10
	 * result ["AC","ACDE","BCFG","CDE"]
	 */
	
	List<Map<String, Integer>> FoodMaps = new ArrayList<>(); 
	// list index 2에는 2가지 요리로 만들 수 있는 코스의 종류와 카운트 수를 map으로 담음..
	
	int[] MaxCnt = new int[11]; // 인덱스 : 코스요리 갯수, 값 : 최대카운트 값
	// map에 저장된 코스 요리 중 중복으로 되는 거 ->가장 큰 cnt를 저장
	
	void comb(char[] str, int pos, StringBuilder candi) {
		
		// 마지막 까지 간 경우 종료 조건
		if(pos>= str.length) {
			int len = candi.length();
			if(len >=2) { // AC, ACD 이런식으로 세트는 요리 2개 이상이어야 함
				//					list의 index 번호에 저장 cnt 저장
				// 코스요리가 이미 있는 경우는 value 값에 +1 해서 cnt 증가 시키고
				// 코스 요리 없는 경우 (Default)로 0을 넣으면 cnt 가 1로 만들어짐
				int cnt = FoodMaps.get(len).getOrDefault(candi.toString(),0)+1;
				//그다음 foodmaps 안 map에  코스 =이름 과 		숫자  저장
				FoodMaps.get(len).put(candi.toString(), cnt);
				//맥스 카운트를 최대값으로 계속 갱신한다.
				MaxCnt[len] = Math.max(MaxCnt[len], cnt);
			}
			return ; //재귀 호출 종료
		}
		
		// 선택하지 않은 경우
		comb(str, pos+1, candi.append(str[pos]));
		// 선택하지 않은 경우 
		candi.setLength(candi.length()-1);
		comb(str, pos+1, candi);
	}

	public String[] solution(String [] orders, int[]course) {
		
		for( int i=0; i<11 ; ++i) {
			FoodMaps.add(new HashMap<String, Integer>()); //FoodMaps element 10개 만들기
			
		}
		for( String str : orders) {
			char[] arr = str.toCharArray();
			// 오름차순 정렬
			Arrays.sort(arr);
			
			// 만들 수 있는 경우의 수 모두 만들기
			// 	 ACD  첫번째 A부터 시작한다는 의미
			comb(arr, 0, new StringBuilder());
			
		}
		
		List<String > list = new ArrayList<>();
		
		for( int len : course) {
			for (Map.Entry<String, Integer> entry : FoodMaps.get(len).entrySet()) {
				// 				2번이상 만들어진 세트인 경우와 maxcnt와 동일한 경우의 세트를 새로운 list에 저장
				if(entry.getValue() >=2 && entry.getValue() == MaxCnt[len]) {
					list.add(entry.getKey());
				}
			}
		}
		//오름 차순 정렬
		Collections.sort(list);
		String[] answer = new String[list.size()];
		
		for( int i= 0; i<list.size(); ++i) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		
	}
	
	
	
}
