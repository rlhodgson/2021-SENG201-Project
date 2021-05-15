import java.util.*; 
import java.util.Random;

public class GameEnvironment {
	
	static String name = "";
	static int days;
	static int initialDays;
	static int money = 500;
	static Ship myShip;
	static ArrayList<Item> soldGoods = new ArrayList<Item>();
	static Island currentIsland;
	static boolean gameEnd = false;



	
	static void setUp() {
		while (name.length() < 3 || name.length() > 15) {
			System.out.println("Choose your trader name: ");
			Scanner sc= new Scanner(System.in);
			String tname = sc.nextLine();
			
			if (tname.length() > 3 && tname.length() < 15 && tname.matches("[ a-zA-Z]+")) {
				name = tname;

			} else {
				System.out.println("Please choose a valid name\n");
			}
			
		}
		
		while (days < 20 || days > 50) {
			System.out.println("\nChoose the number of days you want to play for between 20 and 50: ");
			Scanner sl = new Scanner(System.in);
			int tdays = sl.nextInt();
			
			if (tdays <= 50 && tdays >= 20) {
				days = tdays;
				initialDays = tdays;
			} else {
				System.out.println("Please choose a valid number of days!\n");
			}
		}
		
		
		ArrayList<Ship> ships = new ArrayList<Ship>();
		
		
		
		
		Ship ship1 = new Ship("Ship1", 12, 20, 40);
		Ship ship2 = new Ship("Voyager", 16, 24, 44);
		Ship ship3 = new Ship("Midnight", 20, 28, 48);
		Ship ship4 = new Ship("Summer", 24, 32, 52);
		
		ships.add(ship1);
		ships.add(ship2);
		ships.add(ship3);
		ships.add(ship4);
				
		for (Ship ship : ships) {
			ship.viewDetails();
			System.out.println();
		}
		
		System.out.println("Choose your ship:\n");
		
		
		boolean validShip = false;
		
		while (validShip == false) {
			Scanner sb= new Scanner(System.in);
			String tship = sb.nextLine();
			
			String shipname = tship.toLowerCase();
			/*Check the ship is valid*/
			switch(shipname) {
			case "ship1":
				myShip = ship1;
				validShip = true;
				break;
			case "voyager":
				myShip = ship2;
				validShip = true;
				break;
			case "midnight":
				myShip = ship3;
				validShip = true;
				break;
			case "summer":
				myShip = ship4;
				validShip = true;
				break;	
			default: System.out.println("Invalid ship name, choose again \n");
			}
		}
		
		System.out.println("You're ready to go!\n");
		
		islandInitialiser();
		
	}
	
	
	static void routeInitialiser(Island island) {
		/*Initializes the routes between all islands*/
		
		if (island.getName() == "Island1") {
			
			Route route1 = new Route("Island1", "Island2", 5, "Will likely encounter rough seas and potentially pirates");
			Route route2 = new Route("Island1", "Island3", 6, "Might possibly encounter rough seas and potentially pirates");
			Route route3 = new Route("Island1", "Island4", 7, "Will likely not encounter rough seas or pirates");
			Route route4 = new Route("Island1", "Island5", 8, "May encounter rough seas or potentially pirates");
			
			/*Jewels*/
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
		
		if (island.getName() == "Island2") {
			
			Route route5 = new Route("Island2", "Island1", 5, "Will likely encounter rough seas and potentially pirates");
			Route route6 = new Route("Island2", "Island3", 9, "Will likely not encounter rough seas or pirates");
			Route route7 = new Route("Island2", "Island4", 10, "May encounter rough seas, will likely encounter pirates");
			Route route8 = new Route("Island2", "Island5", 11, "Possibility of encountering extremely rough seas and maybe pirates");
			
			/*Weapons*/
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
			
		if (island.getName() == "Island3") {
			Route route9 = new Route("Island3", "Island1", 6, "Might possibly encounter rough seas and potentially pirates");
			Route route10 = new Route("Island3", "Island2", 9, "Will likely not encounter rough seas or pirates");
			Route route11 = new Route("Island3", "Island4", 12, "Probably won't encounter rough seas but pirates are likely");
			Route route12 = new Route("Island3", "Island5", 13, "Likely to encounter rough seas, less likely to encounter pirates");			
			
			/*Flags*/
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
			
		
		if (island.getName() == "Island4") {
			Route route13 = new Route("Island4", "Island1", 7, "Will likely not encounter rough seas or pirates");
			Route route14 = new Route("Island4", "Island2", 10, "May encounter rough seas, will likely encounter pirates");
			Route route15 = new Route("Island4", "Island3", 12,  "Probably won't encounter rough seas but pirates are likely");
			Route route16 = new Route("Island4", "Island5", 14, "Might discover pirates, but will likely encounter rough seas");
			
			/*Antiques*/
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
			
		if (island.getName() == "Island5") {
			Route route17 = new Route("Island5", "Island1", 8, "May encounter rough seas or potentially pirates");
			Route route18 = new Route("Island5", "Island2", 11, "Possibility of encountering extremely rough seas and maybe pirates");
			Route route19 = new Route("Island5", "Island3", 13, "Likely to encounter rough seas, less likely to encounter pirates");
			Route route20 = new Route("Island5", "Island4", 14, "Might discover pirates, but will likely encounter rough seas");
			
			/*Upgrades*/
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
		Island island1 = new Island("Island1");
		routeInitialiser(island1);
		islands.add(island1);
		
		Island island2 = new Island("Island2");
		routeInitialiser(island2);
		islands.add(island2);
		
		Island island3 = new Island("Island3");
		routeInitialiser(island3);
		islands.add(island3);
		
		Island island4 = new Island("Island4");
		routeInitialiser(island4);
		islands.add(island4);
		
		Island island5 = new Island("Island5");
		routeInitialiser(island5);
		islands.add(island5);
		
		currentIsland = islands.get(0);

	}
	
	static void game() {
		
		if ((days <= 5) || (money <= 100)) {
			gameEnd = true;
		}
			
		while (gameEnd == false) {
			String choices = "1) View amount of money and number of days remaining \n2) View properties of ship \n3) View purchased goods \n"
					+ "4) View islands \n5) Visit store \n6) Set sail \n7) Quit";
			
			System.out.println("What would you like to do? /n");
			System.out.println(choices);
			
			Scanner sc= new Scanner(System.in);
			int choice = sc.nextInt();
			

			switch(choice) {
			case 1:
				System.out.println(name + ", you have $"+money+" and " + days +" days remaining.\n");
				break;
			case 2:
				myShip.viewDetails();
				break;
			case 3:
				System.out.println("\nCurrent goods in cargo: \n");
				myShip.viewPurchasedGoods();
				
				/*view sold goods next*/
				System.out.println("\nGoods that have been sold: \n");
				for (Item i : soldGoods) {
					i.getDescr();
				}
				break;
			case 4:
				System.out.println("Islands:\n");
				currentIsland.viewProperties();
				
				for (Island island : islands) {
					System.out.println(island.name +":\n");
					island.store.viewItems();
					System.out.println("\n");

				}
				
				break;
			case 5:
				boolean stopVisiting = false;
				while (stopVisiting == false) {
					System.out.println("store");
					currentIsland.visitStore();
					
					stopVisiting = visit();
				}
				break;
				
			case 6:
				setSail();
				break;
			case 7:
				gameEnd = true;
				break;
			}
			
			if ((days <= 5) || (money <= 100)) {
				gameEnd = true;
				System.out.println("\nYou no longer have enough days or money to survive\n");
			}
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

		
		
		Scanner sc= new Scanner(System.in);
		int input = sc.nextInt();
		
		switch(input) {
		case 1:
			System.out.println("Which item would you like to buy? \n");
			System.out.println("1");
			System.out.println("2");
			
			Scanner sc2 = new Scanner(System.in);
			int inputnextbuy = sc2.nextInt();
			
			switch(inputnextbuy) {
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
			
			switch(inputnextsell) {
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
			
			/*view sold goods next*/
			System.out.println("\nGoods that have been sold: \n");
			for (Item i : soldGoods) {
				i.getDescr();
			}
			break;
		}
		return output;
	}
	
	
	static void setSail() {
		System.out.println("Which island would you like to travel to?\n");
		int i = 1;
		for (Island island : islands) {
			if (island != currentIsland) {
				Route route = currentIsland.routes.get(i-1);
				int dist = route.tripDist;
				int cost = myShip.dailyWage * dist;
				System.out.println(i + ") " + island.name + " " + dist + " days, $" + cost);
				i += 1;
			}
		}
		
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		if (myShip.damage == 0 || (money - myShip.damageCost) > 100 ) {
			if (myShip.damageCost > 0) {
				System.out.println("You had some ship damage that has costed you $" + myShip.damageCost + " to fix.");
				money -=  myShip.damageCost;
				myShip.damageCost = 0;
				myShip.damage = 0;
			}
			switch(input) {
			case 1:
				Island islandn = null;
				if (currentIsland.name == "Island1") {
					 islandn = islands.get(1);
				} else {
					 islandn = islands.get(0);
				}
				Route route = currentIsland.routes.get(0);
				int trip = route.tripDist;
				int cost = myShip.dailyWage * trip;
				if (cost <= money && trip <= days) {
					money -= cost;
					days -= trip;
					currentIsland = islandn;
				} else {
					System.out.println("Unable to travel here sorry!");
				}
				break;
			case 2:
				if ((currentIsland.name == "Island1") || (currentIsland.name == "Island2")) {
					Island islandn2 = islands.get(2);
					Route route2 = currentIsland.routes.get(2);
					int trip2 = route2.tripDist;
					int cost2 = myShip.dailyWage;
					if (cost2 <= money && trip2 <= days) {
						money -= cost2;
						days -= trip2;
						currentIsland = islandn2;
					} else {
						System.out.println("Unable to travel here sorry!");
					}
				} else {
					Island islandn2 = islands.get(1);
					Route route2 = currentIsland.routes.get(1);
					int trip2 = route2.tripDist;
					int cost2 = myShip.dailyWage;
					if (cost2 <= money && trip2 <= days) {
						money -= cost2;
						days -= trip2;
						currentIsland = islandn2;
					} else {
						System.out.println("Unable to travel here sorry!");
					}
				}
				break;
			case 3:
				if ((currentIsland.name == "Island4") || (currentIsland.name == "Island5")) {
					Island islandn3 = islands.get(2);
					Route route3 = currentIsland.routes.get(2);
					int trip3 = route3.tripDist;
					int cost3 = myShip.dailyWage;
					if (cost3 <= money && trip3 <= days) {
						money -= cost3;
						days -= trip3;
						currentIsland = islandn3;
					} else {
						System.out.println("Unable to travel here sorry!");
					}
				} else {
					Island islandn3 = islands.get(3);
					Route route3 = currentIsland.routes.get(2);
					int trip3 = route3.tripDist;
					int cost3 = myShip.dailyWage;
					if (cost3 <= money && trip3 <= days) {
						money -= cost3;
						days -= trip3;
						currentIsland = islandn3;
					} else {
						System.out.println("Unable to travel here sorry!");
					}
				}
				
				break;
			case 4:
				if ((currentIsland.name == "Island5")) {
					Island islandn4 = islands.get(3);
					Route route4 = currentIsland.routes.get(3);
					int trip4 = route4.tripDist;
					int cost4 = myShip.dailyWage;
					if (cost4 <= money && trip4 <= days) {
						money -= cost4;
						days -= trip4;
						currentIsland = islandn4;
					} else {
						System.out.println("Unable to travel here sorry!");
					}
				} else {
					Island islandn4 = islands.get(4);
					Route route4 = currentIsland.routes.get(3);
					int trip4 = route4.tripDist;
					int cost4 = myShip.dailyWage;
					if (cost4 <= money && trip4 <= days) {
						money -= cost4;
						days -= trip4;
						currentIsland = islandn4;
					} else {
						System.out.println("Unable to travel here sorry!");
					}
				}
				break;
			}
			Random rand = new Random();
			RandomEvent random = null;
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
		} else {
			System.out.println("You do not have enough money to fix the damage to your ship!");
		}
	}
	
	static void purchaseItem(Item item) {
		if (money - item.price > 0) {
			money -= item.price;
			myShip.cargo.add(item);
			myShip.cargoSpace -= item.size;
			System.out.println("You have successfully purchased the item!\n");
		} else {
			System.out.println("You do not have enough money to purchase this item!\n");
		}
	}
	
	static void sellItem(Item item) {
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
			money += item.price;
			soldGoods.add(item);
			myShip.cargo.remove(itemtoRemove);
			myShip.cargoSpace += item.size;
			item.amountSold = item.price;
			item.storeSold = currentIsland;
			System.out.println("You have successfully sold the item!\n");

		} else {
			System.out.println("You do not have this item to sell!\n");
		}
		
	}


	public static void main(String[] args) {
		setUp();
		game();
		int score = (initialDays -(initialDays - days)) * money;
		System.out.println(name + " you have played for " + (initialDays -(initialDays - days)) + " days out of the " + initialDays +
				" days you requested to play for. \nYou have achieved a score of " + score + " points!");
		System.out.println("\nThank you for playing!\n");
	}
	
	
	
}
