import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Inventory {

	private Integer balance = 100000;
	private ArrayList<Vehicle> purchases = new ArrayList<Vehicle>();
	/**
	 * 
	 * @param b | b is the starting balance
	 * @param p | p is the list of vehicles purchased
	 */
	public Inventory (ArrayList<Vehicle> p) {
		this.purchases = p;
	}
	
	public Inventory() {
		
	}
	/**
	 *We print the content of the list of purchases
	 */
	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < this.purchases.size();i++) {
			str = str + purchases.get(i).toString() + "\n";
		}
		return str;
		
	}
	/**
	 * 
	 * @throws Exception to handle errors 
	 * 1- we handle incorrect types
	 * 2- Avoid the user to use more money than what he has
	 * 3- restrict the inputs to the choice available
	 * 4- we allow the user to leave the application
	 * 
	 * It is the core of the program
	 * Each case is coded here either the general cases
	 * or the cases specific to the purchase or sale of
	 * some items.
	 */
	public void getInput() throws Exception {

		Scanner sc = new Scanner(System.in);
		// ok is an interrupter, when it is false all the loop off
		Boolean ok = true;
		int nu = 0;
		while(ok) {
		do {
			/*
			 * This is the first "page" of the program
			 * We present the options available as well
			 * as the amount the user has with him.
			 * 
			 * 1-is to print the record of purchases
			 * 2-is to buy a vehicle
			 * 3-is to sell a vehicle
			 * 4-is to exit from the application!
			 * 
			 */
			System.out.println("Current balance: $" + this.balance);
			String str = "Choose an option:  \n"
			+ "\t1. Print inventory\n"
			+ "\t2. Buy vehicle\n"
			+ "\t3. Sell vehicle\n"
			+ "\t4. Exit\n";
			System.out.println(str);
			
				/*
				 * This portion of code is very impotant 
				 * It will allow us to check the inputs of 
				 * the user and reject those that are not good
				 */
				try {
				nu = sc.nextInt();
				if(nu > 4 || nu <1) {
					System.out.println("We only process integers 1,2 or 3");
					throw new Exception("Enter 1,2 or 3");
				}
				}
				catch(InputMismatchException e) {
					System.out.println("only integers are allowed here");
					sc.next();
					continue;
				}
				catch(Exception e) {
					System.out.println("Enter 1,2 or 3!");
					sc.nextLine();
					continue;
				}
				catch(Throwable ex) {
					System.out.println("enter a correct value");
					sc.nextLine();
				}
				
		if(nu ==1) {
			
			/*
			 * Case 1: !!Print the inventory!!
			 * We just print the list of purchases
			 * THis is a kind of history of purchases
			 */
			
			System.out.println("Current inventory: ");
			if(this.purchases.isEmpty()) {
				System.out.println("\tEmpty...\n");
			}else {
				System.out.println(this.toString());
			}	
		}
		else if(nu == 2) {
			
			/*
			 * Case 2: !!buy a vehicle!!
			 * Well here we want to buy either 
			 * a car or a bicycle
			 */
			
			System.out.println("Do you want to buy a:\n"
					+ "\t1.Bicycle\n"
					+ "\t2.Car\n");
	
			int ch = 0;
			
			/*
			 * Check if the value
			 * is either 1 or 2!!
			 */
			
			do {
				try {
				ch = sc.nextInt();
				if(ch > 2 || ch <1) {
					System.out.println("Number too big or too low!");
					throw new Exception("Enter 1 or 2");
				}
				if(ch ==2 || ch ==1) {
					break;
				}
				}
				catch(InputMismatchException e) {
					System.out.println("only integers are allowed here");
					sc.next();
				}
				catch(Exception e) {
					System.out.println("Enter 1 or 2");
					sc.nextLine();
				}
				catch(Throwable ex) {
					System.out.println("enter a correct value");
					sc.nextLine();
				}
				
			}while(ok);
			
			/*
			 * The purchase of a Bicycle!!!!
			 */
			
			if(ch == 1) {
				if(this.balance==0) {
					System.out.println("You have no money! Press 4 to exit.");				}
				else {
				System.out.println("Enter the model");
				String model =sc.next();
				System.out.println("Enter the price");
				Integer price = 0;
				do {
					try {
						 price = sc.nextInt();
						if(price > this.balance || price < 0) {
							throw new Exception("We need an amount between $1 and $"+ this.balance);
						}
						else {
							/*
							 * We break if everything is ok
							 */
							break;
						}
						}
						catch(InputMismatchException e) {
							System.out.println("Enter a correct amount");
							sc.next();
						}
						catch(Exception e) {
							System.out.println(e.getMessage());
							sc.nextLine();
						}
						catch(Throwable ex) {
							System.out.println("Enter a corect amount of money");
							sc.nextLine();
						}
					}while(ok);
				
				/*
				 * Since everything is ok we had the bicycle 
				 * to the list of purchases!! ANd remove 
				 * the amount of money from the balance
				 */
				
				Bicycle bic = new Bicycle(price,model);
				this.balance -= price;
				this.purchases.add(bic);
				System.out.println("New purchase acquired.");
			}}
			/*
			 * The purchase of a Car!!!
			 */
			else if (ch == 2) {
				if(this.balance==0) {
					System.out.println("You have no money! Press 4 to exit.");
				}
				else{
				System.out.println("Enter the model");
				String model =sc.next();
				System.out.println("Enter the price");
				Integer price = 0;
				
				/*
				 * We check the value of the integer 
				 * and handle exceptions!!
				 */
				
				do {
					try {
						 price = sc.nextInt();
						if(price > this.balance || price < 0) {
							throw new Exception("Enter an amount between $1 and $" + this.balance);
						}
						else {
							/*
							 * We break if everything is ok
							 */
							break;
						}
						}
						catch(InputMismatchException e) {
							System.out.println("Enter a correct amount");
							sc.next();
						}
						catch(Exception e) {
							System.out.println(e.getMessage());
							sc.nextLine();
						}
						catch(Throwable ex) {
							System.out.println("Enter a corect amount of money");
							sc.nextLine();
						}
					}while(ok);
				System.out.println("Enter the mileage");
				Integer mileage = 0;
				
				/*
				 * We check the value of the integer
				 * and handle exceptions!!
				 */
				
				do {
					try {
						 mileage = sc.nextInt();
							 if(mileage < 0) {
									throw new Exception("mileage is positive");
								}
							 else {
								 break;
							 }
						}
						catch(InputMismatchException e) {
							System.out.println("Enter a number please");
							sc.nextLine();
						}
						catch(Exception e) {
							System.out.println(e.getMessage());
							sc.nextLine();
						}
						catch(Throwable ex) {
							System.out.println("Enter a correct mileage");
							sc.nextLine();
						}
					}while(ok);
				
				/*
				 * Since everything is ok we had the car
				 * to the list of purchases
				 */
				Car car = new Car(price,model,mileage);
				this.balance -= price;
				purchases.add(car);
				System.out.println("New purchase acquired.");
					
			}}
		
		}
		else if(nu == 3) {
			/*
			 * check if the arraylist is empty first!!
			 */
			if(this.purchases.isEmpty()) {
			System.out.println("You have nothing to sell!Buy an item first");
			}
			/*
			 * If it is not then the user can sell something
			 */
			else{
			System.out.println("Which element do you want to sell?");
			Integer element = 0;
			do {
				try {
					 element = sc.nextInt();
					if(element > this.purchases.size()-1 || element < 0) {
						throw new Exception("you only have " + (this.purchases.size())+ " elements\ngive an index");
					}
					else {
						break;
					}
					}
					catch(InputMismatchException e) {
						System.out.println("Wrong type! We need whole numbers");
						sc.next();
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
						sc.nextLine();
					}
					catch(Throwable ex) {
						System.out.println("Give a good number");
						sc.nextLine();
					}
				}while(ok);
			System.out.println("Give a price");
			Integer price = 0;
			do {
				try {
					 price = sc.nextInt();
					if(price < 0) {
						throw new Exception("Enter a positive amount");
					}
					else {
						break;
					}
					}
					catch(InputMismatchException e) {
						System.out.println("Give a fair amount");
						sc.next();
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
						sc.nextLine();
					}
					catch(Throwable ex) {
						System.out.println("Enter a corect amount of money");
						sc.nextLine();
					}
				}while(ok);
			/*
			 * We add the money to balance
			 */
				this.balance+=price;
			/*
			 * We remove the element from the arraylist
			 */
				this.purchases.remove(purchases.get(element));
				
			System.out.println("Vehicle sucessfully sold.");
		}}
		else if(nu == 4) {
			System.out.println("\nExiting...");
			ok = false;
		}
		}while(ok);
	}	
	}
	public static void main(String[] args) {
		Inventory i = new Inventory();
		System.out.println(i.toString());
		try {
		i.getInput();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
