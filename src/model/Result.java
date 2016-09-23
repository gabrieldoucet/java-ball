package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Result {

  private Team team;
  private IntegerProperty matchesRankIntegerProperty;
  private IntegerProperty matchesWonIntegerProperty;
  private IntegerProperty matchesDrawnIntegerProperty;
  private IntegerProperty matchesLostIntegerProperty;
  private IntegerProperty goalsForIntegerProperty;
  private IntegerProperty goalsAgainstIntegerProperty;
  private IntegerProperty matchPointsIntegerProperty;
  private IntegerProperty goalDiffIntegerProperty;
  private StringProperty medalStringProperty;
  private final StringProperty teamNameStringProperty;

  public Result(Team team) {
    this.team = team;
    this.teamNameStringProperty = new SimpleStringProperty(this.team.getName());
    this.matchesRankIntegerProperty = new SimpleIntegerProperty(0);
    this.matchesWonIntegerProperty = new SimpleIntegerProperty(0);
    this.matchesDrawnIntegerProperty = new SimpleIntegerProperty(0);
    this.matchesLostIntegerProperty = new SimpleIntegerProperty(0);
    this.goalsForIntegerProperty = new SimpleIntegerProperty(0);
    this.goalsAgainstIntegerProperty = new SimpleIntegerProperty(0);
    this.matchPointsIntegerProperty = new SimpleIntegerProperty(0);
    this.goalDiffIntegerProperty = new SimpleIntegerProperty(0);
    this.medalStringProperty = new SimpleStringProperty("");
  }

  public IntegerProperty getMatchesRankIntegerProperty() {
    return matchesRankIntegerProperty;
  }

  public void setMatchesRankIntegerProperty(
      IntegerProperty matchesRankIntegerProperty) {
    this.matchesRankIntegerProperty = matchesRankIntegerProperty;
  }

  public IntegerProperty getMatchesWonIntegerProperty() {
    return matchesWonIntegerProperty;
  }

  public void setMatchesWonIntegerProperty(
      IntegerProperty matchesWonIntegerProperty) {
    this.matchesWonIntegerProperty = matchesWonIntegerProperty;
  }

  public IntegerProperty getMatchesDrawnIntegerProperty() {
    return matchesDrawnIntegerProperty;
  }

  public void setMatchesDrawnIntegerProperty(
      IntegerProperty matchesDrawnIntegerProperty) {
    this.matchesDrawnIntegerProperty = matchesDrawnIntegerProperty;
  }

  public IntegerProperty getMatchesLostIntegerProperty() {
    return matchesLostIntegerProperty;
  }

  public void setMatchesLostIntegerProperty(
      IntegerProperty matchesLostIntegerProperty) {
    this.matchesLostIntegerProperty = matchesLostIntegerProperty;
  }

  public IntegerProperty getGoalsForIntegerProperty() {
    return goalsForIntegerProperty;
  }

  public void setGoalsForIntegerProperty(IntegerProperty goalsForIntegerProperty) {
    this.goalsForIntegerProperty = goalsForIntegerProperty;
  }

  public IntegerProperty getGoalsAgainstIntegerProperty() {
    return goalsAgainstIntegerProperty;
  }

  public void setGoalsAgainstIntegerProperty(
      IntegerProperty goalsAgainstIntegerProperty) {
    this.goalsAgainstIntegerProperty = goalsAgainstIntegerProperty;
  }

  public IntegerProperty getMatchPointsIntegerProperty() {
    return matchPointsIntegerProperty;
  }

  public void setMatchPointsIntegerProperty(
      IntegerProperty matchPointsIntegerProperty) {
    this.matchPointsIntegerProperty = matchPointsIntegerProperty;
  }

  public IntegerProperty getGoalDiffIntegerProperty() {
    return goalDiffIntegerProperty;
  }

  public void setGoalDiffIntegerProperty(IntegerProperty goalDiffIntegerProperty) {
    this.goalDiffIntegerProperty = goalDiffIntegerProperty;
  }

  public StringProperty getTeamNameStringProperty() {
    return this.teamNameStringProperty;
  }
  
  public void setMedalStringProperty(String medal) {
    this.medalStringProperty = new SimpleStringProperty(medal);
  }
  
  public StringProperty getMedalStringProperty() {
    return this.medalStringProperty;
  }
  
  public Team getTeam() {
    return this.team;
  }

  public void print() {
    String str = String.join(" ", this.team.getName(),
        Integer.toString(this.matchesRankIntegerProperty.get()),
        Integer.toString(this.matchesWonIntegerProperty.get()),
        Integer.toString(this.matchesDrawnIntegerProperty.get()),
        Integer.toString(this.matchesLostIntegerProperty.get()),
        Integer.toString(this.goalsForIntegerProperty.get()),
        Integer.toString(this.goalsAgainstIntegerProperty.get()),
        Integer.toString(this.matchPointsIntegerProperty.get()),
        Integer.toString(this.goalDiffIntegerProperty.get()));
    System.out.println(str);
  }
  
  public String stringify() {
    String str = "";
    String name = this.team.getName();
    str += name;
    for (int i = 1; i < 11 - name.length(); i++) {
      str += " ";
    }
    str += " | ";
    
    str += " " + this.matchesRankIntegerProperty.get() + "    " + this.matchesWonIntegerProperty.get() + "    ";
    str += this.matchesDrawnIntegerProperty.get() + "    " + this.matchesLostIntegerProperty.get() + "  ";
    str += " | ";
    
    str += " " + this.goalsForIntegerProperty.get() + "    " + this.goalsAgainstIntegerProperty.get() + "    "; 
    str += " | ";
    
    str += "  " + this.getMatchPointsIntegerProperty().get() + "   ";
    str += " | ";
    
    str += " " + this.getGoalDiffIntegerProperty().get() + "  ";
    str += " | ";
    
    str += this.getMedalStringProperty().get();
    str += "\n";
    return str;
  }
}
