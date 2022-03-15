package GCD;

public class Task1 {

	//효율성이 떨어진다..!
	public int solution(int mod1, int mod2, int max_range) {

		//4의배수 갯수에서 - 공대 공배수를 뺀다?

		int cnt = 0;

		for( int i = 1; i <= max_range ; i++) {
			if( i % mod1== 0) {

				if(i %mod2 != 0) {
					cnt++;
				}

			}
		}

		return cnt;
	}
	
	//최대 공약수
	public static int getGCD(int mod1, int mod2) {
		if(mod1 % mod2 == 0) {
			return mod2;
		}
		return getGCD(mod2, mod1 % mod2);
	}
	
	//max_range안에서 mod1 으로 나누어떨어지지만 
	//mod2로 나누어떨어지지 않는 수
	// mod1의 배수갯수에서 - 최소공배수의 갯수를 빼준다.
	public int solution2(int mod1, int mod2, int max_range) {

		//4의배수 갯수에서 - 공대 공배수를 뺀다?

		int mod1Div = max_range / mod1;

		int getLCM = mod1 *mod2/ getGCD(mod1, mod2);

		int lcmCount = max_range/getLCM;
		
		return mod1Div - lcmCount;
	}

	public static void main(String[] args) {
		System.out.println(new Task1().solution2(4,3,20));
		System.out.println(new Task1().solution2(6,8,30));
	}
}
