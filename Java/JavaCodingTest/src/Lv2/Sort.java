package Lv2;

import java.util.Arrays;
import java.util.Comparator;

public class Sort {
	// 정렬 , 가장 큰 수를 구하기
	// comparable, comparator
	
	public static String solution(int[] numbers) {
        String answer = "";
        
        String[]numString = new String[numbers.length];
        
        for ( int i= 0; i<numbers.length; i++) {
        	numString[i]= String.valueOf(numbers[i]);
        }
        
        //비교하기
        Comparator<String> comp1 = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// 리턴값이 0 또는 음수이면 자리가 그대로 유지된다.
				// 양수이면  두 객체의 자리가 바뀐다.
				return (o2+o1).compareTo(o1+o2);
			}
        };
        
        //정렬시키기
        Arrays.sort(numString, comp1);
//        Arrays.sort(numString, new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//        	
//        	
//        });
        //가장 첫번째가 0일 경우 -> 뒤에도 다 0 이기 때문에  000000상황 발생
        // 따라서 00000 일 경우 ->0 반환
        if(numString[0].equals("0")) {
        	return "0";
        }else {
        	for( int j=0; j<numString.length; j++) {
        		answer += numString[j];
        	}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		//int[] numbers = {6,10,2};
		int[] numbers= {3, 30, 34, 5, 9};
		
		System.out.println(solution(numbers));
	}
}
