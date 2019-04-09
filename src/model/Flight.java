package model;

import java.util.Date;
import java.util.GregorianCalendar;

public class Flight {
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

	private int hourOut;
	private int minuteOut;
	private int gate;
	
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
	public void timeToString() {
		/*
		Date x = new Date();
		String schedule = "";
		String[] actualDate = x.toString().split(" ");
		String[] amOrPmString = actualDate[3].split(":");
		int militarHour = Integer.parseInt(amOrPmString[4]);
		if(militarHour >= 12 ) {
			schedule = "PM";
		}else if(militarHour < 12) {
			schedule = "AM";
		}
	
		
		if(hourOut >= 12) {
			
		}
		+""+schedule
		*/
		time = ""+hourOut+":"+minuteOut;
	}
	public String dateOutToString(){
		return (""+date.getMonth()+"/"+date.getDate()+"/"+date.getYear());
	}
	public String toString() {
		String msj = "";
		msj += "date"+date.getMonth()+"/"+date.getDay()+"/"+date.getYear()+" airLine"+AirLine+" code"+code+"city"+city+" time"+time+" gate"+gate;
		return msj;
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
	
}
