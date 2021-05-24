import java.util.ArrayList;

public class Store {
	private ArrayList<Item> itemsSold = new ArrayList<Item>();
	private ArrayList<Item> itemsPurchased = new ArrayList<Item>();
	
	Store(ArrayList<Item> itemsSoldin, ArrayList<Item> itemsPurchasedin) {
		this.itemsSold = itemsSoldin;
		this.itemsPurchased = itemsPurchasedin;
	}
	
	public String viewItems() {
		String toReturn = "Items the store sells: \n";
		
		int i = 1;
		for (Item item : this.itemsSold) {
			toReturn += i + ") " + item.getName() + " $" + item.getPrice() + " (" + item.getSize() + " space)\n";
			i += 1;
		}

		toReturn += "Items the store buys: \n";
		
		i = 1;
		for (Item item : this.itemsPurchased) {
			toReturn += i + ") " + item.getName() + " $" + item.getPrice() + "\n";
			i += 1;
		}
		
		return toReturn;
		
	}
	
	public ArrayList<Item> getSelling() {
		return this.itemsSold;
	}
	
	public ArrayList<Item> getBuying() {
		return this.itemsPurchased;
	}
	
	public Item getItemSold(int index) {
		return this.itemsSold.get(index);
	}

	public Item getItemPurchased(int index) {
		return this.itemsPurchased.get(index);
	}
}
