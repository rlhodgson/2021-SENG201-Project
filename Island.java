
import java.util.ArrayList;

public class Island {
	String name;
	ArrayList<Route> routes;
	Store store;
	
	@Override
	public String toString() {
		return (name);
	}
	
	Island(String nname)	{
		name = nname;
		routes = new ArrayList<Route>();
	}
	
	public String viewProperties() {
		String ans = "";
		
		ans += (name + " has routes:\n");
		for (Route i : routes) {
			ans += i.viewProperties();
		}
		
		return ans;
		/*need to do store still*/
	}
	
	public String visitStore() {
		String ans = "";
		ans += (name + " Store: \n");
		ans += store.viewItems();
		return ans;
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

