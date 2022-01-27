package Permutation;

import java.util.ArrayList;

public class Perm2 {


	public static void main(String[] args) {
		int arr[]= {1,2,3,4};
		int output[] = new int[arr.length];
		boolean visited[] = new boolean[arr.length];
		int n = 4;

		perm(arr, output, visited, 0, n, 3);


	}
		// nPr : n개 중에 r개를 뽑는다
	static void perm(int[]arr, int[]output, boolean[]visited, int depth, int n, int r ) {
		if(depth == r) {
			// 종료 조건, r개 다뽑았을 때

			for( int i =0; i<r; i++) {
				System.out.print(output[i] +" ");

			}
			System.out.println();

		}
		for( int i= 0; i<n; i++) {
			if(visited[i] != true) { // 방문하지 않았다면
				visited[i] = true; // 방문표시하고
				output[depth] =arr[i]; // output배열에 넣는다
				perm(arr, output, visited, depth+1, n, r);
				visited[i] = false; // 하나 위로 depth 올라오면 다시 방문처리를 false한다

			}
		}

	}

}
