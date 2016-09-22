package components;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import model.MatchesList;
import model.TeamsList;

public class WithdrawGroup extends HBox {

  public static WithdrawGroup withdrawGroup = new WithdrawGroup();
  
  private WithdrawGroup() {
    Button withdrawButton = new Button("Withdraw");
    TeamsComboBox withdrawComboBox = new TeamsComboBox();
    
    withdrawButton.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
      public void handle(MouseEvent e) {
        // Change model
        TeamsList.withdrawTeam(withdrawComboBox.getValue());
        MatchesList.withdrawTeam(withdrawComboBox.getValue());
        
        // Change view
        MatchesTableView.getInstance().updateTable();
        withdrawComboBox.updateChoices();
        if (TeamsList.getInstance().size() < 3) {
          // TODO
          System.out.println("Tournament cancelled");
        }
      }
    });
    
    this.getChildren().addAll(withdrawComboBox, withdrawButton);
    this.setSpacing(5);
    this.setPadding(new Insets(0, 0, 10, 0));
  }
  
  public static WithdrawGroup getInstance() {
    return withdrawGroup;
  } 
}
