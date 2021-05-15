
import java.util.ArrayList;

public class Ship {
	String name;
	int crewNum;
	int dailyWage;
	int cargoSpace;
	ArrayList<String> upgrades = new ArrayList<String>();
	ArrayList<Item> cargo = new ArrayList<Item>();
	int damage;
	int damageCost;
	
	Ship(String nname, int ncrewNum, int ndailyWage, int ncargoSpace) {
		name = nname;
		crewNum = ncrewNum;
		dailyWage = ndailyWage;
		cargoSpace = ncargoSpace;
	}
	
	void viewDetails() {
		System.out.println("\nYour ship, " + name + ", has " + crewNum +" crew members.");
		System.out.println("\nEach day sailing will cost you $" + dailyWage + ". Currently there is " + cargoSpace + " meters of cargo space available");
		if (upgrades.size() == 0) {
			System.out.println("\nThere are currently no upgrades");
		} else {
			System.out.println("\nThe current upgrade(s) are: \n");
			for (String upgrade : upgrades) {
				System.out.println(upgrade);
			}
		}
		System.out.println("\nThe damage to your ship is " + damage + ". This will cost you $" + damageCost + " to fix.\n");
		

	}
	
	void viewPurchasedGoods() {
		for (Item i : cargo) {
			i.getDescr();
		}
	
	}
	

}

