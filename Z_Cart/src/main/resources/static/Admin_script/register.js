
  var cookies = document.cookie.split(';'); // Split the cookies into an array
  
  for (var i = 0; i < cookies.length; i++) {
    var cookie = cookies[i].trim(); // Trim any extra spaces
    
    // Split the cookie into name and value
    var delimiterIndex = cookie.indexOf('=');
    var cookieName = cookie.substring(0, delimiterIndex);
    var cookieValue = cookie.substring(delimiterIndex + 1);
    
    console.log("Cookie Name:", cookieName);
    console.log("Cookie Value:", cookieValue);
    
	}   


document.addEventListener("DOMContentLoaded", function() {
	
	creating_User(cookieValue);
	
	
});

function creating_User(data) {
	console.log(data)
	var newPageDiv = document.getElementById('subnew');
	var dive = document.createElement('div');
	dive.id = "myDiv" // Set the id attribute 
	dive.className = "newdiv"
	dive.innerHTML = `<p>Hello ${data} </p>	`
	newPageDiv.parentNode.appendChild(dive, newPageDiv);

}

function imageLoaded(){
document.cookie = cookieName + "=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
$.ajax({
		type: "GET",
		url: "/logout",

		success: function fetchcard(data) {
			console.log(data);
			if(data==true){
				var newPageURL = "Home.html";
				window.location.href = newPageURL;
			}
		}
	})	
	
}


function submitsData2() {

	console.log("welcome")

	var info = {
		name: $("#Fname").val(),
		lname: $("#Lname").val(),
		password: $("#Pass").val(),
		Rpass: $("#Rpass").val(),
		email: $("#email").val()


	}

	$.ajax({

		type: "POST",
		datatype: 'json',
		data: JSON.stringify(info),
		contentType: 'application/json; charset=utf-8',
		url: "/regi",
		success: function Regist(Newdata) {
			console.log("this is msg" + Newdata);
			let myJSON = JSON.stringify(Newdata);
			console.log(myJSON);
			const ob = JSON.parse(myJSON);
			console.log(ob.type);
			var user = ob.name;
			var newPageURL = "Home.html";
			window.location.replace(newPageURL);
			console.log(user);



		}
	});



}

