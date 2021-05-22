public class Route {
	String destIsland;
	String origIsland;
	int tripDist;
	String routeDets;
	
	Route(String origIslandIn , String destIslandIn, int tripIn, String routeDetsin)	{
		destIsland = destIslandIn;
		origIsland = origIslandIn;
		tripDist = tripIn;
		routeDets = routeDetsin;
	}
	
	public String viewProperties() {
		String ans = "";
		ans += ("The distance from " + origIsland + " to " + destIsland + " is "
				+ tripDist +" km. " + routeDets + "\n");
		return ans;
	}
	

}
