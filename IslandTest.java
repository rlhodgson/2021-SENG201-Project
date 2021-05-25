import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IslandTest {
	GameEnvironment game = new GameEnvironment();
	Island testIsland = new Island("Pen Island");
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testViewProperties() {
		String ans = null;
		ans = testIsland.viewProperties(5);
		assertNotNull(ans);
	}

	@Test
	void testGetStoreItems() {
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
		testIsland.addStore(island5Store);
		
		
		String ans = null;
		ans = testIsland.getStoreItems();
		assertNotNull(ans);
	}

	@Test
	void testGetStoreSelling() {
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
		testIsland.addStore(island5Store);
		boolean result = false;
		ArrayList<Item> items = new ArrayList<Item>();
		items = testIsland.getStoreSelling();
		if (items.size() == 2 ) {
			result = true;
		}
		assertEquals(true, result);
		
	}
	
	@Test
	void testGetStoreBuying() {
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
		testIsland.addStore(island5Store);
		boolean result = false;
		ArrayList<Item> items = new ArrayList<Item>();
		items = testIsland.getStoreBuying();
		if (items.size() == 2 ) {
			result = true;
		}
		assertEquals(true, result);
		
	}
		
	@Test
	void getItemPurchased() {
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
		testIsland.addStore(island5Store);
		Item item = testIsland.getItemPurchased(1);

		assertEquals("Antique Coins", item.getName());
		
	}
	
	@Test
	void TestGetItemSold() {
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
		testIsland.addStore(island5Store);
		Item item = testIsland.getItemSold(1);

		assertEquals("Upgraded Guns", item.getName());
		
	}
}
