/**Route class controlling route aspects
 * 
 * @author Rachel Hodgson and Aidan Campbell
 *
 */
public class Route {
	private String destIsland;
	private String origIsland;
	private int tripDist;
	private int tripDays;
	private String routeDets;
	
	Route(String origIslandIn , String destIslandIn, int tripIn, int shipSpeed, String routeDetsin)	{
		this.destIsland = destIslandIn;
		this.origIsland = origIslandIn;
		this.tripDist = tripIn;
		this.routeDets = routeDetsin;
		this.tripDays = (int)(tripIn / shipSpeed / 24);
	}
	
	/**Returns a string of the properties of the route 
	 * 
	 * @param wage Cost per day to travel
	 * @return String
	 */
	public String viewProperties(int wage) {
		return "The distance from " + this.origIsland + " to " + this.destIsland + " is " + tripDist +" km. It will take " + 
				this.tripDays + " days to get there. It will cost $" + (wage * this.tripDays) + ". "+ this.routeDets + "\n";
	}
	
	/**Returns the number days the route will take
	 * 
	 * @return integer
	 */
	public int getDays() {
		return this.tripDays;
	}
	
	/**Returns the destination of the route
	 * 
	 * @return String
	 */
	public String getDestination() {
		return this.destIsland;
	}

}
