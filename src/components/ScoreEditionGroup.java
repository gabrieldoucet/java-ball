package components;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.MatchesList;
import views.EditionPane;

public class ScoreEditionGroup extends VBox {

  private MatchesComboBox matchesComboBox = new MatchesComboBox();
  public static ScoreEditionGroup scoreEditionGroup = new ScoreEditionGroup();

  private ScoreEditionGroup() {
    super();

    // First team info
    HBox team1Score = new HBox();
    Text labelScore1 = new Text("Team 1");
    TextField score1 = new TextField();
    Text error1 = new Text();
    labelScore1.setWrappingWidth(80);
    score1.setMaxWidth(35);
    score1.prefWidth(35);
    error1.setWrappingWidth(175);
    score1.setAlignment(Pos.CENTER);
    team1Score.setAlignment(Pos.CENTER_LEFT);
    team1Score.getChildren().addAll(labelScore1, score1, error1);
    team1Score.setSpacing(5);

    // Second team info
    HBox team2Score = new HBox();
    Text labelScore2 = new Text("Team 2");
    TextField score2 = new TextField();
    Text error2 = new Text();
    labelScore2.setWrappingWidth(80);
    score2.setMaxWidth(35);
    score2.prefWidth(35);
    score2.setAlignment(Pos.CENTER);
    error2.setWrappingWidth(175);
    team2Score.setAlignment(Pos.CENTER_LEFT);
    team2Score.getChildren().addAll(labelScore2, score2, error2);
    team2Score.setSpacing(5);

    // Update button
    Button updateButton = new Button("Update score");
    updateButton.addEventHandler(MouseEvent.MOUSE_RELEASED,
        new EventHandler<MouseEvent>() {
          public void handle(MouseEvent e) {
            boolean score1Valid = true;
            try {
              Integer.parseInt(score1.getText());
            } catch (NumberFormatException e1) {
              score1Valid = false;
            }
            
           score1Valid = score1Valid && Integer.parseInt(score1.getText()) >= 0
                && Integer.parseInt(score1.getText()) <= 9;
           
           boolean score2Valid = true;
           try {
             Integer.parseInt(score2.getText());
           } catch (NumberFormatException e2) {
             score2Valid = false;
           } 
           
           score2Valid = score2Valid && Integer.parseInt(score2.getText()) >= 0
                && Integer.parseInt(score2.getText()) <= 9;
            if (score1Valid && score2Valid) {
              // Update model
              MatchesList.updateMatchScore(labelScore1.getText(),
                  score1.getText(), labelScore2.getText(), score2.getText());
              MatchesList.processResults();

              // Update View
              EditionPane.updateChoices();
              MatchesTableView.getInstance().updateTable();
              ResultsTableView.getInstance().updateTable();
              score1.setText("");
              score2.setText("");
              labelScore1.setText("Team 1");
              labelScore2.setText("Team 2");
            } else {
              if (!score1Valid) {
                error1.setText("Must be between 0 and 9");
              }
              if (!score2Valid) {
                error2.setText("Must be between 0 and 9");
              }
            }
          }
        });

    // Listener on the matches comboBox and text fields
    matchesComboBox.valueProperty().addListener(
        (observable, oldValue, newValue) -> {
          updateButton.setDisable(disableUpdateButton(score1.getText(),
              score2.getText()));
          if (oldValue == null) {
            String[] tokens = newValue.split(" v ");
            labelScore1.setText(tokens[0]);
            labelScore2.setText(tokens[1]);
          } else {
            if (newValue != null && !oldValue.equals(newValue)) {
              String[] tokens = newValue.split(" v ");
              labelScore1.setText(tokens[0]);
              labelScore2.setText(tokens[1]);
            }
          }
        });

    score1.textProperty().addListener((observable, oldValue, newValue) -> {
      error1.setText("");
      updateButton.setDisable(disableUpdateButton(newValue, score2.getText()));
    });

    score2.textProperty().addListener((observable, oldValue, newValue) -> {
      error2.setText("");
      updateButton.setDisable(disableUpdateButton(score1.getText(), newValue));
    });

    this.getChildren().addAll(matchesComboBox, team1Score, team2Score,
        updateButton);
    this.setAlignment(Pos.CENTER);
    this.setSpacing(5);
    this.setPadding(new Insets(10, 0, 0, 0));
  }

  public static ScoreEditionGroup getInstance() {
    return scoreEditionGroup;
  }

  public void updateMatchChoices() {
    matchesComboBox.updateChoices();
  };

  public boolean disableUpdateButton(String score1, String score2) {
    return matchesComboBox.getValue() == null || score1.equals("")
        || score2.equals("");
  }
}