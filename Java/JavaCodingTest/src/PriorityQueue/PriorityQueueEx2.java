package PriorityQueue;

import java.util.PriorityQueue;

public class PriorityQueueEx2 {
	public static void main(String[] args) {
		PriorityQueue<Person> pq = new PriorityQueue<>();
		pq.add(new Person("김민수",25));
		pq.add(new Person("이민아",30));
		pq.add(new Person("홍길동",27));
		pq.add(new Person("황진이",30));
		
		
		System.out.println("이름 :" +pq.peek().getName() +" 나이 : "+pq.poll().getAge());
		System.out.println("이름 :" +pq.peek().getName() +" 나이 : "+pq.poll().getAge());
		System.out.println("이름 :" +pq.peek().getName() +" 나이 : "+pq.poll().getAge());
		System.out.println("이름 :" +pq.peek().getName() +" 나이 : "+pq.poll().getAge());
		
//		이름 :김민수 나이 : 25
//		이름 :홍길동 나이 : 27
//		이름 :이민아 나이 : 30
//		이름 :황진이 나이 : 30
		
		
	}
}


class Person implements Comparable<Person>{
	private String name;
	private int age;
	//생성자
	Person(String name, int  time){
		this.name = name;
		this.age = time;

	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}




	@Override
	public int compareTo(Person person) {
		if(this.age == person.age) {
			//나이가 같으면 이름 비교
			return this.name.compareTo(person.name);
		}
		//나이 순으로 오름 차순 정렬
		return this.age - person.age;
	}
	
}
