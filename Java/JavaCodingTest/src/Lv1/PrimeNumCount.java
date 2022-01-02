package Lv1;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PrimeNumCount {
	/*
	 * 주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 
	 * 숫자들이 들어있는 배열 nums가 매개변수로 주어질
	 * 때, nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를
	 * 완성해주세요. 
	 * 제출시 시간초과
	 */
	public static int solution(int[] nums) {

		// 약수 카운트
		int cnt = 0;

		// 답
		int answer =0;

		// 오름차순 정렬시키기
		Arrays.sort(nums);
		ArrayList<Integer> sum = new ArrayList<>();

		// nums 배열에 요소 3개씩 더하기 ->소수인지 확인 -> cnt증가
		// 3개 더한값을 다시 배열에 넣기?
		for(int i=0; i<nums.length-2; i++) {
			for(int j=1 ; j<nums.length-1; j++) {
				for(int k= 2; k<nums.length ;k++) {
					//System.out.println(nums[i]+nums[j]+nums[k]);
					// arraylist에 담기	
					if(!sum.contains(nums[i]+nums[j]+nums[k])) {
						sum.add(nums[i]+nums[j]+nums[k]);
					}
				}
			}
		}
		System.out.println(sum);
		for(int i =0; i<sum.size(); i++) {
			for(int j= 1; j< sum.get(i)+1; j++) {
				if(sum.get(i)%j ==0) {
					cnt+=1;
				}
			}
			// 약수면 ++1
			if(cnt ==2) {
				//System.out.println(sum.get(i));
				answer+=1;
			}
			// cnt다시 초기화시켜주기
			cnt =0;
		}


		return answer;
	}

	public static void main(String[] args) {
		int[] nums = {1,2,7,6,4};
		//int[] nums = {1,2,3,4};
		System.out.println(solution(nums));
	}
}
