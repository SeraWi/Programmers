package Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PocketMons {
	public static int solution(int[] nums) {
		/*
		 * 당신은 최대한 다양한 종류의 폰켓몬을 가지길 원하기 때문에, 최대한 많은 종류의 폰켓몬을 포함해서 N/2마리를 선택하려 합니다. N마리
		 * 폰켓몬의 종류 번호가 담긴 배열 nums가 매개변수로 주어질 때, N/2마리의 폰켓몬을 선택하는 방법 중, 가장 많은 종류의 폰켓몬을
		 * 선택하는 방법을 찾아, 그때의 폰켓몬 종류 번호의 개수를 return 하도록 solution 함수를 완성해주세요.
		 */

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


	// 다른 풀이 1)...?
	public int solution2(int[] nums) {


		// stream : 배열 또는 컬렉션 인스턴스에 함수 여러개를 조합해서 원하는 결과를 필터링하고 가공된 결과를 얻을 수 있다.
		//Arrays.stream() :  스트림 생성


		return Arrays.stream(nums)
				.boxed()
				.collect(Collectors.collectingAndThen(Collectors.toSet(),
						phonekemons -> Integer.min(phonekemons.size(), nums.length / 2)));
	}


	// 2) set 이용
	public int solution3(int[] nums) {
		//set : 중복 허용 x
		Set<Integer> set = new HashSet<>();
		for (int i : nums) {

			set.add(i);
		}

		//삼항 연산자
		//                  set사이즈가 크다? nums 갯수 /2 반환 : 아니면 set사이즈 반환
		return nums.length/2<set.size()?nums.length/2:set.size();
	}


	public static void main(String[] args) {
		//		solution();
		//		System.out.println(solution());
	}
}
