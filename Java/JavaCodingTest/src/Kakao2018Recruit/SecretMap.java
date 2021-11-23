package Kakao2018Recruit;

import java.util.ArrayList;
import java.util.HashMap;
// 2018 카카오 blind recruitment 비밀지도
// 통과 1시간 20분
public class SecretMap {
	public static ArrayList<String> solution(int n, int[] arr1, int[] arr2) {
		ArrayList<String>answer = new ArrayList<>();
		// 들어오는 배열을 일단 이진수로 바꾸고 -> map으로 저장하기
		// 일단arr1 의 숫자를 2진수로 바꾸기
		String[] newarr1 = new String[n] ;
		String[] newarr2 = new String[n];
		
		for(int i= 0; i< arr1.length; i++) {
			// 이진수로 저장
			int a = arr1[i];
			//포맷을 자리수에 맞춰서 바꾸기 ->런타임 에러때문에 Long.parseLong으로 바꿈
			newarr1[i] = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(a).toString()));
			
		}
		
		for(int i= 0; i< arr1.length; i++) {
			int a  = arr2[i];
			newarr2[i] = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(a).toString()));
		}
		
		//map에 key, value 형식으로 저장시키기
		//value 에 이진수 한자리 넣기
		int k =0;
		HashMap<Integer, String> arr1Map = new HashMap<>(); 
		for( int i = 0; i<newarr1.length;i++ ) {
			for( int j= 0 ; j<n ; j++) {
				arr1Map.put(k, newarr1[i].substring(j,j+1));
				k++;
			}
		}
		
		int p= 0;
		HashMap<Integer, String> arr2Map = new HashMap<>(); 
		for( int i = 0; i<newarr2.length;i++ ) {
			for( int j= 0 ; j<n ; j++) {
				arr2Map.put(p, newarr2[i].substring(j,j+1));
				p++;
			}
		}
		
		// value 값 비교해서 하나라도 1이 있으면 #으로 저장
		for(int i=0; i <n*n ;) {
			String keys ="";
			
			for( int j= i; j< i+n ;j++) {
				String arr1val = arr1Map.get(j);
				String arr2val = arr2Map.get(j);
				if(arr1val.equals("1") || arr2val.equals("1")) {
					keys += "#";
				}else {
					keys +=" ";
				}
				
			}
			answer.add(keys);
			i+=n; // n자리수로 끊어서 저장시키기
			
		}
		
        
        return answer;
    }
	public static void main(String[] args) {
		int n =5;
		int[] arr1 = {9, 20, 28, 18, 20};
		int[] arr2 = {30, 1, 21, 17, 28};
		 System.out.println(solution(n,arr1,arr2));
		
	}
}
