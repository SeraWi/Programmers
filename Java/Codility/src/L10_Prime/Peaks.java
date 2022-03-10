package L10_Prime;

import java.util.ArrayList;
import java.util.List;

public class Peaks {


//O(N * log(log(N)))
	public int solution(int[] A) {
		
		//원소 3개 이하면 0
		if(A.length  < 3) {
			return 0;
		}
		//peaks 저장
		List<Integer> peaks = new ArrayList<>();

		for(int i= 1; i<A.length-1 ; i++) {
			if(A[i-1] < A[i]  && A[i+1] < A[i]) {
				peaks.add(i);
			}
		}


		if(peaks.size() == 0) {
			return 0;
		}

		// 3,5,10

		for( int blockLength = 3; blockLength<= A.length/2; blockLength ++ ) {
			
			// 나누어 떨어지지 않으면 pass하기
			if(A.length % blockLength != 0) {
				continue;
			}

			//everyblock에 peak이 있는지 확인

			int currentPeak = 0; //현재 peak
			
			boolean ok = true; //모든 block이 peak을 가지고 있는지 확인
			//블럭별로 검사한다.
			for( int blockStart =0 ; blockStart<A.length; blockStart+=blockLength) {
				boolean foundPeak = false;
				//구간내에 peak이 존재하는지

				while(currentPeak < peaks.size()) {
					if(peaks.get(currentPeak) < blockStart +blockLength) {
						foundPeak = true;
						currentPeak++;
					}else if(peaks.get(currentPeak) >= blockStart+blockLength){
						break;
					}
				}
				if(!foundPeak) {
					ok= false;
					break;
				}
			}
			
			if(ok) {
				return A.length / blockLength;
			}
		}
		return 1;
	}
	
	public static void main(String[] args) {
		System.out.println(new Peaks().solution(new int[] {1,2,3,4,3,4,1,2,3,4,6,2}));
	}

}
