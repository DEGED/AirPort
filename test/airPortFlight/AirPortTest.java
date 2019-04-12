package airPortFlight;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import model.AirPort;
import model.Flight;

class AirPortTest {

		private AirPort airPortTesting;
		
		
	public AirPortTest() {
			
		}

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	
	public void setupScenary1() {
		airPortTesting = new AirPort();
	}
	public void setupScenary2() {
		airPortTesting = new AirPort();
		Flight generic1 = new Flight(new Date(2,7,2019), "AVIANCA", "7980209", "LONDON", 8, 30, 7);
		Flight generic2 = new Flight(new Date(4,10,2019), "LATAM", "2093812", "CHINA", 3, 20, 1);
		airPortTesting.getFlights().add(generic1);
		airPortTesting.getFlights().add(generic2);
	}
	public void setupScenary3() {
		airPortTesting = new AirPort();
		Flight generic1 = new Flight(new Date(2,7,2019), "AVIANCA", "7980209", "LONDON", 8, 30, 7);
		Flight generic2 = new Flight(new Date(4,10,2019), "LATAM", "2093812", "CHINA", 3, 20, 1);
		Flight generic3 = new Flight(new Date(9,30,2019), "EASY FLY", "2093489", "UNITED STATES", 11, 50, 3);
		airPortTesting.getFlights().add(generic1);
		airPortTesting.getFlights().add(generic2);
		airPortTesting.getFlights().add(generic3);
	}
	@Test
	void searchingDateTest(){
		setupScenary2();
		int found = airPortTesting.searchingDate("4/10/2019");
		Flight generic2 = new Flight(new Date(4,10,2019), "LATAM", "2093812", "CHINA", 3, 20, 1);
		assertEquals(airPortTesting.getFlights().get(found), generic2);
	}

}
