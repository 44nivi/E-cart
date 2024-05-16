package com.exterro;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@Path("/go")
public class Rest_Control {
	@Path("/register")
	@POST
	public Response showdata(@FormParam("A") String data) {
		System.out.println("hi");
		try {
			
			System.out.println("inside try");
		/*
		 * JSONObject jobj = new JSONObject(); String stat = null; 
		 * System.out.println("in controller!!!"); JSONParser js = new JSONParser();
		 * Object oo = js.parse(data);
		 * 
		 * JSONArray ja = new JSONArray(); ja.add(oo);
		 * 
		 * for (int i = 0; i < ja.size(); i++) {
		 * 
		 * JSONObject jo = (JSONObject) ja.get(i); String s1 = (String)
		 * jo.get("username"); String s2 = (String) jo.get("password");
		 * 
		 */

			} 
			
		 catch (Exception e) {
				e.getMessage();
			}
			/*
			 * stat = "success"; jobj.put("status", "success");
			 * 
			 */
		
		return Response.status(200).entity("user or password").build();

}}
