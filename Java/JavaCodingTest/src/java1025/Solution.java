package java1025;


import java.util.*;

class Solution {
//K번 째수
//배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.



	public static int[] solution(int[] array, int[][] commands) {
		
//		int []array = new int[]{1, 5, 2, 6, 3, 7, 4, 3,10,3,5,6};
//		int [][]commands = new int[][] {
//			{2,5,3},	
//			{4,4,1},
//			{1,7,3},
//			{4,9,2}
//		};

		// 2차원 배열의 길이 구하기 (1차원 배열이 몇개인지)
		int[] answer = new int[commands.length];
		// arr배열 == commands안의 1차원 배열 하나
		int[] arr = new int[3];

		ArrayList<Integer> temp = new ArrayList<>();
		// commands가 몇개인지 에따라 anwer의 갯수가 바뀐다
		for(int i=0; i<commands.length; i++){

			// j=0,1,2
			for(int j=0; j<3; j++){
				// [0][0],[0][1],[0][2]
				// [1][0],[1],[1],[1][2]
				arr[j] = commands[i][j];
			}
			// arr에는 commands 1차열 배열 하나가 저장된다
			// [2,5,3] i=0 일때
			// [4,4,1] i=1 일때

			//  j=2 ->2번째 숫자, index = 1 , 첫번째 숫자 부터 마지막 숫자까지 arrayList에 저장하기
			for(int j=arr[0]-1; j<arr[1]; j++){
				temp.add(array[j]);
			}
			//array리스트에 2~5번째 숫자가 저장된다

			// sort: 오름차순 정렬한다
			Collections.sort(temp);
			//정렬한뒤에 commands객체 마지막 숫자 = 몇번째숫자를 뽑을 건지(arr[2])
			//인덱스는 -1
			//answer 에 저장하기
			// answer[0] = 5
			answer[i] = temp.get(arr[2]-1);

			//arraylist에 저장된 리스트를 지우기
			for(int j=0; j<temp.size(); j++){
				temp.clear();
			}
			
			//i++되서 for문 돈다
		}

		return answer;
	}
	
	
	public static void main(String[] args) {
		//int[] answer = solution();
		
//		for(int i=0; i<answer.length;i++) {
//			System.out.println(answer[i]);
//		}
//		
	}
	
	
}

