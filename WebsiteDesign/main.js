function setFormMessage(formElement, type, message) {
	const messageElement = formElement.querySelector(".form_message");

	messageElement.textContent = message;
	messageElement.classList.remove("form_message-success", "form_message-error");
	messageElement.classList.add(`form_message-${type}`);
}

document.addEventListener("DOMContentLoaded", () => {
	const loginForm = document.querySelector("#login");
	const createAccountForm = document.querySelector("#createAccount");
	
	document.querySelector("#linkCreateAccount").addEventListener("click", e => {
		e.preventDefault();
		loginForm.classList.add("form_hidden");
		createAccountForm.classList.remove("form_hidden");
	});
	
	document.querySelector("#linkLogin").addEventListener("click", e => {
		e.preventDefault();
		loginForm.classList.remove("form_hidden");
		createAccountForm.classList.add("form_hidden");
	});

	loginForm.addEventListener("submit", e => {
		e.preventDefault();
		
		//Preform Fetch Login

		setFormMessage(loginForm, "error", "Invalid username/password combination");
	});
});

