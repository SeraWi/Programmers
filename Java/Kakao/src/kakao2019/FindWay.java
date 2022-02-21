package kakao2019;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FindWay {
	class Node{
		int id;
		int x, y;
		Node left;
		Node right;
		Node (int id, int x, int y){
			this.id = id;
			this.x = x;
			this.y =y;
		}

	}
	
	int idx;
	List<Node> Nodes =new ArrayList<>();
	
	Comparator<Node> Comp = new Comparator<Node>() {
		public int compare(Node a, Node b) {
			if(a.y == b.y) {
				// y가 같으면 x가 작은거를 왼쪽으로
				return a.x - b.x;
			}
			// y 큰 순서대로 정렬
			return b.y - a.y;
		}
	};
	
	void preorder(int[][] answer, Node node) {
		if(node == null) {
			return;
		}
		
		answer[0][idx++] = node.id;
		preorder(answer, node.left);
		preorder(answer, node.right);
	}
	
	void postorder(int[][]answer, Node node) {
		if(node == null) {
			return;
		}
		postorder(answer, node.left);
		postorder(answer, node.right);
		answer[1][idx++] = node.id;
	}
	
	void addNode(Node parent, Node child) {
		if(child.x < parent.x) {
			if(parent.left == null) {
				parent.left = child; //child 노드를 왼쪽에 저장
			}else{
				// 왼쪽 child node 이미 존재
				addNode(parent.left, child); 
			}
		}else {
			//큰경우
			if(parent.right == null) {
				parent.right = child;
			}else {
				addNode(parent.right, child);
			}
		}
	}

	public int [][] solution(int [][] nodeinfo){
		

		int size = nodeinfo.length;

		for( int i= 0;i <size ; ++i) {
			//					노드번호, 	x좌표, y좌표
			Nodes.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]));
		}
		
		Nodes.sort(Comp);//정렬하기
		
		// 노드 만들기
		// 리스트에서 제일 첫번째(idx = 0)가 root
		Node root = Nodes.get(0);
		for( int i = 1; i<size ; ++i) {
			addNode(root, Nodes.get(i));
		}
		
		int[][] answer = new int[2][size];
		preorder(answer, root);
		postorder(answer, root);
		
		return answer;
	}
	public static void main(String[] args) {
		int[][] nodeinfo = {
				{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}
		};
	}
}

