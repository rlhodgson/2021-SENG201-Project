import java.util.Random;

public class RandomEvent {
	int event;
	Ship ship;
	boolean pirates = false;
	int totalGoodsAmount = 0;
	int money = 0;
	String ans = "";
	
	RandomEvent(int eventInt, Ship myship) {
		event = eventInt;
		ship = myship;
		if (event == 0) {
			pirateEvent();
		} 
		else if (event == 1) {
			badWeather();
		} 
		else if (event == 2) {
			rescueSailors();
		}
	}
		
	 void pirateEvent() {
		/* Random event of pirates occurring */
		ans = "";
		boolean upgrades = false;
		for (Item i : ship.cargo) {
			totalGoodsAmount += i.price;
			if (i.name == "Upgraded Cannon" || i.name == "Upgraded Guns") {
				upgrades = true;
			}
		}
		Random rand = new Random();
		int int_random = rand.nextInt(5);
		if (upgrades == true && int_random <= 1) {
			ans += ("\nYou have been found by pirates, and they have taken your goods\n");
			if (totalGoodsAmount >= 150) {
				for (Item i : ship.cargo) {
					ship.cargo.remove(i);
					}
				ship.cargoSpace = 0;
				ans += ("\nYour goods cost at least $150 which has satisfied the pirates\n");
			} else {
				ans += ("\nYour goods have not satisfied the pirates. You must walk the plank.\n");
				pirates = true;
			}
			/* they get caught*/
		} 
		else if (upgrades == false && int_random <= 2) {
			ans += ("\nYou have been found by pirates, and they have taken your goods\n");
			if (totalGoodsAmount >= 150) {
				for (Item i : ship.cargo) {
					ship.cargo.remove(i);
					}
				ship.cargoSpace = 0;
				ans += ("\nYour goods cost at least $150 which has satisfied the pirates\n");
			} else {
				ans += ("\nYour goods have not satisfied the pirates. You must walk the plank.\n");
				pirates = true;
			}
			/* they get caught */
		}
	}
	
	void badWeather() {
		/* Random event of bad weather occurring */
		ans = "";
		ans += ("\nYou have encountered bad weather that has caused damage to your ship\n");
		Random rand = new Random();
		int int_random = rand.nextInt(9);
		
		ship.damage = int_random + 1;
		ship.damageCost = ship.damage * 10;
		ans += ("\nThis will cost $"+ship.damageCost + " to repair. Repairs must be made before sailing again.\n");

	}
	
	void rescueSailors() {
		/* Random event of sailors being rescued */
		ans = "";
		Random rand = new Random();
		int int_random = rand.nextInt(5);
		ans += ("\nYou have rescued " + (int_random + 1) + " sailors who will give you $30 each as a reward\n");
		money = (int_random + 1) * 30;
	}
}
