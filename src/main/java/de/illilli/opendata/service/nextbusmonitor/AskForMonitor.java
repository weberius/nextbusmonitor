package de.illilli.opendata.service.nextbusmonitor;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.Config;

public class AskForMonitor implements AskFor<String> {

	private String url = Config.getProperty("kvb.monitor.url");
	private InputStream inputStream;
	private String json;

	public AskForMonitor(int id) throws MalformedURLException, IOException {
		inputStream = new URL(url + id).openStream();
		json = IOUtils.toString(inputStream);
		json = json.substring(json.indexOf("<table"), json.length());
	}

	public String getData() {
		return json;
	}

}
