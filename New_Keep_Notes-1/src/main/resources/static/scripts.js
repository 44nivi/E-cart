var inputArray = [];
var count=0
function addNote() {
	const noteInput = document.getElementById("note-input");
	const notesList = document.getElementById("notes-list");
	inputArray.push(noteInput.value);
	if (noteInput.value !== "") {
		const noteItem = document.createElement("div");
		noteItem.classList.add("note-item");

		const noteText = document.createElement("span");
		noteText.textContent = noteInput.value;


		const deleteButton = document.createElement("button");
		deleteButton.textContent = "Delete";
		deleteButton.onclick = function() {
			console.log(noteText.textContent);
			var elementToFind = noteText.textContent
			deleteNote(noteItem);
			var index = -1;
			for (var i = 0; i < inputArray.length; i++) {
				if (inputArray[i] === elementToFind) {
					index = i;
					break; // If you want to find the first occurrence, you can break out of the loop.
				}
			}
			if (index !== -1) {
				// Use the splice method to remove the element at the found index.
				inputArray.splice(index, 1)
				console.log("Updated array: " + inputArray)
			}
		};
		noteItem.appendChild(noteText)
		noteItem.appendChild(deleteButton);
		notesList.appendChild(noteItem);

		noteInput.value = "";

	}


}

function deleteNote(noteItem) {
	const notesList = document.getElementById("notes-list");
	notesList.removeChild(noteItem);
}
function submitsData() {
	 count=count+1;
	console.log(inputArray)
	$.ajax({
		type: "post",
		datatype: 'json',
		data: JSON.stringify(inputArray),
		contentType: 'application/json; charset=utf-8',
		url: "/regi",
		success: function namm(data = []) {
			// console.log(data);	
			alert("hii you are return value ");
			alert(data);
			const arr=[];
			const ar=[];
			
			for (var i = 0; i < data.length; i++) {
			console.log(data[i].a);
			arr.push(data[i].a);
			ar.push(data[i].id);
			}
			
			console.log(arr);
			create(arr,ar,count)
			
		}
			});

}

function create(arr,ar,count){
			const container = document.getElementById("container2");
			if(count>1){
				container.remove();
				count=0
				
			}
			else{
			const container=document.getElementById("container2")
			for (var i = 0; i < arr.length; i++){
			const tableDiv = document.createElement("div"+i);
			tableDiv.id = "myDiv"+i; // Set the id attribute
			tableDiv.className = "newdiv"
			
			const table = document.createElement("table");
   			const caption = document.createElement("caption");
   			caption.textContent = ar[i];
   	
   			table.appendChild(caption);

			const row = table.insertRow();

// Iterate through the array and create a new cell for each element
			arr[i].forEach((element) => {
			    const cell = document.createElement("td");
			    cell.textContent = element;
			    row.appendChild(cell);
			});
			tableDiv.appendChild(table);
			container.appendChild(tableDiv);}
			
}

}

function changeText() {
	var divElement = document.getElementById("stored");
	const newText = document.createElement("span");
	noteText.newtext = noteInput.value;
	noteItem.innerHTML = noteText.textContent
	divElement.innerHTML = "Text has been changed!";
}
