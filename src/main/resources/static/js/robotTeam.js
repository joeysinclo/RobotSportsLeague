// Get the modal
var inputModal = document.getElementById('createTeamInput');
var confirmModal = document.getElementById('createTeamConfirmation');

// Get the button that opens the modal
var createTeamBtn = document.getElementById("createTeamButton");
var submitInputBtn = document.getElementById("submitButton");

// Get the <span> element that closes the modal
var inputCloseBtn = document.getElementById("close_input_button");
var confirmCloseBtn = document.getElementById("close_confirmation_button")


// When the user clicks the button, open the modal
createTeamBtn.onclick = function() {
  inputModal.style.display = "block";
}
submitInputBtn.onclick = function() {
  inputModal.style.display = "none"
  confirmModal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
inputCloseBtn.onclick = function() {
  inputModal.style.display = "none";
}
confirmCloseBtn.onclick = function() {
  confirmModal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == inputModal) {
    inputModal.style.display = "none";
  }
  if (event.target == confirmModal) {
      confirmModal.style.display = "none";
  }
}