package de.illilli.opendata.service.nextbusmonitor;

import java.io.IOException;
import java.net.MalformedURLException;

import com.fasterxml.jackson.core.JsonProcessingException;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.Facade;

public class MonitorFacade implements Facade {

	String json = "";

	public MonitorFacade(int id) throws MalformedURLException, IOException {
		AskFor<String> askFor = new AskForMonitor(id);
		json = askFor.getData();
	}

	public String getJson() throws JsonProcessingException {
		return json;
	}

}
