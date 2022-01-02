package Lv1;

import java.util.*;

class SolutionWithHashMap_1027{
	// hashmap 풀이
	public String solution(String[] participant, String[] completion) {
		//hashmap : Map 인터페이스의 한 종류 <key, value>형식/
		// key 값 중복 불가능, value 중복 가능
		// 순서 유지 되지 않는다 -> 순서 유지하는 경우 LinkedHashMap
		// value 값에 null가능
		
		// 함수
		// put(key, value): 키와 값을 저장
		// remove(key) : 해당키로 지정된 값을 제거
		// size() : 저장된 요소의 개수 반환
		// get(key) :해당 key의 value값 반환
		// values(): 저장된 모든 value값을 출력
		// boolean containskey(key):해당 키가 포함되어 있는지
		// booelan containsValue(value)
		// getOrDefault(key, defaultValue): 지정된 key값을 반환하고 없을시에 defaultValue반환 **
		// Set keySet() :해쉬맵에 저장된 모든 키가 저장된 set을 반환
		
		
        String answer = "";
        //해쉬맵 생성
        HashMap<String, Integer> hm = new HashMap<>();
        
        // participant 한명한명을 해쉬맵에 저장
        // player이름과  해쉬맵에 이미 player이름 존재하면 그 value 값 반환 하고 +1 ->동명이인 있는 경우 2
        // 처음 넣는 이름이다->defautlValue =0을 반환하고 +1시키기 -> 즉 이름이 같지 않으면 1
        for (String player : participant) {
        	hm.put(player, hm.getOrDefault(player, 0) + 1);
        }
        
        // completion에 있는 한명한명 해쉬맵에 저장
        // 동일 key값으로 추가시 덮어쓰기가 된다 ***
        // player 이름으로 value값 찾아서 -1시키기 -> 동명이인 없는 경우 0으로 바뀜 , 0으로 바꼇다는 건 completion에 존재한다는 의미
        // 동명이인이 있는 경우 1으로 바뀜 -> 또 같은 이름이 있다면  ->0으로 바뀜 
        
        for (String player : completion) {
        	hm.put(player, hm.get(player) - 1);
        }
        //해쉬맵에 저장된 모든 key값 반환
        // hashmap 전체 출력 방법
        // entrySet(): key와 value 모두 필요한 경우 사용
        // keySet(): key만 필요
        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
            	//hm.get(key)는 value반환
            	//0이 되지 않았다는 건 , 완주 하지 않았다는 것
                answer = key;
            }
        }
        return answer;
    }
}