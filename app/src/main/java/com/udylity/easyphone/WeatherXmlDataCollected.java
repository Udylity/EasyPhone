package com.udylity.easyphone;



public class WeatherXmlDataCollected {
	int temp = -1234;
	String city = null;
	String humid = null;
	String condi = null;
	String windcondi = null;
	
	public void setCity(String stringcity) {
		city = stringcity;
	}
	
	public void setTemp(int inttemp){
		temp = inttemp;
	}
	
	public void setHumidity (String humidity){
		humid = humidity;
	}
	
	public void setCondition (String condition){
		condi = condition;
	}
	
	public void setWindCondition (String windcondition){
		windcondi = windcondition;
	
	}
	
	public String dataToString(){
		return "Your Current Tempeture is " + temp +" degrees fahrenheit"
				+ "\n" + "your " + humid
				+ "\n" + "your weather condition is " + condi
				+ "\n" + windcondi;
	}
	
}
