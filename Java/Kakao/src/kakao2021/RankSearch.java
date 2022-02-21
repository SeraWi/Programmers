package kakao2021;

import java.util.*;

// 순위 검색
// 정확성 + 효율성!
// HashMap, Bit를 이용한 부분집합, 이진탐색(BinarySearch)
public class RankSearch {

	
	Map<String, Integer> Wordmap = new HashMap<>();
	List<List<Integer>> ScoreList = new ArrayList<>();


	public int[] solution(String[] info, String[] query) {

		Wordmap.put("-",0);
		Wordmap.put("cpp",1);
		Wordmap.put("java",2);
		Wordmap.put("python",3);
		Wordmap.put("backend",1);
		Wordmap.put("frontend",2);
		Wordmap.put("junior",1);
		Wordmap.put("senior",2);
		Wordmap.put("chicken",1);
		Wordmap.put("pizza",2);


		for( int i = 0; i<4*3*3*3 ; i++) {
			//108가지 경우의수
			ScoreList.add(new ArrayList<>());
		}
		// 지원자 정보 저장
		for(String str : info) {
			String[] word = str.split(" ");
			int[] arr = {
					Wordmap.get(word[0])*3*3*3,
					Wordmap.get(word[1])*3*3,
					Wordmap.get(word[2])*3,
					Wordmap.get(word[3])
			};
			int score = Integer.parseInt(word[4]);

			for( int i =0; i<(1<<4); ++i) {
				int idx = 0;
				for( int j = 0 ; j<4 ; ++j) {
					if((i &(1<<j)) != 0) {
						idx+=arr[j];
					}
				}
				// 지원자 한명의 정보당 16개의 경우의 수를 전부 넣어둠
				ScoreList.get(idx).add(score);
				
			}// 안쪽 for end
			
		}// 처음 for end
		
		for( int i = 0; i<4*3*3*3; ++i) {
			Collections.sort(ScoreList.get(i));
		}
		

		int[] answer = new int[query.length];
		
		//쿼리문
		for( int i = 0; i< query.length ; i++) {
			String[] word = query[i].split(" ");
			int idx = Wordmap.get(word[0]) *3 *3 *3 +
					Wordmap.get(word[2]) *3*3 +
					Wordmap.get(word[4]) *3+
					Wordmap.get(word[6]);
			int score = Integer.parseInt(word[7]);
			
			int ret = Collections.binarySearch(ScoreList.get(idx), score);
			if(ret < 0) {
				ret =-(ret + 1);
			}else {
				for ( int j = ret-1; j>=0; --j) {
					if(ScoreList.get(idx).get(j) == score) {
						ret = j;
					}else {
						break;
					}
				}
			}
			answer[i] = ScoreList.get(idx).size()- ret;
 		}
		return answer;
	}
}
