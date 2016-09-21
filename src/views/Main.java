package views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.MatchesList;

public class Main extends Application {
  @Override
  public void start(Stage primaryStage) {
    try {
      MatchesList.buildMatches();
      
      BorderPane root = new BorderPane();
      Scene scene = new Scene(root, 400, 600);
      scene.getStylesheets().add(
          getClass().getResource("application.css").toExternalForm());
      
//      primaryStage.initStyle(StageStyle.UNDECORATED);
      primaryStage.setTitle("JavaBall Tournament");
      primaryStage.setScene(scene);
      primaryStage.show();
      
      root.setLeft(LeftPane.getInstance());
      root.setTop(TopPane.getInstance());
      root.setCenter(CenterPane.getInstance());
      root.setBottom(BottomPane.getInstance());
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
