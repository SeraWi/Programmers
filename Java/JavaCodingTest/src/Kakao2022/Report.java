package Kakao2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

// 정답 통과
public class Report {
	//Level1 : 신고 결과 받기
	//id_list :이용자 ID가 담긴 문자열 배열 2 ≤ id_list의 길이 ≤ 1,000
	//report : 각 이용자가 신고한 이용자이 ID정보
	// k :정지 기준 신고 횟수
	// 각 유저별러 처리 결과 메일을 받은 횟수를 배열에 담아 return


	public static List<Integer> solution(String[] id_list, String[] report, int k) {
		List<Integer> answer = new ArrayList<>();


		// 중복 제거를 위해 report 를 set에 넣음
		HashSet<String> hashSet = new HashSet<>(Arrays.asList(report));

		// 정지된 Id + 횟수를 담는 map (정지맵)
		Map<String, Integer> reportMap = new Hashtable<>();
		// 누가 누구를신고했는지 저장 (신고맵)id_list 순서대로 저장 위해 linedhashmap사용
		Map<String, String> reMap = new LinkedHashMap<>();
		
		for(String id : id_list) {
			reportMap.put(id, 0); //기본 맵에 정지횟수 0번으로 셋팅
			reMap.put(id,""); // 신고맵에 ""로 기본 세팅
		}


		for( String reports : hashSet) {
			String[] re = reports.split(" "); // 앞에는 신고자, 뒤에는 신고대상
			// 신고 받은 사람의 정지 횟수 올려주기
			reportMap.put(re[1], reportMap.get(re[1])+1);
			
			// 누가 누구를 신고했는지 확인 하기 위해
			//     muzi     frodo appeach neo (공백을 두고 신고대상 늘려서 쓰기)
			if(reMap.get(re[0])!= null) {
				// 이미 존재하면, 존재하는 value에 + 새로운 신고한놈 문자열 붙여서 put
				reMap.put(re[0], reMap.get(re[0]) +" "+ re[1]);
			}else {
				reMap.put(re[0],re[1]);
			}

		}

		//k번 이상 신고된 놈들의 list (정지 확정!)
		ArrayList<String> arr = new ArrayList<>();

		for(Entry<String, Integer> entrySet : reportMap.entrySet()) {
			if(entrySet.getValue()>=k) {
				//key 값을 arr에 넣기
				arr.add(entrySet.getKey());
			}
		}

		// 정지확정된 user와 user가 신고한 사람들 비교해서 -> answer에 메일 받게되는 횟수 담기
		for(Entry<String, String> entrySet : reMap.entrySet()) {
			System.out.println(entrySet.getKey()+": "+entrySet.getValue());
			
			int count = 0;
			String[] values = entrySet.getValue().split(" ");
			
			for(String val : values) {
				if(arr.contains(val)) {
					count++;
				}
			}
			answer.add(count);
			
		}


		return answer;
	}

	public static void main(String[] args) {
		String[]id_list= {"muzi", "frodo", "apeach", "neo"};
		String[] report ={"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k= 2;

		System.out.println(solution(id_list, report, k));
		

	}
}
