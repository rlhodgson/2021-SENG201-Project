
import java.util.ArrayList;

public class Ship {
	private String name;
	private int crewNum;
	private int sailSpeed;
	private int cargoSpace;
	private ArrayList<String> upgrades = new ArrayList<String>();
	private ArrayList<Item> cargo = new ArrayList<Item>();
	private int damageTaken = 0;
	private int health; // not used in this version
	private int dailyWage;
	
	
	Ship(String nname, int ncrewNum, int sailSpeed, int ncargoSpace, int health) {
		this.name = nname;
		this.crewNum = ncrewNum;
		this.sailSpeed = sailSpeed;
		this.cargoSpace = ncargoSpace;
		this.health = health;
		this.dailyWage = (int)(ncrewNum * 1.5);
		
	}
	
	public String viewDetails() {
		
		String toReturn = "\nShip, " + this.name + ", has " + this.crewNum +" crew members.";
		toReturn += "\nEach day sailing will cost you $" + this.dailyWage + ". Currently there is " + this.cargoSpace + " units of cargo space available";
		if (this.upgrades.size() == 0) {
			toReturn += "\nThere are currently no upgrades";
		} else {
			toReturn += "\nThe current upgrade(s) are: \n";
			for (String upgrade : this.upgrades) {
				toReturn += upgrade;
			}
		}
		if (this.damageTaken == 0) {
			toReturn += "\nYour ship has no damage";
		}else {
			toReturn += "\nThe damage to your ship is " + this.damageTaken + ". This will cost you $" + getDamageCost() + " to fix.\n";
		}
	
		return toReturn;
	}
	
	public void addUpgrade(String upgrade) {
		this.upgrades.add(upgrade);
	}
	
	public String viewPurchasedGoods() {
		String toReturn = "";
		for (Item i : cargo) {
			toReturn += i.getDescr();
		}
		
		return toReturn;
	}
	
	public int getCargoSpace() {
		return this.cargoSpace;
	}
	
	public void addCargo(Item item) {
		this.cargo.add(item);
		this.cargoSpace -= item.getSize();
	}
	
	public void removeItem(Item item) {
		this.cargo.remove(item);
		this.cargoSpace += item.getSize();
	}
	
	public ArrayList<Item> getCargo(){
		return this.cargo;
	}
	
	public int getSpeed() {
		return this.sailSpeed;
	}
	
	public int getDailyCost() {
		return this.dailyWage;
	}
	
	public void changeDamage(int damage) {
		this.damageTaken += damage;
	}
	
	public int getDamageCost() {
		double damageCost = (double)(this.damageTaken) / (double)(this.health);
		return (int)(damageCost * 100.0);
	}
	
	public String getName() {
		return this.name;
	}
	
	public void resetDamage() {
		this.damageTaken = 0;
	}

}

