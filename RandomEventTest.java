import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RandomEventTest {
	Ship testShip = new Ship("Tester", 10, 30, 40, 20);
	RandomEvent testRandom1 = new RandomEvent(0, testShip);
	RandomEvent testRandom2 = new RandomEvent(1, testShip);
	RandomEvent testRandom3 = new RandomEvent(2, testShip);

	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testPirateEvent() {
		String ans = testRandom1.initiateEvent();
		assertEquals(true, ans.contains("pirates"));
		String ans2 = testRandom2.initiateEvent();
		assertEquals(false, ans2.contains("pirates"));
	}

	@Test
	void testBadWeather() {
		String ans = testRandom2.initiateEvent();
		assertEquals(true, ans.contains("weather"));
		String ans2 = testRandom3.initiateEvent();
		assertEquals(false, ans2.contains("weather"));
	}

	@Test
	void testRescueSailors() {
		String ans = testRandom3.initiateEvent();
		assertEquals(true, ans.contains("sailors"));
		String ans2 = testRandom1.initiateEvent();
		assertEquals(false, ans2.contains("sailors"));
	}

//	@Test
	//void testGetMoney() {
		//fail("Not yet implemented");
	//}

	@Test
	void testDidWalkPlank() {
		boolean ans = false;
		String str = testRandom1.initiateEvent();
		if ((str.contains("over")) && (testRandom1.didWalkPlank() == true)) {
			ans = true;
		} else if (!(testRandom1.initiateEvent().contains("over")) && (testRandom1.didWalkPlank() == true)) {
			ans = true;
		}
		assertEquals(true, ans);
	}

}
