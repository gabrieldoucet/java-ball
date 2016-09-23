package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import components.ResultsTableView;

public class ResultsPane extends VBox {

  public static ResultsPane resultsPane = new ResultsPane();
  private ResultsTableView resultsTableView;
  private ResultsPane() {
    super();
    
    Label title = new Label("Results");
    title.setFont(Font.font("Gill Sans", FontWeight.BOLD, 14));
       
    // The table view
    resultsTableView = ResultsTableView.getInstance();
 
    this.setSpacing(5);
    this.setPadding(new Insets(10, 0, 0, 0));
    this.setAlignment(Pos.TOP_CENTER);
    this.getChildren().addAll(title, resultsTableView);
  }

  public static ResultsPane getInstance() {
    return resultsPane;
  }
}
