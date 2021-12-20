package Lv2;


// 완전탐색/ 소수 찾기
//각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 
//만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
public class FindPrimeNum {
	public static int solution(String numbers) {
		
		// 1. numbers로 만들 수 있는 모든 경우의 수를 찾기
		// 2. 그 다음 이 숫자들이 소수 인지 확인 -> cnt++
		
		// 0의 경우 0을 때고 숫자가 존재하는지 확인해야 한다.
		int[] Snum = new int[numbers.length()];
		
		for( int i=0; i< numbers.length(); i++) {
			Snum[i] = Integer.parseInt(numbers.substring(i, i+1));
		}
		

		
//		for( int i = 0; i<Snum.length; i++) {
//			System.out.println(Snum[i]);
//		}
		
		
		
		
		
		
		int answer = 0;
		return answer;
	}
	public static void main(String[] args) {
		System.out.println(solution("17"));
	}
}
