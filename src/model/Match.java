package model;

import helpers.TeamsComparator;

public class Match {

  private Team team1;
  private Team team2;
  private int score;

  public Match(Team team1, Team team2) {
    
    TeamsComparator tc = new TeamsComparator();
    int res = tc.compare(team1, team2);
    if (res > 0) {
      this.team1 = team2;
      this.team2 = team1;      
    } else {
      this.team1 = team1;
      this.team2 = team2;
    }

    this.score = -1;
  }

  public Team getTeam1() {
    return this.team1;
  }

  public Team getTeam2() {
    return this.team2;
  }

  public void printMatch() {
    System.out.println(this.team1.getName() + " v " + this.team2.getName() + " "
        + this.score);
  }
}