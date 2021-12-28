package DFSandBFS;

import java.util.Scanner;
import java.util.Stack;

public class DFS_floodfill {
	//입력이 관계가 있으면 0 없으면 1로 표현
	//5
	// 00000
	// 00011
	// 00010
	// 11110
	// 00000
	static int N;  // 보드 크기 
	static final int max_n =10;
	static int[][] D = {
			{-1,0},
			{1,0},
			{0,-1},
			{0,1}
	};
	static int[][] Board = new int[max_n][max_n]; //행렬로 정렬할 2차원 배열
	
	// 노드들 저장 
	static class Point{
		int row;
		int col;
		
		//생성자 행렬 좌표 받는다
		Point(int r, int c) {
			row = r;
			col = c;
			
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		for(int i = 0; i<N; ++i) {
			for( int j=0; j <N ; ++j) {
				System.out.println(i+ ","+ j+"에 해당하는 관계를 써주세요");
				//보드에 저장
				Board[i][j] = sc.nextInt();
			}
		}
		
		int sRow = sc.nextInt();
		int sCol = sc.nextInt();
		int color = sc.nextInt();
		dfs(sRow,sCol, color);
		
		for(int i =0; i<N; i++) {
			for(int j= 0; j<N; ++j) {
				System.out.printf(Board[i][j]+ " ");
			}
			System.out.println();
		}
		
		
		
	}
	
	
	
	static void dfs(int r, int c, int color) {
		//방문 여부
		boolean[][] visited = new boolean[max_n][max_n];
		Stack<Point> mystack = new Stack<>();
		
		// 입력받은 위치값을 point객체 만들어서 스택에 push
		mystack.push(new Point(r,c));
		
		while(!mystack.empty()) {
			Point curr = mystack.pop();
			
			//방문한적 있으면 pass
			if(visited[curr.row][curr.col]) {
				continue;
			}
			//방문한적 없으면 true로 바꾼다
			visited[curr.row][curr.col] = true;
			Board[curr.row][curr.col] =color;
			
			
			for(int i =0;i <4; i++) {
				//새로운 행과 열의 위치를 만들기
				int nr = curr.row +D[i][0];
				int nc = curr.col  +D[i][1];
				
				
				if(nr<0 || nr > N-1 || nc <0 || nc>N-1) {
					continue;
				}
				//방문했으면 pass
				if(visited[nr][nc]) {
					continue;
				}
				
				if(Board[nr][nc] ==1) {
					continue;
				}
				// 새로운 행과열을push한다
				mystack.push(new Point(nr,nc));
			}
			
		}
		
		
	}
	
}
