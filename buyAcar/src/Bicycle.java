
public class Bicycle extends Vehicle {

	public Bicycle() {
		
	}
	
	public Bicycle(Integer price, String model) {
		this.price = price;
		this.model = model;
	}
	@Override
	public String toString() {
		return "Bicycle --" + super.toString();
	}
	
	/*
	public static void main(String [] args) {
		Bicycle b = new Bicycle(1500, "tesla");
		
		System.out.println(b.toString());
	}
	*/
	
}
