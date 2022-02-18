package kakao2021;

import java.util.HashMap;

// 숫자 문자열과 영단어 (Lv1)
// one4seveneight ->1478반환
// 123 -> 123

/*
startsWith() : 해당 문자로 시작하는지, 시작하면 true 반환
endsWith()

*/
public class EnglishToNum {
	
	
	String[] word = {
			"zero","one","two","three","four","five",
			"six","seven","eight","nine"
	};
	
	public int solution(String s) {
		int answer  =0;
		
		StringBuilder sb = new StringBuilder();
		
		for( int pos = 0; pos<s.length();) {
			// 숫자인경우
			if(s.charAt(pos) >='0' && s.charAt(pos) <='9' ) {
				sb.append(s.charAt(pos++));
			}else {
				// 글자인경우 word 단어와 하나씩 비교
				for(int i = 0; i<10 ; ++i) {
					//				비교문자, 시작할 위치
					if(s.startsWith(word[i],pos)) {
						// 아스키값을 숫자로 바꿔서 넣기
						sb.append((char) ('0' +i));
						// 글자 길이만큼 뛰어 넘기
						pos += word[i].length();
						break;
					}
				}
			}
		}
		answer = Integer.parseInt(sb.toString());
		
		return answer;
	}
	
	public int solution2(String s) {
  		
		int answer = 0;

		HashMap<String, String> numbers= new HashMap<>();
		numbers.put("zero","0");
		numbers.put("one","1");
		numbers.put("two","2");
		numbers.put("three","3");
		numbers.put("four","4");
		numbers.put("five","5");
		numbers.put("six","6");
		numbers.put("seven","7");
		numbers.put("eight","8");
		numbers.put("nine","9");

		for(String key :numbers.keySet()) {
			if(s.contains(key)) {
				String value = numbers.get(key);
				s= s.replace(key, value);
			}
		}
		
		
		answer = Integer.parseInt(s);
		return answer;
    }
}
