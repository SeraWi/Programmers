package kakao2021;

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
				//처음 나온 마침표				마지막에 나온 마침표
				if(answer.length() == 0 || lastDot) {
					continue;
				}
				lastDot = true;
			}else {
				//마지막 문자가 .이 아닌경우
				lastDot = false;
			}
			//소문자로 변환
			ch = Character.toLowerCase(ch);
			//문자를 넣는다.
			answer.append(ch);
		}// for end
		
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
