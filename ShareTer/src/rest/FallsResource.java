package rest;

import java.io.IOException;
import java.util.UUID;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import services.MongoCon;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

/**
 * Created by orkazaz on 1/28/15.
 */
@Path("/falls")
public class FallsResource {
	
	ObjectMapper mapper = new ObjectMapper();
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFalls() {
    	String shelters = MongoCon.getFallsCol().find().toArray().toString();
    	try {
			return Response.ok(mapper.readTree(shelters)).build();
		} catch (IOException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewFall(JsonNode o) {
    	BasicDBObject fall = (BasicDBObject) JSON.parse(o.toString());
    	fall.put("_id", UUID.randomUUID());
    	MongoCon.getFallsCol().insert(fall);
		return Response.ok().build();
    }
}