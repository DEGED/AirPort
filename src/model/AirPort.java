package model;

import java.util.*;

public class AirPort {

	public static String AVIANCA = "AVIANCA";
	public static String ADA = "ADA";
	public static String AERO_OASIS = "AERO OASIS";
	public static String AERO_TOTAL = "AERO TOTAL";
	public static String EASY_FLY = "EASY FLY";
	public static int MAX_BOARDING_GATES = 10;
	
	private int boardingGates;

	private ArrayList<Flight> flights;
	
	public AirPort() {
		
		flights = new ArrayList<Flight>();
	}
	public ArrayList<Flight> getFlights() {
		return flights;
	}
	public void setFlights(ArrayList<Flight> flights) {
		this.flights = flights;
	}
	public int binarySearch() {
		int posfind = 0;
		
		return posfind;
	}
	
	public int searchFind() {
		int posFind = 0;
		
		return posFind;
	}
	public void sortByBubble() {
		
	}
	public void sortByInserting() {
		
	}
	public void sortBySelection() {
		
	}
	public void RandomGeneric(int numberOfFlights) {
		for(int i = 0; i<numberOfFlights ; i++) {
			Flight randomFligth = new Flight(randomDate(), randomAirLine(), randomCode(), randomCity(), randomHour(), randomMinute(), randomGate());
			flights.add(randomFligth);
		}
	}
	public Date randomDate() {
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
		/*
		String ranMonth = "";
		if(randomMonth == 03) {
			ranMonth = Calendar.APRIL;
		}else if(randomMonth == 04) {
			
		}else if(randomMonth == 05) {
			
		}else if(randomMonth == 06) {
			
		}else if(randomMonth == 07) {
			
		}else if(randomMonth == 08) {
			
		}else if(randomMonth == 09) {
			
		}else if(randomMonth == 10) {
			
		}else if(randomMonth == 11) {
			
		}
		*/
		Date randomDate = new Date(2019, randomMonth, randomDay);
		System.out.println(randomDate.toString());
		return randomDate;
	}
	public String randomAirLine() {
		String airLineRandom = "";
		Random x = new Random();
		int airRand = x.nextInt(3);
		if(airRand == 0) {
			airLineRandom = AVIANCA;
		}else if(airRand == 1){
			airLineRandom = ADA;
		}else if(airRand == 2){
			airLineRandom = AERO_OASIS;
		}else if(airRand == 3){
			airLineRandom = AERO_TOTAL;
		}
		System.out.println(airLineRandom);
		return airLineRandom;
	}
	public String randomCode() {
		String ranCode = "";
		Random x = new Random();
		for(int i = 0; i<7 ;i++) {
			int ranNum = x.nextInt(9);
			ranCode += ""+ranNum;
		}
		System.out.println(ranCode);
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
		System.out.println(cityRandom);
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
		System.out.println(ranHour);
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
		System.out.println(ranMinute);
		return ranMinute;
	}
	public int randomGate(){
		Random x = new Random();
		int ranGate = (x.nextInt(9)+1);
		System.out.println(ranGate);
		return ranGate;
	}
	public int getBoardingGates(){
		return boardingGates;
	}

	public void setBoardingGates(int boardingGates) {
		this.boardingGates = boardingGates;
	}

	
}
