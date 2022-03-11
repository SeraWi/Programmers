package CodingTest;

public class Question1 {


	public static int solution(String S) {
		// write your code in Java SE 8

		//x를 만나면 청소한다.
		char[] c = S.toCharArray();
		int cnt = 0;

		//System.out.println(c.length);

		if(S.equals("...") || S.equals(".") || S.equals("..")) {
			// 여기 코드 추가해써야 하는데!
			return 0;
		}

		// 위에랑 순서 바껴야 함
		if(S.length() <=3) {
			return 1;
		}


		for( int i = 0 ; i< c.length;  i++) {
			//System.out.println("현재 :" + c[i] +" index : " +i);
			if(c[i] == '.') {
				continue;
			}else {
				//X인 경우
				cnt ++;
				// .으로 바꾼다.

				if(i < c.length-1 ) {//여기 범위 -2 ->-1로 변경함
					if(c[i+1] == 'X'  && i+1 < c.length) {
						c[i+1] = '.';
					}

					if(i+2 < c.length) { //여기 범위때문에 Index error 떳을 거임
						if(c[i+2] =='X') {
							c[i+2] ='.';
						}
					}

				}


			}
		}

		return cnt;

	}
	public static void main(String[] args) {
		System.out.println(solution("..."));
		System.out.println(solution("."));
		System.out.println(solution(".X."));
		System.out.println(solution("XXX"));
		System.out.println(solution("...X.XX.XXX")); //3
		//System.out.println(solution("............."));
		System.out.println(solution(".X.X..XXXXXXX"));//4

	}

}
