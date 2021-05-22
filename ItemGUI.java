
public class Item {
	
	String name;
	int size;
	String description;
	int price;
	
	int amountSold;
	Island storeSold = null;
	
	Item(String namein, int pricein, int sizein, String descript) {
		name = namein;
		size = sizein;
		price = pricein;
		description = descript;
		
	}
	
	@Override
	public String toString() {
		return (name + " costs $" + price + " and takes up " + size + " amount of cargo.\n");
	}
	
	public String getDescr() {
		String ans = "";
		if (storeSold != null) {
			ans += (name + " sold for " + amountSold + " at the store on " + storeSold.name + "\n");
		} else {
			ans += (name + " cost you " + price + " and is taking up " + size + " amount of cargo.\n");
		}
		return ans;
	}

}