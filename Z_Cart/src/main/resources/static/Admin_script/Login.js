var user;
var newData;


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



function submitsData() {

	console.log("welcome")


	var infos = {
		name: $("#uname").val(),
		password: $("#passwd").val(),


	}

	$.ajax({

		type: "POST",
		datatype: 'json',
		data: JSON.stringify(infos),
		contentType: 'application/json; charset=utf-8',
		url: "/login",
		success: function namm(data) {
			console.log("this is msg" + data);
			let myJSON = JSON.stringify(data);

			console.log(data)
			if (data === false) {
				var messageElement = document.getElementById('forme');
				messageElement.innerText = 'Invalid credentials. Please try again.';
			} else {
				 newData = encodeURIComponent(data); 
				var newPageURL = "Admin_Page.html?value=" + newData; 
				window.location.href = newPageURL;
				

			}
		}
	});

}

function backhome(){
	console.log("hi am inside backhome"+newData);
	var newPageURL = "home.html?value=" + newData; 
	window.location.href = newPageURL;
	
}

document.addEventListener("DOMContentLoaded", function() {
	const urlParams = new URLSearchParams(window.location.search);
	var rdata = urlParams.get('value');
	console.log('Extracted value from URL:', rdata);
	if (rdata==cookieValue){
	creating_User(cookieValue);
	}
	
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



//***************************************************admin Page Add on************************************************************* */

function submit_product() {

	console.log("welcome")


	var radioButtons = document.getElementsByName('Subject');
	var adder = {
		product_name: $("#product_name").val(),
		quantity: $("#Quantity").val(),
		price: $("#price").val(),
		path: $("#image_path").val()
	}
	for (var i = 0; i < radioButtons.length; i++) {
		if (radioButtons[i].checked) {
			// Add the selected radio button value to the 'info' object
			adder.gender = radioButtons[i].value;
			break; // Exit the loop once a checked radio button is found
		}
	}
	console.log(adder);
	$.ajax({

		type: "POST",
		datatype: 'json',
		data: JSON.stringify(adder),
		contentType: 'application/json; charset=utf-8',
		url: "/added",
		success: function addon(addondata) {
			console.log("this is msg" + addondata);

			var messageElement = document.getElementById('message');

			if (addondata === true) {
				// Redirect to a new HTML page

				messageElement.innerText = 'successfully uploaded';
			} else {
				messageElement.innerText = 'Invalid '

			}



		}
	});



}

