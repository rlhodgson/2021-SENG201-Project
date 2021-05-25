import java.util.*; 
import java.util.Random;

public class GameEnvironment {
	
	private String name = "";
	private int days;
	private int initialDays;
	private int money = 1500;
	private Ship myShip;
	private ArrayList<Item> soldGoods = new ArrayList<Item>();
	private Island currentIsland;
	private ArrayList<Island> islands = new ArrayList<Island>();
	private RandomEvent previousRandomEvent;
	

	public void launchmainWindow() {
		MainWindow main = new MainWindow(this);
	}

	public void closeMainWindow(MainWindow main) {
		main.closeWindow();
	}

	public void launchSetUpWindow() {
		SetUpWindow setUp = new SetUpWindow(this);
	}

	public void closeSetUpWindow(SetUpWindow setUp) {
		setUp.closeWindow();
		islandInitialiser();
		launchmainWindow();
	}
	
	
	
	public boolean checkName(String name) {
		if (name.length() >= 3 && name.length() <= 15 && name.matches("[ a-zA-Z]+")) {
			return true;
		} else {
			return false;
		}
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDays(int days) {
		this.days = days;
		this.initialDays = days;
	}
	
	
	public void setShip(String shipName) {
		
		Ship ship1 = new Ship("Voyager", 12, 30, 35, 70);
		Ship ship2 = new Ship("Midnight", 16, 25, 40, 80);
		Ship ship3 = new Ship("Summer", 20, 20, 45, 90);
		Ship ship4 = new Ship("Black Pearl", 24, 15, 52, 100);
		
		
		switch(shipName) {
		case "Voyager":
			this.myShip = ship1;
			break;
		case "Midnight":
			this.myShip = ship2;
			break;
		case "Summer":
			this.myShip = ship3;
			break;
		case "Black Pearl":
			this.myShip = ship4;
			break;	
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	
	public String getCurrentIslandName() {
		return this.currentIsland.getName();
	}
	
	public String getShipName() {
		return this.myShip.getName();
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public String viewPurchasedGoods() {
				
		String toReturn = "";
		toReturn += ("\nCurrent goods in cargo: \n");
		toReturn += this.myShip.viewPurchasedGoods();

		/* view sold goods next */
		toReturn += ("\nGoods that have been sold: \n");
		for (Item i : soldGoods) {
			toReturn += i.getDescr();
		}
		
		return toReturn;
	}
	
	public ArrayList<Item> getItemsStoreBuys(){
		return this.currentIsland.getStoreBuying();
	}
	
	public ArrayList<Item> getItemsStoreSells(){
		return this.currentIsland.getStoreSelling();
	}
	
	
	public boolean sellItem(Item item) {
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
		} 
		
		return found;
	}
	
	
	public boolean purchaseItem(Item item) {
		
		boolean canPurchase = false;
		if (this.money - item.getPrice() >= 0 && this.myShip.getCargoSpace() - item.getSize() >= 0) {  	
			this.money -= item.getPrice();
			this.myShip.addCargo(item);
			if (item.getName().contains("Upgrade")) {
				this.myShip.addUpgrade(item.getName());
			}
			canPurchase = true;
		}
		
		return canPurchase;
	}
	
	
	public String getEndStatement() {
		String endStatement = "";
		
		int itemsWorth = 0;
		for (Item item : this.myShip.getCargo()) {
			itemsWorth += item.getPrice();
		}
		int profit = this.money + itemsWorth;
		
		double daysPlayed = (double)(this.initialDays - this.days);
		int score =  (int) (daysPlayed / (double)this.initialDays * profit);
		endStatement += (this.name + " you have played for " + (int)daysPlayed + " days out of the " + this.initialDays +
				" days you requested to play for. \nYour profit was $" + profit + "\nYou have achieved a score of " + score + " points!\nThank you for playing!\n");
		return endStatement;
	}
	
	
	public boolean checkGameEnd() {
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
		
		if (this.days < minDays) { 													// not enough days to sail anywhere
			isFinished = true;
		}else if (minCost - maxSellable + dmgCost > this.money) {					// Not enough money to sail anywhere
			isFinished = true;
		}
		return isFinished;
	}
	
	
	public String setSail(int input) {
		
		this.previousRandomEvent = null;
		String sailMessage = "You don't have enough money or days left to sail to this island";

		Route route = this.currentIsland.getRoute(input-1);
		boolean canTravelTo = canTravel(route);
			if (canTravelTo == true) {
				changeIsland(route);
				
				sailMessage = randomEventHandler();
				
			}
			
		return sailMessage;
		
	}
	
	
	public boolean canTravel(Route route) {
		
		if (route.getDays() > this.days){											// Not enough days to travel here
			return false;
		}else if ((route.getDays() * this.myShip.getDailyCost() > this.money)){		// Not enough money to travel here
			return false;
		}else {
			return true;
		}
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
	
	
	public String randomEventHandler() {
		String eventString = "You have successfully sailed to the island";
		Random rand = new Random();
		
		
		int int_random = rand.nextInt(7);
		if (int_random <= 2) {
			
			RandomEvent randomObject = new RandomEvent(int_random, myShip);
			eventString = randomObject.initiateEvent();
			this.previousRandomEvent = randomObject;
			
			this.money += randomObject.getMoney();
			if (randomObject.didWalkPlank() == false) {
				eventString += "You have successfully sailed to the Island";
			}
		}
		return eventString;
	}
	
	
	public int getDays() {
		return this.days;
	}
	
	public String viewShipDetails() {
		return this.myShip.viewDetails();
	}
	
	public String getIslandsInfo() {
		String toReturn = "";
		toReturn += ("Islands:\n");
		toReturn += this.currentIsland.viewProperties(this.myShip.getDailyCost());
		toReturn += "\n";

		for (Island island : islands) {
			toReturn += island.getName() + ":\n";
			toReturn += island.getStoreItems();
			toReturn += ("\n");

		}
		return toReturn;
	}
	
	public Island getIsland() {
		return this.currentIsland;
	}
	
	public int getDailyWage() {
		return this.myShip.getDailyCost();
	}
	
	
	public boolean lostToPirates() {
		boolean didLose = false;
		if (this.previousRandomEvent != null) {
			if (previousRandomEvent.didWalkPlank() == true) {
				didLose = true;
			}
		}
		return didLose;
	}


	public int getShipDamageCost() {
		return this.myShip.getDamageCost();
	}
	
	
	public void payDamage() {
		int damageCost = this.myShip.getDamageCost();
		this.money -= damageCost;
		this.myShip.resetDamage();
	}


	
	
	public void routeInitialiser(Island island) {
		/*Initializes the routes between all islands and the islands stores*/
		int speed = this.myShip.getSpeed();
		
		if (island.getName() == "Pen Island") {
			
			Route route1 = new Route("Pen Island", "Herbert Island", 1500, speed, "Will likely encounter rough seas and potentially pirates");
			Route route2 = new Route("Pen Island", "St Caleb Island", 1650, speed, "Might possibly encounter rough seas and potentially pirates");
			Route route3 = new Route("Pen Island", "Palm Island", 1800, speed, "Will likely not encounter rough seas or pirates");
			Route route4 = new Route("Pen Island", "New Canada Island", 1950, speed, "May encounter rough seas or potentially pirates");
			
			/*Jewels*/
			ArrayList<Item> itemsSold = new ArrayList<Item>();
			Item item1 = new Item("Gold", 200, 10, "Large gold nugget!");
			Item item2 = new Item("Silver", 160, 8, "Medium silver nugget!");
			itemsSold.add(item1);
			itemsSold.add(item2);
			
			ArrayList<Item> itemsPurchased = new ArrayList<Item>();
			Item item3 = new Item("Skull Flag", 210, 5, "Large skull flag!");
			Item item4 = new Item("Black Flag", 190, 4, "Medium black flag!");
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
			
			Route route5 = new Route("Herbert Island", "Pen Island", 1500, speed, "Will likely encounter rough seas and potentially pirates");
			Route route6 = new Route("Herbert Island", "St Caleb Island", 2100, speed, "Will likely not encounter rough seas or pirates");
			Route route7 = new Route("Herbert Island", "Palm Island", 2250, speed, "May encounter rough seas, will likely encounter pirates");
			Route route8 = new Route("Herbert Island", "New Canada Island", 2400, speed, "Possibility of encountering extremely rough seas and maybe pirates");
			
			/*Weapons*/
			ArrayList<Item> itemsSold = new ArrayList<Item>();
			Item item1 = new Item("Machine Gun", 300, 10, "Large machine gun!");
			Item item2 = new Item("Machete", 150, 8, "Medium machete!");
			itemsSold.add(item1);
			itemsSold.add(item2);
			
			ArrayList<Item> itemsPurchased = new ArrayList<Item>();
			Item item3 = new Item("Gold", 300, 10, "Large gold nugget!");
			Item item4 = new Item("Silver", 240, 8, "Medium silver nugget!");
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
			Route route9 = new Route("St Caleb Island", "Pen Island", 1650, speed, "Might possibly encounter rough seas and potentially pirates");
			Route route10 = new Route("St Caleb Island", "Herbert Island", 2100, speed, "Will likely not encounter rough seas or pirates");
			Route route11 = new Route("St Caleb Island", "Palm Island", 2550, speed, "Probably won't encounter rough seas but pirates are likely");
			Route route12 = new Route("St Caleb Island", "New Canada Island", 2700, speed, "Likely to encounter rough seas, less likely to encounter pirates");			
			
			/*Flags*/
			ArrayList<Item> itemsSold = new ArrayList<Item>();
			Item item1 = new Item("Skull Flag", 100, 5, "Large skull flag!");
			Item item2 = new Item("Black Flag", 90, 4, "Medium black flag!");
			itemsSold.add(item1);
			itemsSold.add(item2);
			
			ArrayList<Item> itemsPurchased = new ArrayList<Item>();
			Item item3 = new Item("Machete", 250, 8, "Medium machete!");
			Item item4 = new Item("Machine Gun", 430, 10, "Large machine gun!");
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
			Route route13 = new Route("Palm Island", "Pen Island", 1800, speed, "Will likely not encounter rough seas or pirates");
			Route route14 = new Route("Palm Island", "Herbert Island", 2250, speed, "May encounter rough seas, will likely encounter pirates");
			Route route15 = new Route("Palm Island", "St Caleb Island", 2550, speed,  "Probably won't encounter rough seas but pirates are likely");
			Route route16 = new Route("Palm Island", "New Canada Island", 2850, speed, "Might discover pirates, but will likely encounter rough seas");
			
			/*Antiques*/
			ArrayList<Item> itemsSold = new ArrayList<Item>();
			Item item1 = new Item("Antique Lamp", 300, 8, "Antique lamp with gold fixings!");
			Item item2 = new Item("Antique Coins", 200, 10, "Coins from the early 1700s and 1800s!");
			itemsSold.add(item1);
			itemsSold.add(item2);
			
			ArrayList<Item> itemsPurchased = new ArrayList<Item>();
			Item item3 = new Item("Skull Flag", 190, 5, "Large skull flag!");
			Item item4 = new Item("Black Flag", 175, 4, "Medium black flag!");
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
			Route route17 = new Route("New Canada Island", "Pen Island", 1950, speed, "May encounter rough seas or potentially pirates");
			Route route18 = new Route("New Canada Island", "Herbert Island", 2400, speed, "Possibility of encountering extremely rough seas and maybe pirates");
			Route route19 = new Route("New Canada Island", "St Caleb Island", 2700, speed, "Likely to encounter rough seas, less likely to encounter pirates");
			Route route20 = new Route("New Canada Island", "Palm Island", 2850, speed, "Might discover pirates, but will likely encounter rough seas");
			
			/*Upgrades*/
			ArrayList<Item> itemsSold = new ArrayList<Item>();
			Item item1 = new Item("Upgraded Cannon", 80, 0, "Cannon can shoot much further!");
			Item item2 = new Item("Upgraded Guns", 100, 0, "Guns run a longer amount of ammunition!");
			itemsSold.add(item1);
			itemsSold.add(item2);
			
			ArrayList<Item> itemsPurchased = new ArrayList<Item>();
			Item item3 = new Item("Antique Lamp", 470, 8, "Antique lamp with gold fixings!");
			Item item4 = new Item("Antique Coins", 250, 10, "Coins from the early 1700s and 1800s!");

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
		Island island1 = new Island("Pen Island");
		routeInitialiser(island1);
		this.islands.add(island1);
		
		Island island2 = new Island("Herbert Island");
		routeInitialiser(island2);
		this.islands.add(island2);
		
		Island island3 = new Island("St Caleb Island");
		routeInitialiser(island3);
		this.islands.add(island3);
		
		Island island4 = new Island("Palm Island");
		routeInitialiser(island4);
		this.islands.add(island4);
		
		Island island5 = new Island("New Canada Island");
		routeInitialiser(island5);
		this.islands.add(island5);
		
		this.currentIsland = this.islands.get(0);

	}
	

	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		game.launchSetUpWindow();
	}
	
	
	
}
