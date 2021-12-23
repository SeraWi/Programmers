package DFSandBFS;

import java.util.Scanner;

public class DFS_Matrix {
	// 그래프 탐색의 한 종류
	// 깊이 우선 탐색
	// stack사용
	// 정점vertex, 간선 edge

	// 구현방법1 )인접행렬, adjency matrix
	// 행렬로 정점들 사이의 관계를 표현하는 것
	// 구현방법2) 인접리스트
	// 리스트 방식으로 각 정점이 연결된 노드들의 정보를 저장함. 간선방향의 존재 유무에 따라
	// 출발지 도착지를 고려하여 리스트에 정보를 저장함
	
	
	static int edge;
	static int vertex;
	static int[][]map;//map : 정점간의 연결의 정보를 담는 객체
	static boolean[] visit;//visit : 정점을 방문했는지 체크하기 위한 객체
	
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		vertex = sc.nextInt();
		System.out.println(vertex);
		edge = sc.nextInt();
		map = new int[vertex+1][vertex+1];
		visit = new boolean[vertex+1];

		for( int i =0; i<edge; i++) {
			int start = sc.nextInt();
			int next = sc.nextInt();

			map[start][next] =1;
			map[next][start] =1;

		}
		dfs(1);

	}


	public static void dfs(int start) {
		visit[start] = true;
		System.out.println(start + " ");

		for( int i=1; i<vertex+1; i++) {
			if(map[start][i] ==1 && visit[i]== false) {
				dfs(i);		
			}
		}
	}
}
