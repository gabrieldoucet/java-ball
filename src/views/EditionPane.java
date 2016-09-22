package views;

import components.ScoreEditionGroup;
import components.WithdrawGroup;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EditionPane extends VBox {

  public static EditionPane editionPane = new EditionPane();
  private static WithdrawGroup withdrawGroup;
  private static ScoreEditionGroup scoreEditionGroup;
  
  private EditionPane() {
    super();

    // Section title
    Label title = new Label("Withdrawl / Score updates");
    title.setFont(Font.font("Gill Sans", FontWeight.BOLD, 14));
    
    // Team withdrawal section
    withdrawGroup = WithdrawGroup.getInstance();
    
    Separator vs1 = new Separator(Orientation.HORIZONTAL);
    
    // Score editing section
    scoreEditionGroup = ScoreEditionGroup.getInstance();
    this.getChildren().addAll(title, withdrawGroup, vs1, scoreEditionGroup);
    this.setPadding(new Insets(10));
    this.setSpacing(5);
    this.setAlignment(Pos.TOP_CENTER);
    
    disableWithdrawal(true);
  }

  public static EditionPane getInstance() {
    return editionPane;
  }
  
  public static void disableWithdrawal (boolean val) {
    for (Node node : withdrawGroup.getChildren()) {
      node.setDisable(val);
    }
    
    for (Node node : scoreEditionGroup.getChildren()) {
      node.setDisable(val);
    }
  }
  
  public static void updateChoices() {
    scoreEditionGroup.updateMatchChoices();
  }
}
