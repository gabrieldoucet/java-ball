package views;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Team;
import model.TeamsList;

public class ResultsPane extends VBox {

  public static ResultsPane leftPane = new ResultsPane();
    
  private ResultsPane() {
    super();

    Label title = new Label("Results");
    title.setFont(Font.font("Gill Sans", FontWeight.BOLD, 14));
    
    for (Team team : TeamsList.getInstance()) {
      Label teamLabel = new Label(team.getName());
      teamLabel.getStyleClass().add("team-label");
      teamLabel.setPrefWidth(100);
      teamLabel.setPadding(new Insets(1));
      this.getChildren().add(teamLabel);
    }
    
   
    this.getChildren().addAll(title);
  }

  public static ResultsPane getInstance() {
    return leftPane;
  }
}
