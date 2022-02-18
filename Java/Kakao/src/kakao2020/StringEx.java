package kakao2020;


// 2020 문자열 압축 문제

/*
 * aabbcc
1. 몇개씩 자르는지 for문을 돈다.( 1개에서 전체 길이 절반 만큼의 개수까지 자를 수 있음)
2. 자른 갯수만큼 s를 자르고(unit) 자르고 난 다음으로 위치를 이동한다.
3. 위치를 뒤로 옮긴 잘린 문자열을 unit과 비교한다.
4. 같은 경우 압축가능하기 때문에 그 다음 문자랑 비교한다 . 아니면 break로 for문 종료
5. 가장 처음의 문자를 다음 문자로 비교했다면(2a로 압축 가능 확인), 이제 그다음인 두번째 a, b, b,c,c를 전부 순회하며 압축을 확인한다.
6. 두번째 for문이 종료되면 첫번째 for문으로 올라와서
7. 2개씩 잘라서 비교하고 반복한다. aa로 압축이 되는지 확인
8. 이런방식으로 전체 길이 - 압축길이 , 빼는 방식으로 압축된 길이를 확인하고, math 함수로 계속 최솟값을 저장한다.
9. 마지막에 최소값을 반환한다.
*/
public class StringEx {

	public int solution(String s) {
		int answer = s.length();

		// aabbaccc
		// pos : 몇번째인지 가리킨다.
		// len : 길이

		for( int i= 1; i<= s.length()/2 ; ++i) {// 첫번째 for 몇개씩 자르는지 정한다.
			int pos = 0;
			int len = s.length(); 

			for( ;pos+i <= s.length();) {// 두번째 for 
				//a
				String unit = s.substring(pos, pos+i);
				pos +=i; // 위치 뒤로 옮기기

				int cnt = 0;

				for( ; pos+i <= s.length(); ) {//세번째 for
					// 같은지 확인하기
					if(unit.equals(s.substring(pos, pos+i))) {
						++cnt;
						pos +=i;
					}else {
						// 다르면 그만하기
						break;
					}
				}//세번째 for 종료
				
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
				} // if 끝
				// 가장 작은 값을 return 한다
				answer = Math.min(answer, len);
			} // 두번째 for end
		}// 첫번째 for  end

		return answer;
	}

}
