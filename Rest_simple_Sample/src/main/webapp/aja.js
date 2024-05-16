
function register(){
    console.log("welcome")
    alert("call!!!")
     event.preventDefault();
    
    var infos = {
        name : $("#uname").val(),
        age : $("#age").val(),
        email:$("#email").val(),
        phone:$("#phone").val(),
        date : $("#date").val(),
        password : $("#password").val(),
        confirmpassword : $("#confirmPassword").val()
    };
    
    console.log("after data")
   
    

    $.ajax({
        
        type : "POST",
        
        data: {B : JSON.stringify(infos)},
        contentType:"appliction/Json",
        url:"rest/call/hit",
        success : function(B){
            console.log("this is msg"+B);
            alert("i am done!!!!");
            
        }
    });

    
    console.log("data")
    
}