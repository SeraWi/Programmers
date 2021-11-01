package java1101;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class OtherSolution {
	// 다른 풀이 1)...?
	public int solution(int[] nums) {
		
		
		// stream : 배열 또는 컬렉션 인스턴스에 함수 여러개를 조합해서 원하는 결과를 필터링하고 가공된 결과를 얻을 수 있다.
		//Arrays.stream() :  스트림 생성
		
		
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.collectingAndThen(Collectors.toSet(),
                        phonekemons -> Integer.min(phonekemons.size(), nums.length / 2)));
    }
	
	
	// 2) set 이용
	public int solution2(int[] nums) {
		//set : 중복 허용 x
		Set<Integer> set = new HashSet<>();
        for (int i : nums) {
        	
            set.add(i);
        }
        
        //삼항 연산자
        //                  set사이즈가 크다? nums 갯수 /2 반환 : 아니면 set사이즈 반환
        return nums.length/2<set.size()?nums.length/2:set.size();
    }
	
}
