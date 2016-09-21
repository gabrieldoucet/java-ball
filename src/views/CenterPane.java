package views;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.Match;
import model.MatchesList;

public class CenterPane extends VBox {

  public static CenterPane centerPane = new CenterPane();

  private CenterPane() {
    super();
    this.buildMatches();
  }

  public void buildMatches() {
    this.getChildren().clear();
    for (Match match : MatchesList.getInstance()) {
      Label matchLabel = new Label();
      matchLabel.setPadding(new Insets(1));
      if (match.pending()) {
        matchLabel.setText(match.getTeam1().getName() + " v "
            + match.getTeam2().getName() + " ***** no results yet *****");
      } else {
        matchLabel.setText(match.getTeam1().getName() + " "
            + match.getScore().getScoreTeam1() + " "
            + match.getTeam2().getName() + " "
            + match.getScore().getScoreTeam2());
      }
      
      this.setSpacing(1);
      this.getChildren().add(matchLabel);
    }
  }

  public static CenterPane getInstance() {
    return centerPane;
  }
}
