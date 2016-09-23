package model;

import helpers.ResultsComparator;

import java.util.ArrayList;

import javafx.beans.property.SimpleIntegerProperty;

public class ResultsList extends ArrayList<Result> {

  private static final long serialVersionUID = 1L;
  public static ResultsList resultsList = new ResultsList();

  private ResultsList() {
    super();
  }

  public static ResultsList getInstance() {
    return resultsList;
  }

  public static void buildResults() {
    for (Team team : TeamsList.getInstance()) {
      Result result = new Result(team);
      team.setResult(result);
      resultsList.add(result);
    }
  }

  public static void sort() {
    ResultsComparator rc = new ResultsComparator();
    resultsList.sort(rc);
    processRanks();
  }

  public static int getResultFromTeamName(String teamName) {
    for (int i = 0; i < ResultsList.getInstance().size(); i++) {
      if (ResultsList.getInstance().get(i).getTeam().getName().equals(teamName)) {
        return i;
      }
    }
    return -1;
  }

  public static void withdrawTeam(String teamName) {
    int resultIndex = getResultFromTeamName(teamName);
    resultsList.remove(resultIndex);
  }

  public static void processRanks() {
    int currentRank = 1;
    int listIndex = 0;
    int offset;
    while (listIndex < resultsList.size()) {
      offset = 0;
      while (listIndex + offset  <= resultsList.size() - 1) {
        boolean samePoints = resultsList.get(listIndex)
            .getMatchPointsIntegerProperty().get() == resultsList
            .get(listIndex + offset).getMatchPointsIntegerProperty().get();
        boolean sameGoalDiff = resultsList.get(listIndex)
            .getGoalDiffIntegerProperty().get() == resultsList
            .get(listIndex + offset).getGoalDiffIntegerProperty().get();
        if (samePoints && sameGoalDiff) {
          resultsList.get(listIndex + offset).setMatchesRankIntegerProperty(
              new SimpleIntegerProperty(currentRank));
          offset += 1;
        } else {
          break;
        }
      }
      currentRank += offset;
      listIndex += offset;
    }
  processMedals();
  }
  
  public static void processMedals() {
    int rankSwitch = 0;
    int currentRank;
    int i = 0;
    while (i < resultsList.size()) {
      currentRank = resultsList.get(i).getMatchesRankIntegerProperty().get();
      for (int j = 0; j < resultsList.size() - i - 1; j++) {
        int jCurrentRank = resultsList.get(i + j).getMatchesRankIntegerProperty().get();
        if (jCurrentRank == currentRank) {
          resultsList.get(i + j).setMedalStringProperty(getMedalColor(rankSwitch));
        } else {
          break;
        }
        rankSwitch += 1;
      }
        i +=1;
    }
  }
  
  private static String getMedalColor(int rankSwitch) {
    if (rankSwitch == 0) {
      return "Gold";
    } else if (rankSwitch == 1) {
      return "Silver";
    } else if (rankSwitch == 2) {
      return "Bronze";
    } else {
      return "";
    }
  }
}
