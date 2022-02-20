package kakao2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


// 오픈 채팅방 문제 (Lv1)
/*StringTokenizer 사용해서 문자열을 토근화 한다.
생성자 3개 : 1. new StringTokenizer(문자열) : 띄어쓰기 기준으로 분리된다.
		2. new StringTokenizer(문자열, 구분자 ): 구분자 기준으로 분리된다.
		3. new StringTOkenizer(문자열, 구분자, true/false ) :구분자로 분리한뒤 문자열에 넣을지 안넣을지
메서드 : nextToken() : 분리된 문자열 확인
	  hasMoreTokens() :남아있는 토큰이 있는지 boolean 반환
*/



public class OpenChat {
	public String[] solutin(String[]record) {
		List<String> ansList = new ArrayList<>();
		Map<String, String> idmap = new HashMap<String, String>();


		for(String str:record) {
			StringTokenizer tokenizer = new StringTokenizer(str);
			String cmd = tokenizer.nextToken();

			if(cmd.equals("Enter")|| cmd.equals("change")) {
				String id = tokenizer.nextToken();
				String name = tokenizer.nextToken();
				idmap.put(id,name); //덮어쓰기 or 추가되기 된다.
			}
		} //for end
		
		//답 생성
		for(String str: record) {
			StringTokenizer tokenizer = new StringTokenizer(str);
			String cmd = tokenizer.nextToken();
			
			if(cmd.equals("Enter")) {
				String id = tokenizer.nextToken();
				ansList.add(idmap.get(id) +"님이 들어왔습니다.");
			}else if(cmd.equals("Leave")) {
				String id = tokenizer.nextToken();
				ansList.add(idmap.get(id) +"님이 나갔습니다.");
			}
		}
		
		String[] answer = new String[ansList.size()];
		ansList.toArray(answer);

		return answer;
	}// solution end
}
