package StackAndQueue;

public class Eg {
	
	public static void main(String[] args) {
		Egg normal = new Egg();
		normal.make();
		
		MyEgg my = new MyEgg();
		my.make();
		
		// 다형성의 원리를 말하고 싶은걸까?
		// 어떤 계란을 주던 상위타입은 Egg로 받고 make()메서드를 실행하면, 그 egg의 주체에 따라 결과가 달라진다.
		Egg my2 = new MyEgg();
		my2.make(); //상위 타입으로 받아도 결국 계란 후라이를 만들 수 있다.
		
		Egg your = new YourEgg();
		your.make();
		
	}
}

class Egg{
	
	
	public Egg() {
	
	}
	
	public void make() {
		System.out.println("후라이를 만든다");
	}
	
}

class MyEgg extends Egg{

	public MyEgg() {};
	
	
	@Override
	public void make() {
		System.out.println("내가 주는 계란으로 계란 후라이를 만든다");
	}
	
}
class YourEgg extends Egg{
	public YourEgg() {};
	
}