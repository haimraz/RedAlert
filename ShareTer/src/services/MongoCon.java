package services;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;


public class MongoCon {

	private static MongoClient c;
	
	public static MongoClient getClient() {
		if (c == null) {
			synchronized (MongoCon.class) {
				if (c == null) {
					try {
						c = new MongoClient(new MongoClientURI("mongodb://redalert:Aa123456@ds063779.mongolab.com:63779/redalert"));
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		return c;
	}
	
	public static DBCollection getSheltersCol() {
		return getClient().getDB("redalert").getCollection("shelters");
	}
	
	public static DBCollection getFallsCol() {
		return getClient().getDB("redalert").getCollection("falls");
	}
	
	public static DBObject findNearestShelter(double x, double y) {
		BasicDBObject geonear = new BasicDBObject();
		geonear.put("near"	,new Double[]{x,y});
		geonear.put("maxDistance", 2);
		geonear.put("num", 1);
		geonear.put("includeLocs", "location");
		
		ArrayList<DBObject> agg = new ArrayList<>();
		
		agg.add(new BasicDBObject("$geoNear", geonear));
		
		Iterator<DBObject> i = getSheltersCol().aggregate(agg).results().iterator();
		if (i.hasNext()) {
			return i.next();
		} else {
			return null;
		}
	}
}
