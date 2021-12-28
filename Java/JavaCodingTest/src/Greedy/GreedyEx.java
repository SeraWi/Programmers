package Greedy;

import java.util.Scanner;

public class GreedyEx {
	// 당장 눈앞에 보이는 최적의 상황만을 쫓는 알고리즘
	// 항상 최적의 결과를 도출하는 것은 아니다
	// 예 ) 거스름 돈 문제
	// 무조건 큰 경우, 작은 겨웅, 긴 경우  즉 극단적으로 문제에 접근한다.
	
	// 500,100, 50,10원으로 거스름돈 코인 갯수 가장 적게 거슬러 주기
	public static void main(String[] args) {
		int n = 0; // 입력한 돈
		int result =0; //거슬러주는 코인 갯수
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		result += n /500;  // 500원으로 거슬러주기
		n %= 500; //남은 돈 (나머지값)
		result += n/100;
		n %= 100;
		result += n /50;
		n %= 50;
		result += n/ 10;
		n %= 10;
		
		System.out.println(result);
		
		
		
		
	}
}
