package com.exterro;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin("http://localhost:4200/")
public class Cart_Controller {

	@Autowired
	Service_Admin service;

	@GetMapping("go")
	public ModelAndView showData() {
		System.out.println("hi");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.html");

		return mv;
	}

	// **********************************************************home page
	// load*************************************************************

	@GetMapping("getset")
	public ResponseEntity<List<Admin_add_on>> getBooks(HttpSession session, HttpServletRequest request) {

		List<Admin_add_on> Notes = null;
		Notes = service.findAll();
		return new ResponseEntity<List<Admin_add_on>>(Notes, HttpStatus.CREATED);
	}

	// *************************************************************logout************************************************************
	@GetMapping("/logout")
	public ResponseEntity<Boolean> logout(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// Invalidate the session
		session.invalidate();
		HttpSession session1 = request.getSession(false); // Get the existing session if it exists

		if (session1 != null) {
			// Invalidate the session
			session1.invalidate();

			// Clear the cookie by setting its maxAge to 0
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if ("myCookieName".equals(cookie.getName())) {
						cookie.setMaxAge(0);
						response.addCookie(cookie);
						break;
					}
				}
			}
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

	// ***********************************************************************login**********************************************************

	@PostMapping("login")
	public ResponseEntity<Boolean> LoginData(@RequestBody String B, HttpSession session, HttpServletResponse response) {

		JSONParser jparse = new JSONParser();
		try {
			JSONObject jobject = new JSONObject();
			System.out.println(B);
			Object ob;
			ob = jparse.parse(B);
			jobject = (JSONObject) ob;
			String name = (String) jobject.get("name");
			System.out.println(name);
			String password = (String) jobject.get("password");

			boolean isValidCredentials = service.checkCredentials(name, password);
			if (isValidCredentials) {
				System.out.println(isValidCredentials);
				session.setAttribute("loggedInUser", name);
				String loggedInUser = (String) session.getAttribute("loggedInUser");
				Cookie cookie = new Cookie("myCookieName", loggedInUser);

				cookie.setMaxAge(3600);
				cookie.setPath("/");
				response.addCookie(cookie);

				return new ResponseEntity<Boolean>(true, HttpStatus.OK);
			}

			else {
				// You can return an appropriate error message if credentials are not valid
				return new ResponseEntity<Boolean>(false, HttpStatus.OK);
			}
		}

		catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

//**************************************************************Registration********************************************************
	@PostMapping("regi")
	public ResponseEntity<Object> storeData(@RequestBody String B, HttpSession session) {
		JSONObject jsonObject = new JSONObject();
		JSONParser jparse = new JSONParser();
		try {
			String loggedInUser = (String) session.getAttribute("loggedInUser");
			if (loggedInUser != null) {
				JSONObject jobject = new JSONObject();
				System.out.println(B);
				Object ob;
				ob = jparse.parse(B);
				jobject = (JSONObject) ob;
				String name = (String) jobject.get("name");
				System.out.println(name);
				String lname = (String) jobject.get("lname");
				String password = (String) jobject.get("password");
				String Rpass = (String) jobject.get("Rpass");
				String email = (String) jobject.get("email");
				Admin_Regi add = new Admin_Regi(name, lname, password, Rpass, email);
				service.saver(add);
				System.out.println("successful in back controller");
				return new ResponseEntity<Object>(jobject, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(null, HttpStatus.OK);
			}
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

//********************************************************************add ON Items*********************************************************
	@PostMapping("added")
	public ResponseEntity<Boolean> addon(@RequestBody String B, HttpSession session) {

		JSONParser jparse = new JSONParser();
		try {

			String loggedInUser = (String) session.getAttribute("loggedInUser");
			if (loggedInUser != null) {
				JSONObject jobject = new JSONObject();
				System.out.println(B);
				Object ob;
				ob = jparse.parse(B);
				jobject = (JSONObject) ob;
				String name = (String) jobject.get("product_name");
				System.out.println(name);
				String quantity = (String) jobject.get("quantity");
				String price = (String) jobject.get("price");
				String path = (String) jobject.get("path");

				String gender = (String) jobject.get("gender");

				Admin_add_on ad = new Admin_add_on(name, quantity, price, path, gender);
				service.adding(ad);

				System.out.println("successful in back controller");
				return new ResponseEntity<Boolean>(true, HttpStatus.OK);
			} else {
				return new ResponseEntity<Boolean>(false, HttpStatus.OK);
			}
		}

		catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

//************************************************************fetch****************************************************************************
	@PostMapping("fetch")
	public ResponseEntity<List<Admin_add_on>> fetch(@RequestBody String value, HttpSession session) {

		JSONParser jparse = new JSONParser();
		try {
			JSONObject jobject = new JSONObject();
			System.out.println(value);
			Object ob;
			ob = jparse.parse(value);
			jobject = (JSONObject) ob;
			String gender = (String) jobject.get("gender");
			System.out.println(gender);
			List<Admin_add_on> lst = null;
			lst = service.findByGender(gender);

			System.out.println(lst);
			session.invalidate();

			return new ResponseEntity<List<Admin_add_on>>(lst, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

//**************************************************Search Box*************************************************************************
	@PostMapping("search")
	public ResponseEntity<List<Admin_add_on>> Searches(@RequestBody String searchText, HttpSession session) {
		JSONParser jparse = new JSONParser();
		try {
			JSONObject jobject = new JSONObject();
			System.out.println(searchText);
			Object ob;
			ob = jparse.parse(searchText);
			jobject = (JSONObject) ob;
			String find = (String) jobject.get("find");
			List<Admin_add_on> lsst = null;
			lsst = service.findByColumnNameContaining(find);

			session.invalidate();
			return new ResponseEntity<List<Admin_add_on>>(lsst, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

//****************************************************cart loader post************************************************************************
//    TEMP CART LOADER CAN BE USED LATER
//	
//	@PostMapping("addcart")
//	public ResponseEntity<Boolean> add_cart(@RequestBody String addcart,HttpSession session) {
//		JSONParser jparse = new JSONParser();
//
//		try {
//
//			
//			JSONObject jobject = new JSONObject();
//			JSONObject jobject2 = new JSONObject();
//
//			System.out.println(addcart);
//			Object ob;
//			ob = jparse.parse(addcart);
//			jobject = (JSONObject) ob;
//			Object adder =jobject.get("add");
//			System.out.println(adder);
//			jobject2=(JSONObject)adder;
//			String name = (String) jobject2.get("name");
//			System.out.println(name);
//			String quantity = (String) jobject2.get("quantity");
//			String price = (String) jobject2.get("price");
//			String path = (String) jobject2.get("path");
//
//			String gender = (String) jobject2.get("gender");
//			
//			Cart_Adder ad = new Cart_Adder(name, quantity, price, path, gender);			
//			Cart_Adder lsst = null;
//			lsst = service.saver_cart(ad);
//			
//			
//			session.invalidate();
//			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
//        
//		} catch (Exception e) {
//			System.out.println(e);
//			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}
//	

//***************************************************CART LOADER GET********************************************************************

	@GetMapping("load_cart")
	public ResponseEntity<List<Cart_quantity>> getcart(HttpSession session, HttpServletRequest request) {
		System.out.println("hi am in ");

		List<Cart_quantity> Note = null;
		Note = service.findingAll();
		System.out.println(Note);
		return new ResponseEntity<List<Cart_quantity>>(Note, HttpStatus.CREATED);
	}

//****************************************************cart quantity********************************************************************

	@PostMapping("quantity")
	public ResponseEntity<Cart_quantity> add_quantity(@RequestBody String addquantity, HttpSession session) {
//	JSONParser jparse = new JSONParser();
//	try {
//		JSONObject jobject = new JSONObject();
//		JSONObject jobject2 = new JSONObject();
//		System.out.println("i am in quantity");
//		System.out.println(addquantity);
//		Object ob;
//		ob = jparse.parse(addquantity);
//		jobject = (JSONObject) ob;
//		Object adder =jobject.get("add");
//		System.out.println(adder);
//		jobject2=(JSONObject)adder;
//		String product_id=(String)jobject2.get("product_id");
//	String name = (String) jobject2.get("name");
//	System.out.println(name);
//	String quantity = (String) jobject2.get("quantity");
//	String price = (String) jobject2.get("price");
//	
//	String gender=(String)jobject2.get("gender");
//	
//	String path=(String)jobject2.get("path");

		ObjectMapper objectMapper = new ObjectMapper();

		try {

			String path;
			String name;
			String gender;
			String product_id;
			String quantity;
			String price;
			int prod_order;
			// Parse the JSON string
			JsonNode jsonNode = objectMapper.readTree(addquantity);

			// Access the "add" array and get the "path" value from the first element
			JsonNode addArray = jsonNode.get("add");

			JsonNode firstItem = addArray.get(0);
			path = firstItem.get("path").asText();
			name = firstItem.get("name").asText();
			gender = firstItem.get("gender").asText();
			product_id = firstItem.get("product_id").asText();
			quantity = firstItem.get("quantity").asText();
			price = firstItem.get("price").asText();
			prod_order = firstItem.get("order").asInt();
			System.out.println("Path value: " + path);

			Cart_quantity qty = new Cart_quantity(name, gender, path, product_id, quantity, price, prod_order, 0);
			Cart_quantity lsst = null;
			lsst = service.saver_qty_cart(qty);
			return new ResponseEntity<Cart_quantity>(lsst, HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

//*************************************************************fetch count ********************************************************

	@PostMapping("counter")
	public ResponseEntity<Integer> counting_qty(@RequestBody String count, HttpSession session) {

		JSONParser jparse = new JSONParser();
		try {
			JSONObject jobject = new JSONObject();
			System.out.println(count);
			Object ob;
			ob = jparse.parse(count);
			jobject = (JSONObject) ob;
			String productid = (String) jobject.get("product_id");
			System.out.println(productid);
			Integer lst = null;
			lst = service.find_qty(productid);

			System.out.println(lst);
			return new ResponseEntity<Integer>(lst, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
