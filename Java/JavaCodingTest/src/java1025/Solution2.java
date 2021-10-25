package java1025;

import java.util.Arrays;
// 참고코드
class Solution2 {
    public int[] solution(int[] array, int[][] commands) {
    	// commands객체 길이 구하기
    	int[] answer = new int[commands.length];
        
        
        // 자바 배열 복사하기
        // Arrays.copyOf(배열원본, 복사할길이)
        // Arrays.copyOfRange(배열 원본, 시작 인덱스, 마지막 인덱스)
        // 마지막 인덱스는 포함되지 않고 그 앞에까지 저장된다.
        //commands배열 길이 == answer의 갯수
        for(int i=0; i<commands.length; i++){
        	// 시작인덱스부터 마지막인덱스 배열 복사하기
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            //복사한 배열 오름차순정렬하기
            Arrays.sort(temp);
            //정렬후에 뽑는 숫자 answer에 저장하기
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}

