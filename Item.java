
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
	
	@Override
	public String toString() {
		return (name + " costs $" + price + " and takes up " + size + " space.\n");
	}
	
	public String getDescr() {
		String toReturn = "";
		if (storeSold != null) {
			toReturn += (name + " sold for " + amountSold + " at the store on " + storeSold.getName() + "\n");
		} else {
			toReturn += (name + " cost you " + price + " and is taking up " + size + " amount of cargo.\n");
		}
		return	toReturn;
	}
	
	public String getRawDescription() {		// used to return the raw string of description instead of the one above
		return this.description;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void changeSoldInfo(int soldFor, Island soldAtIsland) {
		this.amountSold = soldFor;
		this.storeSold = soldAtIsland;
	}

}
