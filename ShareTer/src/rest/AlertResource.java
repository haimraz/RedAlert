package rest;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonNode;

import services.GCM;

import alertsManager.CitiesDictionary;
import alertsManager.City;

@Path("/alerts")
public class AlertResource {

	@POST
	public Response sendAlert(JsonNode o) {
		List<City> cities = 
				CitiesDictionary.getCitiesById(o.get("space").asText());
		
		String msg = o.get("title").asText();
		
		GCM.SendAlertNotification(cities, msg);
		
		return Response.ok().build();
	}
}
