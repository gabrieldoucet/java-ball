package views;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class BottomPane extends HBox {

  public static BottomPane bottomPane = new BottomPane();

  private BottomPane() {
    super();

    Button exitButton = new Button("Exit");
    exitButton.addEventHandler(MouseEvent.MOUSE_RELEASED,
        new EventHandler<MouseEvent>() {
          public void handle(MouseEvent e) {
            Main.close();
          }
        });
    this.getChildren().add(exitButton);

    this.setSpacing(10);
    this.setPadding(new Insets(0, 0, 30, 0));
    this.setAlignment(Pos.CENTER);
  }

  public static BottomPane getInstance() {
    return bottomPane;
  }
}
