package javaIterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class IteratorEx {
	
	//iterator란 자바 컬렉션 프레임웍에서 컬렉션에 저장된어 있는 요소들을 읽어오는 방법을 표준화한 것
	// 주로 읽기 전용으로 사용, list와 set에서 구현, map에는 없다
	//iterator 인터페이스 안에는 주요 3 메서드가 있다
	// boolean hasNext() : 읽어올 요소가 남아있는지 확인하는 메서드, 있으면 true
	// Object next(): 요소 반환
	// void remove() : next()로 불러온 요소를 삭제 즉 next()호출후에 remove()호출해야
	
	
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("사과");
		list.add("바나나");
		list.add("포도");
		list.add("파인애플");
		list.add("복숭아");
		
		
		System.out.println(list);//[사과, 바나나, 포도, 파인애플, 복숭아]
		
		//list에 데이터를 담고 반복을 돌리자
		
		// 1.for문
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
			
		//2. for each
		for(String str: list) {
			System.out.println(str);
		}
		
		System.out.println("3");
		//3. Iterator
		Iterator<String> itr = list.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
		//map에서 iterator사용하기
		
		HashMap<String,String>map = new HashMap<String,String>();
		map.put("one", "하나");
		map.put("two", "둘");
		map.put("three", "셋");
		map.put("four", "넷");
		
		//keySet ->iterator사용하기
		Set<String> keys = map.keySet();
		Iterator<String> itr2 = keys.iterator();
		while(itr2.hasNext()) {
			String key = itr2.next();
			System.out.println(key);
		}
		
		//iterator사용하지 않고 더 간단히 ->for each
		for(String key: map.keySet()) {
			System.out.println(key);
		}
		
		
		
	}
}
