package views;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Team;
import model.TeamsList;

public class LeftPane extends VBox {

  public static LeftPane leftPane = new LeftPane();
  public Button withdrawButton;
    
  private LeftPane() {
    super();

    Label teamsLabel = new Label("Teams");
    this.getChildren().add(teamsLabel);
    teamsLabel.setFont(Font.font("Gill Sans", FontWeight.BOLD, 14));
    
    for (Team team : TeamsList.getInstance()) {
      Label teamLabel = new Label(team.getName());
      teamLabel.getStyleClass().add("team-label");
      teamLabel.setPrefWidth(100);
      teamLabel.setPadding(new Insets(1));
      this.getChildren().add(teamLabel);
    }

    this.withdrawButton = new Button("Withdraw");
    this.getChildren().add(withdrawButton);
    this.setSpacing(1);
    this.setPadding(new Insets(10));
  }

  public static LeftPane getInstance() {
    return leftPane;
  }
}
