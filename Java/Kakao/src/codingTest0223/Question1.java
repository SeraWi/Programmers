package codingTest0223;

public class Question1 {
	public static int solution(int n) {
		//n 개의 문이 있다.
		//n의 배수까지 실행함
		// 열고 닫기를 반복하고 최종으로 열려있는 문의 갯수를 반환
		
		//0으로 초기화 시키기
		//열면 1을 더하고 닫으면 0으로 만들기
		
		//약수 갯수가 짝수인지 홀수인지 하면 -> 짝수이면 닫히고, 홀수이면 열린 상태가 된다.
		
		int cnt =0;
		int open = 0;
		
		for( int i= 1; i <= n; i++) {
			//숫자 지정
			for( int j = 1; j<=i;j++ ) {
				//약수 갯수 구하기
				
				if(i%j==0) {
					//약수임
					cnt++;
				}
				
			}
			
			if(cnt%2 != 0) {
				//cnt가 홀수이면 열린 상태
				open++;
			}
			cnt = 0;

		}
        return open;
    }
	public static void main(String[] args) {
		System.out.println(solution(2));
	}
}



