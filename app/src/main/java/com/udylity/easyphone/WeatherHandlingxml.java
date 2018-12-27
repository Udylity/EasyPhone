package com.udylity.easyphone;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WeatherHandlingxml extends DefaultHandler{

	WeatherXmlDataCollected info = new WeatherXmlDataCollected();
	
	public String getInformation(){
		return info.dataToString();
	}
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		
		if (localName.equals("city")){
			String stringcity = attributes.getValue("data");
			info.setCity(stringcity);
		}else if(localName.equals("temp_f")){
			String stringt = attributes.getValue("data");
			int inttemp = Integer.parseInt(stringt);
			info.setTemp(inttemp);
		}else if (localName.equals("humidity")){
			String humidity = attributes.getValue("data");
			info.setHumidity(humidity);
		}else if (localName.equals("wind_condition")){
			String windcondition = attributes.getValue("data");
			info.setWindCondition(windcondition);
		}else if (localName.equals("condition")){
			String condition = attributes.getValue("data");
			info.setCondition(condition);
		}
	}
}