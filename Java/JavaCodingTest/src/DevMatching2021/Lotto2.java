package DevMatching2021;

import java.util.HashMap;
import java.util.Map;

public class Lotto2 {	
	public int[] solution(int[]lottos, int[]win_nums) {
		
		
		
		int zero =0;//0의 갯수 count
		int matched =0; // 맞춘 개수 count
		
		for( int i: lottos) {
			if(i == 0) {
				zero++;
			}
			
			for(int j: win_nums) {
				if(i==j) {
					matched++;
				}
			}
		}
		
		
		int min = matched;
		int max = matched+zero;
		
		// Math.min(a, b) : a와 b중 작은 수를 return 한다
		int[] answer = {Math.min(7-max, 6), Math.min(7-min,6)};

		return answer;
	}
	
	
	public int[] solution2(int[] lottos, int[] win_nums) {
		
		
		Map<Integer,Boolean> map = new HashMap<Integer,Boolean>();
		
		int zeroCount =0;
		
		for( int lotto: lottos) {
			if(lotto == 0) {
				zeroCount ++;
				continue;
				
			}
			//0이 아닌 경우 map에 담는다
			map.put(lotto, true);
		}
		
		int sameCount =0; // 맞춘갯수
		
		for(int winNum : win_nums) {
			if(map.containsKey(winNum)) {
				sameCount++;
			}
		}
		int maxRank = 7-(sameCount+ zeroCount);
		int minRank = 7-sameCount;
		if(maxRank > 6) {
			maxRank = 6;
		}
		if(minRank > 6) {
			minRank =6;
		}
		
		
		return new int[] {maxRank, minRank};
	}

}
