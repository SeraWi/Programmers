package L14_BinarySearch;

public class MinMaxDivision {
	
	//The large sum is the maximal sum of any block.
	
	public static int solution(int K, int M, int[] A) {
		// write your code in Java SE 8
		// K block으로 array를 나눈다.
		// A의 최대값은 M이하다
		// K블럭으로 나누고 블럭안의 element합의 최대를 구한다.
		// 그러한 조합 중 최솟값을 return 한다.
		int min = 0;
		int max = 0;
		for( int a : A) {
			max +=a;
			min = Math.max(min,  a);
		}
		
		
		int bestAnswer = max;
		
		while(min <= max) {
			int mid = (min + max) /2;
			
			int blocks = checkBlocks(A, mid);
			if(blocks > K) {
				min = mid +1;
			}else {
				max = mid-1;
				if(mid < bestAnswer) {
					bestAnswer =mid;
				}
			}
		}
		
		
		return bestAnswer;
	}
	
	private static int checkBlocks(int[] A, int guess) {
		int blocks = 1;
		int blockSum = 0;
		
		for( int a: A) {
			blockSum += a;
			if(blockSum > guess) {
				blockSum = a;
				blocks ++;
			}
		}
		return blocks;
	}
	
	public static void main(String[] args) {
		int k = 3;
		int M = 5;
		int [] A = new int[]{1,5,1,2,2,2};
		System.out.println(solution(k, M, A));
	}
}
