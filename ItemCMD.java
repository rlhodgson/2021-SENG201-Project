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
	
	
	public void getDescr() {
		if (this.storeSold != null) {
			System.out.println(this.name + " sold for " + this.amountSold + " at the store on " + this.storeSold.getName());
		} else {
			System.out.println(this.name + " cost you " + this.price + " and is taking up " + this.size + " amount of cargo.");
		}
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
