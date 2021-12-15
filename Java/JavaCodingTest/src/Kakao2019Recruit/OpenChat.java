package Kakao2019Recruit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//채팅방에 들어오고 나가거나,
//닉네임을 변경한 기록이 담긴 문자열 배열 record가 매개변수로 주어질 때, 
//모든 기록이 처리된 후, 최종적으로 방을 개설한 사람이 보게 되는 메시지를 문자열 배열 형태로 return 하도록
//solution 함수를 완성하라.
public class OpenChat {
	public List<String> solution(String[] record) {
        List<String> answer = new ArrayList<>();
        
        // 일단 record에 저장된 아이디와 닉네임을 매치 시켜 map에 넣기
        // 중복되면 알아서 덮어쓰기된다.
        // Enter일경우와 change일 경우만 add하기
        HashMap<String, String> map = new HashMap<>();
        
        for( int i = 0; i<record.length; i++) {
        	String[] records = record[i].split(" ");
        	
        	if(records[0].equals("Enter")|| records[0].equals("Change")) {
        		map.put(records[1], records[2]);
        	}
        }
        
        
        for( int i= 0; i<record.length; i++) {
        	String[]records2 = record[i].split(" ");
        	//해당 아이디에 해당하는 가장 최근 닉네임 찾기
        	String currentNickname = map.get(records2[1]);
        	
        	if(records2[0].equals("Enter")) {
        		answer.add(currentNickname+"님이 들어왔습니다.");
        		
        	}else if(records2[0].equals("Leave")) {
        		answer.add(currentNickname+"님이 나갔습니다.");
        	}
        }
        
        
        
        return answer;
    }
}
