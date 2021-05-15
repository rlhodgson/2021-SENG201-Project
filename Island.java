
import java.util.ArrayList;

public class Island {
	String name;
	ArrayList<Route> routes;
	Store store;
	
	Island(String nname)	{
		name = nname;
		routes = new ArrayList<Route>();
	}
	
	void viewProperties() {
		System.out.println(name + " has routes:\n");
		for (Route i : routes) {
			i.viewProperties();
		}
		/*need to do store still*/
	}
	
	void visitStore() {
		System.out.println(name + " Store: \n");
		store.viewItems();
	}
	
	String getName() {
		return  name;
	}
	
	void addRoute(Route route) {
		routes.add(route);
	}
	
	void addStore(Store storein) {
		store = storein;
	}
 
}

