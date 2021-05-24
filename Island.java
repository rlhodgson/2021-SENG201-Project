
import java.util.ArrayList;

public class Island {
	private String name;
	private ArrayList<Route> routes;
	private Store store;
	
	Island(String nname)	{
		name = nname;
		routes = new ArrayList<Route>();
	}
	
	public String viewProperties(int wage) {
		String toReturn = this.name + " has routes:\n";
		for (Route route : this.routes) {
			toReturn += route.viewProperties(wage);
		}
		
		return toReturn;
	}
	
	public void getRoutes(int wage) {
		int i = 1;
		for (Route route: this.routes) {
			System.out.print(i + ") ");
			route.viewProperties(wage);
			i ++;
		}
	}
	
	public String getStoreItems() {
		return this.store.viewItems();
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
	
	public ArrayList<Item> getStoreSelling() {
		return this.store.getSelling();
	}
	
	public ArrayList<Item> getStoreBuying() {
		return this.store.getBuying();
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

