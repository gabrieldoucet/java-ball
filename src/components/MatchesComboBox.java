package components;

import javafx.scene.control.ComboBox;
import model.Match;
import model.MatchesList;

public class MatchesComboBox extends ComboBox<String> {

  public MatchesComboBox() {
    super();
    this.setPromptText("Select match");
    this.prefWidth(345);
    updateChoices();
  }

  public void updateChoices() {
    this.getItems().clear();
    for (Match match : MatchesList.getInstance()) {
      if (match.pending()) {
        String item = match.team1NameProperty().getValue() + " v " + match.team2NameProperty().getValue();
        this.getItems().add(item);
      }
    }
  }
}