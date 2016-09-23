package helpers;

import java.util.Comparator;

import model.Result;
import helpers.TeamsComparator;

public class ResultsComparator implements Comparator<Result> {

  @Override
  public int compare(Result r1, Result r2) {
    int matchPointsTeam1 = r1.getMatchPointsIntegerProperty().get();
    int matchPointsTeam2 = r2.getMatchPointsIntegerProperty().get();

    if (matchPointsTeam1 == matchPointsTeam2) {
      int goalDiffTeam1 = r1.getGoalDiffIntegerProperty().get();
      int goalDiffTeam2 = r2.getGoalDiffIntegerProperty().get();
      if (goalDiffTeam1 == goalDiffTeam2) {
        TeamsComparator tc = new TeamsComparator();
        int res = tc.compare(r1.getTeam(), r2.getTeam());
        return res;
      } else {
        return (int) Math.signum(goalDiffTeam2 - goalDiffTeam1);
      }
    } else {
      return (int) Math.signum(matchPointsTeam2 - matchPointsTeam1);
    }
  }
}