package views;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import model.MatchesList;

public class BottomPane extends HBox {

  public static BottomPane bottomPane = new BottomPane();

  private BottomPane() {
    super();

    Button exitButton = new Button("Exit");
    exitButton.addEventHandler(MouseEvent.MOUSE_RELEASED,
        new EventHandler<MouseEvent>() {
          public void handle(MouseEvent e) {
            // primaryStage.close();
          }
        });
    this.getChildren().add(exitButton);

    Button importResults = new Button("Import results");
    importResults.addEventHandler(MouseEvent.MOUSE_RELEASED,
        new EventHandler<MouseEvent>() {
          public void handle(MouseEvent e) {
            MatchesList.readMatchesScore();
            CenterPane.getInstance().buildMatches();
          }
        });
    
    this.setSpacing(10);
    this.setPadding(new Insets(10));
    this.setAlignment(Pos.CENTER);
    this.getChildren().add(importResults);
  }

  public static BottomPane getInstance() {
    return bottomPane;
  }
}
