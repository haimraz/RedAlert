package alertsManager;

import java.util.List;
import java.util.logging.Logger;

import org.codehaus.jackson.node.ArrayNode;

import services.GCM;

public class AlertsChecker implements Runnable {

	public static final String ALERTS_JSON_URI = "http://www.oref.org.il/WarningMessages/alerts.json?v=1";

	// Run method implementation, the checking for alerts should be 1 second at
	// most , becasue the data is generated
	// only every 2 secs.
	@Override
	public void run() {

		// Make an HTTP request to the alerts uri and get parse it to a json
		org.codehaus.jackson.JsonNode jsnAlert = JsonParser.httpGetRequestToJson(ALERTS_JSON_URI);

		// Check if the jsn alert has any data and if it's valid
		if (jsnAlert.has("data") && (jsnAlert.get("data") instanceof ArrayNode)) {
			ArrayNode jsonData = (ArrayNode) jsnAlert.get("data");
			if (jsonData.size() > 0) {
				List<City> citiesToAlert = JsonParser
						.createCitiesListOutOfData(jsonData);

				// Send notification to registered users
				GCM.SendAlertNotification(citiesToAlert, jsnAlert.get("title")
						.asText());
				Logger.getGlobal().info("found alert...sending notifications");
			}
		}

	}
}
