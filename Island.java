
import java.util.ArrayList;

public class Island {
	private String name;
	private ArrayList<Route> routes;
	private Store store;
	
	Island(String nname)	{
		name = nname;
		routes = new ArrayList<Route>();
	}
	
	public void viewProperties(int wage) {
		System.out.println(name + " has routes:\n");
		for (Route i : routes) {
			i.viewProperties(wage);
		}
		/*need to do store still*/
	}
	
	public void displayRoutes(int wage) {
		int i = 1;
		for (Route route: this.routes) {
			System.out.print(i + ") ");
			route.viewProperties(wage);
			i ++;
		}
	}
	
	public void listStoreItems() {
		this.store.viewItems();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void addRoute(Route route) {
		this.routes.add(route);
	}
	
	public void addStore(Store storein) {
		this.store = storein;
	}
	
	public void viewStoreSelling() {
		this.store.viewSelling();
	}
	
	public void viewStoreBuying() {
		this.store.viewBuying();
	}
	
	public Item getItemSold(int index) {
		return this.store.getItemSold(index);
	}
	
	public Item getItemPurchased(int index) {
		return this.store.getItemPurchased(index);
	}
	
	public Route getRoute(int index) {
		return this.routes.get(index);
	}
	
}	

