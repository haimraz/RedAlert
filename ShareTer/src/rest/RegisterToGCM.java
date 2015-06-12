package rest;

import java.util.UUID;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonNode;

import services.MongoCon;

import com.mongodb.BasicDBObject;
import com.mongodb.util.JSON;

@Path("/GCM")
public class RegisterToGCM {
	
	 	@POST
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response RegisterNewUser(JsonNode o) 
	 	{
	    	BasicDBObject registrationId = (BasicDBObject) JSON.parse(o.toString());
	    	MongoCon.getRegistrationIdCol().insert(registrationId);
			return Response.ok().build();
	    }
	    

}
