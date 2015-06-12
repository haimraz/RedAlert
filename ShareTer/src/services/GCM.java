package services;

import java.util.List;
import java.util.logging.Logger;

import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.ObjectNode;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import alertsManager.City;


public class GCM {
	private static String GCM_URL = "https://android.googleapis.com/gcm/send";
	private static String API_KEY = "AIzaSyB6KDOPgjpxk__9ASRnLW2brYJ0T03hrSE";
	private static String PROJECT_ID = "548355374500";

	public static void SendAlertNotification(List<City> cities, String title) {
		Logger.getGlobal().info("Sending notification..");
		ObjectNode jsnMessage = new ObjectNode(JsonNodeFactory.instance);
		jsnMessage.put("registration_ids", UsersResource.getAllRegIds());

		ObjectNode jsnData = new ObjectNode(JsonNodeFactory.instance);
		ArrayNode citiesArray = new ArrayNode(JsonNodeFactory.instance);

		for (City currCity : cities) {
			citiesArray.add(currCity.getCity());
		}

		jsnData.put("cities", citiesArray);
		jsnData.put("title", title);
		jsnMessage.put("data", jsnData);

		Client c = new Client();
		WebResource webResource = c.resource(GCM_URL);
		
		
		ClientResponse response = webResource.accept("application/json")
							.header("Authorization", "key=" + API_KEY)
							.post(ClientResponse.class);
		 
		if (response.getStatus() == 200) {
			Logger.getGlobal().info("notifications sent: " + response.getEntity(String.class));
		} else {
			Logger.getGlobal().severe("notifications send error: " + response.getEntity(String.class));
		}

	}
}
