package codingTest0223;

public class Question4 {
	public static int solution(int n) {
		//n 개의 문이 있다.
		//n의 배수까지 실행함
		// 열고 닫기를 반복하고 최종으로 열려있는 문의 갯수를 반환
		
		//0으로 초기화 시키기
		//열면 1을 더하고 닫으면 0으로 만들기
		
		//약수 갯수가 짝수인지 홀수인지 하면 -> 짝수이면 닫히고, 홀수이면 열린 상태가 된다.
		
		
		int [] count = new int[n+1];
		
		
		int open = 0;
		
		for ( int i = 1; i<=Math.sqrt(n); i++) {
			for( int  j= 1; j<=Math.sqrt(n); j++) {
				count[i*j]++;
			}
		}
		
		
		for( int c : count) {
			if(c%2!=0) {
				open++;
			}
		}
		
        return open;
    }
	public static void main(String[] args) {
		System.out.println(solution(2));
	}
}
