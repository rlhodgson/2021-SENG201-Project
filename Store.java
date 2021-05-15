import java.util.ArrayList;

public class Store {
	ArrayList<Item> itemsSold = new ArrayList<Item>();
	ArrayList<Item> itemsPurchased = new ArrayList<Item>();
	
	Store(ArrayList<Item> itemsSoldin, ArrayList<Item> itemsPurchasedin) {
		itemsSold = itemsSoldin;
		itemsPurchased = itemsPurchasedin;
	}
	
	void viewItems() {
		System.out.println("Items the store sells: \n");
		for (Item item : itemsSold) {
			System.out.println(item.name + " $" + item.price + "\n");
		}
		System.out.println("Items the store buys: \n");
		for (Item item : itemsPurchased) {
			System.out.println(item.name + " $" + item.price + "\n");
		}
	}

}
