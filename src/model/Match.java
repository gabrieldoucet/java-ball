package model;

import helpers.TeamsComparator;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Match {

  private Team team1;
  private Team team2;
  private StringProperty team1NameProperty;
  private StringProperty team2NameProperty;
  private StringProperty team1GoalsProperty;
  private StringProperty team2GoalsProperty;
  private boolean isProcessed = false;
  
  public Match(Team team1, Team team2) {

    TeamsComparator tc = new TeamsComparator();
    int res = tc.compare(team1, team2);
    if (res > 0) {
      this.team1 = team2;
      this.team1NameProperty = new SimpleStringProperty(team2.getName());
      this.team2 = team1;
      this.team2NameProperty = new SimpleStringProperty(team1.getName());
    } else {
      this.team1 = team1;
      this.team1NameProperty = new SimpleStringProperty(team1.getName());
      this.team2 = team2;
      this.team2NameProperty = new SimpleStringProperty(team2.getName());
    }

    this.team1GoalsProperty = new SimpleStringProperty("N/A");
    this.team2GoalsProperty = new SimpleStringProperty("N/A");
  }

  public Team getTeam1() {
    return this.team1;
  }

  public Team getTeam2() {
    return this.team2;
  }

  public StringProperty team1NameProperty() {
    return this.team1NameProperty;
  }

  public StringProperty team2NameProperty() {
    return this.team2NameProperty;
  }

  public StringProperty goalsTeam1Property() {
    return this.team1GoalsProperty;
  }

  public StringProperty goalsTeam2Property() {
    return this.team2GoalsProperty;
  }

  public void setGoalsTeam1(String goals) {
    this.team1GoalsProperty.set(goals);
  }

  public void setGoalsTeam2(String goals) {
    this.team2GoalsProperty.set(goals);
  }

  public boolean pending() {
    return this.team1GoalsProperty.get().equals("N/A") && this.team2GoalsProperty.get().equals("N/A");
  }

  public boolean equals(Match m) {
    TeamsComparator tc = new TeamsComparator();
    return tc.compare(m.getTeam1(), this.team1) == 0 && tc.compare(m.getTeam2(), this.team2) == 0;
  }

  public boolean processed() {
    return this.isProcessed;
  }

  public void setProcessed(boolean val) {
    this.isProcessed = val;
  }
  
  public void printMatch() {
    System.out.println(String.join(" ", this.team1.getName(), this.team1GoalsProperty.getValue(), this.team2.getName(),
        this.team2GoalsProperty.getValue()));
  }
}