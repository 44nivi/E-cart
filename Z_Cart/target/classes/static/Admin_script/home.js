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
	
	
    //document.cookie = cookieName + "=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
	fetchCards();
	document.getElementById('myButton').addEventListener('click', function() {


		var searchText = { find: document.getElementById('myTextBox').value };
		const cardContainer = document.getElementById('product-container');
		while (cardContainer.firstChild) cardContainer.firstChild.remove();

		console.log(searchText);
		$.ajax({

			type: "POST",
			datatype: 'json',
			data: JSON.stringify(searchText),
			contentType: 'application/json; charset=utf-8',
			url: "/search",
			success: function searchon(searched_Data) {

				createCards(searched_Data);


			}
		});
	});



});





function fetchCards() {

	$.ajax({
		type: "GET",
		url: "/getset",

		success: function fetchcard(data = []) {
			console.log(data);
			createCards(data)

		}
	})
}

function createCards(cardData) {
	const cardContainer = document.getElementById('product-container');

	cardData.forEach(card => {
		const cardElement = document.createElement('div');
		cardElement.className = "product-card"
		cardElement.classList.add('card');
		console.log(card.path);
		cardElement.innerHTML = `
          	<div class="product-image">
            <span class="discount-tag">50% off</span>
            <img src="${card.path}"class="product-thumb" alt="">
            <button class="card-btn">add to whislist</button>
        	</div>            
            <div class="product-info">
            <h2 class="product-brand">${card.name}</h2>
            <p class="product-short-des">Pride </p>
            <span class="price">${card.price}</span><span class="actual-price">$80</span>
        	</div>
       		 `;

		cardContainer.appendChild(cardElement);
	});
}

document.addEventListener("DOMContentLoaded", function() {
	
	const urlParams = new URLSearchParams(window.location.search);
	var rdata = urlParams.get('value');
	console.log('Extracted value from URL:', rdata);
	
	creating_User(cookieValue);
	
	function creating_User(cookieValue) {
		console.log(cookieValue)
		var newPageDiv = document.getElementById('subnew');
		var dive = document.createElement('div');
		dive.id = "myDiv" // Set the id attribute 
		dive.className = "newdiv"
		dive.innerHTML = `<p>Hello ${cookieValue} </p>	`
		newPageDiv.parentNode.appendChild(dive, newPageDiv);

	}

});
