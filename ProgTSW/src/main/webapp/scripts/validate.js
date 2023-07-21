const nameOrLastnamePattern = /^[A-Za-z]+$/;
const emailPattern = /^\S+@\S+\.\S+$/;
const passwordPattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
const nameErrorMessage = "solo lettere";
const lastnameErrorMessage = "solo lettere";
const emailErrorMessage = "contenuto valido: username@domain.ext";
const passwordErrorMessage = "tra 6 e 20 caratteri almeno un numero, una lettera maiuscola e una minuscola";
let count = 1;


function validateFormElem(formElem, pattern, span, message) {
	if(formElem.value.match(pattern)){
		formElem.classList.remove("error");
		span.style.color = "black";
		span.innerHTML = "";
		return true;
	}
	formElem.classList.add("error");
	span.innerHTML = message;
	span.style.color = "white";
	return false;
}

function validatereg() {
	let valid = true;	
	let form = document.getElementById("regForm");
	
	let spanName = document.getElementById("errorName");
	if(!validateFormElem(form.firstname, nameOrLastnamePattern, spanName, nameErrorMessage)){
		valid = false;
	} 
	let spanLastname = document.getElementById("errorLastname");
	if (!validateFormElem(form.lastname, nameOrLastnamePattern, spanLastname, lastnameErrorMessage)){
		valid = false;
	}
	let spanEmail = document.getElementById("errorEmailReg");
	if (!validateFormElem(form.email, emailPattern, spanEmail, emailErrorMessage)){
		valid = false;
	}
	let spanpassword = document.getElementById("erropasswordReg");
	if (!validateFormElem(form.passwordReg, passwordPattern, spanpassword, passwordErrorMessage)){
		valid = false;
	}
	return valid;
}

function validateacc() {
	let valid = true;	
	let form = document.getElementById("accForm");

	let spanEmail = document.getElementById("errorEmailAcc");
	if (!validateFormElem(form.email, emailPattern, spanEmail, emailErrorMessage)){
		valid = false;
	}
	let spanpassword = document.getElementById("erropasswordAcc");
	if (!validateFormElem(form.passwordAcc, passwordPattern, spanpassword, passwordErrorMessage)){
		valid = false;
	}
	return valid;
}

