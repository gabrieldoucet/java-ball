package components;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Match;
import model.MatchesList;

public class MatchesTableView extends TableView<Match> {

  private ObservableList<Match> matchesData;
  public static MatchesTableView matchesTable = new MatchesTableView();

  private MatchesTableView() {
    super();
    this.setEditable(false);
    
    TableColumn<Match, String> team1Col = new TableColumn<Match, String>("First Team");
    TableColumn<Match, String> goalsTeam1Col = new TableColumn<Match, String>("Goals");
    TableColumn<Match, String> team2Col = new TableColumn<Match, String>("Second Team");
    TableColumn<Match, String> goalsTeam2Col = new TableColumn<Match, String>("Goals");

    this.getColumns().add(team1Col);
    this.getColumns().add(goalsTeam1Col);
    this.getColumns().add(team2Col);
    this.getColumns().add(goalsTeam2Col);

    matchesData = getInitialTableData();
    this.setItems(matchesData);

    team1Col.setCellValueFactory(cellData -> cellData.getValue().team1NameProperty());
    team2Col.setCellValueFactory(cellData -> cellData.getValue().team2NameProperty());
    goalsTeam1Col.setCellValueFactory(cellData -> cellData.getValue().goalsTeam1Property());
    goalsTeam2Col.setCellValueFactory(cellData -> cellData.getValue().goalsTeam2Property());
    
    team1Col.setSortable(false);
    team2Col.setSortable(false);
    goalsTeam1Col.setSortable(false);
    goalsTeam2Col.setSortable(false);
  }

  public static MatchesTableView getInstance() {
    return matchesTable;
  }

  private ObservableList<Match> getInitialTableData() {
    ObservableList<Match> data = FXCollections.observableList(MatchesList.getInstance());
    return data;
  }
  
  public void updateTable() {
    ObservableList<Match> data = FXCollections.observableList(MatchesList.getInstance());
    this.setItems(data);
  }
}
