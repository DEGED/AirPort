package ui;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.AirPort;
import model.Flight;
import javafx.scene.control.Button;

public class FlightsControllerGUI {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private AnchorPane anchor;

    @FXML
    private AnchorPane anchor2;
    
    @FXML
    private MenuItem SortDate;

    @FXML
    private MenuItem SortSchedule;

    @FXML
    private MenuItem SortAirLine;

    @FXML
    private MenuItem SortCode;

    @FXML
    private MenuItem SortCity;

    @FXML
    private MenuItem sortGate;

    @FXML
    private MenuItem searchDate1;

    @FXML
    private MenuItem searchSchedule1;

    @FXML
    private MenuItem searchAirLine1;

    @FXML
    private MenuItem searchCode1;

    @FXML
    private MenuItem searchCity1;

    @FXML
    private MenuItem searchGate1;

    
    @FXML
    private TableView<Flight> inicialTableView;


    @FXML
    private Button backWard;

    @FXML
    private Button Button;
    
    private AirPort x;
    
    private ArrayList<TableView<Flight>> alma;
    
    @FXML
    void AboutMessage(ActionEvent event) {

    }

    @FXML
    void SortingAirLine(ActionEvent event) {

    }

    @FXML
    void SortingCity(ActionEvent event) {

    }

    @FXML
    void SortingCode(ActionEvent event) {

    }

    @FXML
    void SortingDate(ActionEvent event) {

    }

    @FXML
    void SortingGates(ActionEvent event) {

    }

    @FXML
    void SortingSchedule(ActionEvent event) {

    }

    @SuppressWarnings("unchecked")
	@FXML
    void generatingFlights(ActionEvent event) {
      
    	int ranFlights = 12;
    	x.RandomGeneric(ranFlights);
    	
    	//DateColumn
    	TableColumn<Flight, String> dateColumn = new TableColumn<>("DATE");
    	dateColumn.setMinWidth(100);
    	dateColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("dateOut"));
    	
    	//AirLineColumn
    	TableColumn<Flight, String> airLineColumn = new TableColumn<>("AIRLINE");
    	airLineColumn.setMinWidth(100);
    	airLineColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("AirLine"));
  
    	//CodeCOlumn
    	TableColumn<Flight, String> codeColumn = new TableColumn<>("CODE");
    	codeColumn.setMinWidth(100);
    	codeColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("code"));
    	
    	//CityColumn
    	TableColumn<Flight, String> cityColumn = new TableColumn<>("CITY");
    	cityColumn.setMinWidth(100);
    	cityColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("city"));
    	
    	//TimeColumn
    	TableColumn<Flight, String> timeColumn = new TableColumn<>("TIME OUT");
    	timeColumn.setMinWidth(100);
    	timeColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("time"));
    	
    	//GateColumn
    	TableColumn<Flight, String> gateColumn = new TableColumn<>("GATE");
    	gateColumn.setMinWidth(100);
    	gateColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("gate"));
    	inicialTableView.setItems(getFlights(x.getFlights()));
    	inicialTableView.getColumns().addAll(cityColumn, codeColumn, airLineColumn, dateColumn, timeColumn, gateColumn);
  
    }
    @FXML
    void searchingAirLine(ActionEvent event) {

inicialTableView.getColumns().clear();
    }

    @FXML
    void searchingCity(ActionEvent event) {

    }

    @FXML
    void searchingCode(ActionEvent event) {

    }

    @FXML
    void searchingDate(ActionEvent event) {

    }

    @FXML
    void searchingGates(ActionEvent event) {

    }

    @FXML
    void searchingSchedule(ActionEvent event) {

    }
    
    @FXML
    void nextAction(ActionEvent event) {

    }

    @FXML
    void backWardAction(ActionEvent event) {

    }

    public ObservableList<Flight> getFlights(ArrayList<Flight> array){
    	ObservableList<Flight> flights = FXCollections.observableArrayList();
    	for(int i = 0; i<array.size();i++){
    		flights.add(array.get(i));
    	}
    	return flights;
    }
    @FXML
    void initialize() {
    	assert anchor != null : "fx:id=\"anchor\" was not injected: check your FXML file 'AirPortGUI.fxml'.";
        assert SortDate != null : "fx:id=\"SortDate\" was not injected: check your FXML file 'AirPortGUI.fxml'.";
        assert SortSchedule != null : "fx:id=\"SortSchedule\" was not injected: check your FXML file 'AirPortGUI.fxml'.";
        assert SortAirLine != null : "fx:id=\"SortAirLine\" was not injected: check your FXML file 'AirPortGUI.fxml'.";
        assert SortCode != null : "fx:id=\"SortCode\" was not injected: check your FXML file 'AirPortGUI.fxml'.";
        assert SortCity != null : "fx:id=\"SortCity\" was not injected: check your FXML file 'AirPortGUI.fxml'.";
        assert sortGate != null : "fx:id=\"sortGate\" was not injected: check your FXML file 'AirPortGUI.fxml'.";
        assert searchDate1 != null : "fx:id=\"searchDate1\" was not injected: check your FXML file 'AirPortGUI.fxml'.";
        assert searchSchedule1 != null : "fx:id=\"searchSchedule1\" was not injected: check your FXML file 'AirPortGUI.fxml'.";
        assert searchAirLine1 != null : "fx:id=\"searchAirLine1\" was not injected: check your FXML file 'AirPortGUI.fxml'.";
        assert searchCode1 != null : "fx:id=\"searchCode1\" was not injected: check your FXML file 'AirPortGUI.fxml'.";
        assert searchCity1 != null : "fx:id=\"searchCity1\" was not injected: check your FXML file 'AirPortGUI.fxml'.";
        assert searchGate1 != null : "fx:id=\"searchGate1\" was not injected: check your FXML file 'AirPortGUI.fxml'.";   
        assert anchor2 != null : "fx:id=\"anchor2\" was not injected: check your FXML file 'AirPortGUI.fxml'.";
        assert inicialTableView != null : "fx:id=\"inicialTableView\" was not injected: check your FXML file 'AirPortGUI.fxml'.";
        assert backWard != null : "fx:id=\"backWard\" was not injected: check your FXML file 'AirPortGUI.fxml'.";
        assert Button != null : "fx:id=\"Button\" was not injected: check your FXML file 'AirPortGUI.fxml'.";
        x = new AirPort();
        alma = new ArrayList<TableView<Flight>>();   
    }
}