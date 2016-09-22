package views;

import components.MatchesTableView;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Match;
import model.MatchesList;

public class MatchesPane extends VBox {

  public static MatchesPane centerPane = new MatchesPane();
  private TableView<Match> matchesTable;

  private MatchesPane() {
    super();

    // Section title
    Label title = new Label("Matches");
    title.setFont(Font.font("Gill Sans", FontWeight.BOLD, 14));

    matchesTable = MatchesTableView.getInstance();
    
    // Import button
    Button importResults = new Button("Import results");
    importResults.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
      public void handle(MouseEvent e) {
        // Update model
        MatchesList.readMatchesScore();
        
        // Update View
        EditionPane.updateChoices();
        MatchesTableView.getInstance().updateTable();
        EditionPane.disableWithdrawal(false);
        importResults.setDisable(true);
      }
    });

    this.getChildren().addAll(title, matchesTable, importResults);
    this.setPadding(new Insets(10));
    this.setSpacing(5);
    this.setAlignment(Pos.TOP_CENTER);
  }

  public static MatchesPane getInstance() {
    return centerPane;
  }
}
