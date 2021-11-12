package java1110;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
// 테스트 케이스 모두 통과
// 효율성 테스트 : 시간 초과  -->Priory Queue 로 해결해야
public class MySolution {
	//Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때, 
	//모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
	// 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
	// 스코빌 지수 확인 함수
	public static boolean scovillechk(ArrayList<Integer> scovilleList, int K) {
		boolean chk = true;
		
		Iterator it = scovilleList.iterator();
		while(it.hasNext()) {
			int value = (int) it.next();
			if(value < K) {
				//k 이하인 경우 false return
				chk = false;
				break;
			}
		}
		return chk;
	}
	
	public static int solution(int[] scoville, int K) {
		// scoville : 스코빌 지수 
		// k : 원하는 스코빌 지수
		// 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
		// 모든 음식 k 이상!!!
		
        int answer = 0;

		// scoville 오름 차순 정렬
		Arrays.sort(scoville);
		
		// scoville 을 arrayList 로 변환
		ArrayList<Integer> scovilleList = new ArrayList<>();
		for(int temp: scoville) {
			scovilleList.add(temp);
		}
		
		// 섞은 음식의 스코빌 지수 
		int newSco;
		
		// scoville 안에 하나라도 k이하인게 있는지 확인
		while(!scovillechk(scovilleList,K)) {
			// fasle : 안에 k이하 있으면
			// 음식 섞기 0+1
			// 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
			
			if(scovilleList.size()>1) {
				newSco = scovilleList.get(0) + (scovilleList.get(1) *2);
				
				//System.out.println(newSco);
				// 섞은 음식 scovilleList 에 다시 대입
				// index 0, 1삭제
				scovilleList.remove(0); // 0번지 삭제하면 그뒤에거 0번지 된다
				scovilleList.remove(0);
				scovilleList.add(0,newSco); // 새 스코빌 지수 0번지에 add
				
				// 다시 scovilleList 오름 차순정렬 시키기
				Collections.sort(scovilleList);
				//섞은뒤 answer++
				newSco = 0;
				answer++;
			}else {
				// 현재 다 섞었다!!-> arrayList 에 인자가 하나뿐
				// 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다. (마지막에 간과함)
				answer = -1;
				break;
			}
			
			
		}
		
			
        return answer;
    }
	
	
	public static void main(String[] args) {
		
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		System.out.println(solution(scoville,K));
	}

}
