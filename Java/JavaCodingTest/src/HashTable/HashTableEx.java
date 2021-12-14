package HashTable;

public class HashTableEx {
	public static void main(String[] args) {
		String name ="세라";
		String name2 ="세라";
		String name4 = name;
		String name3 ="세";
		
		
		System.out.println(name.hashCode());
		System.out.println(name2.hashCode());
		System.out.println(name3.hashCode());
		//1580356
		//1580356
		
	
		
		System.out.println(name.equals(name2));
	}
}
