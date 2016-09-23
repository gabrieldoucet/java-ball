package views;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.MatchesList;
import model.Result;
import model.ResultsList;

public class Main extends Application {

  public static Stage stage;

  @Override
  public void start(Stage primaryStage) {
    try {

      stage = primaryStage;

      // Ensures that the model is intialised before the views
      MatchesList.buildMatches();
      ResultsList.buildResults();

      BorderPane root = new BorderPane();
      Scene scene = new Scene(root, 1280, 800);
      scene.getStylesheets().add(
          getClass().getResource("application.css").toExternalForm());

      primaryStage.initStyle(StageStyle.UNDECORATED);
      primaryStage.setTitle("JavaBall Tournament");
      primaryStage.setScene(scene);
      primaryStage.show();

      root.setLeft(MatchesPane.getInstance());
      root.setTop(TopPane.getInstance());
      root.setRight(EditionPane.getInstance());
      root.setCenter(ResultsPane.getInstance());
      root.setBottom(BottomPane.getInstance());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }

  public static void close() {
    String file = "src/data/ResultsOut.txt";
    try {
      BufferedWriter writer = Files.newBufferedWriter(Paths.get(file));
      writer
          .write("           |         Match       |   Goals     | Match  | Goal |\n");
      writer
          .write("Team       | Rank Won Drawn Lost | For Against | Points | Diff | Medal\n");
      for(Result result : ResultsList.getInstance()) {
        writer.write(result.stringify());
      }
      writer.close();
    } catch (IOException e1) {
      System.out.println("An error occured writting data/ResultsOut.txt");
      e1.printStackTrace();
    }

    stage.close();
  }
}
