
import java.util.ArrayList;
/**Island class housing island aspects
 * 
 * @author Rachel Hodgson and Aidan Campbell
 *
 */
public class Island {
	private String name;
	private ArrayList<Route> routes;
	private Store store;
	
	Island(String nname)	{
		name = nname;
		routes = new ArrayList<Route>();
	}
	
	/**Returns a string of the properties of an island
	 * 
	 * @param wage The daily cost to sail
	 * @return String
	 */
	public String viewProperties(int wage) {
		String toReturn = this.name + " has routes:\n";
		for (Route route : this.routes) {
			toReturn += route.viewProperties(wage);
		}
		
		return toReturn;
	}
	
	/**Returns all routes from a given island
	 * 
	 * @param wage The daily cost to sail
	 */
	public void getRoutes(int wage) {
		int i = 1;
		for (Route route: this.routes) {
			System.out.print(i + ") ");
			route.viewProperties(wage);
			i ++;
		}
	}
	
	/**Returns the items within the store on the island
	 * 
	 * @return String
	 */
	public String getStoreItems() {
		return this.store.viewItems();
	}
	
	/**Returns the name of the island
	 * 
	 * @return String
	 */
	public String getName() {
		return this.name;
	}
	
	/**Adds a route to the route list
	 * 
	 * @param route Route to add
	 */
	public void addRoute(Route route) {
		this.routes.add(route);
	}
	
	/**Adds a store to the island
	 * 
	 * @param storein The store to set at the island
	 */
	public void addStore(Store storein) {
		this.store = storein;
	}
	
	/**Returns the items that the store on the island sells
	 * 
	 * @return ArrayList
	 */
	public ArrayList<Item> getStoreSelling() {
		return this.store.getSelling();
	}
	
	/**Returns the items that the store on the island buys
	 * 
	 * @return ArrayList
	 */
	public ArrayList<Item> getStoreBuying() {
		return this.store.getBuying();
	}
	
	/**Returns a particular item that has been sold from the island store
	 * 
	 * @param index Integer of the item index
	 * @return Item
	 */
	public Item getItemSold(int index) {
		return this.store.getItemSold(index);
	}
	
	/**Returns a particular item that has been bought from the island store
	 * 
	 * @param index Integer of the item index
	 * @return Item
	 */
	public Item getItemPurchased(int index) {
		return this.store.getItemPurchased(index);
	}
	
	/**Return a route 
	 * 
	 * @param index Index of route
	 * @return route
	 */
	public Route getRoute(int index) {
		return this.routes.get(index);
	}
	
}	

