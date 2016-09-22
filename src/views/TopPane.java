package views;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TopPane extends HBox {

  private static TopPane topPane = new TopPane();
  
  private TopPane() {
    super();
    
    Label title = new Label("JavaBall Tournament");
    title.setFont(Font.font("Gill Sans", FontWeight.BOLD, 25));
    this.setAlignment(Pos.CENTER);
    this.getChildren().add(title);
    this.setPadding(new Insets(5));
  }
  
  public static TopPane getInstance() {
    return topPane;
  }
}
