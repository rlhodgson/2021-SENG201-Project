import java.util.ArrayList;

public class Store {
	private ArrayList<Item> itemsSold = new ArrayList<Item>();
	private ArrayList<Item> itemsPurchased = new ArrayList<Item>();
	
	Store(ArrayList<Item> itemsSoldin, ArrayList<Item> itemsPurchasedin) {
		this.itemsSold = itemsSoldin;
		this.itemsPurchased = itemsPurchasedin;
	}
	
	public void viewItems() {
		System.out.println("Items the store sells: \n");
		viewSelling();
		System.out.println("Items the store buys: \n");
		viewBuying();
	}
	
	public void viewSelling() {
		int i = 1;
		for (Item item : this.itemsSold) {
			System.out.println(i + ") " + item.getName() + " $" + item.getPrice() + " (" + item.getSize() + " space)\n");
			i += 1;
		}
	}
	
	public void viewBuying() {
		int i = 1;
		for (Item item : this.itemsPurchased) {
			System.out.println(i + ") " + item.getName() + " $" + item.getPrice() + "\n");
			i += 1;
		}
	}
	
	public Item getItemSold(int index) {
		return this.itemsSold.get(index);
	}

	public Item getItemPurchased(int index) {
		return this.itemsPurchased.get(index);
	}
}
