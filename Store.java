import java.util.ArrayList;

/**Store class houses all aspects of the store
 * 
 * @author Rachel Hodgson and Aidan Campbell
 *
 */
public class Store {
	private ArrayList<Item> itemsSold = new ArrayList<Item>();
	private ArrayList<Item> itemsPurchased = new ArrayList<Item>();
	
	Store(ArrayList<Item> itemsSoldin, ArrayList<Item> itemsPurchasedin) {
		this.itemsSold = itemsSoldin;
		this.itemsPurchased = itemsPurchasedin;
	}
	
	/**Returns a string of items that the store sells and buys
	 * 
	 * @return String
	 */
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
	
	/**Returns the items that the store sells
	 * 
	 * @return ArrayList
	 */
	public ArrayList<Item> getSelling() {
		return this.itemsSold;
	}
	
	/**Returns the items that the store purchases
	 * 
	 * @return ArrayList
	 */
	public ArrayList<Item> getBuying() {
		return this.itemsPurchased;
	}
	
	/**Returns an item that can be sold
	 * 
	 * @return Item
	 */
	public Item getItemSold(int index) {
		return this.itemsSold.get(index);
	}

	/**Returns an item that can be purchased
	 * 
	 * @return Item
	 */
	public Item getItemPurchased(int index) {
		return this.itemsPurchased.get(index);
	}
}
