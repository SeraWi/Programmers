package Study;


// 2020 문자열 압축 문제
public class StringEx {

	public int solution(String s) {
		int answer = s.length();

		// aabbaccc
		// pos : 몇번째인지 가리킨다.
		// len : 길이

		for( int i= 1; i<= s.length()/2 ; ++i) {
			int pos = 0;
			int len = s.length(); 

			for( ;pos+i <= s.length();) {
				//a
				String unit = s.substring(pos, pos+i);
				pos +=i; // 위치 뒤로 옮기기

				int cnt = 0;

				for( ; pos+i <= s.length(); ) {
					// 같은지 확인하기
					if(unit.equals(s.substring(pos, pos+i))) {
						++cnt;
						pos +=i;
					}else {
						// 다르면 그만하기
						break;
					}
				}
				
				// aa -> cnt = 1
				
				
				if(cnt > 0) {
					len -= i *cnt; // 전체 길이에서 압축길이 뺀다 

					if(cnt < 9) { // 2a -> 전체길이가 위에서 2개 빠져서 다시 하나 더해준다.
						len +=1;
					}else if(cnt <99) { //10a 이면
						len +=2;
					}else if(cnt < 999) {
						len +=3;
					}else {
						len +=4;
					}
				}
				// 가장 작은 값을 return 한다
				answer = Math.min(answer, len);
			}
		}

		return answer;
	}

}
