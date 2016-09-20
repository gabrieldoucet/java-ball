package model;

import helpers.ReadFile;

import java.util.ArrayList;

public class Tournament {

  public static ArrayList<Match> matchesList = new ArrayList<Match>();
  public static ArrayList<Team> teamsList = new ArrayList<Team>();

  public static void main(String[] args) {
    
    // Read teams
    ArrayList<String> teams = ReadFile.readFile("src/data/TeamsIn.txt");
    for (String teamName : teams) {
      Team team = new Team(teamName);
      TeamsList.getInstance().add(team);
    }
    
    for (Team team : TeamsList.getInstance()) {
      team.printTeam();
    }
    
    MatchesList.buildMatches();
  }

  private Tournament() {

  }
}
