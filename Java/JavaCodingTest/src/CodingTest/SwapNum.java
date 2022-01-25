package CodingTest;

import java.util.ArrayList;
import java.util.List;

public class SwapNum {
	// Swap 횟수의 최솟값을 return 하도록 solution 함수를 완성해주세요.

	// 1. 순열로 모든 경우의 수 구한다.
	// 2. 원소간의 차이를 만족하는 경우의 수를 추출
	// 3. swap이 가장 적은 경우를 확인한다



	public static int solution(int[] numbers, int k) {
		int answer =0;

		Permutation perm = new Permutation(numbers.length, numbers.length);

		perm.permutation(numbers, 0, numbers.length, numbers.length);	

		ArrayList<ArrayList<Integer>> result = perm.getResult();
		for( int i =0; i<result.size(); i++) {
			for( int j = 0; j<result.get(i).size()-1; j++) {
				// 순열에서 원소간의 차이를 검사
				if(Math.abs(result.get(i).get(j)-result.get(i).get(j+1))> k) {
					result.remove(i);
					break;
				}
			}
		}
		
		System.out.println(result.size());
		
		return answer;
	}

	public static void main(String[] args) {
		int[] numbers= {10, 40, 30, 20};
		int k= 3;
		solution(numbers, 3);
	}
}


class Permutation{
	private int[] now;// 현재 순열
	private static ArrayList<ArrayList<Integer>> result;
	private int n;
	private int r;

	public Permutation(int n, int r) {
		this.n= n;
		this.r= r;
		this.now = new int[r];
		this.result = new ArrayList<ArrayList<Integer>>();
	}

	static void permutation(int[] arr, int depth, int n, int r) {
		if (depth == r) {
			ArrayList<Integer> temp = new ArrayList<>();
			for( int i= 0; i<arr.length; i++) {
				temp.add(arr[i]);
			}
			result.add(temp);
			return;
		}

		for (int i=depth; i<n; i++) {
			swap(arr, depth, i);
			permutation(arr, depth + 1, n, r);
			swap(arr, depth, i);
		}
	}

	static void swap(int[] arr, int depth, int i) {
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}

	public ArrayList<ArrayList<Integer>> getResult() { 
		return result;
	}

}