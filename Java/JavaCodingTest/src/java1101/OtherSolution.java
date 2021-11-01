package java1101;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class OtherSolution {
	// 다른 깔끔한 풀이 1)
	public int solution(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.collectingAndThen(Collectors.toSet(),
                        phonekemons -> Integer.min(phonekemons.size(), nums.length / 2)));
    }
	
	
	// 2) set 이용
	public int solution2(int[] nums) {
		Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        return nums.length/2<set.size()?nums.length/2:set.size();
    }
	
}
