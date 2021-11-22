package Kakao2019Recruit;

import java.util.*;

// 카카오톡 오픈 채팅방 (정답 통과)
// 채팅방에 들어오고 나가거나, 닉네임을 변경한 기록이 담긴 문자열 배열 record가 매개변수로 주어질 때, 
// 모든 기록이 처리된 후, 
// 최종적으로 방을 개설한 사람이 보게 되는 메시지를 
// 문자열 배열 형태로 return 하도록 solution 함수를 완성하라.
public class MySolution {
	public static List<String> solution(String[] record) {

		List<String> answer = new ArrayList<>();
		// record 형식 Leave uid1234 , Change uid1234 Muzi, Enter uid1234 Muzi
		// hash map 으로 아이디와 닉네임 저장하기
		// change -> put 해서 덮어쓰기
		// enter -> put하기

		// 해쉬맵에 record 저장하기 (enter와 change일 경우)
		//  userId , 닉네임
		Map<String,String> recordMap = new HashMap<>();

		for(String rec : record) {
			String[] splitRecord = rec.split(" ");
			if(splitRecord[0].equals("Change") || splitRecord[0].equals("Enter")) {
				// hashmap 에 저장
				recordMap.put(splitRecord[1], splitRecord[2]);
			}
		}
		
		System.out.println(recordMap.toString());
		for(String rec : record) {
			String[] splitRecord2 = rec.split(" ");
			// 현재 닉네임 찾기 -> 아이디로 검색
			String currentNickname =  recordMap.get(splitRecord2[1]);

			if(splitRecord2[0].equals("Enter")) {
				String print =currentNickname+"님이 들어왔습니다.";
				answer.add(print);
			}else if(splitRecord2[0].equals("Leave")) {
				String print = currentNickname+"님이 나갔습니다.";
				answer.add(print);
			}else {
				continue;
			}

		}

		return answer;
	}
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		System.out.println(solution(record));



	}
}
