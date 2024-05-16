$(document).ready(function() {

	$("#clicker").click(function() {

		var info = {
			name: $("#usr").val(),
			pass: $("#pwd").val()

		};


		alert(info.name);
		alert(info.pass);
		$.ajax({
			type: "post",
			datatype: 'json',
			data: { A: JSON.stringify(info) },
			contentType: 'application/json; charset=utf-8',
			url: "rest/go/register",
		});
		alert(info.pass);
	});


});