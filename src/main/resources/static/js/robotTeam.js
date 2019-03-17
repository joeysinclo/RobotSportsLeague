// Get the modal
var inputModal = document.getElementById('createTeamInput');
var confirmModal = document.getElementById('createTeamConfirmation');

// Get the button that opens the modal
var createTeamBtn = document.getElementById("createTeamButton");
var submitInputBtn = document.getElementById("submitButton");

// Get the element that closes the modal
var inputCloseBtn = document.getElementById("close_input_button");
var confirmCloseBtn = document.getElementById("close_confirmation_button");


// When the user clicks the button, open the modal
createTeamBtn.onclick = function() {
  inputModal.style.display = "block";
}

// When the user clicks this button, display 'confirmation modal'
submitInputBtn.onclick = function() {

  var teamNameInput = document.getElementById("teamNameInput").value;
  var firstNameInput = document.getElementById("firstNameInput").value;
  var lastNameInput = document.getElementById("lastNameInput").value;

  inputModal.style.display = "none"
  confirmModal.style.display = "block";

  document.getElementById("teamNameValue").innerHTML = teamNameInput;
  document.getElementById("firstNameValue").innerHTML = firstNameInput;
  document.getElementById("lastNameValue").innerHTML = lastNameInput;
}

// When the user clicks on (x), close the modal
inputCloseBtn.onclick = function() {
  inputModal.style.display = "none";
}
confirmCloseBtn.onclick = function() {
  confirmModal.style.display = "none";
}