package model;

import java.util.ArrayList;

public class TeamsList extends ArrayList<Team> {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  public static TeamsList teamsList = new TeamsList();
  
  private TeamsList () {
    super();
  }
  
  public static TeamsList getInstance() {
    return teamsList;
  }
  
}