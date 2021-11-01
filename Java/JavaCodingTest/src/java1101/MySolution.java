package java1101;

import java.util.ArrayList;

public class MySolution {
	public static int solution(int[] nums) {
		//당신은 최대한 다양한 종류의 폰켓몬을 가지길 원하기 때문에,
		// 최대한 많은 종류의 폰켓몬을 포함해서 N/2마리를 선택하려 합니다. 
		// N마리 폰켓몬의 종류 번호가 담긴 배열 nums가 매개변수로 주어질 때,
		// N/2마리의 폰켓몬을 선택하는 방법 중, 가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아, 
		// 그때의 폰켓몬 종류 번호의 개수를 return 하도록 solution 함수를 완성해주세요.

		//int[] nums = {3,3,3,2,2,4};

		// nums : n마리 포켓몬의 종류 번호가 담긴 배열
		
		// 최대 선택 포켓몬 종류 수
		int answer = 0;
		
		//nums에서 중복제거해서 arrayList에 담기

		ArrayList<Integer> arrayList = new ArrayList<>();		

		for(Integer item : nums) {
			// 중복되지 않을 경우만 add
			if(!arrayList.contains(item))
				arrayList.add(item);
		}

		System.out.println(arrayList);
		
		
		if(arrayList.size()>=nums.length/2) {
			answer = (int) nums.length/2;
		}else {
			answer = arrayList.size();
		}

		return answer;
	}

	public static void main(String[] args) {
//		solution();
//		System.out.println(solution());
	}
}
