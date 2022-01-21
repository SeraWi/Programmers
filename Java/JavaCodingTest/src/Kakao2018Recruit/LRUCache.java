package Kakao2018Recruit;

import java.util.LinkedList;

public class LRUCache {
	/*
	 * cacheSize는 정수이며, 범위는 0 ≦ cacheSize ≦ 30 이다. 
	 * cities는 도시 이름으로 이뤄진 문자열 배열로, 
	 * 최대 도시 수는 100,000개이다.
	 */
	
	public int solution(int cacheSize, String[] cities) {
		int answer = 0;
		
		LinkedList<String> list = new LinkedList<String>();
		
		if(cacheSize == 0) {
			// 캐시 사이즈 0일때 항상 cache miss
			return cities.length*5;
		}
		
		for( int i = 0; i<cities.length; i++) {
			cities[i] = cities[i].toUpperCase();
			
			if(list.contains(cities[i])) {
				// cache hit
				answer++;
				list.remove(cities[i]); 
				list.add(cities[i]);// 가장 최근으로 넣기
			}else {
				// cache miss
				answer +=5;
				
				if(list.size()== cacheSize) {
					//캐시 공간 없을 때
					list.remove(0);// 가장 첫번째 삭제
					list.add(cities[i]); // 뒤에 새로 넣기
				}else {
					// 캐시공간 존재
					list.add(cities[i]);
				}
			}
			
		}
       
        return answer;
    }
	
	
	
	
	
}

