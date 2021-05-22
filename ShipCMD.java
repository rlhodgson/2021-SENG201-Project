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
	
	public void viewDetails() {
		System.out.println("\nYour ship, " + this.name + ", has " + this.crewNum +" crew members.");
		System.out.println("\nEach day sailing will cost you $" + this.dailyWage + ". Currently there is " + this.cargoSpace + " units of cargo space available");
		if (this.upgrades.size() == 0) {
			System.out.println("\nThere are currently no upgrades");
		} else {
			System.out.println("\nThe current upgrade(s) are: \n");
			for (String upgrade : this.upgrades) {
				System.out.println(upgrade);
			}
		}
		System.out.println("\nThe damage to your ship is " + this.damageTaken + ". This will cost you $" + getDamageCost() + " to fix.\n");
		

	}
	
	public void viewMinDetails(int speed) {
		System.out.println("The ship, " + this.name + ", has " + this.cargoSpace + " cargo space available. Crew members: " + this.crewNum + ". Daily Wage: $"
				+ this.dailyWage + ". Speed: " + speed + " km/h");
	}
	
	public void viewPurchasedGoods() {
		for (Item i : this.cargo) {
			i.getDescr();
		}
	
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
	
	public void takeDamage(int damage) {
		this.damageTaken += damage;
	}
	
	public int getDamageCost() {
		return (int)(this.damageTaken * 1.5);
	}

}

