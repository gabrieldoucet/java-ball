package model;

public class Team {

	private String name;
	private int points;

	public Team(String name) {
		this.name = name;
		this.points = 0;
	}
	
	public Team(String name, int points) {
	    this.name = name;
	    this.points = points;
	}

	public int getPoints() {
		return this.points;
	}
	
	public String getName() {
	  return this.name;
	}
	
	public void printTeam() {
	  System.out.println("(" + this.name + ", " + this.points + ")");
	}
}