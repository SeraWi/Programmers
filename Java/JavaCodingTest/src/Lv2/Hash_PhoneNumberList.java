package Lv2;
//전화번로 목록
//전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
//전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 
//어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 
//solution 함수를 작성해주세요.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class Hash_PhoneNumberList {

	//정확성 100 효율성 0
	//phone_book의 길이는 1 이상 1,000,000 이하입니다.
	public static boolean solution(String[] phone_book) {
		boolean answer = true;


		for( int i = 0; i< phone_book.length; i++) {
			for( int  j=0; j<phone_book.length; j++) {

				String currentNum = phone_book[i];
				if( i != j) {
					// 현재 숫자가 접두사인지 확인하기
					if(phone_book[j].startsWith(currentNum)) {
						answer = false;
						break;
					}
				}
			}
		}



		return answer;
	}

	//효율성 0
	public static boolean solution2(String[] phone_book) {
		boolean answer = true;

		//map 에 넣어서 해보기
		HashMap<Integer, String> map = new HashMap<>();

		for( int i= 0; i<phone_book.length; i++) {
			//정하기
			map.put(i, phone_book[i]);
		}

		for(Entry<Integer, String> elem : map.entrySet()) {
			//System.out.println("key: "+ elem.getKey()+", value: "+ elem.getValue() );
			String currentVal = elem.getValue();
			int currentKey = elem.getKey();

			for(Entry<Integer, String>  compareElem : map.entrySet()) {

				if( currentKey != compareElem.getKey()) {

					if(compareElem.getValue().startsWith(currentVal)) {
						answer = false;
						break;
					}
				}
			}

		}


		return answer;
	}
	public static boolean solution3(String[] phone_book) {
		boolean answer = true;
		HashMap<String, Integer> map = new HashMap<>();

		//map에 넣기
		for( int i= 0; i<phone_book.length; i++) {
			//정하기
			map.put(phone_book[i],i);
		}

		for(int i= 0; i<phone_book.length; i++) {
			
			// 기준이 되는 전화번호의 기준
			for ( int j= 0; j<phone_book[i].length() ; j++) {
				if(map.containsKey(phone_book[i].substring(0, j))) {
					answer = false;
				}
			}
		}




		return answer;
	}
	
	//참고 코드
	
	public boolean solution4(String[]phonebook) {
		Arrays.sort(phonebook);
		
		boolean result = false;
		
		
		for ( int i = 0; i<phonebook.length-1; i++) {
			
			// 1과 0 비교 
			// 2와 1을 비교
			if(phonebook[i+1].startsWith(phonebook[i])) {
				result= false;
				break;
			}
		}
		
		return result;
		
	}
	public static void main(String[] args) {
		String [] phone = {"119", "97674223", "1195524421"};
		System.out.println(solution3(phone));
	}

}
