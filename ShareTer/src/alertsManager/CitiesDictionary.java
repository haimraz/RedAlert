package alertsManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;


public class CitiesDictionary {

	private static HashMap<String, List<City>> citiesById = loadCitiyesById();

	public static List<City> getCitiesById(String id) {
		if (citiesById.containsKey(id)) {
			return citiesById.get(id);
		} else {
			return null;
		}
	}

	public static JsonNode getAllCitiesByIds() {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.convertValue(citiesById, JsonNode.class);
		return node;
	}
	
	public static Set<String> getAllSpaces() {
		
		return citiesById.keySet();
	}

	@SuppressWarnings("unchecked")
	private static HashMap<String, List<City>> loadCitiyesById() {

		try
		{
			

		citiesById = new HashMap<String, List<City>>();

		// JSONParser parser = new JSONParser();
		// JSONArray citiesArray = (JSONArray) parser.parse(new FileReader(
		// "resources\\cities.json"));

		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		JsonNode citiesArray = mapper.readTree(new File(
				"resources\\cities.json"));

		if (citiesArray.isArray()) {
			for (final JsonNode currCity : citiesArray) {

				String currCityId = currCity.get("id").asText();
				String currCityCity = currCity.get("city").asText();

				if (citiesById.containsKey(currCityId)) {
					citiesById.get(currCityId).add(
							new City(currCityCity, currCityId));
				} else {
					ArrayList<City> citiesList = new ArrayList<City>();
					citiesList.add(new City(currCityCity, currCityId));
					citiesById.put(currCityId, citiesList);
				}
			}
		}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		
		return citiesById;
	}

	public static List<String> getRandomCitiesID() {

		List<String> citiesIds = new ArrayList<String>();
		Random rand = new Random();

		int size = rand.nextInt(10) + 1;

		for (int i = 0; i < size; i++) {

			int n = rand.nextInt(citiesById.keySet().size()) + 1;
			citiesIds.add((String) citiesById.keySet().toArray()[n - 1]);
		}

		return citiesIds;
	}
}
