package seng201Project;

public class Item {
	
	String name;
	int size;
	String description;
	int amountPaid;
	int amountSold = 0;
	String storeSold = null;
	
	void getDescr() {
		if (storeSold == null) {
			System.out.println("Stuff that hasnt been sold");

		} else {
			System.out.println("Stuff that has been sold");
		}
	}

}
