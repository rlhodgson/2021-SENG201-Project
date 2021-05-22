import java.util.ArrayList;

public class Store {
	ArrayList<Item> itemsSold = new ArrayList<Item>();
	ArrayList<Item> itemsPurchased = new ArrayList<Item>();
	
	Store(ArrayList<Item> itemsSoldin, ArrayList<Item> itemsPurchasedin) {
		itemsSold = itemsSoldin;
		itemsPurchased = itemsPurchasedin;
	}
	
	public String viewItems() {
		String ans = "";
		ans += ("Items the store sells: \n");
		for (Item item : itemsSold) {
			ans += (item.name + " $" + item.price + ", ");
		}
		ans += ("\nItems the store buys: \n");
		for (Item item : itemsPurchased) {
			ans += (item.name + " $" + item.price + ", ");
		}
		return ans;
	}

}
