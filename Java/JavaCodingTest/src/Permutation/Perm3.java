package Permutation;

import java.util.ArrayList;
import java.util.Arrays;

public class Perm3 {

	private int n ;
	private int r;
	private static ArrayList<Integer> itemList;
	private int[] res;

	public Perm3(int [] intArr, int r) {
		this.r = r;
		this.n = n;
		this.res = new int[r]; // 결과 값 반환

		itemList = new ArrayList<Integer>();
		for( int item: intArr) {
			itemList.add(item);
		}
	}
	//시작점
	public void perm(int depth) {
		perm(itemList,0);
	}
	public void perm(ArrayList<Integer> itemList, int depth) {
		if(depth == r) {
			System.out.println(Arrays.toString(res));
			return;
		}

		for( int i = 0; i<n-depth; i++) {
			res[depth] = itemList.remove(i);
			perm(itemList,depth+1);
			itemList.add(i,res[depth]);

		}
	}

	public static void main(String[] args) {
		int r = 3;
		int[] arr = {1,2,3,4,5};
		Perm3 main = new Perm3(arr, r);
		main.perm(0);
		System.out.println(itemList.toString());
	}

}
