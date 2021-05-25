import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameEnvironmentTest {
	GameEnvironment gameEnv = new GameEnvironment();

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCheckName() {
		String name1 = "Bob";
		String name2 = "R@y";
		String name3 = "Ou";
		String name4 = "1234";
		
		assertEquals(true, gameEnv.checkName(name1));
		assertEquals(false, gameEnv.checkName(name2));
		assertEquals(false, gameEnv.checkName(name3));
		assertEquals(false, gameEnv.checkName(name4));
		
	}

	@Test
	void testSetDays() {
		int days = 30;
		gameEnv.setDays(days);
		assertEquals(30, gameEnv.getDays());
	}

	@Test
	void testGetCurrentIslandName() {
		gameEnv.setShip("Voyager");
		gameEnv.islandInitialiser();
		assertEquals("Pen Island", gameEnv.getCurrentIslandName());
	}

	@Test
	void testGetShipName() {
		gameEnv.setShip("Voyager");
		assertEquals("Voyager", gameEnv.getShipName());
	}

	@Test
	void testSellItem() {
		gameEnv.setShip("Voyager");
		Item item1 = new Item("Item1",30, 10, "Random test item");
		Item item2 = new Item("Item2",30, 10, "Random test item2");
		
		gameEnv.purchaseItem(item1);
		assertEquals(true, gameEnv.sellItem(item1));
		assertEquals(false, gameEnv.sellItem(item2));
	}

	@Test
	void testPurchaseItem() {
		gameEnv.setShip("Voyager");
		Item item1 = new Item("Item1",4000, 10, "Random test item");
		// item1 worth more than the amount of money possible, should return false
		Item item2 = new Item("Item2",30, 10, "Random test item2");
		// should return true
		assertEquals(false, gameEnv.purchaseItem(item1));
		assertEquals(true, gameEnv.purchaseItem(item2));
	}

	@Test
	void testViewShipDetails() {
		gameEnv.setShip("Voyager");
		String ans = null;
		ans = gameEnv.viewShipDetails();
		assertNotNull(ans);
	}

}
