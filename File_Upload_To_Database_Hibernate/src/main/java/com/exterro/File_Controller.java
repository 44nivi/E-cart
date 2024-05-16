package com.exterro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Blob;
import java.util.Iterator;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Session;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


@Path("/reg")
public class File_Controller {
		
		@POST
		@Path("/hit")
		public Response sign(@FormParam("B")String val2) {
			
			System.out.println("Controller!!!");
			System.out.println("hey");
			JSONParser jparse = new JSONParser();
			JSONObject jobjects = new JSONObject();
			String filePath=null;
			try {
			
				file_upload userreg=null;

				Object ob=jparse.parse(val2);
				JSONArray array = new JSONArray();
				array.add(ob);
				for (Object elements : array) {

					JSONObject obj2 = (JSONObject) elements;

					System.out.println("name from obj2" );
					String name = (String) obj2.get("name");
					String email = (String) obj2.get("email");
					String upload = (String) obj2.get("upload");
					System.out.println(upload);
					String pass = (String) obj2.get("password");
					String cpass = (String) obj2.get("confirmpassword");
					
					/*
					 * File file =new File(upload); Reader reader=new FileReader(file); char[]
					 * resume=new char[(int)file.length()]; reader.read(resume);
					 */
					File input=new File(upload);
					FileInputStream fis = new FileInputStream(input);
				    byte [] byteArray = IOUtils.toByteArray(fis);
					Blob blob = new SerialBlob(byteArray);
					
					System.out.println(name);
					Session session = Session_Factory.getSessionFactory().openSession();

					file_upload emp1 = new file_upload(name, email, blob, pass, cpass);
					
					//emp = (Reg_Employee) session2.get(Reg_Employee.class, 1);
					// System.out.println(session2.createSQLQuery("SELECT name,pass FROM
					// Reg_Employee WHERE name=raj"));
					
					String dbname = emp1.getName();
					String dbemail = emp1.getEmail();
					//char[] dbupload = emp1.getresume();
					String dbpass = emp1.getPass();
					String dbcpass = emp1.getCpass();
					System.out.println(dbname);
				//	System.out.println(dbupload);
					session.beginTransaction();
					System.out.println("test:1");	
					session.save(emp1);
					session.getTransaction().commit();		
					
					session.close();

				}
			   
			//	return Response.status(200).entity(jobjects.toString()).build();

			}
			catch(Exception e){

			}

			return Response.status(200).entity(jobjects.toString()).build();

			
		}


}

