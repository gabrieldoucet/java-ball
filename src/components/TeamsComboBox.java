package components;

import javafx.scene.control.ComboBox;
import model.Team;
import model.TeamsList;

public class TeamsComboBox extends ComboBox<String> {

  public TeamsComboBox() {
    super();
    this.setPromptText("Select team");
    this.prefWidth(345);
    updateChoices();
  }

  public void updateChoices() {
    this.getItems().clear();
    for (Team team : TeamsList.getInstance()) {
      this.getItems().add(team.getName());
    }
  }
}