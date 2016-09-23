package model;

import javafx.beans.property.SimpleIntegerProperty;

public class Team {

  private String name;
  private Result result;

  public Team(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public int getIndex() {
    return TeamsList.getTeamIndexFromName(this.name);
  }

  public Result getResult() {
    return this.result;
  }
  
  public void setResult(Result result) {
    this.result = result;
  }
  
  public void addVictory(int goalsFor, int goalsAgainst) {
    int matchesWon = this.result.getMatchesWonIntegerProperty().get();
    this.result.setMatchesWonIntegerProperty(new SimpleIntegerProperty(matchesWon + 1));

    int previousGoalsFor = this.result.getGoalsForIntegerProperty().get();
    this.result.setGoalsForIntegerProperty(new SimpleIntegerProperty(previousGoalsFor + goalsFor));
    
    int previousGoalsAgainst = this.result.getGoalsAgainstIntegerProperty().get();
    this.result.setGoalsAgainstIntegerProperty(new SimpleIntegerProperty(previousGoalsAgainst + goalsAgainst));
    
    int previousMatchPoints = this.result.getMatchPointsIntegerProperty().get();
    this.result.setMatchPointsIntegerProperty(new SimpleIntegerProperty(previousMatchPoints + 3));
    
    processGoalDiff();
  }
  
  public void addDefeat(int goalsFor, int goalsAgainst) {
    this.result.getMatchesLostIntegerProperty().add(1);
    
    int previousGoalsFor = this.result.getGoalsForIntegerProperty().get();
    this.result.setGoalsForIntegerProperty(new SimpleIntegerProperty(previousGoalsFor + goalsFor));
    
    int previousGoalsAgainst = this.result.getGoalsAgainstIntegerProperty().get();
    this.result.setGoalsAgainstIntegerProperty(new SimpleIntegerProperty(previousGoalsAgainst + goalsAgainst));
    
    processGoalDiff();
  }
  
  public void addDraw(int goalsFor, int goalsAgainst) {
    int matchesDrawn = this.result.getMatchesDrawnIntegerProperty().get();
    this.result.setMatchesDrawnIntegerProperty(new SimpleIntegerProperty(matchesDrawn + 1));
    
    int previousGoalsFor = this.result.getGoalsForIntegerProperty().get();
    this.result.setGoalsForIntegerProperty(new SimpleIntegerProperty(previousGoalsFor + goalsFor));
    
    int previousGoalsAgainst = this.result.getGoalsAgainstIntegerProperty().get();
    this.result.setGoalsAgainstIntegerProperty(new SimpleIntegerProperty(previousGoalsAgainst + goalsAgainst));
    
    int previousMatchPoints = this.result.getMatchPointsIntegerProperty().get();
    this.result.setMatchPointsIntegerProperty(new SimpleIntegerProperty(previousMatchPoints + 1));
    
    processGoalDiff();
  }
  
  public void processGoalDiff (){
    int goalsFor = this.result.getGoalsForIntegerProperty().get();
    int goalsAgainst = this.result.getGoalsAgainstIntegerProperty().get();
    this.result.setGoalDiffIntegerProperty(new SimpleIntegerProperty(goalsFor - goalsAgainst));
  }
  
  public void printTeam() {
    System.out.println("(" + this.name + ", "
        + this.result.getMatchPointsIntegerProperty().get() + ")");
  }
}