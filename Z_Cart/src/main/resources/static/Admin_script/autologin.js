
document.addEventListener("DOMContentLoaded", function() {
	
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
	creating_User(cookieValue);
	alert("welcome to auto-login");
	var usernameValue = cookieValue;
	document.getElementById('uname').value = usernameValue;
	document.querySelector('button').click();


	
});


	
	function creating_User(cookieValue) {
		console.log(cookieValue)
		var newPageDiv = document.getElementById('subnew');
		var dive = document.createElement('div');
		dive.id = "myDiv" // Set the id attribute 
		dive.className = "newdiv"
		dive.innerHTML = `<p>Hello ${cookieValue} </p>	`
		newPageDiv.parentNode.appendChild(dive, newPageDiv);

	}

	function triggerLink() {
    // Simulate the click on the link
    document.getElementById('myLink').click();
}