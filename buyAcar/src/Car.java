
public class Car extends Vehicle {

	private Integer mileage;
	
	public Car() {
		
	}
	
	public Car(Integer i, String s, Integer d) {
		this.price = i;
		this.model = s;
		this.mileage = d;
	}
	
	@Override
	public String toString() {
		return "Car --mileanage:" + this.mileage + ", " + super.toString();
	}
	
	/*
	public static void main(String[] args) {
		Car c = new Car(1000,"Tesla",155);
		System.out.println(c.toString());
	}
	*/

}
