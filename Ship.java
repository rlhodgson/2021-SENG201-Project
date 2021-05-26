
import java.util.ArrayList;
/**Ship class controlling all ship aspects
 * 
 * @author Rachel Hodgson and Aidan Campbell
 *
 */
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
	/**Returns a string of the details of the ship
	 * 
	 * @return String
	 */
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
	
	/**Adds an upgrade to the upgrade list
	 * 
	 * @param upgrade The upgrade to add by name
	 */
	public void addUpgrade(String upgrade) {
		this.upgrades.add(upgrade);
	}
	
	/**Returns a string of purchased goods going through the cargo
	 * 
	 * @return String
	 */
	public String viewPurchasedGoods() {
		String toReturn = "";
		for (Item i : cargo) {
			toReturn += i.getDescr();
		}
		
		return toReturn;
	}
	
	/**Returns the amount of cargo space
	 * 
	 * @return integer
	 */
	public int getCargoSpace() {
		return this.cargoSpace;
	}
	
	/**Adds an item to the ship cargo
	 * 
	 * @param item Item to add to cargo
	 */
	public void addCargo(Item item) {
		this.cargo.add(item);
		this.cargoSpace -= item.getSize();
	}
	
	/**Removes an item from the ship cargo
	 * 
	 * @param item Item to remove from cargo
	 */
	public void removeItem(Item item) {
		this.cargo.remove(item);
		this.cargoSpace += item.getSize();
	}
	
	/**Returns the list of cargo
	 * 
	 * @return ArrayList
	 */
	public ArrayList<Item> getCargo(){
		return this.cargo;
	}
	
	/**Returns the speed of the ship
	 * 
	 * @return integer
	 */
	public int getSpeed() {
		return this.sailSpeed;
	}
	
	/**Returns the daily cost of sailing the ship
	 * 
	 * @return integer
	 */
	public int getDailyCost() {
		return this.dailyWage;
	}
	
	/**Changes the amount of damage that the ship has
	 * 
	 * @param damage Damage amount to add
	 */
	public void changeDamage(int damage) {
		this.damageTaken += damage;
	}
	
	/**Returns the cost of the current damage
	 * 
	 * @return integer
	 */
	public int getDamageCost() {
		double damageCost = (double)(this.damageTaken) / (double)(this.health);
		return (int)(damageCost * 100.0);
	}
	
	/**Returns the name of the ship
	 * 
	 * @return String
	 */
	public String getName() {
		return this.name;
	}
	
	/**Makes the ship damage 0 
	 * 
	 */
	public void resetDamage() {
		this.damageTaken = 0;
	}

}

