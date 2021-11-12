package p06.Class;

class Car{}

public class ClassExample {
//? : ? extends Car - Car, Car자식 클래스가 물음표에 해당이 된다 
	public static void main(String[] args) {
		
		Car c = new Car();
		Class<?> clazz1 = c.getClass();
		
		System.out.println(clazz1.getName()); //car라는 클래스에 이름을 추가
		
		
		try {
			Class<?> clazz2 = Class.forName("p06.Class.Car");
			System.out.println(clazz2.getName());
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
		

	}

}
