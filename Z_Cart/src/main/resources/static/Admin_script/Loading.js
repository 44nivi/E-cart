
document.addEventListener("DOMContentLoaded", function() {

	const homeButton = document.getElementById('homeButton');

	homeButton.addEventListener('click', () => {
		// Define the action when the Home button is clicked
		window.location.href = 'Home.html'; // Replace with your desired URL
	});


	const loginpage = document.getElementById('LoginPage');

	loginpage.addEventListener('click', () => {
		// Define the action when the Home button is clicked
		window.location.href = 'LoginPage.html'; // Replace with your desired URL
	});
	
	
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


/*	const container = document.getElementById('myList');
	container.addEventListener('click', () => {
		const firstLinkClickedEvent = new Event('firstLinkClicked');
		document.dispatchEvent(firstLinkClickedEvent);

	});  */

	document.querySelectorAll('a').forEach(link => {

		link.addEventListener('click', function(event) {
			event.preventDefault();
			const cardContainer = document.getElementById('product-container');
			while (cardContainer.firstChild) cardContainer.firstChild.remove();

			const value = { gender: this.getAttribute('data-value') }
			console.log(value);
			$.ajax({

				type: "POST",
				datatype: 'json',
				data: JSON.stringify(value),
				contentType: 'application/json; charset=utf-8',
				url: "/fetch",
				success: function fetchon(fetch_data) {
					createCards(fetch_data);


				}
			});

		});
	});

});


//*******************************************************************sample check************************************* */

document.addEventListener('firstLinkClicked', function() {
	document.querySelectorAll('a').forEach(link => {

		link.addEventListener('click', function(event) {
			event.preventDefault();
			const cardContainer = document.getElementById('product-container');
			while (cardContainer.firstChild) cardContainer.firstChild.remove();

			const value = { gender: this.getAttribute('data-value') }
			console.log(value);
			$.ajax({

				type: "POST",
				datatype: 'json',
				data: JSON.stringify(value),
				contentType: 'application/json; charset=utf-8',
				url: "/fetch",
				success: function fetchon(fetch_data) {
					createCards(fetch_data);


				}
			});

		});
	});
});



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



