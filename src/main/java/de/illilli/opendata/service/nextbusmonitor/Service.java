package de.illilli.opendata.service.nextbusmonitor;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import de.illilli.opendata.service.Config;
import de.illilli.opendata.service.Facade;

@Path("/")
public class Service {

	private final static Logger logger = Logger.getLogger(Service.class);
	public static final String ENCODING = Config.getProperty("encoding");

	@Context
	private HttpServletRequest request;
	@Context
	private HttpServletResponse response;

	/**
	 * <p>
	 * Beispiel:
	 * </p>
	 * <ul>
	 * <li><a href="http://localhost:8080/nextbusmonitor/service/monitor/1">
	 * /nextbusmonitor/service/monitor/{id} </a></li>
	 * </ul>
	 * 
	 * @param id
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/monitor/{id}")
	public String getStops(@PathParam("id") int id) throws MalformedURLException, IOException {
		logger.info("call /monitor/" + id);
		Facade facade = new MonitorFacade(id);
		return facade.getJson();
	}

}
