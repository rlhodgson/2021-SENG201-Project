import java.util.Random;

public class RandomEvent {
	private Ship ship;
	private int eventNum;
	private boolean walkedPlank = false;
	private int money = 0;
	
	RandomEvent(int eventNum, Ship myShip) {
		this.ship = myShip;
		this.eventNum = eventNum;
	}
	
	public String initiateEvent() {
		
		String toReturn = "";
		if (this.eventNum == 0) {
			toReturn = pirateEvent();
		} 
		else if (this.eventNum == 1) {
			toReturn = badWeather();
		} 
		else if (this.eventNum == 2) {
			toReturn = rescueSailors();
		}
		return toReturn;
	}
		
	public String pirateEvent() {
		/* Random event of pirates occurring */
		String toReturn;
		
		boolean upgrades = false;
		int totalGoodsAmount = 0;
		for (Item item : this.ship.getCargo()) {
			totalGoodsAmount += item.getPrice();
			if (item.getName() == "Upgraded Cannon" || item.getName() == "Upgraded Guns") {
				upgrades = true;
			}
		}
		Random rand = new Random();
		int int_random = rand.nextInt(6);
		if (upgrades == true) {
			int_random -= 1;
		}
		
		if (int_random <= 1) {
			toReturn = "\nYou have been found by pirates. Your crew was no match for them... You've walked the plank!\n";
			this.walkedPlank = true;
			
		} else if (totalGoodsAmount >= 500) {
			for (Item item : this.ship.getCargo()) {
				this.ship.removeItem(item);
			}
			toReturn = "\nYou've been found by pirates! Your goods were worth at least $500 which has satisfied the pirates to leave you alone.\n";
		} else {
			toReturn = "\nYou've been found by pirates! Your goods weren't worth enough to satisfy the pirates. You must walk the plank!\n";
			this.walkedPlank = true;
		}
		
		return toReturn;
	} 

	
	
	public String badWeather() {
		/* Random event of bad weather occurring */
		
		Random rand = new Random();
		int int_random = rand.nextInt(5);
		
		int damage = (int_random + 1) * 10;
		this.ship.changeDamage(damage);
		String toReturn = "\nYou have encountered bad weather that has caused damage to your ship\nThis will cost $"+ this.ship.getDamageCost() + " to repair. Repairs must be made before sailing again.\n";
		
		return toReturn;

	}
	
	public String rescueSailors() {
		/* Random event of sailors being rescued */
		Random rand = new Random();
		int int_random = rand.nextInt(5);
		this.money = (int_random + 1) * 30;
		String toReturn = "\nYou have rescued " + (int_random + 1) + " sailors who will gave you $30 each as a reward\n";
		
		return toReturn;
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public boolean didWalkPlank() {
		return this.walkedPlank;
	}
	
	
	
}
