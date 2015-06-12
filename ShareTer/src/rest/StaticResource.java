package rest;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.UUID;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import services.MongoCon;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

/**
 * Created by orkazaz on 1/28/15.
 */
@Path("/static/{seg: .*}")
public class StaticResource {
	
	ObjectMapper mapper = new ObjectMapper();
	
    @GET
    public Response getFile(@Context UriInfo uriInfo) {
    	String path = uriInfo.getAbsolutePath().getPath();
    	path = path.substring(1);
    	path = path.substring(path.indexOf("/"));
    	try {
    		return Response.ok(new File("public" + path)).build();
    	} catch (Exception e) {
    		return Response.status(404).build();
    	}
    	
    }
}