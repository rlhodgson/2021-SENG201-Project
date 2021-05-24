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
	
	public String viewProperties(int wage) {
		return "The distance from " + this.origIsland + " to " + this.destIsland + " is " + tripDist +" km. It will take " + 
				this.tripDays + " days to get there. It will cost $" + (wage * this.tripDays) + ". "+ this.routeDets + "\n";
	}
	
	public int getDays() {
		return this.tripDays;
	}
	
	public String getDestination() {
		return this.destIsland;
	}

}
