import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShipTest {
	Ship testShip = new Ship("Tester", 10, 30, 40, 20);
	Item testItem = new Item("Tester", 50, 10, "Just an item for testing");

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testViewDetails() {
		String expected = "\nShip, Tester, has 10 crew members.\nEach day sailing will cost you $15."
				+ " Currently there is 40 units of cargo space available" + "\nThere are currently no upgrades"
						+ "\nYour ship has no damage";
		assertEquals(expected, testShip.viewDetails());
	}

	@Test
	void testAddUpgrade() {
		testShip.addUpgrade("Upgraded Guns");
		String expected = "\nShip, Tester, has 10 crew members.\nEach day sailing will cost you $15."
				+ " Currently there is 40 units of cargo space available" + "\nThe current upgrade(s) are: \n"+ "Upgraded Guns" +
						"\nYour ship has no damage";
		assertEquals(expected, testShip.viewDetails());
	}

	@Test
	void testGetCargoSpace() {
		int current = 40;
		assertEquals(current, testShip.getCargoSpace());
		testShip.addCargo(testItem);
		int newCurrent = 30;
		assertEquals(newCurrent, testShip.getCargoSpace());	
	}
	
	@Test
	void testRemoveItem() {
		int current = testShip.getCargoSpace();
		testShip.addCargo(testItem);
		testShip.removeItem(testItem);
		int newCurrent = testShip.getCargoSpace();
		assertEquals(current, newCurrent);
	}
	
	@Test
	void testViewPurchasedGoods() {
		testShip.addCargo(testItem);
		String ans = "Tester cost you $50 and is taking up 10 amount of cargo.\n";
		assertEquals(ans, testShip.viewPurchasedGoods());
		testShip.removeItem(testItem);
		assertEquals("", testShip.viewPurchasedGoods());
	}

	@Test
	void testGetDailyCost() {
		int cost = 15;
		assertEquals(cost, testShip.getDailyCost());
		int costWrong = 44;
		assertNotEquals(costWrong, testShip.getDailyCost());
	}

	@Test
	void testGetDamageCost() {
		int current = 0;
		assertEquals(current, testShip.getDamageCost());
		testShip.changeDamage(11);
		boolean ans = false;
		if (testShip.getDamageCost() > 0) {
			ans = true;
		}
		assertEquals(true, ans);
	}

	@Test
	void testResetDamage() {
		boolean res = false;
		int damage = 11;
		testShip.changeDamage(damage);
		if (testShip.getDamageCost() > 0) {
			testShip.resetDamage();
			if (testShip.getDamageCost() == 0) {
				res = true;
			}
		}
		assertEquals(true, res);
	}

}
