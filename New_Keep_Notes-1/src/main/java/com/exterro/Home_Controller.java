package com.exterro;

import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Home_Controller {

	@Autowired
    Repo repo;
	
	
	@GetMapping("go")
	public ModelAndView showData() {
		System.out.println("hi");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.html");

		return mv;
	}

	@PostMapping("regi")
	public ResponseEntity<List<Keep>> storeData(@RequestBody String A) throws JSONException {

		
		JSONArray obj = new JSONArray(A);
		String arr[] = new String[obj.length()];
		int i = 0;
		for (i = 0; i < obj.length(); i++) {
			arr[i] = obj.getString(i);
		}
		Keep keeper = new Keep(arr);
		try{
			List<Keep> node=repo.findAll();
		
    	if(node.size()==0) {
    		keeper.setId(1);
    	}
    	else {
    		Keep obj1=node.get(node.size()-1);
    		keeper.setId(obj1.getId()+1);
    	}
    	 Keep ee = repo.save(keeper);
    	 System.out.println(ee);
    	 List<Keep> Notes=null;
    	 Notes=repo.findAll();
    	 
    	 return new ResponseEntity<List<Keep>>(Notes, HttpStatus.CREATED);
    }
   catch(Exception e){
    	System.out.println(e.getMessage());
    	return null;
    }
	}
	
}
