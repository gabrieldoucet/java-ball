package model;

import helpers.TeamsComparator;

public class Match {

  private Team team1;
  private Team team2;
  private Score score;

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

    this.score = new Score(this);
  }

  public Team getTeam1() {
    return this.team1;
  }

  public Team getTeam2() {
    return this.team2;
  }

  public Score getScore() {
    return this.score;
  }

  public void setScore(Score score) {
    this.score = score;
  }

  public boolean pending() {
    return this.score.getScoreTeam1() == -1 && this.score.getScoreTeam2() == -1;
  }

  public boolean equals(Match m) {
    TeamsComparator tc = new TeamsComparator();
    return tc.compare(m.getTeam1(), this.team1) == 0
        && tc.compare(m.getTeam2(), this.team2) == 0;
  }

  public void printMatch() {
    System.out.println(this.team1.getName() + " v " + this.team2.getName()
        + " " + this.score.getScoreTeam1() + " " + this.score.getScoreTeam2());
  }
}