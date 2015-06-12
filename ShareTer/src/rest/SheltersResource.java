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
@Path("/shelters")
public class SheltersResource {
	
	ObjectMapper mapper = new ObjectMapper();
	
    @GET
    @Path("/{shelter_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShelterById(@PathParam("shelter_id") String shelterId) {
        DBObject shelter = MongoCon.getSheltersCol().findOne(shelterId);
    	try {
			return Response.ok(mapper.readTree(shelter.toString())).build();
		} catch (IOException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShelters() {
    	String shelters = MongoCon.getSheltersCol().find().toArray().toString();
    	try {
			return Response.ok(mapper.readTree(shelters)).build();
		} catch (IOException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewShelter(JsonNode o) {
    	BasicDBObject shelter = (BasicDBObject) JSON.parse(o.toString());
    	shelter.put("_id", UUID.randomUUID());
    	MongoCon.getSheltersCol().insert(shelter);
		return Response.ok().build();
    }
    
    @DELETE
    @Path("/{shelter_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeShelterById(@PathParam("shelter_id") String shelterId) {
        MongoCon.getSheltersCol().remove(new BasicDBObject("_id",shelterId));
		return Response.ok().build();
    }
}