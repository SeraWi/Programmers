package codingTest0223;

public class Question3 {
	//n개의 공을 바구니에 나누어 담으려고 합니다. 이 때, 각 바구니에는 K^2 개의 공을 담아야 합니다. (K는 자연수)
	// 그리디 인듯?
	// 공의 개수 n : n은 1이상 100,000이하의 자연수
	// 100000 == 317

	public static int solution(int n) {
		int answer = 0;

		//n보다 작은 제곱수를 찾아서 빼고
		// 빼는 그 과정을 반복해서 바구니수를 구하고
		// 최소를 return
		int a = 0;
		int cnt = 0;
		while(n != 0) {
			for(int i= 1; i <317 ; i++) {
				if(n == i*i) {
					a = i;
					break;
				}else if(n < i*i) {
					a = i-1;
					break;
				}
			}

			n= n- a*a;
			cnt++;
		}
		
		return cnt;
	}
	public static void main(String[] args) {
		System.out.println(solution(9));
	}
}
