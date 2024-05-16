package com.exterro;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.json.simple.parser.ParseException;


@Path("/call")
public class Controls {
	    
	    @POST
	    @Path("/hit")
	    public Response HitMe(@FormParam("B")String data) throws  ParseException {
	        System.out.println("Inside !!!!");
	        System.out.println();
	        
	        System.out.println("Invalid user!!!");
	        
	    return Response.status(200).entity("Done").build();
	        
	    }
	}


