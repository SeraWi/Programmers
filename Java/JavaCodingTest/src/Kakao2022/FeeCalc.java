package Kakao2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


// . 차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 정수 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
public class FeeCalc {


	static int basicTime; 
	static int basicFee;
	static int unitTime;
	static int unitFee;

	//시간 계산 -> 차량 요금 계산
	public int totalFee(ArrayList<String> records) {
		int fee =0;
		
		if(records.size() %2 == 1) {
			// 홀수면 마지막 OUT이 없음
			records.add("23:59"); //추가해주기
		}
		
		int totalStayTime = 0;
		
		for( int i =1; i<records.size();) {
			String out = records.get(i);
			String[] outSplit = out.split(":"); // OUt
			String [] inSplit = records.get(i-1).split(":"); //IN
			
			int outHour = Integer.parseInt(outSplit[0]);
			int outMin = Integer.parseInt(outSplit[1]);
			int inHour = Integer.parseInt(inSplit[0]);
			int inMin = Integer.parseInt(inSplit[1]);
			
			totalStayTime += outHour * 60+ outMin - inHour * 60 - inMin;
			i+=2;
		}
		
		// 주차 요금 계산
		// 기본 요금  + 추가요금
		
		if(totalStayTime <= basicTime) {
			fee = basicFee;
		}else {
			fee = basicFee + (int) Math.ceil((totalStayTime-basicTime)/ unitTime) * unitFee;
		}
		
		
		return fee;
	}
	
	public int[] solution(int[] fees, String[] records) {
		// fees : 기본시간, 기본요금, 단위시간, 단위요금 
		// records : 시각, 차량번호, 내역

		// fees 세팅
		basicTime = fees[0];
		basicFee = fees[1];
		unitTime = fees[2];
		unitFee = fees[3];

		int[] answer = {};


		// records 를  Map에 저장
		Map<Integer, ArrayList<String>> recordsMap = new HashMap<>();
		//  차량 번호 , 			시각 String 으로 저장

		for( String r : records) {
			String[] rSplit = r.split(" ");
			// "05:34 5961 IN"
			// 차량 번호
			int carNum = Integer.parseInt(rSplit[1]);
			ArrayList<String> list = new ArrayList<>();

			// 존재하면
			if(recordsMap.containsKey(carNum)) {
				// 이미 존재하면 기존에 ArrayList에 새로운 값 넣어주면 된다.
				list = recordsMap.get(carNum);
				list.add(rSplit[2]);
				// 덮어쓰기
				recordsMap.put(carNum, list);

			}else {
				// 존재하지 않으면
				list.add(rSplit[2]);
				recordsMap.put( carNum, list);
			}

		}
		
		// Map의 key(차량 번호) 오름 차순으로 정렬하기
		
		
		// 차량 번호에 해당하는 차량 fee 구하기
		

		return answer;
	}
}





class Record{
	int hourIn;
	int minuteIn;
	int hourOut;
	int minuteOut;

	public Record(int hourIn, int minuteIn, int carNum) {
		super();
		this.hourIn = hourIn;
		this.minuteIn = minuteIn;
		this.hourOut = 23; // 기본 세팅
		this.minuteOut = 59; // 기본 세팅
	}
	public int totalStay() {
		int in = hourIn * 60 + minuteIn;
		int out = hourOut * 60 + minuteOut;
		return out-in;
	}


}
