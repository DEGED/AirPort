package model;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class Flight implements Comparable<Flight> {
//constants
	public static String BRAZIL = "BRAZIL";
	public static String CHINA = "CHINA";
	public static String UNITED_STATES = "UNITED STATES";
	public static String JAPAN= "JAPAN";
	public static String ARGENTINA = "ARGENTINA";
	public static String LONDON = "LONDON";
//	attributes
	private Date date;
	private String dateOut;
	private String AirLine;
	private String code;
	private String city;
	private String time;
	private String schedule;
	private int hourOut;
	private int minuteOut;
	private int gate;
	
	private Flight next;
	private Flight previous;
//	constructor
	public Flight(Date date, String airLine, String code, String city, int hourOut, int minuteOut, int gate) {
		super();
		this.date = date;
		setDateOut(dateOutToString());
		AirLine = airLine;
		this.code = code;
		this.city = city;
		this.hourOut = hourOut;
		this.minuteOut = minuteOut;
		this.gate = gate;
		timeToString();
		
	}
	public void change(Date date, String airLine, String code, String city, int hourOut, int minuteOut, int gate) {
		this.date = date;
		this.AirLine = airLine;
		this.code = code;
		this.city = city;
		this.hourOut = hourOut;
		this.minuteOut = minuteOut;
		this.gate = gate;
	}	
	
	public void timeToString() {
		Random x = new Random();
		int ran = x.nextInt(2);
		String schedule = "";
		if(ran == 0){
			schedule = "AM";
		}else if(ran == 1){
			schedule = "PM";
		}
		
		time = ""+hourOut+":"+minuteOut+" "+schedule;
	}
	public String dateOutToString(){
		return (""+date.getMonth()+"/"+date.getDate()+"/"+date.getYear());
	}
//	getters and setters
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAirLine() {
		return AirLine;
	}
	public void setAirLine(String airLine) {
		AirLine = airLine;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getHourOut() {
		return hourOut;
	}
	public void setHourOut(int hourOut) {
		this.hourOut = hourOut;
	}
	public int getMinuteOut() {
		return minuteOut;
	}
	public void setMinuteOut(int minuteOut) {
		this.minuteOut = minuteOut;
	}
	public int getGate() {
		return gate;
	}
	public void setGate(int gate) {
		this.gate = gate;
	}
	public String getDateOut() {
		return dateOut;
	}
	public void setDateOut(String dateOut) {
		this.dateOut = dateOut;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public Flight getNext() {
		return next;
	}
	public void setNext(Flight next) {
		this.next = next;
	}
	public Flight getPrevious() {
		return previous;
	}
	public void setPrevious(Flight previous) {
		this.previous = previous;
	}
	@Override
	public int compareTo(Flight s){
		int resultado = 0;
		if(AirLine.compareTo(s.getAirLine())<0) {
			resultado= -1;
		}else if(AirLine.compareTo(s.getAirLine())>0){
			resultado= 1;
		}else {
			resultado = 0;
		}
		
		return resultado;
	}
	
	
}
