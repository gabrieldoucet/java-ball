package components;

import java.util.Optional;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import model.MatchesList;
import model.ResultsList;
import model.TeamsList;
import views.EditionPane;
import views.Main;

public class WithdrawGroup extends HBox {

  public static WithdrawGroup withdrawGroup = new WithdrawGroup();
  private TeamsComboBox teamsComboBox;
  
  private WithdrawGroup() {
    Button withdrawButton = new Button("Withdraw"); 
    teamsComboBox = new TeamsComboBox();
    
    withdrawButton.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
      public void handle(MouseEvent e) {
        // Change model
        TeamsList.withdrawTeam(teamsComboBox.getValue());
        MatchesList.withdrawTeam(teamsComboBox.getValue());
        ResultsList.withdrawTeam(teamsComboBox.getValue());
        
        // Change view
        MatchesTableView.getInstance().updateTable();
        ResultsTableView.getInstance().updateTable();
        EditionPane.updateChoices();
        
        if (TeamsList.getInstance().size() < 3) {
          Alert alert = new Alert(AlertType.INFORMATION);
          alert.setTitle("Tournament cancelled");
          alert.setHeaderText("Information");
          alert.setContentText("There are not enough teams remaining, the tournament will be cancelled");
          Optional<ButtonType> result = alert.showAndWait();
          if (result.get() == ButtonType.OK){
              Main.close();
          }
        }
      }
    });
    
    this.setAlignment(Pos.TOP_CENTER);
    this.getChildren().addAll(teamsComboBox, withdrawButton);
    this.setSpacing(5);
    this.setPadding(new Insets(0, 0, 10, 0));
  }
  
  public static WithdrawGroup getInstance() {
    return withdrawGroup;
  }
  
  public void updateTeamChoices() {
    teamsComboBox.updateChoices();
  }
}
