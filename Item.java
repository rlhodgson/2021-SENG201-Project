/**Item class controlling all aspects of an Item
 * 
 * @author Rachel Hodgson and Aidan Campbell
 *
 */
public class Item {
	
	private String name;
	private int size;
	private String description;
	private int price;
	
	// only used when the item is sold
	private int amountSold;
	private Island storeSold = null;
	
	Item(String namein, int pricein, int sizein, String descript) {
		this.name = namein;
		this.size = sizein;
		this.price = pricein;
		this.description = descript;
		
	}
	
	/**Returns a string representation of the item
	 * 
	 */
	@Override
	public String toString() {
		return (name + " costs $" + price + " and takes up " + size + " space.\n");
	}
	
	/**Returns a string of the description of an item
	 * 
	 * @return String
	 */
	public String getDescr() {
		String toReturn = "";
		if (storeSold != null) {
			toReturn += (name + " sold for $" + amountSold + " at the store on " + storeSold.getName() + "\n");
		} else {
			toReturn += (name + " cost you $" + price + " and is taking up " + size + " amount of cargo.\n");
		}
		return	toReturn;
	}
	
	/**Returns the 'description' aspect of an item rather than the full description
	 * 
	 * @return String
	 */
	public String getRawDescription() {		// used to return the raw string of description instead of the one above
		return this.description;
	}
	
	/**Returns the amount of cargo space the item takes up
	 * 
	 * @return integer
	 */
	public int getSize() {
		return this.size;
	}
	
	/**Returns the price of the item
	 * 
	 * @return integer
	 */
	public int getPrice() {
		return price;
	}
	
	/**Returns the name of the item
	 * 
	 * @return String
	 */
	public String getName() {
		return this.name;
	}
	
	/**Changes the information of an item after it has been sold
	 * 
	 * @param soldFor Amount the item sold for
	 * @param soldAtIsland Island the item was sold at
	 */
	public void changeSoldInfo(int soldFor, Island soldAtIsland) {
		this.amountSold = soldFor;
		this.storeSold = soldAtIsland;
	}

}
