package components;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Result;
import model.ResultsList;

public class ResultsTableView extends TableView<Result> {

  private ObservableList<Result> resultsData;
  public static ResultsTableView matchesTable = new ResultsTableView();

  private ResultsTableView() {
    super();
    this.setEditable(false);

    TableColumn<Result, String> teamsCol = new TableColumn<Result, String>(
        "Team");

    TableColumn<Result, String> matchesCol = new TableColumn<Result, String>(
        "Matches");
    TableColumn<Result, Integer> matchesRankCol = new TableColumn<Result, Integer>(
        "Rank");
    TableColumn<Result, Integer> matchesWonCol = new TableColumn<Result, Integer>(
        "Won");
    TableColumn<Result, Integer> matchesDrawnCol = new TableColumn<Result, Integer>(
        "Drawn");
    TableColumn<Result, Integer> matchesLostCol = new TableColumn<Result, Integer>(
        "Lost");
    matchesCol.getColumns().add(matchesRankCol);
    matchesCol.getColumns().add(matchesWonCol);
    matchesCol.getColumns().add(matchesDrawnCol);
    matchesCol.getColumns().add(matchesLostCol);

    TableColumn<Result, String> goalsCol = new TableColumn<Result, String>(
        "Goals");
    TableColumn<Result, Integer> goalsForCol = new TableColumn<Result, Integer>(
        "For");
    TableColumn<Result, Integer> goalsAgainstCol = new TableColumn<Result, Integer>(
        "Against");
    goalsCol.getColumns().add(goalsForCol);
    goalsCol.getColumns().add(goalsAgainstCol);

    TableColumn<Result, Integer> matchPointsCol = new TableColumn<Result, Integer>(
        "Match points");
    TableColumn<Result, Integer> goalDiffCol = new TableColumn<Result, Integer>(
        "Goal diff");
    TableColumn<Result, String> medalCol = new TableColumn<Result, String>(
        "Medal");

    this.getColumns().add(teamsCol);
    this.getColumns().add(matchesCol);
    this.getColumns().add(goalsCol);
    this.getColumns().add(matchPointsCol);
    this.getColumns().add(goalDiffCol);
    this.getColumns().add(medalCol);

    resultsData = getInitialTableData();
    this.setItems(resultsData);

    teamsCol.setCellValueFactory(cellData -> cellData.getValue()
        .getTeamNameStringProperty());
    matchesRankCol.setCellValueFactory(cellData -> cellData.getValue()
        .getMatchesRankIntegerProperty().asObject());
    matchesWonCol.setCellValueFactory(cellData -> cellData.getValue()
        .getMatchesWonIntegerProperty().asObject());
    matchesDrawnCol.setCellValueFactory(cellData -> cellData.getValue()
        .getMatchesDrawnIntegerProperty().asObject());
    matchesLostCol.setCellValueFactory(cellData -> cellData.getValue()
        .getMatchesLostIntegerProperty().asObject());
    goalsForCol.setCellValueFactory(cellData -> cellData.getValue()
        .getGoalsForIntegerProperty().asObject());
    goalsAgainstCol.setCellValueFactory(cellData -> cellData.getValue()
        .getGoalsAgainstIntegerProperty().asObject());
    matchPointsCol.setCellValueFactory(cellData -> cellData.getValue()
        .getMatchPointsIntegerProperty().asObject());
    goalDiffCol.setCellValueFactory(cellData -> cellData.getValue()
        .getGoalDiffIntegerProperty().asObject());
    medalCol.setCellValueFactory(cellData -> cellData.getValue()
        .getMedalStringProperty());

    for (TableColumn<Result, ?> col : this.getColumns()) {
      col.setSortable(false);
    }
  }

  public static ResultsTableView getInstance() {
    return matchesTable;
  }

  private ObservableList<Result> getInitialTableData() {
    ObservableList<Result> data = FXCollections.observableList(ResultsList
        .getInstance());
    return data;
  }

  public void updateTable() {
    ObservableList<Result> data = FXCollections.observableList(ResultsList
        .getInstance());
    this.setItems(data);
    this.getColumns().get(0).setVisible(false);
    this.getColumns().get(0).setVisible(true);
  }
}
