package ui;

import java.awt.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.AirPort;
import model.Flight;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class FlightsControllerGUI {

	private Stage stage;
	
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
    
    private AirPort airPort;
        
    private int ranFlights;
    private int ini;
    
    private int end;
    
    private long initTime;
    
    private long endTime;
    @FXML
    void AboutMessage(ActionEvent event) {
    	
    }

    @FXML
    void SortingAirLine(ActionEvent event){
    	initTime = System.currentTimeMillis();
    	airPort.sortAirLine();
    	airPort.getFlights().clear();
    	airPort.toArrayList();
    	inicialTableView.setItems(getFlights(airPort.getFlights()));
    	endTime = System.currentTimeMillis();
    	AlertTime();
    	
    }

    @FXML
    void SortingCity(ActionEvent event){
    	initTime = System.currentTimeMillis();
    	airPort.sortCity();
    	airPort.getFlights().clear();
    	airPort.toArrayList();
    	inicialTableView.setItems(getFlights(airPort.getFlights()));
    	endTime = System.currentTimeMillis();
    	AlertTime();
    }

    @FXML
    void SortingCode(ActionEvent event){
    	initTime = System.currentTimeMillis();
    	airPort.sortCode();
    	airPort.getFlights().clear();
    	airPort.toArrayList();
    	inicialTableView.setItems(getFlights(airPort.getFlights()));
    	endTime = System.currentTimeMillis();
    	AlertTime();
    }

    @FXML
    void SortingDate(ActionEvent event) {
    	initTime = System.currentTimeMillis();
    	airPort.sortDate();
    	airPort.getFlights().clear();
    	airPort.toArrayList();
    	inicialTableView.setItems(getFlights(airPort.getFlights()));
    	endTime = System.currentTimeMillis();
    	AlertTime();
    }
    @FXML
    void SortingGates(ActionEvent event) {
    	initTime = System.currentTimeMillis();
    	airPort.sortGate();
<<<<<<< HEAD
    	airPort.getFlights().clear();
    	airPort.toArrayList();
=======
>>>>>>> ca8b7f7bdb2001e6bfd15b0391ea3b219971f0b7
    	inicialTableView.setItems(getFlights(airPort.getFlights()));
    	endTime = System.currentTimeMillis();
    	AlertTime();
    }

    @FXML
    void SortingSchedule(ActionEvent event) {
    	initTime = System.currentTimeMillis();
    	airPort.sortTime();
    	airPort.getFlights().clear();
    	airPort.toArrayList();
    	inicialTableView.setItems(getFlights(airPort.getFlights()));
    	endTime = System.currentTimeMillis();
    	AlertTime();
    }

    @SuppressWarnings("unchecked")
	@FXML
    void generatingFlights(ActionEvent event) {
    	Stage genericStage = new Stage();
    	genericStage.initModality(Modality.APPLICATION_MODAL);
    	genericStage.initOwner(stage);
    	VBox generic = new VBox(20);
    	Scene scene = new Scene(generic, 300, 200);
    	Label sing = new Label();
    	sing.setText("Introduce the numbers of the random flights");
    	generic.getChildren().add(sing);
    	generic.setAlignment(Pos.CENTER);
    	javafx.scene.control.TextField genericText = new javafx.scene.control.TextField();
    	generic.getChildren().add(genericText);
    	Button ok = new Button();
    	ok.setText("OK");
    	generic.getChildren().add(ok);
    	genericStage.setScene(scene);
    	genericStage.show();
    	ok.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0){
				initTime = System.currentTimeMillis();
				airPort.getFlights().clear();
				ranFlights = Integer.parseInt(genericText.getText());
				try {
					airPort.RandomGeneric(ranFlights);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				airPort.sortDate();
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
		    	endTime = System.currentTimeMillis();
		    	inicialTableView.getColumns().addAll(cityColumn, codeColumn, airLineColumn, dateColumn, timeColumn, gateColumn);
		    	ObservableList<Flight> x = FXCollections.observableArrayList(airPort.getFlights());
		    	inicialTableView.setItems(x);
		    	AlertTime();
				genericStage.close();
			}
    	});
    }
    @FXML
    void searchingAirLine(ActionEvent event){
    	Stage genericStage = new Stage();
    	genericStage.initModality(Modality.APPLICATION_MODAL);
    	genericStage.initOwner(stage);
    	VBox generic = new VBox(20);
    	Scene scene = new Scene(generic, 300, 200);
    	Label sing = new Label();
    	sing.setText("Introduce the AIRLINE to find");
    	generic.getChildren().add(sing);
    	generic.setAlignment(Pos.CENTER);
    	javafx.scene.control.TextField genericText = new javafx.scene.control.TextField();
    	generic.getChildren().add(genericText);
    	Button ok = new Button();
    	ok.setText("OK");
    	generic.getChildren().add(ok);
    	genericStage.setScene(scene);
    	genericStage.show();
    	ok.setOnAction(new EventHandler<ActionEvent>(){	
    		@Override
    		public void handle(ActionEvent arg0){
    			initTime = System.currentTimeMillis();
    			int find = airPort.searchingAirling(genericText.getText());
    			Flight found = airPort.getFlights().get(find);
    			ObservableList<Flight> x = FXCollections.observableArrayList(found);
    			inicialTableView.setItems(x);
    			endTime = System.currentTimeMillis();
    			AlertTime();
    			
    		}
    	
    	});
    }

    @FXML
    void searchingCity(ActionEvent event) {
    	Stage genericStage = new Stage();
    	genericStage.initModality(Modality.APPLICATION_MODAL);
    	genericStage.initOwner(stage);
    	VBox generic = new VBox(20);
    	Scene scene = new Scene(generic, 300, 200);
    	Label sing = new Label();
    	sing.setText("Introduce the city to find");
    	generic.getChildren().add(sing);
    	generic.setAlignment(Pos.CENTER);
    	javafx.scene.control.TextField genericText = new javafx.scene.control.TextField();
    	generic.getChildren().add(genericText);
    	Button ok = new Button();
    	ok.setText("OK");
    	generic.getChildren().add(ok);
    	genericStage.setScene(scene);
    	genericStage.show();
    	ok.setOnAction(new EventHandler<ActionEvent>(){	
    		@Override
    		public void handle(ActionEvent arg0){
//    			initTime = System.currentTimeMillis();
    			int find = airPort.searchingCity(genericText.getText());
    			Flight found = airPort.getFlights().get(find);
    			ObservableList<Flight> x = FXCollections.observableArrayList(found);
    			inicialTableView.setItems(x);
//    			endTime = System.currentTimeMillis();
//    			AlertTime();    			
    		}
    	
    	});
    	
    }

    @FXML
    void searchingCode(ActionEvent event) {
    	Stage genericStage = new Stage();
    	genericStage.initModality(Modality.APPLICATION_MODAL);
    	genericStage.initOwner(stage);
    	VBox generic = new VBox(20);
    	Scene scene = new Scene(generic, 300, 200);
    	Label sing = new Label();
    	sing.setText("Introduce the CODE to find");
    	generic.getChildren().add(sing);
    	generic.setAlignment(Pos.CENTER);
    	javafx.scene.control.TextField genericText = new javafx.scene.control.TextField();
    	generic.getChildren().add(genericText);
    	Button ok = new Button();
    	ok.setText("OK");
    	generic.getChildren().add(ok);
    	genericStage.setScene(scene);
    	genericStage.show();
    	ok.setOnAction(new EventHandler<ActionEvent>(){	
    		@Override
    		public void handle(ActionEvent arg0){
    			initTime = System.currentTimeMillis();
    			int find = airPort.searchingCode(genericText.getText());
    			Flight found = airPort.getFlights().get(find);
    			ObservableList<Flight> x = FXCollections.observableArrayList(found);
    			inicialTableView.setItems(x);
    			endTime = System.currentTimeMillis();
    			AlertTime();
    			
    		}
    	
    	});
    	
    }
    

    @FXML
    void searchingDate(ActionEvent event) {
    	Stage genericStage = new Stage();
    	genericStage.initModality(Modality.APPLICATION_MODAL);
    	genericStage.initOwner(stage);
    	VBox generic = new VBox(20);
    	Scene scene = new Scene(generic, 300, 200);
    	Label sing = new Label();
    	sing.setText("Introduce the DATE to find");
    	generic.getChildren().add(sing);
    	generic.setAlignment(Pos.CENTER);
    	javafx.scene.control.TextField genericText = new javafx.scene.control.TextField();
    	generic.getChildren().add(genericText);
    	Button ok = new Button();
    	ok.setText("OK");
    	generic.getChildren().add(ok);
    	genericStage.setScene(scene);
    	genericStage.show();
    	ok.setOnAction(new EventHandler<ActionEvent>(){	
    		@Override
    		public void handle(ActionEvent arg0){
    			initTime = System.currentTimeMillis();
    			int find = airPort.searchingDate(genericText.getText());
    			Flight found = airPort.getFlights().get(find);
    			ObservableList<Flight> x = FXCollections.observableArrayList(found);
    			inicialTableView.setItems(x);
    			endTime = System.currentTimeMillis();
    			AlertTime();
    			
    		}
    	
    	});
    }
   
    @FXML
    void searchingGates(ActionEvent event) {
    	Stage genericStage = new Stage();
    	genericStage.initModality(Modality.APPLICATION_MODAL);
    	genericStage.initOwner(stage);
    	VBox generic = new VBox(20);
    	Scene scene = new Scene(generic, 300, 200);
    	Label sing = new Label();
    	sing.setText("Introduce the GATE to find");
    	generic.getChildren().add(sing);
    	generic.setAlignment(Pos.CENTER);
    	javafx.scene.control.TextField genericText = new javafx.scene.control.TextField();
    	generic.getChildren().add(genericText);
    	Button ok = new Button();
    	ok.setText("OK");
    	generic.getChildren().add(ok);
    	genericStage.setScene(scene);
    	genericStage.show();
    	ok.setOnAction(new EventHandler<ActionEvent>(){	
    		@Override
    		public void handle(ActionEvent arg0){
    			initTime = System.currentTimeMillis();
    			int find = airPort.searchingGate(Integer.parseInt(genericText.getText()));
    			System.out.println(find);
    			Flight found = airPort.getFlights().get(find);
    			ObservableList<Flight> x = FXCollections.observableArrayList(found);
    			inicialTableView.setItems(x);
    			endTime = System.currentTimeMillis();
    			AlertTime();
    			
    		}
    	
    	});
    }

    @FXML
    void searchingSchedule(ActionEvent event) {
    	Stage genericStage = new Stage();
    	genericStage.initModality(Modality.APPLICATION_MODAL);
    	genericStage.initOwner(stage);
    	VBox generic = new VBox(20);
    	Scene scene = new Scene(generic, 300, 200);
    	Label sing = new Label();
    	sing.setText("Introduce the HOUR to find");
    	generic.getChildren().add(sing);
    	generic.setAlignment(Pos.CENTER);
    	javafx.scene.control.TextField genericText = new javafx.scene.control.TextField();
    	generic.getChildren().add(genericText);
    	Button ok = new Button();
    	ok.setText("OK");
    	generic.getChildren().add(ok);
    	genericStage.setScene(scene);
    	genericStage.show();
    	ok.setOnAction(new EventHandler<ActionEvent>(){	
    		@Override
    		public void handle(ActionEvent arg0){
    			initTime = System.currentTimeMillis();
    			int find = airPort.searchingHour(genericText.getText());
    			System.out.println(find);
    			Flight found = airPort.getFlights().get(find);
    			ObservableList<Flight> x = FXCollections.observableArrayList(found);
    			inicialTableView.setItems(x);
    			endTime = System.currentTimeMillis();
    			AlertTime();
    			
    		}
    	
    	});
    }
    
    @FXML
    void nextAction(ActionEvent event) {
    	ini = end;
    	int cont = 0;
    	ArrayList<Flight> miniFligths = new ArrayList<Flight>();
    	for(int i =ini; i<airPort.getFlights().size() && i<end+12;i++){
    		miniFligths.add(airPort.getFlights().get(i));
    		cont++;
    		
    	}
    	end += cont;
    	ObservableList<Flight> flights = FXCollections.observableArrayList(miniFligths);
    	inicialTableView.setItems(flights);
    	if(end>=ranFlights) {
    		Button.setDisable(true);
    		backWard.setDisable(false);
    		
    	}else {
    		Button.setDisable(false);
    	}
    }

    @FXML
    void backWardAction(ActionEvent event) {
    
    	end = ini;
    	ini -= 12;
    	int cont = 0;
    	ArrayList<Flight> miniFligths = new ArrayList<Flight>();
    	for(int i = ini; i<airPort.getFlights().size() && i<end;i++){
    		miniFligths.add(airPort.getFlights().get(i));
    		cont++;	
    	}
    	//ini -= cont;
    	if(ini==0) {
    		backWard.setDisable(true);
    		Button.setDisable(false);
    		
    	}else {
    		backWard.setDisable(false);
    	}
    	ObservableList<Flight> flights = FXCollections.observableArrayList(miniFligths);
    	inicialTableView.setItems(flights);
    }

    public ObservableList<Flight> getFlights(ArrayList<Flight> array){
    	ObservableList<Flight> flights = FXCollections.observableArrayList();
    	for(int i =0; i<array.size();i++){
    		flights.add(array.get(i));
    	}
    	return flights;
    }
    @FXML
    void initialize() {
    	airPort = new AirPort();
        
        end = 12;
    }
    public long realTime() {
    	long realTime = 0;
    	realTime = (endTime-initTime);
    	return realTime;
    }
    public void AlertTime() {
    	Alert k = new Alert(AlertType.INFORMATION);
		k.setTitle("Time of execution");
		k.setHeaderText(null);
		k.initStyle(StageStyle.UTILITY);
		k.setContentText("The time of execution was "+realTime()+" segundos");
		k.show();
    }
    
    public void setStage(Stage stage) {
    	
    }
}