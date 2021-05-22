import java.util.*;
import java.util.Random;

import javax.swing.JOptionPane;

public class GameEnvironment {

	static String name = "";
	static int days;
	static int initialDays;
	static int money = 1000;
	static String shipName;
	static Ship myShip;
	static ArrayList<Item> soldGoods = new ArrayList<Item>();
	static Island currentIsland;
	static boolean gameEnd = false;
	static int choice = 0;
	static Random rand = new Random();
	static RandomEvent random = null;

	mainWindow main;
	setUpWindow1 setUp;

	public void launchmainWindow() {
		main = new mainWindow(this);
	}

	public void closemainWindow(mainWindow main) {
		main.closeWindow();
	}

	public void launchsetUpWindow() {
		setUp = new setUpWindow1(this);
	}

	public void closesetUpWindow1(setUpWindow1 setUp) {
		setUp.closeWindow();
		launchmainWindow();
	}
	 

	static void setUp() {
		
		ArrayList<Ship> ships = new ArrayList<Ship>();
		
		Ship ship1 = new Ship("Voyager", 12, 20, 40);
		Ship ship2 = new Ship("Midnight", 16, 24, 44);
		Ship ship3 = new Ship("Summer", 20, 28, 48);
		Ship ship4 = new Ship("Black Pearl", 24, 32, 52);
		
		ships.add(ship1);
		ships.add(ship2);
		ships.add(ship3);
		ships.add(ship4);
		
				
		for (Ship ship : ships) {
			if (ship.name == shipName) {
				myShip = ship;
				
			}
		}
		
		islandInitialiser();
		
	}

	static void routeInitialiser(Island island) {
		/* Initializes the routes between all islands */

		if (island.getName() == "Pen Island") {

			Route route1 = new Route("Pen Island", "Herbert Island", 5,
					"Will likely encounter rough seas and potentially pirates");
			Route route2 = new Route("Pen Island", "St Caleb Island", 6,
					"Might possibly encounter rough seas and potentially pirates");
			Route route3 = new Route("Pen Island", "Palm Island", 7, "Will likely not encounter rough seas or pirates");
			Route route4 = new Route("Pen Island", "New Canada Island", 8, "May encounter rough seas or potentially pirates");

			/* Jewels */
			ArrayList<Item> itemsSold = new ArrayList<Item>();
			Item item1 = new Item("Gold", 100, 10, "Large gold nugget!");
			Item item2 = new Item("Silver", 80, 8, "Medium silver nugget!");
			itemsSold.add(item1);
			itemsSold.add(item2);

			ArrayList<Item> itemsPurchased = new ArrayList<Item>();
			Item item3 = new Item("Copper", 40, 8, "Medium sized piece of copper!");
			Item item4 = new Item("Bronze", 30, 8, "Medium sized bronze pieces!");
			itemsPurchased.add(item3);
			itemsPurchased.add(item4);

			Store island1Store = new Store(itemsSold, itemsPurchased);
			island.addStore(island1Store);
			island.addRoute(route1);
			island.addRoute(route2);
			island.addRoute(route3);
			island.addRoute(route4);
		}

		if (island.getName() == "Herbert Island") {

			Route route5 = new Route("Herbert Island", "Pen Island", 5,
					"Will likely encounter rough seas and potentially pirates");
			Route route6 = new Route("Herbert Island", "St Caleb Island", 9, "Will likely not encounter rough seas or pirates");
			Route route7 = new Route("Herbert Island", "Palm Island", 10,
					"May encounter rough seas, will likely encounter pirates");
			Route route8 = new Route("Herbert Island", "New Canada Island", 11,
					"Possibility of encountering extremely rough seas and maybe pirates");

			/* Weapons */
			ArrayList<Item> itemsSold = new ArrayList<Item>();
			Item item1 = new Item("Machine Gun", 100, 10, "Large machine gun!");
			Item item2 = new Item("Machete", 80, 8, "Medium machete!");
			itemsSold.add(item1);
			itemsSold.add(item2);

			ArrayList<Item> itemsPurchased = new ArrayList<Item>();
			Item item3 = new Item("Gold", 100, 10, "Large gold nugget!");
			Item item4 = new Item("Silver", 80, 8, "Medium silver nugget!");
			itemsPurchased.add(item3);
			itemsPurchased.add(item4);

			Store island2Store = new Store(itemsSold, itemsPurchased);
			island.addStore(island2Store);

			island.addRoute(route5);
			island.addRoute(route6);
			island.addRoute(route7);
			island.addRoute(route8);
		}

		if (island.getName() == "St Caleb Island") {
			Route route9 = new Route("St Caleb Island", "Pen Island", 6,
					"Might possibly encounter rough seas and potentially pirates");
			Route route10 = new Route("St Caleb Island", "Herbert Island", 9, "Will likely not encounter rough seas or pirates");
			Route route11 = new Route("St Caleb Island", "Palm Island", 12,
					"Probably won't encounter rough seas but pirates are likely");
			Route route12 = new Route("St Caleb Island", "New Canada Island", 13,
					"Likely to encounter rough seas, less likely to encounter pirates");

			/* Flags */
			ArrayList<Item> itemsSold = new ArrayList<Item>();
			Item item1 = new Item("Skull Flag", 50, 5, "Large skull flag!");
			Item item2 = new Item("Black Flag", 40, 4, "Medium black flag!");
			itemsSold.add(item1);
			itemsSold.add(item2);

			ArrayList<Item> itemsPurchased = new ArrayList<Item>();
			Item item3 = new Item("Machete", 80, 8, "Medium machete!");
			Item item4 = new Item("Machine Gun", 100, 10, "Large machine gun!");
			itemsPurchased.add(item3);
			itemsPurchased.add(item4);

			Store island3Store = new Store(itemsSold, itemsPurchased);
			island.addStore(island3Store);
			island.addRoute(route9);
			island.addRoute(route10);
			island.addRoute(route11);
			island.addRoute(route12);
		}

		if (island.getName() == "Palm Island") {
			Route route13 = new Route("Palm Island", "Pen Island", 7, "Will likely not encounter rough seas or pirates");
			Route route14 = new Route("Palm Island", "Herbert Island", 10,
					"May encounter rough seas, will likely encounter pirates");
			Route route15 = new Route("Palm Island", "St Caleb Island", 12,
					"Probably won't encounter rough seas but pirates are likely");
			Route route16 = new Route("Palm Island", "New Canada Island", 14,
					"Might discover pirates, but will likely encounter rough seas");

			/* Antiques */
			ArrayList<Item> itemsSold = new ArrayList<Item>();
			Item item1 = new Item("Antique Lamp", 80, 8, "Antique lamp with gold fixings!");
			Item item2 = new Item("Antique Coins", 100, 10, "Coins from the early 1700s and 1800s!");
			itemsSold.add(item1);
			itemsSold.add(item2);

			ArrayList<Item> itemsPurchased = new ArrayList<Item>();
			Item item3 = new Item("Skull Flag", 50, 5, "Large skull flag!");
			Item item4 = new Item("Black Flag", 40, 4, "Medium black flag!");
			itemsPurchased.add(item3);
			itemsPurchased.add(item4);

			Store island4Store = new Store(itemsSold, itemsPurchased);
			island.addStore(island4Store);

			island.addRoute(route13);
			island.addRoute(route14);
			island.addRoute(route15);
			island.addRoute(route16);

		}

		if (island.getName() == "New Canada Island") {
			Route route17 = new Route("New Canada Island", "Pen Island", 8, "May encounter rough seas or potentially pirates");
			Route route18 = new Route("New Canada Island", "Herbert Island", 11,
					"Possibility of encountering extremely rough seas and maybe pirates");
			Route route19 = new Route("New Canada Island", "St Caleb Island", 13,
					"Likely to encounter rough seas, less likely to encounter pirates");
			Route route20 = new Route("New Canada Island", "Palm Island", 14,
					"Might discover pirates, but will likely encounter rough seas");

			/* Upgrades */
			ArrayList<Item> itemsSold = new ArrayList<Item>();
			Item item1 = new Item("Upgraded Cannon", 80, 8, "Cannon can shoot much further!");
			Item item2 = new Item("Upgraded Guns", 100, 10, "Guns run a longer amount of ammunition!");
			itemsSold.add(item1);
			itemsSold.add(item2);

			ArrayList<Item> itemsPurchased = new ArrayList<Item>();
			Item item3 = new Item("Antique Lamp", 80, 8, "Antique lamp with gold fixings!");
			Item item4 = new Item("Antique Coins", 100, 10, "Coins from the early 1700s and 1800s!");

			itemsPurchased.add(item3);
			itemsPurchased.add(item4);

			Store island5Store = new Store(itemsSold, itemsPurchased);
			island.addStore(island5Store);

			island.addRoute(route17);
			island.addRoute(route18);
			island.addRoute(route19);
			island.addRoute(route20);
		}
	}

	static ArrayList<Island> islands = new ArrayList<Island>();

	static void islandInitialiser() {
		Island island1 = new Island("Pen Island");
		routeInitialiser(island1);
		islands.add(island1);

		Island island2 = new Island("Herbert Island");
		routeInitialiser(island2);
		islands.add(island2);

		Island island3 = new Island("St Caleb Island");
		routeInitialiser(island3);
		islands.add(island3);

		Island island4 = new Island("Palm Island");
		routeInitialiser(island4);
		islands.add(island4);

		Island island5 = new Island("New Canada Island");
		routeInitialiser(island5);
		islands.add(island5);

		currentIsland = islands.get(0);

	}

	static void game() {

		if ((days <= 5) || (money <= 100)) {
			gameEnd = true;
		}
	}
	
	static void getNameMon() {
		System.out.println(name + ", you have $" + money + " and " + days + " days remaining.\n");
	}
	
	static String viewShipDetails() {
		String answer = myShip.viewDetails();

		return answer;
	}	
	
	static String viewPurchasedGoods() {
		String answer = "";
		answer += ("\nCurrent goods in cargo: \n");
		String nextan = myShip.viewPurchasedGoods();
		answer += nextan;

		/* view sold goods next */
		answer += ("\nGoods that have been sold: \n");
		for (Item i : soldGoods) {
			answer += i.getDescr();
		}
		
		return answer;
	}
	
	static String viewIslands() {
		String ans = "";
		ans += ("Islands:\n");
		String nextan = currentIsland.viewProperties();
		ans += nextan;

		for (Island island : islands) {
			ans += (island.name + ":\n");
			ans += island.store.viewItems();
			ans += ("\n");

		}
		return ans;
	}
	
	static void visitStore() {
		boolean stopVisiting = false;
		while (stopVisiting == false) {
			System.out.println("store");
			String ans = currentIsland.visitStore();

			stopVisiting = visit();
		}
	}
	
	static boolean visit() {
		boolean output = false;

		System.out.println("\nYou currently have $" + money + "\n");
		System.out.println("\nWould you like to buy or sell something? \n");
		System.out.println("1) Buy\n");
		System.out.println("2) Sell\n ");
		System.out.println("3) Leave store\n");
		System.out.println("4) View current goods\n");

		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		switch (input) {
		case 1:
			System.out.println("Which item would you like to buy? \n");
			System.out.println("1");
			System.out.println("2");

			Scanner sc2 = new Scanner(System.in);
			int inputnextbuy = sc2.nextInt();

			switch (inputnextbuy) {
			case 1:
				Item item = currentIsland.store.itemsSold.get(0);
				purchaseItem(item);
				break;
			case 2:
				Item item2 = currentIsland.store.itemsSold.get(1);
				purchaseItem(item2);
				break;
			}
			break;
		case 2:
			System.out.println("Which item would you like to sell? \n");
			System.out.println("1");
			System.out.println("2");

			Scanner sc3 = new Scanner(System.in);
			int inputnextsell = sc3.nextInt();

			switch (inputnextsell) {
			case 1:
				Item item = currentIsland.store.itemsPurchased.get(0);
				sellItem(item);
				break;
			case 2:
				Item item2 = currentIsland.store.itemsPurchased.get(1);
				sellItem(item2);
				break;
			}
			break;
		case 3:
			output = true;
			break;
		case 4:
			System.out.println("\nCurrent goods in cargo: \n");
			myShip.viewPurchasedGoods();

			/* view sold goods next */
			System.out.println("\nGoods that have been sold: \n");
			for (Item i : soldGoods) {
				i.getDescr();
			}
			break;
		}
		return output;
	}

	static void setSail() {
			int int_random = rand.nextInt(5);
			if (int_random <= 2) {
				random = new RandomEvent(int_random, myShip);
			}
			if (random != null) {
				if (random.money != 0) {
					money += random.money;
				}
				if (random.pirates == true) {
					gameEnd = true;
				}
			}

			game();
	}
	
	static int checkDamage() {
		if (myShip.damage == 0) {
			return 0;
		} else if ((money - myShip.damageCost) > 100) {
			return 1;
		} else {
			return 2;
		}
	}
	
	static boolean gameOver() {
		if (gameEnd == false) {
			return false;
		} else {
			return true;
		}
	}
	
	static ArrayList<Island> setIslands() {
		ArrayList<Island> islands1 = new ArrayList<Island>();

		if (currentIsland.name == "Pen Island") {
			islands1.add(islands.get(1));
			islands1.add(islands.get(2));
			islands1.add(islands.get(3));
			islands1.add(islands.get(4));
		} else if (currentIsland.name == "Herbert Island") {
			islands1.add(islands.get(0));
			islands1.add(islands.get(2));
			islands1.add(islands.get(3));
			islands1.add(islands.get(4));
		} else if (currentIsland.name == "St Caleb Island") {
			islands1.add(islands.get(0));
			islands1.add(islands.get(1));
			islands1.add(islands.get(3));
			islands1.add(islands.get(4));
		} else if (currentIsland.name == "Palm Island") {
			islands1.add(islands.get(0));
			islands1.add(islands.get(1));
			islands1.add(islands.get(2));
			islands1.add(islands.get(4));
		} else {
			islands1.add(islands.get(0));
			islands1.add(islands.get(1));
			islands1.add(islands.get(2));
			islands1.add(islands.get(3));
		}
		
		return islands1;
	}
	
	static String payDamage() {
		String ans = "You had some ship damage that has costed you $" + myShip.damageCost + " to fix.";
		money -= myShip.damageCost;
		myShip.damageCost = 0;
		myShip.damage = 0;
		return ans;
	}

	static boolean purchaseItem(Item item) {
		if (money - item.price > 0) {
			if (item.name == "Upgraded Cannon" || item.name == "Upgraded Guns") {
				myShip.upgrades.add(item.name);
			}
			money -= item.price;
			myShip.cargo.add(item);
			myShip.cargoSpace -= item.size;
			return true;
			//System.out.println("You have successfully purchased the item!\n");
		} else {
			return false;
			//System.out.println("You do not have enough money to purchase this item!\n");
		}
	}

	static boolean sellItem(Item item) {
		String itemName = item.name;
		Item itemtoRemove = null;
		boolean found = false;
		for (Item itemm : myShip.cargo) {
			if (itemm.name == itemName) {
				itemtoRemove = itemm;
				found = true;
			}
		}

		if (found == true) {
			if (item.name == "Upgraded Cannon" || item.name == "Upgraded Guns") {
				myShip.upgrades.remove(item.name);
			}
			money += item.price;
			soldGoods.add(item);
			myShip.cargo.remove(itemtoRemove);
			myShip.cargoSpace += item.size;
			item.amountSold = item.price;
			item.storeSold = currentIsland;
			return true;
		} else {
			return false;
		}

	}
	
	public String endStatement() {
		int score = (initialDays - days) * money;
		String ans = name + " you have played for " + (initialDays - days) + " days out of the "
				+ initialDays + " days you requested to play for. \nYou have achieved a score of " + score
				+ " points! With $" + money + " remaining.";
		return ans;
	}
	
	public ArrayList<String> sail(String btnName) {
		ArrayList<String> ans = new ArrayList<String>();
		if (ans.size() == 2) {
			ans.remove(0);
			ans.remove(1);
		} else if (ans.size() == 1) {
			ans.remove(0);
		}
		for (Island island : islands) {
			if (island.name == btnName) {
				Route route = null;
				for (Route routeF : currentIsland.routes ) {
					if (routeF.destIsland == island.name) {
						route = routeF;
					}
				}
				int trip = route.tripDist;
				int cost = myShip.dailyWage * trip;
				if (cost <= money && trip <= days) {
					money -= cost;
					days -= trip;
					currentIsland = island;
					ans.add("true");
					ans.add(island.name);
					//JOptionPane.showMessageDialog(frame, "You have successfully travelled to " + island.name);
				} else {
					ans.add("false");
					//JOptionPane.showMessageDialog(frame, "Unable to travel to this island. \nCheck your money and days remaining");
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		GameEnvironment gamee = new GameEnvironment();
		gamee.launchsetUpWindow();
		setUp();
	}

}
