package Kakao2018Recruit;

//비트 연산자 사용하기

public class SecretMapOthers {
	public static String[] solution(int n, int[] arr1, int[] arr2) {
		// 비트 연산자
		String[] result =new String[n];
		
		for(int i= 0; i<n ;i++) {
			// 비트연산자               2진수로 바꾸고           두 비트 중 하나라도 1이면 1을 반환
			result[i] =Integer.toBinaryString(arr1[i]|arr2[2]);
		}
		
		for(int i=0; i<n;i++) {
			// 형식을 n자리수로 맞추기
			result[i] =String.format("%" +n +"s",result[i]);
			// 1을 전부 #으로 바꾸기
			result[i] =result[i].replaceAll("1", "#");
			// 0은 공백으로 바꾸기
			result[i] =result[i].replaceAll("0", " ");
		}
		return result;
	}
	public static void main(String[] args) {
		int n =5;
		int[] arr1 = {9, 20, 28, 18, 20};
		int[] arr2 = {30, 1, 21, 17, 28};
		for(String str : solution(5,arr1,arr2)) {
			System.out.println(str);
		}
		
	}
}
