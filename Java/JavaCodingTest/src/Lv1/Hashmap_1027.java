package Lv1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Hashmap_1027 {

	public static void main(String[] args) {
		Map<String, String> map =new HashMap<>();
		//저장하기
		map.put("key1","value1");
		map.put("key2","value2");
		map.put("key3","value3");
		map.put("key4","value4");
		
		
		//entrySet
		for(Map.Entry<String, String> elem : map.entrySet()) {
			System.out.println("key: "+ elem.getKey()+", value: "+ elem.getValue() );
		}
		System.out.println("----------------------------------");
		//keySet
		for(String key : map.keySet()) {
			System.out.println("key: "+ key +", value: "+ map.get(key));
		}
		
		
		System.out.println("----------------------------------");
		//interator
		
		Iterator<String> keys = map.keySet().iterator();
		while(keys.hasNext()) {
			String key = keys.next();
			System.out.println("key: "+key + ",value: "+ map.get(key));
		}

	}






}
