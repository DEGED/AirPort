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
		/*
		 * 
		 
		CircleController guiController = loader.getController();
    	stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                try {
					guiController.onCloseRequest();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            }
        });
        */
		Scene scene = new Scene(root);
		stage.setTitle("Catch The Pac Man");
		stage.setScene(scene);
		stage.show();
	}

}
/*
Date x = new Date();
GregorianCalendar y = new GregorianCalendar(2019, Calendar.JANUARY, 15);
Date po = new Date();
String time = po.toString();
String[] parts = time.split(" ");
//String moderndate 
int pojik = 03;

System.out.println(pojik);
System.out.println(y.getTimeInMillis());
System.out.println(x.toString());


anonimo.RandomGeneric(2);
for(int i = 0; i<anonimo.getFlights().size() ;i++) {
	System.out.println(anonimo.getFlights().get(i).getAirLine());
	
	
	anonimo.randomDate();
anonimo.randomAirLine();
anonimo.randomCity();
anonimo.randomCode();
anonimo.randomGate();
anonimo.randomHour();
anonimo.randomMinute();
}

System.out.println(x.getHours());
AirPort anonimo = new AirPort();
anonimo.RandomGeneric(1);
System.out.println(anonimo.getFlights().get(0).toString());
*/