package L4_CountingElement;

import java.util.Arrays;

//O(N) or O(N * log(N))
public class PermCheck {
	
	public int solution(int[] A) {
        // write your code in Java SE 8
		int answer = 1;
		
		boolean[] contains =new boolean[A.length+1];
		
		for( int i = 0; i<A.length; i++) {
			int number = A[i];
			
			if(number <= A.length && !contains[number]) {
				// 해당 값을 인덱스로해서 true 넣기
				contains[number] =true;
			}
		}
		
		for(int i= 1;i <contains.length ;i++) {
			//false 인경우 permutation 이 아님
			if(!contains[i]) {
				return 0;
			}
		}
		
		
		return answer;
    }
	
	//O(N) or O(N * log(N))
	// 내풀이 - 통과 O(N)
	public int solution2(int[] A) {
        // write your code in Java SE 8
        //permutaion이면 1return , 아니면 0return

        //A오름 차순 정렬한뒤 인덱스와 비교하기
        //인덱스 +1 = A원소값 
        // 아닌경우 0바로 리턴


        //A 정렬
        Arrays.sort(A);

        for( int i= 0; i<A.length ; i++){

            if(i+1 == A[i]){
                //같다면 pass
                continue;
            }else{
                //다르면 permutation아님
                return 0;
            }
        }
        //for문 break되지 않고 통과하면 1
        return 1;
    }
	
	
	public static void main(String[] args) {
		
		
	}
}
