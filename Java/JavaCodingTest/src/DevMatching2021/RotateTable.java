package DevMatching2021;

import java.util.Arrays;

// 행렬 테두리 회전하기
public class RotateTable {


	static int[][] matrix;


	// 행 X 열  
	public static  int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		//원본테이블 생성
		matrix = new int[rows][columns];

		int num = 1;
		for( int i = 0; i<rows; i++) {
			for( int  j= 0; j<columns ; j++) {
				matrix[i][j] = num;
				num++;
			}
		}


		for( int i =0; i<queries.length ; i++) {
			answer[i] = rotate(queries[i]);
			show(rows);
		}

		return answer;
	}


	public static int rotate(int[]query) {
		int r1 = query[0]-1;
		int c1 = query[1]-1;
		int r2 = query[2]-1;
		int c2 = query[3]-1;


		int temp = matrix[r1][c1];
		int min = temp;
		
		// 왼쪽 세로가 하나씩 위로 올라가는 거 (1,1) 자리에 (2,1) 숫자가 온다
		for(int i = r1; i < r2; i++){
			matrix[i][c1] = matrix[i+1][c1];
			if(min > matrix[i][c1]) min = matrix[i][c1];
		}
		
		//왼쪽 가로방향으로 움직인다. (4,2)자리에 (4,3)숫자가 온다. 
		for(int i = c1; i < c2; i++){
			matrix[r2][i] = matrix[r2][i+1];
			if(min > matrix[r2][i]) min = matrix[r2][i];
		}

		//오른쪽 세로 숫자가 하나씩 밑으로 내려감 (2,3)자리에 (1,3)숫자가 온다.
		for(int i = r2; i > r1; i--){
			matrix[i][c2] = matrix[i-1][c2];
			if(min > matrix[i][c2]) min = matrix[i][c2];
		}
		
		//오른쪽 가로 방향으로 움직인다 .(2,1)자리에 (1,1)이 온다
		for(int i = c2; i > c1; i--){
			matrix[r1][i] = matrix[r1][i-1];
			if(min > matrix[r1][i]) min = matrix[r1][i];
		}
		matrix[r1][c1+1] = temp;

		return min;
	}

	public static void main(String[] args) {
		int[][]queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		int answer []= solution(6,6,queries);

		for( int i : answer ) {
			System.out.println(i);
		}
	}
	
	public static void show(int row){
        for(int i = 0; i < row; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println();
    }
}
