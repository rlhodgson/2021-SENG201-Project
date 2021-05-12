package seng201Project;

public class Trader {
	
	String name;
	int money;
	int daysRemaining;
	
	Trader(String nname, int nmoney, int days) {
		name = nname;
		money = nmoney;
		daysRemaining = days;
	}
	
	void viewTimeMoney() {
		System.out.println(name + ", you have $"+money+" and " + daysRemaining +" days remaining.");
	}
	


}
