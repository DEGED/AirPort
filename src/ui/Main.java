package ui;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.lang.model.element.AnnotationMirror;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.AirPort;

public class Main extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader(getClass().getResource("AirPortGUI.fxml"));
		Parent root = loader.load();
		
		FlightsControllerGUI fC = loader.getController();
		
		fC.setStage(stage);
		Scene scene = new Scene(root);
		stage.setTitle("Catch The Pac Man");
		stage.setScene(scene);
		stage.show();
	}

}
