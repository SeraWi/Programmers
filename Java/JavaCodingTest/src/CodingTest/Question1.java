package CodingTest;

import java.util.ArrayList;

public class Question1 {

	// 1. {}{} ()가 잘 닫혀있는지
	// 2. programmers 글자 2개 사이에 공간 몇개인지
	// 3. 경우의수를 이용하여 팀 조직할 수 있는 경우의 수 반환하기
	// 4. ?
	// 5. 너비 우선 탐색으로 정사각형으로 노드들 다 연결되어 있는지 확인하기.depth가 곧 return값
	// 6. BFS, DFS
	public static int programmerStrings(String s) {
		ArrayList<String> alphabet = new ArrayList<>();
		alphabet.add("p");alphabet.add("r");alphabet.add("o");
		alphabet.add("g");alphabet.add("r");alphabet.add("a");
		alphabet.add("m");alphabet.add("m");alphabet.add("e"); alphabet.add("r");
		System.out.println(alphabet.toString());

		ArrayList<String> sList = new ArrayList<>();

		//s를 어레이 리스트에 저장
		for( int i =0; i<s.length() ; i++) {
			sList.add(s.substring(i,i+1));
		}

		System.out.println(sList.toString());
		//programmer : p1, r3, o1, g1,a1,m2,e1 가 카운트 되면 programmer 글자 완성

		//progrmammer 글자 중 하나 있으면 list에서 삭제하고, 0이 될때까지 반복한다. 
		// 0이되는 순간의 index를 찾기
		int lastindex = 0;
		System.out.println(sList.size());
		// size가 0이 될때까지 반복한다.
		for(int i= 0; i<sList.size(); i++) {
			//글자 i가 programmer 중에 있는지 확인

			for( String alpha : alphabet) {
				if(sList.get(i).equals(alpha)){
					//  같은 경우 삭제 시키고  종료
					sList.remove(alpha);
				}
			} 
			lastindex++; 
			if(sList.size()== 0) {
				break;
			}
			
		}

		System.out.println(lastindex);

		ArrayList<String> alphabet2 = new ArrayList<>();
		alphabet2.add("p");alphabet2.add("r");alphabet2.add("o");
		alphabet2.add("g");alphabet2.add("r");alphabet2.add("a");
		alphabet2.add("m");alphabet2.add("m");alphabet2.add("e"); alphabet2.add("r");
		//뒤에서 부터 시행
		int firstIndex = 0;
		while(sList.size()>0) {
			for( int i= sList.size()-1; i>0; i--) {
				//글자를 뒤에서 부터 찾기
				for( String alpha : alphabet2) {
					if(sList.get(i).equals(alpha)) {
						sList.remove(sList.get(i));
						break;
					}
				}
				firstIndex++;
			}
		}
		return firstIndex-lastindex-1;
	}
	public static void main(String[] args) {
		int result = programmerStrings("progxrammerrxproxgrammer");
		System.out.println(result);
	}
}
