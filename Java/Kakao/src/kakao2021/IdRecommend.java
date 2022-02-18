package kakao2021;



// 아이디 추천 문제
/*StringBuilder 
String 객체까리 더하는 방법은 메모리할당과 해제를 발생, 비효율적
StringBuilder 는 변경 가능한 문자열을 만들어 준다.
append() : 문자열 추가
delete(index) : index 의 문자열 제거
deleteCharAt() : 특정 인덱스의 한문자만 삭제
reverse() :문자열 거꾸로 뒤집어줌
toString() :String 으로 반환
*/
public class IdRecommend {
	
	// 유효한 문자의 경우
	boolean isValid(char c) {
		
		if(Character.isLetterOrDigit(c)) {
			return true;
		}
		
		if(c == '-' ||c =='_' | c =='.') {
			return true;
		}
		return false;
	}
	
	public String solution (String new_id) {
		StringBuilder answer = new StringBuilder();
		
		// 마지막 문자가 .인지
		boolean lastDot = false;
		
		for(char ch : new_id.toCharArray()) {
			if(isValid(ch) == false) { 
				// 유효하지 않은 문자의 경우 skip
				continue;
			}
			if(ch =='.') {
				//처음 나온 마침표				
				if(answer.length() == 0 || lastDot) {
					continue;
				}
				
				// 중간에 있는 .은 true 를 반환하게 된다.
				// 연속되는 .은 lastDot 이 true 라서 위의 if 문을 거쳐 skip된다.
				lastDot = true;
			}else {
				lastDot = false;
			}
			//소문자로 변환
			ch = Character.toLowerCase(ch);
			//문자를 넣는다.
			answer.append(ch);
		}// for end
		
		// 글자갯수 15개로 맞추기
		if(answer.length()>= 16) {
			answer.setLength(15);
		}
		//빈문자열 처리 ->a 넣기
		if(answer.length() == 0) {
			answer.append('a');
		}
		
		//마지막 문자 .인 경우 삭제하기
		if(answer.charAt(answer.length()-1) == '.') {
			answer.deleteCharAt(answer.length()-1);
		}
		
		// 문자열 길이 2이하인 경우
		if(answer.length() <= 2) {
			char ch = answer.charAt(answer.length()-1);
			//마지막 문자 반복하며 붙이기
			while(answer.length()<3) {
				answer.append(ch);
			}
		}
		return answer.toString();
	}

}
