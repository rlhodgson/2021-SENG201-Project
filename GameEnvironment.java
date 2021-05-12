package seng201Project;
import java.util.*;  

public class GameEnvironment {
	
	static String name = "";
	
	static int days;
	static int money;
	static Ship myShip;
	static ArrayList<Item> soldGoods = new ArrayList<Item>();


	
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
		
		
		if (island.getName() == "Island1") {
			
			Route route1 = new Route("Island1", "Island2", 5);
			Route route2 = new Route("Island1", "Island3", 6);
			Route route3 = new Route("Island1", "Island4", 7);
			Route route4 = new Route("Island1", "Island5", 8);
			
			island.addRoute(route1);
			island.addRoute(route2);
			island.addRoute(route3);
			island.addRoute(route4);
		}
		
		if (island.getName() == "Island2") {
			
			Route route5 = new Route("Island2", "Island1", 5);
			Route route6 = new Route("Island2", "Island3", 9);
			Route route7 = new Route("Island2", "Island4", 10);
			Route route8 = new Route("Island2", "Island5", 11);
			island.addRoute(route5);
			island.addRoute(route6);
			island.addRoute(route7);
			island.addRoute(route8);
		}
			
		if (island.getName() == "Island3") {
			Route route9 = new Route("Island3", "Island1", 6);
			Route route10 = new Route("Island3", "Island2", 9);
			Route route11 = new Route("Island3", "Island4", 12);
			Route route12 = new Route("Island3", "Island5", 13);			
			island.addRoute(route9);
			island.addRoute(route10);
			island.addRoute(route11);
			island.addRoute(route12);
		
		}
			
		
		if (island.getName() == "Island4") {
			Route route13 = new Route("Island4", "Island1", 7);
			Route route14 = new Route("Island4", "Island2", 10);
			Route route15 = new Route("Island4", "Island3", 12);
			Route route16 = new Route("Island4", "Island5", 14);
			island.addRoute(route13);
			island.addRoute(route14);
			island.addRoute(route15);
			island.addRoute(route16);

		}
			
		if (island.getName() == "Island5") {
			Route route17 = new Route("Island5", "Island1", 8);
			Route route18 = new Route("Island5", "Island2", 11);
			Route route19 = new Route("Island5", "Island3", 13);
			Route route20 = new Route("Island5", "Island4", 14);
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
		
	}
	
	static void game() {
		Island currentIsland = islands.get(0);
		boolean gameEnd = false;
		
		while (gameEnd == false) {
			String choices = "1) View amount of money and number of days remaining \n2) View properties of ship \n3) View purchased goods \n"
					+ "4) View islands \n5) Visit store \n6) Set sail";
			
			System.out.println("What would you like to do? /n");
			System.out.println(choices);
			
			Scanner sc= new Scanner(System.in);
			int choice = sc.nextInt();
			

			switch(choice) {
			case 1:
				System.out.println(name + ", you have $"+money+" and " + days +" days remaining.");
				break;
			case 2:
				myShip.viewDetails();
				break;
			case 3:
				System.out.println("/nCurrent goods in cargo: /n");
				myShip.viewPurchasedGoods();
				
				/*view sold goods next*/
				System.out.println("/nGoods that have been sold: /n");
				for (Item i : soldGoods) {
					i.getDescr();
				}
				break;
			case 4:
				System.out.println("Islands:\n");
				currentIsland.viewProperties();
				break;
			case 5:
				System.out.println("store");
				/*currentIsland.visitStore();*/
				
				/*input for numbered items in the store*/
				/*call purchaseItem(item) function*/
				
				/*sellItem(item)*/

				break;
			case 6:
				setSail();
				break;
			}
		}
		
		
		
	}
	
	static void setSail() {
		System.out.println("Need to check some stuff then we're good to go");
	}
	
	/*purchaseItem(item)
	 add to purchased items
	 continue until asked to close
	 add to ship
	 reduce money
	 */
	
	/*sellItem(item)
	 increase money
	 remove from ship
	 add to soldGoods list
	 */

	public static void main(String[] args) {
		setUp();
		game();
	}
	
	
	
}

