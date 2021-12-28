package DFSandBFS;

import java.util.Scanner;
import java.util.Stack;

public class DFS_Stack {
		
	static final int max_n =10;
	static int N,E;
	static int[][]Graph = new int[max_n][max_n];
	
	static void dfs(int node) {
		boolean[]visited = new boolean[max_n];
		Stack<Integer> mystack = new Stack<>();
		mystack.push(node);
		
		
		while(!mystack.empty()) {
			//제일 위에 숫자 꺼내기 - 마지막에 집어넣은 연결된 노드가 튀어나온다
			int curr = mystack.pop();
			// 방분표시하기			
			visited[curr] = true;
			
			System.out.println(curr + " ");
			
			// N: 노드 갯수
			for( int next =0 ; next<N; ++next) {
				if(!visited[next] && Graph[curr][next]!=0) {
					// 방문하지 않았거나,  선 연결된 노드 push로 넣기
					mystack.push(next);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("node갯수를 입력하세요");
		
		N = sc.nextInt(); // 5
		System.out.println("edge갯수를 입력하세요");
		E=sc.nextInt(); //6
		
		//				엣지 갯수만큼
		for(int i = 0; i<E; i++) { //01 02 13 14 24 34
			System.out.println(i+"번쨰 엣지의 관계를 쓰세요");
			int u = sc.nextInt();
			int v = sc.nextInt();
			Graph[u][v] = Graph[v][u] =1;
		}
		//0부터 호출
		dfs(0);
	}
	
	

}
