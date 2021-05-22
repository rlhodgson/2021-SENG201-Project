
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
	
	public String viewDetails() {
		String answer = "";
		answer += ("\nYour ship, " + name + ", has " + crewNum +" crew members.");
		answer += ("\nEach day sailing will cost you $" + dailyWage + ". Currently there is " + cargoSpace + " meters of cargo space available");
		if (upgrades.size() == 0) {
			answer += ("\nThere are currently no upgrades");
		} else {
			answer += ("\nThe current upgrade(s) are: \n");
			for (String upgrade : upgrades) {
				answer += (upgrade + "\n");
			}
		}
		answer += ("\nThe damage to your ship is " + damage + ". This will cost you $" + damageCost + " to fix.\n");
		return answer;
	}
	
	public String viewPurchasedGoods() {
		String answer = "";
		for (Item i : cargo) {
			answer += i.getDescr();
		}
		
		return answer;
	}
	

}

