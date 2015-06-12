package alertsManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JsonParser {

	public static JsonNode httpGetRequestToJson(String url) {

		Client client = new Client();
		
		WebResource webResource = client
				   .resource(url);
		 
		ClientResponse response = webResource.accept("application/json")
		                   .get(ClientResponse.class);
		 
		if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
		}
		 
		String output = response.getEntity(String.class);

		try {
			return new ObjectMapper().readTree(output);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static JsonNode getAlertExample() {
		String json = "{ \"id\" : \"1405053379253\",\"title\" : \"׳₪׳™׳§׳•׳“ ׳”׳¢׳•׳¨׳£ ׳”׳×׳¨׳¢׳” ׳‘׳�׳¨׳—׳‘ \",\"data\" : [\"test\"]}";
		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		try {
			JsonNode example = mapper.readTree(json);
			ArrayNode exampleData = (ArrayNode) example.get("data");

			List<String> randomCities = CitiesDictionary.getRandomCitiesID();
			for (String string : randomCities) {
				exampleData.add(string);
			}

			return example;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static List<City> createCitiesListOutOfData(ArrayNode arrayOfCityIds) {

		List<City> citiesArray = new ArrayList<City>();

		for (final JsonNode currCity : arrayOfCityIds) {

			ObjectMapper mapper = new ObjectMapper();
			Object obj;
			String stringValue;
			try {
				obj = mapper.treeToValue(currCity, Object.class);
				stringValue = mapper.writeValueAsString(obj);
				if (stringValue.startsWith("\"") && stringValue.endsWith("\"")) {
					stringValue = stringValue.substring(1,
							stringValue.length() - 1);
				}

				String currCityId = stringValue;
				List<City> citiesToAlert = CitiesDictionary
						.getCitiesById(currCityId);

				if (citiesToAlert == null) {
					System.out.println("city ID " + currCityId
							+ " dosen't exist");
				} else {
				for (City city : citiesToAlert) {
						citiesArray.add(city);
					}
				}
			} catch (IOException e) {
				Logger.getGlobal().info("createCitiesListOutOfData:there was a problem with the given arraynode of cities");
				e.printStackTrace();
			}
		}

		return citiesArray;
	}

}
