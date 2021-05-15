
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
	
	void getDescr() {
		if (storeSold != null) {
			System.out.println(name + " sold for " + amountSold + " at the store on " + storeSold.name);
		} else {
			System.out.println(name + " cost you " + price + " and is taking up " + size + " amount of cargo.");
		}
	}

}