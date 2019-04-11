package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AirPort {

	public static String AVIANCA = "AVIANCA";
	public static String ADA = "ADA";
	public static String AERO_OASIS = "AERO OASIS";
	public static String AERO_TOTAL = "AERO TOTAL";
	public static String EASY_FLY = "EASY FLY";	
	public static String LATAM = "LATAM";	
	public static String SURAMERICANA = "SURAMERICANA";	
	public static String WEST = "WEST";	

	private ArrayList<Flight> flights;
	
	public AirPort() {
		
		flights = new ArrayList<Flight>();
	}

	public int searchingDate(String date) {
		int posFind = -1;
		boolean found = false;
			for(int i = 0; i<flights.size() && !found; i++) {
				if(flights.get(i).getDateOut().equals(date)) {
					found = true;
					posFind = i;
				}
			}
		return posFind;
	}
	
	public int searchingAirling(String airLine) {
		sortAirLine();
		int posFound = -1;
		int  mid = 0;
		int low = 0;
		int high = 0;
		while(low<= high && posFound == -1) {
			mid = (low+high)/2;
			if(flights.get(mid).getAirLine().compareToIgnoreCase(airLine)<0){
				mid = low+1;
			}else if(flights.get(mid).getAirLine().compareToIgnoreCase(airLine)>0) {
				mid = high-1;
			}else {
				posFound = mid;
			}
		}
		return posFound;
	}
	public int searchingCode(String code){
		int posFound = -1;
		boolean found = false;
			for(int i = 0; i<flights.size() && !found;i++) {
				if(flights.get(i).getCode().equalsIgnoreCase(code)) {
					found = true;
					posFound = i;
				}
			}
		return posFound;
	}
	public int searchingCity(String city) {
		sortCity();
		int posFound = -1;
		int  mid = 0;
		int low = 0;
		int high = 0;
		while(low<= high && posFound == -1) {
			mid = (low+high)/2;
			if(flights.get(mid).getCity().compareToIgnoreCase(city)<0){
				mid = low+1;
			}else if(flights.get(mid).getCity().compareToIgnoreCase(city)>0){
				mid = high-1;
			}else {
				posFound = mid;
			}
		}
		return posFound;
	}
	
	public int searchingHour(String hour) {
		int posFound = -1;
		boolean found = false;
			for(int i = 0; i<flights.size() && !found;i++) {
				if(flights.get(i).getTime().equalsIgnoreCase(hour)) {
					found = true;
					posFound = i;
				}
			}
		return posFound;
	}
	public int searchingGate(int gate) {
		int posFound = -1;
		boolean found = false;
			for(int i = 0; i<flights.size() && !found;i++) {
				if(flights.get(i).getGate() == gate){
					found = true;
					posFound = i;
				}
			}
		return posFound;
	}
	public void RandomGeneric(int numberOfFlights) throws IOException {
		for(int i = 0; i<numberOfFlights ; i++){
			Flight randomFligth = new Flight(randomDate(), randomAirLine("data\\airLine.txt", ";"), randomCode(), randomCity(), randomHour(), randomMinute(), randomGate());
			flights.add(randomFligth);
		}
	}
	public Date randomDate(){
		Random x = new Random();
		Date actualDate = new Date();
		String[] stringActualDate = actualDate.toString().split(" ");
		int actualDay = Integer.parseInt(stringActualDate[2]);
		int actualMonth = actualDate.getMonth();
		int randomDay = 0;
		while(randomDay < actualDay){
			randomDay = (x.nextInt(30)+1);
		}
		int randomMonth = 0;
		while(randomMonth < actualMonth){
			randomMonth = x.nextInt(11);
		}
		Date randomDate = new Date(2019, randomMonth, randomDay);
		return randomDate;
	}
	public String randomAirLine(String path, String step) throws IOException {
		String airLineRandom = "";
		Random x = new Random();
		File f = new File(path);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		int airRand = x.nextInt(8);
		while(line != null){
			String[] parts = line.split(step);
			System.out.println(parts[0]);
			String easyFly= parts[0];
			String ada = parts[1];
			String aeroOasis= parts[2];
			String aeroTotal= parts[3];
			String latam = parts[4];
			String suraAmerica = parts[5];
			String west = parts[6];
			if(airRand == 0){
				airLineRandom = easyFly;
			}else if(airRand == 1){
				airLineRandom = ada;
			}else if(airRand == 2){
				airLineRandom = aeroOasis;
			}else if(airRand == 3){
				airLineRandom = aeroTotal;
			}else if(airRand == 4){
				airLineRandom = latam;
			}else if(airRand == 5){
				airLineRandom = suraAmerica;
			}else if(airRand == 6){
				airLineRandom = west;
				System.out.println(airLineRandom);
			}
			line = br.readLine();
		}
		System.out.println(airLineRandom);
		br.close();
		return airLineRandom;
	}
	public String randomCode() {
		String ranCode = "";
		Random x = new Random();
		for(int i = 0; i<7 ;i++) {
			int ranNum = x.nextInt(9);
			ranCode += ""+ranNum;
		}
		return ranCode;
	}
	public String randomCity() {
		String cityRandom = "";
		Random x = new Random();
		int cityRandomRandom = x.nextInt(6);
		if(cityRandomRandom == 0){
			cityRandom = Flight.ARGENTINA;	
		}else if(cityRandomRandom == 1){
			cityRandom = Flight.BRAZIL;	
		}else if(cityRandomRandom == 2){
			cityRandom = Flight.CHINA;
		}else if(cityRandomRandom == 3){
			cityRandom = Flight.JAPAN;
		}else if(cityRandomRandom == 4){
			cityRandom = Flight.LONDON;
		}else if(cityRandomRandom == 5){
			cityRandom = Flight.UNITED_STATES;
		}
		return cityRandom;
	}
	public int randomHour(){
		int ranHour = 0;
		Date actualDate = new Date();
		int actualHour = actualDate.getHours();
		actualHour += actualHour>12? -12:0;
		actualHour += actualHour< 1? 1:0;
		Random x = new Random();
		while(ranHour < actualHour){
			ranHour = (x.nextInt(11)+1);
			
		}
		return ranHour;
	}
	public int randomMinute() {
		int ranMinute = 0;
		Date actualDate = new Date();
		int actualMinute = actualDate.getMinutes();
		Random x = new Random();
		while(ranMinute < actualMinute){
			ranMinute = (x.nextInt(59)+1);
		}
		return ranMinute;
	}
	public int randomGate(){
		Random x = new Random();
		int ranGate = (x.nextInt(9)+1);
		return ranGate;
	}
	public void sortDate(){
		int n = flights.size();
	    for (int i = 0; i <= n; i++) {
	        for (int j = 0; j < n - i - 1; j++){
	            if (flights.get(j+1).getDate().compareTo(flights.get(j).getDate())<0){
	                Flight temp = flights.get(j); 
	                flights.set(j,flights.get(j+1));
	                flights.set(j+1,temp);
	            }
	        }
	    }
	        
	}
	/*
	 * */
	 
	public void sortTime() {
		 for (int I = 0; I < flights.size()-1; I++) {
				int minPosition = I;
				for (int J = I+1; J < flights.size() ; J++) {
					if(flights.get(J).getHourOut() < flights.get(minPosition).getHourOut()) {
						minPosition = J;
					}else if(flights.get(J).getHourOut() == flights.get(minPosition).getHourOut()){
						if(flights.get(J).getMinuteOut()<flights.get(minPosition).getMinuteOut()){
							minPosition = J; 
						}
					}
				}
				Flight temp = flights.get(minPosition);
				flights.set(minPosition, flights.get(I));
				flights.set(I, temp);
		 }
		 
	}
	
	public void sortAirLine(){
		
		Collections.sort(flights);
		
	}
	public void sortGate(){
		int n = flights.size();
	    for (int i = 1; i <= n - 1; i++) {
	        int x = flights.get(i).getGate();
	        Flight temp = flights.get(i);
	        int j = i - 1;
	        while (j >= 0 && x < flights.get(j).getGate()){
	            flights.set(j+1,flights.get(j));
	            j = j - 1;
	        }
	        flights.set(j + 1, temp);
	    }
	}
	public void sortCode(){
		int n = flights.size();
	    for (int i = 1; i <= n - 1; i++) {
	        int x = Integer.parseInt(flights.get(i).getCode());
	        Flight temp = flights.get(i);
	        int j = i - 1;
	        while (j >= 0 && x < Integer.parseInt(flights.get(j).getCode())) {
	        	flights.set(j+1,flights.get(j));
	            j = j - 1;
	        }
	        flights.set(j + 1, temp);
	    }
	}	
	public void sortCity(){
		int n = flights.size();
	    for(int i = 1; i <= n - 1; i++){
	        String x = flights.get(i).getCity();
	        Flight temp = flights.get(i);
	        int j = i - 1;
	        while (j >= 0 && x.compareTo(flights.get(j).getCity())<0) {
	        	flights.set(j+1,flights.get(j));
	            j = j - 1;
	        }
	        flights.set(j + 1, temp);
	    }
	}
	public ArrayList<Flight> getFlights() {
		return flights;
	}
	public void setFlights(ArrayList<Flight> flights) {
		this.flights = flights;
	}
	
}
