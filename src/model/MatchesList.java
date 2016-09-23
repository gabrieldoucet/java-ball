package model;

import helpers.MatchesComparator;
import helpers.ReadFile;
import helpers.TeamsComparator;

import java.util.ArrayList;

public class MatchesList extends ArrayList<Match> {

  private static final long serialVersionUID = 1L;
  public static MatchesList matchesList = new MatchesList();

  private MatchesList() {
    super();
  }

  public static MatchesList getInstance() {
    return matchesList;
  }

  public static void buildMatches() {
    TeamsList teamsList = TeamsList.getInstance();
    Object[] teamsArray = teamsList.toArray();
    for (int i = 0; i < teamsList.size(); i++) {
      for (int j = i + 1; j < teamsList.size(); j++) {
        Match match = new Match((Team) teamsArray[i], (Team) teamsArray[j]);
        matchesList.add(match);
      }
    }

    matchesList.sort(new MatchesComparator());
  }

  public static void withdrawTeam(String teamName) {
    MatchesList.getInstance().removeIf(
        p -> p.getTeam1().getName().equals(teamName)
            || p.getTeam2().getName().equals(teamName));
  }

  public static void readMatchesScore() {
    // Read teams
    ArrayList<String> scores = ReadFile.readFile("src/data/ResultsIn.txt");
    for (String score : scores) {
      String[] tokens = score.split(" ");
      Team team1 = new Team(tokens[0]);
      Team team2 = new Team(tokens[2]);
      if (TeamsList.getTeamIndexFromName(team1.getName()) != -1
          && TeamsList.getTeamIndexFromName(team2.getName()) != -1) {
        Match existingMatch;
        TeamsComparator tc = new TeamsComparator();
        int res = tc.compare(team1, team2);
        if (res > 0) {
          existingMatch = MatchesList.getMatchFromTeams(team2, team1);
          existingMatch.setGoalsTeam1(tokens[3]);
          existingMatch.setGoalsTeam2(tokens[1]);
        } else {
          existingMatch = MatchesList.getMatchFromTeams(team1, team2);
          existingMatch.setGoalsTeam1(tokens[1]);
          existingMatch.setGoalsTeam2(tokens[3]);
        }
      }
    }
  }

  public static Match getMatchFromTeams(Team team1, Team team2) {
    TeamsComparator tc = new TeamsComparator();
    int res = tc.compare(team1, team2);
    int indexTeam1;
    int indexTeam2;
    if (res > 0) {
      indexTeam1 = team2.getIndex();
      indexTeam2 = team1.getIndex();
    } else {
      indexTeam1 = team1.getIndex();
      indexTeam2 = team2.getIndex();
    }
    int firstTeam1MatchIndex = (indexTeam1 * (2
        * TeamsList.getInstance().size() - 2 - indexTeam1 + 1)) / 2;
    firstTeam1MatchIndex += Math.abs(indexTeam2 - indexTeam1 - 1);
    return matchesList.get(firstTeam1MatchIndex);
  }

  public static void updateMatchScore(String teamName1, String score1,
      String teamName2, String score2) {
    Match match = MatchesList.getMatchFromTeams(new Team(teamName1), new Team(
        teamName2));
    match.setGoalsTeam1(score1);
    match.setGoalsTeam2(score2);
  }

  public static void processResults() {
    for (Match match : matchesList) {
      if (!match.pending() && !match.processed()) {
        Team team1 = match.getTeam1();
        Team team2 = match.getTeam2();

        int goalsTeam1 = Integer.parseInt(match.goalsTeam1Property().get());
        int goalsTeam2 = Integer.parseInt(match.goalsTeam2Property().get());

        // Goals processing
        if (goalsTeam1 > goalsTeam2) {
          team1.addVictory(goalsTeam1, goalsTeam2);
          team2.addDefeat(goalsTeam2, goalsTeam2);
        } else if (goalsTeam1 == goalsTeam2) {
          team1.addDraw(goalsTeam1, goalsTeam2);
          team2.addDraw(goalsTeam1, goalsTeam2);
        } else if (goalsTeam1 < goalsTeam2) {
          team1.addDefeat(goalsTeam1, goalsTeam2);
          team2.addVictory(goalsTeam1, goalsTeam2);
        }
        match.setProcessed(true);
      }
    }

    ResultsList.sort();
  }
}