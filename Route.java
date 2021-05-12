package seng201Project;

public class Route {
	String destIsland;
	String origIsland;
	int tripDist;
	
	Route(String origIslandIn , String destIslandIn, int tripIn)	{
		destIsland = destIslandIn;
		origIsland = origIslandIn;
		tripDist = tripIn;
	}
	
	void viewProperties() {
		System.out.println("The distance from " + origIsland + " to " + destIsland + " is "
				+ tripDist +" km.");
	}
	

}
