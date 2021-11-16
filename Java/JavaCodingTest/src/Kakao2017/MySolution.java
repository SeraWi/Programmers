package Kakao2017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

// 2017 카카오코드본선
//첫 번째 글자와 세 번째 글자는 다음 8개 중 하나이다. {A, C, F, J, M, N, R, T} 
//각각 어피치, 콘, 프로도, 제이지, 무지, 네오, 라이언, 튜브를 의미한다. 
//첫 번째 글자는 조건을 제시한 프렌즈, 세 번째 글자는 상대방이다. 첫 번째 글자와 세 번째 글자는 항상 다르다.
//두 번째 글자는 항상 ~이다.
//네 번째 글자는 다음 3개 중 하나이다. {=, <, >} 각각 같음, 미만, 초과를 의미한다.
//다섯 번째 글자는 0 이상 6 이하의 정수의 문자형이며, 조건에 제시되는 간격을 의미한다. 
//이때 간격은 두 프렌즈 사이에 있는 다른 프렌즈의 수이다.
public class MySolution {
	static String[]members = {"A","C","F","J","M","N","R","T"};
	static ArrayList<String> membersPerm;


	public static int solution(int n, String[] data) {
		
		// n : 조건의 갯수
		// data : 조건
		// 배열을 arrayList 로 바꾸기
		// data 에 있는 String 조건을 자르기
		// 자른 글자와 현재 정렬에서 글자의 index 찾아서 거리를 절댓값으로 구해서
		// 조건과 비교하고
		// 조건에 맞으면 +1, 틀리면 넘어가기!
		
		//System.out.println(data[0]);
		//System.out.println(data[1]);

		// 사람은 A,C,F,J,M,N,R,T
		// 총 정렬 가능한 갯수?  8! = 40320
		membersPerm = new ArrayList();
		perm(members,0,8,8);
		//System.out.println(membersPerm.size()); //40320
		// 전체 경우의 수
		//		for(String arr : membersPerm) {
		//			System.out.println(arr);
		//		}
		int answer = 40320;
		
		for(int i = 0; i<membersPerm.size(); i++) {

			for(int j =0;  j<n; j++) {
				String My = data[j].substring(0,1);
				String You = data[j].substring(2,3);	
				String compare = data[j].substring(3,4);
				int distance = Integer.parseInt(data[j].substring(4,5));
				//System.out.println(distance);
//				System.out.println(My);
//				System.out.println(You);
//				System.out.println(compare);
//				System.out.println(distance);
				
				// membersPerm 에서 문자 추출해서 거리의 절댓값 구하기
				int realDis = Math.abs(membersPerm.get(i).indexOf(My) - membersPerm.get(i).indexOf(You));
//				System.out.println(distance);
//				System.out.println(realDis);
//				System.out.println(compare);
				
				switch(compare) {
				case ">" : 
					if(realDis > distance ) {
						break;
					} else {
						answer -=1;
						break;
					}
					
				case "=":
					if(realDis == distance) {
						break;
					}else {
						answer -=1;
						break;
					}
					
				case "<":
					if(realDis < distance) {
						break;
					}else {
						answer -=1;
						break;
					}
					
				}
//				if(compare.equals(">") && realDis> distance) {
//					//System.out.println(realDis +">"+ distance);
//					
//				
//				}else if(compare.equals("=") && realDis == distance) {
//					//System.out.println(realDis +"=="+ distance);
//					break;
//				}else if(compare.equals("<") && realDis < distance){
//					//System.out.println(realDis +"<"+ distance);
//					break;
//				} else {
//					// 단 한 번이라도 조건을 만족하지 못함 -> 전체 갯수에서 빼기!, for문 종료
//					//System.out.println("break");
//					
//					
//				}
				
			}// for 문 종료
			
		}

		return answer;
	}

	public static void perm(String[] members, int depth, int n, int r) {
		if(depth ==r) {
			//System.out.println(print(members,r));
			// arrayList에 저장
			membersPerm.add(print(members,r));
			return;
		}

		for(int i= depth; i<n; i++) {
			swap(members, i,depth);
			perm(members,depth+1,n,r);
			swap(members,i,depth);
		}
	}

	private static void swap(String [] arr, int i, int j) {
		// 순서 바꾸기
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] =temp;
	}

	static String print(String[] arr, int r) {
		String combi = "";
		for(int i=0; i<r; i++) {
			//System.out.print(arr[i] + "");
			combi +=arr[i];
		}
		//System.out.println();
		//System.out.println(combi);
		return combi;

	}
	public static void main(String[] args) {
		int n = 2;
		String [] data = {"N~F=0","R~T>2"};
		System.out.println(solution(n,data));
	}
}
