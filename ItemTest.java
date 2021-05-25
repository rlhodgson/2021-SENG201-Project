import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemTest {
	
	Item testItem = new Item("Tester", 50, 10, "Just an item for testing");

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testToString() {
		String expected = "Tester costs $50 and takes up 10 space.\n";
		assertEquals(expected, testItem.toString());
	}

	@Test
	void testGetDescr() {
		String expected = ("Tester cost you $50 and is taking up 10 amount of cargo.\n");
		assertEquals(expected, testItem.getDescr());
	}

	@Test
	void testGetRawDescription() {
		String expected = "Just an item for testing";
		assertEquals(expected, testItem.getRawDescription());
	}

	@Test
	void testChangeSoldInfo() {
		int amount = 100;
		Island testIsland = new Island("Pen Island");
		testItem.changeSoldInfo(amount, testIsland);
		String expected = ("Tester sold for $100 at the store on Pen Island\n");
		assertEquals(expected, testItem.getDescr());
	}

}
