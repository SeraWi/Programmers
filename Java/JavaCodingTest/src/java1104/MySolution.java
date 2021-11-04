package java1104;

public class MySolution {
	//두 정수 left와 right가 매개변수로 주어집니다. 
	//left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고,
	// 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.

	public static int solution(int left, int right) {
		
		int sum= 0;
		// 약수 갯수 세기
		int count = 0;
		
		for(int i=left ; i <right +1; i++) {
			// 약수의 갯수를 구하기
			// 약수의 갯수가 짝수인지 학인후
			// sum에 더하기
			for(int j =1; j<=i ; j++) {
				if((i%j)==0) {
					// 나머지가 0이며 약수임
					// 약수이면 1증가시키기
					count ++;
				}
			}
			
			//약수갯수가 짝수인가?
			if((count%2)==0) {
				// 짝수라면 더하기
				sum +=i;
			}else {
				// 홀수라면 빼기
				sum -=i;
			}
			
			//한번 루프 돌고 count 0으로 만들기
			count = 0;
			
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(24,27));
	}
}
