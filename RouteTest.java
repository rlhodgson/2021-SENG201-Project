import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RouteTest {
	Route testRoute = new Route("New Canada Island", "Pen Island", 1950, 100, "May encounter rough seas or potentially pirates");
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testViewProperties() {
		String expected = "The distance from New Canada Island to Pen Island is 1950 km. It will take " + 
				testRoute.getDays() + " days to get there. It will cost $" + testRoute.getDays() + ". May encounter rough seas or potentially pirates\n";
		assertEquals(expected, testRoute.viewProperties(1));
	}


	@Test
	void testGetDestination() {
		String destTrue = "Pen Island";
		String destFalse = "Not an island";
		assertEquals(destTrue, testRoute.getDestination());
		assertNotEquals(destFalse, testRoute.getDestination());
	}

}
