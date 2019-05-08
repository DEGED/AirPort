package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AirPort {

	public static String L = "data\\airLine.txt";
	public static String AVIANCA = "AVIANCA";
	public static String ADA = "ADA";
	public static String AERO_OASIS = "AERO OASIS";
	public static String AERO_TOTAL = "AERO TOTAL";
	public static String EASY_FLY = "EASY FLY";	
	public static String LATAM = "LATAM";	
	public static String SURAMERICANA = "SURAMERICANA";	
	public static String WEST = "WEST";	

	private ArrayList<Flight> flights;
//	new attribute
	private Flight first;
	public AirPort(){
		
		flights = new ArrayList<Flight>();
	}

	public Flight searchingDate(String date){
		
		Flight found = null;
		Flight current = first;
		boolean flag = false;
		while(current!=null && !flag){
			if(current.getDateOut().equals(date)){
				found = current;
				flag = true;
			}
			current = current.getNext();
		}
		
		return found;
	}
	
	public Flight searchingAirling(String airLine) {
		Flight found = null;
		Flight current = first;
		boolean flag = false;
		while(current!=null && !flag){
			if(current.getAirLine().equals(airLine)){
				found = current;
				flag = true;
			}
			current = current.getNext();
		}
		
		return found;
	}
	
	public Flight searchingCode(String code){
		Flight found = null;
		Flight current = first;
		boolean flag = false;
		while(current!=null && !flag){
			if(current.getCode().equals(code)){
				found = current;
				flag = true;
			}
			current = current.getNext();
		}
		
		return found;
	}
	public Flight searchingCity(String city) {
		Flight found = null;
		Flight current = first;
		boolean flag = false;
		while(current!=null && !flag){
			if(current.getCity().equals(city)){
				found = current;
				flag = true;
			}
			current = current.getNext();
		}
		
		return found;
	}
	
	public Flight searchingHour(String hour) {
		Flight found = null;
		Flight current = first;
		boolean flag = false;
		while(current!=null && !flag){
			if(current.getTime().equalsIgnoreCase(hour)){
				found = current;
				flag = true;
			}
			current = current.getNext();
		}
		
		return found;
	}
	public Flight searchingGate(int gate) {
		Flight found = null;
		Flight current = first;
		boolean flag = false;
		while(current!=null && !flag){
			if(current.getGate() == gate){
				found = current;
				flag = true;
			}
			current = current.getNext();
		}
		
		return found;
	}
	public void RandomGeneric(int numberOfFlights) throws IOException {
		Flight[] x = new Flight[numberOfFlights];
		for(int i = 0; i<numberOfFlights ; i++){
			Flight randomFligth = new Flight(randomDate(), randomAirLine("data\\airLine.txt", ";"), randomCode(), randomCity(), randomHour(), randomMinute(), randomGate());
			x[i] = randomFligth;
		}
		first = x[0];
		Flight current = first;
		for(int i = 1; i<numberOfFlights; i++){
				if(current!=null){
				Flight prev = current;
				current.setNext(x[i]);
				current = current.getNext();
				current.setPrevious(prev);
//				System.out.println(current.getAirLine());
			}
		}
		
	}
	//nuevo método no agregado en la API
	//	TODO
	public void toArrayList() {
		Flight current = first;
		while(current != null) {
			flights.add(current);
			current = current.getNext();
		}
		for(int i = 0; i<flights.size();i++){
//			System.out.println(flights.get(i).dateOutToString());
		}
	}
	//metodo no agregado en la API
	//TODO
	public int sizeOfLinkedList() {
		int  retu = 0;
		Flight current = first;
		while(current != null){
			retu++;
			current = current.getNext();
		}
		return retu;
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
		int airRand = x.nextInt(7);
		while(line != null){
			String[] parts = line.split(step);
//			System.out.println(parts[0]);
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
//				System.out.println(airLineRandom);
			}
			line = br.readLine();
		}
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
	//TODO metodo para organizar segun la fecha con linked List
	public void sortDate(){
		/*
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
	     */
		if(first != null){
			boolean changed = true;
			while(changed) {
				Flight current = first;
				changed = false;
				while(current.getNext() != null) {
					Flight next = current.getNext();
					if(current.getDate().compareTo(next.getDate())>0) {
						if(current.getPrevious()!=null) {
							current.getPrevious().setNext(next);
						}
						if(next.getNext()!=null) {
							next.getNext().setPrevious(current);
						}
						current.setNext(next.getNext());
						next.setPrevious(current.getPrevious());
						current.setPrevious(next);
						next.setNext(current);						
						if(current==first) {
							first = next;
						}
						changed = true;
					}else{
						current = current.getNext();
					}
				}
			}
		}
	}
	/* 
	 * */
	 
	public void sortTime() {
		Flight oCurr = first.getNext();
        while(oCurr != null) {
            Flight curr = oCurr;
            while(curr.getPrevious()!=null){
                if(curr.getHourOut() < curr.getPrevious().getHourOut()) {
                    Flight temp = curr.getPrevious();
                    if(temp.getPrevious()!= null) {
                       temp.getPrevious().setNext(curr);
                   }
                   if(curr.getNext() != null) {
                       curr.getNext().setPrevious(temp);
                   }
                   temp.setNext(curr.getNext());
                   curr.setPrevious(temp.getPrevious());
                   temp.setPrevious(curr);
                   curr.setNext(temp);
                   if(temp == first)
                       first = curr;
                }else {
                curr = curr.getPrevious();
            }
        	}
            oCurr = oCurr.getNext();
        }
	}
	
	public void sortAirLine(){
		if(first != null){
			boolean changed = true;
			while(changed) {
				Flight current = first;
				changed = false;
				while(current.getNext() != null) {
					Flight next = current.getNext();
					if(current.getAirLine().compareTo(next.getAirLine())>0) {
						if(current.getPrevious()!=null) {
							current.getPrevious().setNext(next);
						}
						if(next.getNext()!=null) {
							next.getNext().setPrevious(current);
						}
						current.setNext(next.getNext());
						next.setPrevious(current.getPrevious());
						current.setPrevious(next);
						next.setNext(current);						
						if(current==first) {
							first = next;
						}
						changed = true;
					}else{
						current = current.getNext();
					}
				}
			}
		}
	}
	/*
	 * int n = flights.size();
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
	 */
	public void sortGate(){
		/*
		if(first != null){
			Flight current = first;
			while(current != null && current.getNext()!= null ){
				Flight currentPrev = current.getNext();
				System.out.println(currentPrev.getGate());
				if(current.getGate()>current.getNext().getGate()){
					boolean changed = false;
					while(current != null){
						System.out.println("ok");
						if(current.getGate() < currentPrev.getGate()) {
							current.setNext(currentPrev.getNext());
							currentPrev.setPrevious(current.getPrevious());
							current.setPrevious(currentPrev);
							currentPrev.setNext(current);
							System.out.println("ok1");
						}
						current = current.getPrevious();	
					 }
				}else {
				current = current.getNext();
				}
			}
		}
		*/
		if(first != null){
			boolean changed = true;
			while(changed) {
				Flight current = first;
				changed = false;
				while(current.getNext() != null) {
					Flight next = current.getNext();
					if(current.getDate().compareTo(next.getDate())>0) {
						if(current.getPrevious()!=null) {
							current.getPrevious().setNext(next);
						}
						if(next.getNext()!=null) {
							next.getNext().setPrevious(current);
						}
						current.setNext(next.getNext());
						next.setPrevious(current.getPrevious());
						current.setPrevious(next);
						next.setNext(current);						
						if(current==first) {
							first = next;
						}
						changed = true;
					}else{
						current = current.getNext();
					}
				}
			}
		}
	}
	
	public void sortCode(){
		if(first != null){
			boolean changed = true;
			while(changed) {
				Flight current = first;
				changed = false;
				while(current.getNext() != null) {
					Flight next = current.getNext();
					if(current.getCode().compareTo(next.getCode())>0) {
						if(current.getPrevious()!=null) {
							current.getPrevious().setNext(next);
						}
						if(next.getNext()!=null) {
							next.getNext().setPrevious(current);
						}
						current.setNext(next.getNext());
						next.setPrevious(current.getPrevious());
						current.setPrevious(next);
						next.setNext(current);						
						if(current==first) {
							first = next;
						}
						changed = true;
					}else{
						current = current.getNext();
					}
				}
			}
		}
	}	
	public void sortCity(){
		if(first != null){
			boolean changed = true;
			while(changed) {
				Flight current = first;
				changed = false;
				while(current.getNext() != null) {
					Flight next = current.getNext();
					if(current.getCity().compareTo(next.getCity())>0) {
						if(current.getPrevious()!=null) {
							current.getPrevious().setNext(next);
						}
						if(next.getNext()!=null) {
							next.getNext().setPrevious(current);
						}
						current.setNext(next.getNext());
						next.setPrevious(current.getPrevious());
						current.setPrevious(next);
						next.setNext(current);						
						if(current==first) {
							first = next;
						}
						changed = true;
					}else{
						current = current.getNext();
					}
				}
			}
		}
	}
	public ArrayList<Flight> getFlights() {
		return flights;
	}
	public void setFlights(ArrayList<Flight> flights) {
		this.flights = flights;
	}
	
}
