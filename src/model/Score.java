package model;

public class Score {

  private Match match;
  private int scoreTeam1 = -1;
  private int scoreTeam2 = -1;
  
  public Score(Match match) {
    this.match = match;
  }
  
  public int getScoreTeam1() {
    return this.scoreTeam1;
  }

  public int getScoreTeam2() {
    return this.scoreTeam2;
  }
  
  public void setScoreTeam1(int scoreTeam1) {
    this.scoreTeam1 = scoreTeam1;
  }

  public void setScoreTeam2(int scoreTeam2) {
    this.scoreTeam2 = scoreTeam2;
  } 
}
