import java.util.*; 
import java.util.Random;

public class GameEnvironment {
	
	public static final String LINE_SEPERATOR = "\n#################################\n";
	private String name = "";
	private int days;
	private int initialDays;
	private int money = 1500;
	private Ship myShip;
	private ArrayList<Item> soldGoods = new ArrayList<Item>();
	private Island currentIsland;
	private ArrayList<Island> islands = new ArrayList<Island>();
	


	// handles the setup of the game where you choose name, days and ship and then creates all the islands
	public void setUp() {

		boolean ready = false;
		do {		
			chooseName();	
			System.out.println(LINE_SEPERATOR);
			chooseDays();
			System.out.println(LINE_SEPERATOR);
			chooseShip();
			System.out.println(LINE_SEPERATOR);
			
			// This checks if the user is ready to start of if they'd like to restart the setup
			System.out.println("Ready to start?\n1) Start\n2) Restart setup");
			boolean isValid = false;
			while (isValid == false) {
				int choice = numInput();
				if (choice == 1) {
					isValid = true;
					ready = true;
				}else if (choice == 2) {
					isValid = true;
					System.out.println(LINE_SEPERATOR);
				}else {
					System.out.println("Please choose 1 or 2");
				}
				
			}
			
		}while (ready == false);
		
		
		islandInitialiser();
		
	}
	
	
	// handles choosing the trader name at startup
	public void chooseName() {
		
		boolean validName = false;
		while (validName == false) {
			System.out.println("Choose your trader name (3-15 characters):");
			Scanner sc= new Scanner(System.in);
			String tname = sc.nextLine();
			
			
			if (tname.length() >= 3 && tname.length() <= 15 && tname.matches("[ a-zA-Z]+")) {
				this.name = tname;
				validName = true;

			} else {
				System.out.println("Please choose a valid name!\n");
			}
			
		}
		
		
	}
	
	
	// handles choosing the number of days at startup
	public void chooseDays() {
		
		boolean validDays = false;
		while (validDays == false) {
			System.out.println("Choose the number of days you want to play for between 20 and 50: ");
			int tdays = numInput();
			
			if (tdays <= 50 && tdays >= 20) {
				this.days = tdays;
				this.initialDays = tdays;
				validDays = true;
				
			} else {
				System.out.println("Please choose a valid number of days!\n");
			}
		}
	}
	
	
	// handles choosing the ship at startup
	public void chooseShip() {
		
		ArrayList<Ship> ships = new ArrayList<Ship>();
		
		Ship ship1 = new Ship("Ship1", 12, 30, 30, 70);
		Ship ship2 = new Ship("Voyager", 16, 25, 40, 80);
		Ship ship3 = new Ship("Midnight", 20, 20, 45, 90);
		Ship ship4 = new Ship("Summer", 24, 15, 52, 100);
		
		ships.add(ship1);
		ships.add(ship2);
		ships.add(ship3);
		ships.add(ship4);
				
		for (Ship ship : ships) {
			ship.viewMinDetails(ship.getSpeed());
			System.out.println();
		}
		
		System.out.println("Choose your ship:\n");
		
		
		boolean validShip = false;
		
		while (validShip == false) {
			Scanner sc= new Scanner(System.in);
			String tship = sc.nextLine();
			
			String shipname = tship.toLowerCase();
			/*Check the ship is valid*/
			switch(shipname) {
			case "ship1":
				this.myShip = ship1;
				validShip = true;
				break;
			case "voyager":
				this.myShip = ship2;
				validShip = true;
				break;
			case "midnight":
				this.myShip = ship3;
				validShip = true;
				break;
			case "summer":
				this.myShip = ship4;
				validShip = true;
				break;	
			default: System.out.println("Invalid ship name, choose again \n");
			}
		}
	}
	
	
	public void routeInitialiser(Island island) {
		/*Initializes the routes between all islands and the islands stores*/
		int speed = this.myShip.getSpeed();
		
		if (island.getName() == "Island1") {
			
			Route route1 = new Route("Island1", "Island2", 1500, speed, "Will likely encounter rough seas and potentially pirates");
			Route route2 = new Route("Island1", "Island3", 1650, speed, "Might possibly encounter rough seas and potentially pirates");
			Route route3 = new Route("Island1", "Island4", 1800, speed, "Will likely not encounter rough seas or pirates");
			Route route4 = new Route("Island1", "Island5", 1950, speed, "May encounter rough seas or potentially pirates");
			
			/*Jewels*/
			ArrayList<Item> itemsSold = new ArrayList<Item>();
			Item item1 = new Item("Gold", 200, 10, "Large gold nugget!");
			Item item2 = new Item("Silver", 160, 8, "Medium silver nugget!");
			itemsSold.add(item1);
			itemsSold.add(item2);
			
			ArrayList<Item> itemsPurchased = new ArrayList<Item>();
			Item item3 = new Item("Copper", 50, 8, "Medium sized piece of copper!");
			Item item4 = new Item("Bronze", 40, 8, "Medium sized bronze pieces!");
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
			
			Route route5 = new Route("Island2", "Island1", 1500, speed, "Will likely encounter rough seas and potentially pirates");
			Route route6 = new Route("Island2", "Island3", 2100, speed, "Will likely not encounter rough seas or pirates");
			Route route7 = new Route("Island2", "Island4", 2250, speed, "May encounter rough seas, will likely encounter pirates");
			Route route8 = new Route("Island2", "Island5", 2400, speed, "Possibility of encountering extremely rough seas and maybe pirates");
			
			/*Weapons*/
			ArrayList<Item> itemsSold = new ArrayList<Item>();
			Item item1 = new Item("Machine Gun", 300, 10, "Large machine gun!");
			Item item2 = new Item("Machete", 150, 8, "Medium machete!");
			itemsSold.add(item1);
			itemsSold.add(item2);
			
			ArrayList<Item> itemsPurchased = new ArrayList<Item>();
			Item item3 = new Item("Gold", 250, 10, "Large gold nugget!");
			Item item4 = new Item("Silver", 200, 8, "Medium silver nugget!");
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
			Route route9 = new Route("Island3", "Island1", 1650, speed, "Might possibly encounter rough seas and potentially pirates");
			Route route10 = new Route("Island3", "Island2", 2100, speed, "Will likely not encounter rough seas or pirates");
			Route route11 = new Route("Island3", "Island4", 2550, speed, "Probably won't encounter rough seas but pirates are likely");
			Route route12 = new Route("Island3", "Island5", 2700, speed, "Likely to encounter rough seas, less likely to encounter pirates");			
			
			/*Flags*/
			ArrayList<Item> itemsSold = new ArrayList<Item>();
			Item item1 = new Item("Skull Flag", 100, 5, "Large skull flag!");
			Item item2 = new Item("Black Flag", 90, 4, "Medium black flag!");
			itemsSold.add(item1);
			itemsSold.add(item2);
			
			ArrayList<Item> itemsPurchased = new ArrayList<Item>();
			Item item3 = new Item("Machete", 200, 8, "Medium machete!");
			Item item4 = new Item("Machine Gun", 350, 10, "Large machine gun!");
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
			Route route13 = new Route("Island4", "Island1", 1800, speed, "Will likely not encounter rough seas or pirates");
			Route route14 = new Route("Island4", "Island2", 2250, speed, "May encounter rough seas, will likely encounter pirates");
			Route route15 = new Route("Island4", "Island3", 2550, speed,  "Probably won't encounter rough seas but pirates are likely");
			Route route16 = new Route("Island4", "Island5", 2850, speed, "Might discover pirates, but will likely encounter rough seas");
			
			/*Antiques*/
			ArrayList<Item> itemsSold = new ArrayList<Item>();
			Item item1 = new Item("Antique Lamp", 300, 8, "Antique lamp with gold fixings!");
			Item item2 = new Item("Antique Coins", 200, 10, "Coins from the early 1700s and 1800s!");
			itemsSold.add(item1);
			itemsSold.add(item2);
			
			ArrayList<Item> itemsPurchased = new ArrayList<Item>();
			Item item3 = new Item("Skull Flag", 130, 5, "Large skull flag!");
			Item item4 = new Item("Black Flag", 120, 4, "Medium black flag!");
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
			Route route17 = new Route("Island5", "Island1", 1950, speed, "May encounter rough seas or potentially pirates");
			Route route18 = new Route("Island5", "Island2", 2400, speed, "Possibility of encountering extremely rough seas and maybe pirates");
			Route route19 = new Route("Island5", "Island3", 2700, speed, "Likely to encounter rough seas, less likely to encounter pirates");
			Route route20 = new Route("Island5", "Island4", 2850, speed, "Might discover pirates, but will likely encounter rough seas");
			
			/*Upgrades*/
			ArrayList<Item> itemsSold = new ArrayList<Item>();
			Item item1 = new Item("Upgraded Cannon", 80, 8, "Cannon can shoot much further!");
			Item item2 = new Item("Upgraded Guns", 100, 10, "Guns run a longer amount of ammunition!");
			itemsSold.add(item1);
			itemsSold.add(item2);
			
			ArrayList<Item> itemsPurchased = new ArrayList<Item>();
			Item item3 = new Item("Antique Lamp", 400, 8, "Antique lamp with gold fixings!");
			Item item4 = new Item("Antique Coins", 240, 10, "Coins from the early 1700s and 1800s!");

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
	
	
	public void islandInitialiser() {
		Island island1 = new Island("Island1");
		routeInitialiser(island1);
		this.islands.add(island1);
		
		Island island2 = new Island("Island2");
		routeInitialiser(island2);
		this.islands.add(island2);
		
		Island island3 = new Island("Island3");
		routeInitialiser(island3);
		this.islands.add(island3);
		
		Island island4 = new Island("Island4");
		routeInitialiser(island4);
		this.islands.add(island4);
		
		Island island5 = new Island("Island5");
		routeInitialiser(island5);
		this.islands.add(island5);
		
		this.currentIsland = this.islands.get(0);

	}
	
	
	
	//play game
	public void playGame() {
		
		boolean gameEnd = false;
		System.out.println(LINE_SEPERATOR);
		
		while (gameEnd == false) {
			String choices = "1) View amount of money and number of days remaining \n2) View properties of ship \n3) View purchased goods \n"
					+ "4) View islands \n5) Visit store \n6) Set sail \n7) Quit";
			
			
			System.out.println(choices);
			System.out.println("\nWhat would you like to do?\n");
			
			int choice = numInput();
			
			System.out.println(LINE_SEPERATOR);
			// when the input is a number it will execute the command associated with that number
			switch(choice) {
			case 1:
				System.out.println(this.name + ", you have $"+this.money+" and " + this.days +" days remaining.\n");
				break;
			case 2:
				this.myShip.viewDetails();
				break;
			case 3:
				System.out.println("\nCurrent goods in cargo: \n");
				this.myShip.viewPurchasedGoods();
				
				/*view sold goods next*/
				System.out.println("\nGoods that have been sold: \n");
				for (Item i : this.soldGoods) {
					i.getDescr();
				}
				break;
			case 4:
				this.currentIsland.viewProperties(this.myShip.getDailyCost());
				
				for (Island island : this.islands) {
					System.out.println("------------------------");
					System.out.println("\n" + island.getName() +":\n");
					island.listStoreItems();


				}
				
				break;
			case 5:
				this.currentIsland.listStoreItems();
				visitStore();
				System.out.println(LINE_SEPERATOR);
				break;
				
			case 6:
				int damageCost = this.myShip.getDamageCost();
				if (damageCost > 0) {
					if (damageCost < this.money) {
						this.money -= damageCost;
						System.out.println("You paid $" + damageCost + " to fix your ship.\n");
						gameEnd = setSail();
					}else {
						System.out.println("You need to sell some items so you can fix your ship before sailing!\n");
					}
					
				}else {
					gameEnd = setSail();
				}
				break;
			case 7:
				gameEnd = true;
				break;
			default:
				System.out.println("Not a valid number. Please choose a number between 1 and 7");
				break;
			}
			if (gameEnd != true){
				gameEnd = checkEnd();
			}
		}
		
		
		
	}
	
	
	public boolean checkEnd() {
		int minDays = this.currentIsland.getRoute(0).getDays();
		int minCost = this.myShip.getDailyCost() * minDays;
		int dmgCost = this.myShip.getDamageCost();
		boolean isFinished = false;
		int maxSellable = 0;
		
		Item item1 = this.currentIsland.getItemSold(0);
		Item item2 = this.currentIsland.getItemSold(1);
		for (Item item : this.myShip.getCargo()) {
			if (item.getName() == item1.getName() || item.getName() == item2.getName()) {
				maxSellable += item.getPrice();
			}
		}
		
		if (this.days < minDays) {
			System.out.println("Not enough days left to sail. Game Over!\n");
			isFinished = true;
		}else if (minCost + maxSellable - dmgCost > this.money) {
			System.out.println("Not enough money left to sail. Game Over!\n");
			isFinished = true;
		}
		return isFinished;
	}
	
	
	
	
	public void visitStore() {
		boolean leaveStore = false;
		while (leaveStore == false) {
			
			System.out.println("\nYou currently have $" + this.money + "\n");
			System.out.println("\nWould you like to buy or sell something? \n");
			System.out.println("1) Buy\n");
			System.out.println("2) Sell\n ");
			System.out.println("3) Leave store\n");
			System.out.println("4) View current goods\n");
	
			
			int input = numInput();		
			
			
			switch(input) {
			case 1:
				System.out.println("------------------------");
				System.out.println("Which item would you like to buy? \n");
				this.currentIsland.viewStoreSelling();
				System.out.println("Any other number to leave buy menu\n");
				
				int inputnextbuy = numInput();
				System.out.println("------------------------");
				
				switch(inputnextbuy) {
				case 1:
					Item item = this.currentIsland.getItemSold(0);
					purchaseItem(item);
					break;
				case 2:
					Item item2 = this.currentIsland.getItemSold(1);
					purchaseItem(item2);
					break;
				default:
					break;
				}
				
				break;
			case 2:
				System.out.println("------------------------");
				System.out.println("Which item would you like to sell? \n");
				this.currentIsland.viewStoreBuying();
				System.out.println("Any other number to leave sell menu\n");
				
				int inputnextsell = numInput();
				System.out.println("------------------------");
				
				switch(inputnextsell) {
				case 1:
					Item item = this.currentIsland.getItemPurchased(0);
					sellItem(item);
					break;
				case 2:
					Item item2 = this.currentIsland.getItemPurchased(1);
					sellItem(item2);
					break;
				default:
					break;
				}
				break;
			case 3:
				leaveStore = true;
				break;
			case 4:
				System.out.println("------------------------");
				System.out.println("\nCurrent goods in cargo: \n");
				this.myShip.viewPurchasedGoods();
				
				/*view sold goods next*/
				System.out.println("\nGoods that have been sold: \n");
				for (Item i : this.soldGoods) {
					i.getDescr();
				}
				
				break;
			}
			
		}
	}
	
	
	public boolean setSail() {
		System.out.println("Which island would you like to travel to?\n");
		this.currentIsland.displayRoutes(this.myShip.getDailyCost());
		System.out.println("Any other number to return");
		
		boolean isGameOver = false;
		int input = numInput();
		System.out.println(LINE_SEPERATOR);
		if (input > 0 && input <= 4) {
			Route route = this.currentIsland.getRoute(input-1);
			boolean canTravelTo = canTravel(route);
			if (canTravelTo == true) {
				changeIsland(route);
				isGameOver = randomEventHandler();
			}
			if (canTravelTo == true && isGameOver == false) {
				System.out.println("\nSuccessfully sailed to the island!\n");
			}
		}
		return isGameOver;
		
	}
	
	
	public void changeIsland(Route route) {
		
		String islandName = route.getDestination();
		for (Island island : this.islands) {
			if (island.getName() == islandName) {
				this.currentIsland = island;
			}
		}
		this.days -= route.getDays();
		this.money -= route.getDays() * this.myShip.getDailyCost();
	}
	
	
	public boolean randomEventHandler() {
		boolean gameOver = false;
		Random rand = new Random();
		RandomEvent randomObject = null;
		
		int int_random = rand.nextInt(7);
		if (int_random <= 2) {
			System.out.println(LINE_SEPERATOR);
			randomObject = new RandomEvent(int_random, myShip);
			this.money += randomObject.getMoney();
			if (randomObject.didWalkPlank() == true) {
				gameOver = true;
			}
		}
		return gameOver;
	}
	
	
	public void purchaseItem(Item item) {
		if (this.money - item.getPrice() < 0) {   											// if we don't have enough money for the item
			System.out.println("You do not have enough money to purchase this item!\n");
		} else if (this.myShip.getCargoSpace() < item.getSize()) { 							// if we don't have enough space for the item
			System.out.println("You do not have enough space to purchase this item!\n");
		} else {																			// otherwise purchase the item
			this.money -= item.getPrice();
			this.myShip.addCargo(item);
			System.out.println("You have successfully purchased the item!\n");
		}
		
	}
	
	public void sellItem(Item item) {
		String itemName = item.getName();
		Item itemtoRemove = null;
		boolean found = false;
		for (Item storedItem : this.myShip.getCargo()) {
			if (storedItem.getName() == itemName) {
				itemtoRemove = storedItem;
				found = true;
			}
		}
		
		if (found == true) {
			this.money += item.getPrice();
			this.myShip.removeItem(itemtoRemove);
			
			// need to create a new item object otherwise if bought again later it will affect the sold goods item
			Item soldItem = new Item(itemtoRemove.getName(), itemtoRemove.getPrice(), itemtoRemove.getSize(), itemtoRemove.getRawDescription());
			soldItem.changeSoldInfo(item.getPrice(), this.currentIsland); // changes the info of where and for how much the item was sold
			
			this.soldGoods.add(soldItem);
			System.out.println("You have successfully sold the item!\n");

		} else {
			System.out.println("You do not have this item to sell!\n");
		}
		
	}
	
	public void printScore() {
		
		double daysPlayed = (double)(this.initialDays - this.days);
		int score =  (int) (daysPlayed / (double)this.initialDays * this.money);
		System.out.println(this.name + " you have played for " + (int)daysPlayed + " days out of the " + this.initialDays +
				" days you requested to play for. \nYou have achieved a score of " + score + " points!");
		System.out.println("\nThank you for playing!\n");
	}
	// gets the input and checks if it is a number, returns only once a number has been input
	public int numInput() {
		
		int input = 0;
		boolean isNum = false;
		while (isNum == false){
			Scanner sc = new Scanner(System.in);
			if (!sc.hasNextInt()) {
				System.out.println("Please give a valid number\n");
				
			}
			else {
				isNum = true;
				input = sc.nextInt();
			}
		}
		return input;
	}
	
	public boolean canTravel(Route route) {
		// not enough days to travel
		// not enough money to travel
		// damaged ship?
		
		if (route.getDays() > this.days){
			System.out.println("Not enough days left to travel here!\n");
			return false;
		}else if ((route.getDays() * this.myShip.getDailyCost() > this.money)){
			System.out.println("Not enough money to pay crews wages to travel here!\n");
			return false;
		}else {
			return true;
		}
	}


	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		game.setUp();
		game.playGame();
		game.printScore();
	}
	
	
	
}
