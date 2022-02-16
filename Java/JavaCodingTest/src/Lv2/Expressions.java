package Lv2;

//효율성 통과 X
public class Expressions {
	public static void main(String[] args) {
		int n = 15;
		System.out.println(solution(n));
		System.out.println(expression(n));
	}

	public static int solution(int n) {
		int answer = 0;

		for( int i = 1; i<n/2 ; i++) {
			if(chk(n, i)) {
				answer++;
			}
		}


		return answer;
	}

	public static boolean chk(int n, int count) {
		boolean chk =false;

		// count 는 표현하고자 하는 숫자의 갯수
		// 1 -> n
		// 2 -> 2n +1
		// 3 -> 3n +3 (1+2) 
		// 4 -> 4n +6 (1+2+3)
		// 5 -> 5n +10 (1+2+3+4)

		int sum =0;
		for( int i = 0 ; i<count ; i++) {
			sum += i;
		}

		if(((n-sum)%count == 0) && n > sum) {
			chk = true;
		}

		return chk;
	}
	public int solution2(int n) {


		if(n < 3) {
			return 1;
		}
		int answer = 1;
		int left = 1;
		int right = 2;

		int sum = left+ right;

		while(right< n) {
			if(sum < n) {
				sum+= ++right;
				continue;
			}
			if(sum == n) {
				answer++;
			}
			sum -= left++;
		}


		return answer;
	}

	// 주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의수는 주어진 수의 홀수 약수의 개수와 같다라는 정수론이 있다.
	public static int expression(int num) {
		int answer =0;
		for( int i= 1; i<= num ; i+=2) {
			if(num % i == 0) {
				answer ++;
			}
		}
		return answer;
	}

}
