package DAL;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoCon {

	private static MongoClient c;
	
	public static MongoClient getClient() {
		if (c == null) {
			synchronized (MongoCon.class) {
				if (c == null) {
					c = new MongoClient(new MongoClientURI("mongodb://redalert:Aa123456@ds063779.mongolab.com:63779/redalert"));
				}
			}
		}
		
		return c;
	}
	
}
