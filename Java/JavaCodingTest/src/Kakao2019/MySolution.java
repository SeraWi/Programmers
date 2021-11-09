package Kakao2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

// 2019 KakaoBlindRecruitment
// 실패율: 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
// 통과!!!
// 전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때, 
// 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.
public class MySolution {
	public static ArrayList solution(int N, int[] stages) {
		// n: 전체 스테이지 갯수
		// stages  :게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호

		// 전체 참가자 수 : stages.length
		// 스테이지 클리어 했을 때 : n+1

		// stages 오름차순으로 정렬
		Arrays.sort(stages);
		// 단계에 머물러 있는 사람수 cnt
		int stageCnt =0;
		// stageCnt를 담는 배열( 스테이지별 머물러 있는 사람 수 저장)
		ArrayList<Integer> stageCntarr = new ArrayList<>();
		// index 0에 임의로 0저장
		stageCntarr.add(0);

		
		
		// 실패율을 담는 arrayList
		//ArrayList<Double> failrate = new ArrayList<>();	
		
		// 실패율 HashMap 으로 만들기 (단계, 실패율)으로 저장
		Map<Integer,Double> hashmap = new HashMap<>();

		// 실패율 갯수는 n과 같다

		for(int i=1; i<N+1; i++) {
			// 단계 별로 몇명이 머물러 있는지 실패율 계산

			for(int participate : stages) {
				if(participate == i) {
					stageCnt ++;
				}
			}
			//한단계 끝나면 stageCnt 저장
			stageCntarr.add(stageCnt);

			//실패율 계산
			//이 단계에서 실패한사람 / 전체 첨가자수 - 전단계 탈락자 수 *100
			//System.out.println(stageCntarr.get(i-1));
			//System.out.println( i+"단계"+stageCnt);
			// total : 전단계까지의 탈락자 수 총합산
			int total = 0;
			for(int k = 0; k<i; k++) {
				total += stageCntarr.get(k);
			}
			//System.out.println(total +"이전 단계 까지탈락자");
			//System.out.println(stageCnt +"나누기" +(stages.length-total));
			//failrate.add((stageCnt/ (double) (stages.length-total)));
			if(stages.length-total==0){
				// 참가자 전체 1단계에서 탈락하면 
				// 나누기 0으로 할 경우 -> 실패율 0으로 만들기
				hashmap.put(i,0.0);
			}else {
				hashmap.put(i,(stageCnt/ (double) (stages.length-total)));
			}
			
			// 초기화
			stageCnt =0;

		}
		
		// value값 기준으로 내림차순
		
		//System.out.println(hashmap);
		// Map.Entry 리스트
		List<Entry<Integer,Double>> entryList = new ArrayList<Entry<Integer,Double>>(hashmap.entrySet());
		
		//comparator를 사용하여 정렬
		Collections.sort(entryList,new Comparator<Entry<Integer,Double>>(){
			public int compare(Entry<Integer,Double>obj1, Entry<Integer,Double> obj2) {
				// 내림차순 정렬
			 return obj2.getValue().compareTo(obj1.getValue());
			}
		});
		
		// 출력
//		for(Entry<Integer,Double> entry: entryList ) {
//			System.out.println(entry.getKey() +":"+ entry.getValue());
//		}
		System.out.println(entryList);
		
		// answer에 key값만 저장
		ArrayList <Integer> answer = new ArrayList<>();
		
		for(Entry<Integer, Double> entry: entryList) {
			answer.add(entry.getKey());
		}
		
				
		return answer;
	}
	
	public static void main(String[] args) {
		int N = 4;
		//int[] stages= {4,4,4,4,4};
		//int[] stages= {2, 1, 2, 6, 2, 4, 3, 3};
		int[] stages = {1,1,1,1,1,1,1,1,1}; // 1단계 제외 다른 단계 실패율 null
		
		System.out.println(solution(N, stages));
	}
}
