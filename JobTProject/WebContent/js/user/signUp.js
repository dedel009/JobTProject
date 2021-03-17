/**
 * 
 */

window.onload = function() {
	const input = document.querySelector(".id");
    const pass = document.querySelector(".password");	
    const passcheck = document.querySelector(".passwordcheck"); 
    const name = document.querySelector(".name");
    const nickname = document.querySelector(".nickname");
    
    input.addEventListener("blur", idSubmit);
    pass.addEventListener("blur", passSubmit);	
    passcheck.addEventListener("blur", passwordCheck);
    name.addEventListener("blur", nameCheck);
    nickname.addEventListener("blur", nicknameCheck);
}

function idSubmit() {
    const var1 = document.querySelector(".id").value;
    if(var1==null || var1==""){
        document.querySelector(".p1").style.display = "none";   	
        document.querySelector(".nono1").style.display = "block";
    }else{
        const form = document.querySelector(".form");
        form.action = "idCheck";
        form.submit();
    }
}

function passSubmit() {
    const var1 = document.querySelector(".password").value;
    if(var1==null || var1==""){
        document.querySelector(".no2").style.display = "none"; 
        document.querySelector(".yes2").style.display = "none";  
        document.querySelector(".nono2").style.display = "block";
    }else{
        if(var1.length < 8){
            document.querySelector(".nono2").style.display = "none"; 
            document.querySelector(".yes2").style.display = "none";   
            document.querySelector(".no2").style.display = "block";
        }else{
            document.querySelector(".nono2").style.display = "none"; 
            document.querySelector(".no2").style.display = "none";  
            document.querySelector(".yes2").style.display = "block";
        }
    } 
}

function passwordCheck() {
    const var1 = document.querySelector(".password").value;
    const var2 = document.querySelector(".passwordcheck").value;
    if(var2==null || var2==""){
        document.querySelector(".no3").style.display = "none"; 
        document.querySelector(".yes3").style.display = "none";  
        document.querySelector(".nono3").style.display = "block";
    }else{
        if(var1==var2){
            document.querySelector(".nono3").style.display = "none"; 
            document.querySelector(".no3").style.display = "none";   
            document.querySelector(".yes3").style.display = "block";
        }else{
            document.querySelector(".nono3").style.display = "none"; 
            document.querySelector(".yes3").style.display = "none";  
            document.querySelector(".no3").style.display = "block";
        }
    } 
}

function nameCheck(){
    const var1 = document.querySelector(".name").value;
    if(var1==null || var1==""){
        document.querySelector(".nono4").style.display = "block";
    }else{
        document.querySelector(".nono4").style.display = "none";  
    }
}

function nicknameCheck(){
    const var1 = document.querySelector(".nickname").value;
    if(var1==null || var1==""){
        document.querySelector(".nono5").style.display = "block";
    }else{
        document.querySelector(".nono5").style.display = "none";  
    }
}