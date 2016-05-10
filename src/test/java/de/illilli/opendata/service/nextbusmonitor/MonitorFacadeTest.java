package de.illilli.opendata.service.nextbusmonitor;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Before;

import de.illilli.opendata.service.Facade;

public class MonitorFacadeTest {

	@Before
	public void setUp() throws Exception {
	}

	public static void main(String[] args) throws MalformedURLException, IOException {
		Facade facade = new MonitorFacade(1);
		System.out.println(facade.getJson());
	}

}
