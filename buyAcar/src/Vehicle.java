
public class Vehicle {

	protected Integer price;
	protected String model;
	
	public Vehicle() {
		
	}
	
	public Vehicle(Integer i, String s) {
		this.price = i;
		this.model = s;
	}
	
	public Integer getPrice() {
		return this.price;
	}

	public String getModel() {
		return this.model;
	}
	
	public void setPrice(Integer i) {
		this.price = i;
	}
	
	public void setModel(String m) {
		this.model = m;
	}
	public String toString() {
		return  "model: " + this.model + ", purchased price: $" + this.price;
	}
	
	/*
	public static void main(String [] args) {
		Vehicle v = new Vehicle(1500, "tesla");
		
		System.out.println(v.toString());
	}
	*/
	
}

