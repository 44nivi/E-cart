function register() {

   console.log("welcome")
    alert("call!!!")
     event.preventDefault();
    
    var infos = {
        name : $("#uname").val(),
        email:$("#email").val(),
        upload:$("#myfile").val(),
        password : $("#password").val(),
        confirmpassword : $("#confirmPassword").val()
    };
    
    console.log("after data")
   
      $.ajax({
        
        type : "POST",
        
        data: {B : JSON.stringify(infos)},
        contentType:"appliction/Json",
        url:"rest/reg/hit",
        success : function namm(data){
            console.log("this is msg");
            alert("i am done!!!!");
      	const obj=JSON.parse(data);
      	console.log(obj);
        var div = document.createElement('div');
	    div.setAttribute("id","full");
        div.innerHTML ='<div id="kids"> </div>';
		document.getElementById('full').innerHTML = obj.name + ", " + obj.email;
	   
        }
    });

    
    console.log("data")
    

    
    
}
