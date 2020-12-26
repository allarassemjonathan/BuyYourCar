import java.util.InputMismatchException;

public class LotManager {

	public static void main(String[] args) {
		Inventory i = new Inventory();
		try {
			i.getInput();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}

	}

}

/*
Integer nu = sc.nextInt();
do {
try {
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
	

}
}while(true);
*/