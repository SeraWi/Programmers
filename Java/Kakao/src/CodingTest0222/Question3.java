package CodingTest0222;

import java.util.Scanner;

// 시간복잡도 n^2

public class Question3 {

	//모든 경우에 대해 완전 탐색하기

	public static String ArrayChallenge(int[] arr) {
		//두개씩 묶어서 합이 나오는 쌍을 모두 반환하기
		// 없으면 -1반환
		String answer ="";
		int sumNum = arr[0];
		
		for( int i = 1; i< arr.length ; i++) {
			for( int j = i+1 ; j<arr.length; j++) {
				if( arr[i] + arr[j] == sumNum ) {
					answer +=arr[i]+","+arr[j]+" ";
					System.out.println(answer);
				}
			}
		}
		if(answer.length()== 0) {
			answer = "-1";
		}
		
		
		return answer;
	}

	public static void main (String[] args) {  
		// keep this function call here     
		int[] arr = {17,4,5,6,10,11,4,-3,-5,3,15,2,7};
		System.out.print(ArrayChallenge(arr)); 
	}
}
