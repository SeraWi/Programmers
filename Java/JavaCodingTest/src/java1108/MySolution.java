package java1108;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MySolution {
	//정수 배열 numbers가 주어집니다. 
	//numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를
	//배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
	public static List solution(int[] numbers) {
		// 합을 arrayList에 담기
		ArrayList<Integer> answer =new ArrayList<>();
		
		// 정렬하기
		Arrays.sort(numbers);
		
		// 2개 숫자 더해서 arrayList 에 담기
		
		for(int i=0; i<numbers.length-1 ; i++) {
			for( int j= i+1; j<numbers.length; j++) {
				//[0] +[1], [0] +[2], [0] +[3], [0] +[4]
				
			 if(!answer.contains(numbers[i]+numbers[j])) {
				 System.out.println(numbers[i]+numbers[j]);
				 answer.add(numbers[i]+numbers[j]);
			 }
			}
		}
		
		// ArrayList 오름차순 정렬
		
		Collections.sort(answer);		
		
		return answer;
	}

	public static void main(String[] args) {
		int[] numbers = {2,1,3,4,1}; //1,1,2,3,4
		
		System.out.println(solution(numbers));
	}

}
