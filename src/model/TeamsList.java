package model;

import helpers.ReadFile;
import helpers.TeamsComparator;

import java.util.ArrayList;

public class TeamsList extends ArrayList<Team> {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  public static TeamsList teamsList = new TeamsList();
  
  private TeamsList () {
    super();
    
    // Read teams
    ArrayList<String> teams = ReadFile.readFile("src/data/TeamsIn.txt");
    for (String teamName : teams) {
      Team team = new Team(teamName);
      this.add(team);
    }
    
    this.sort(new TeamsComparator());
  }
  
  public static TeamsList getInstance() {
    return teamsList;
  }
  
}