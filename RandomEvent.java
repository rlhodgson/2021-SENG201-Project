import java.util.Random;

public class RandomEvent {
	private Ship ship;
	private boolean walkedPlank = false;
	private int money = 0;
	
	RandomEvent(int eventNum, Ship myShip) {
		this.ship = myShip;
		if (eventNum == 0) {
			pirateEvent();
		} 
		else if (eventNum == 1) {
			badWeather();
		} 
		else if (eventNum == 2) {
			rescueSailors();
		}
	}
		
	public void pirateEvent() {
		/* Random event of pirates occurring */
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
			System.out.println("\nYou have been found by pirates. Your crew was no match for them... You've walked the plank!\n");
			this.walkedPlank = true;
			
		}else if (totalGoodsAmount >= 500) {
			for (Item item : this.ship.getCargo()) {
				this.ship.removeItem(item);
			}
			System.out.println("\nYou've been found by pirates! Your goods cost were worth at least $150 which has satisfied the pirates to leave you alone.\n");
		} else {
			System.out.println("\nYou've been found by pirates! Your goods weren't worth enough to satisfy the pirates. You must walk the plank!\n");
			this.walkedPlank = true;
		}
			/* they get caught*/
	} 

	
	
	public void badWeather() {
		/* Random event of bad weather occurring */
		System.out.println("\nYou have encountered bad weather that has caused damage to your ship");
		Random rand = new Random();
		int int_random = rand.nextInt(5);
		
		int damage = int_random + 1 * 10;
		this.ship.takeDamage(damage);
		System.out.println("This will cost $"+ this.ship.getDamageCost() + " to repair. Repairs must be made before sailing again.\n");

	}
	
	public void rescueSailors() {
		/* Random event of sailors being rescued */
		Random rand = new Random();
		int int_random = rand.nextInt(5);
		System.out.println("\nYou have rescued " + (int_random + 1) + " sailors who will gave you $30 each as a reward\n");
		this.money = (int_random + 1) * 30;
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public boolean didWalkPlank() {
		return this.walkedPlank;
	}
	
	
	
}
