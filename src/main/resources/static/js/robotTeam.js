// Get the modal
var createInputModal = document.getElementById('createTeamInput');
var editInputModal = document.getElementById('editTeamInput');
var confirmModal = document.getElementById('createTeamConfirmation');

// Get the buttons that opens the modal
var createTeamBtn = document.getElementById("createTeamButton");
var editTeamBtn = document.getElementById("editTeamButton");

// Get the buttons that saves input provided by user
var createInputBtn = document.getElementById("createInputButton");
var editInputBtn = document.getElementById("editInputButton");

// Get the element that closes the modal
var createInputCloseBtn = document.getElementById("close_create_team_input_button");
var editInputCloseBtn = document.getElementById("close_edit_team_input_button");
var confirmCloseBtn = document.getElementById("close_confirmation_button");


// When the user clicks the "create team" button, open the 'create team' input modal
createTeamBtn.onclick = function() {
  createInputModal.style.display = "block";
}

// When the user clicks the edit button, open the 'edit team' input modal
editTeamBtn.onclick = function() {
  editInputModal.style.display = "block";
}

// When the user clicks 2nd "create team" button, display 'confirmation modal'
createInputBtn.onclick = function() {

  var teamNameInput = document.getElementById("createTeamNameInput").value;
  var firstNameInput = document.getElementById("createFirstNameInput").value;
  var lastNameInput = document.getElementById("createLastNameInput").value;

  createInputModal.style.display = "none";
  confirmModal.style.display = "block";

  document.getElementById("teamNameValue").innerHTML = teamNameInput;
  document.getElementById("firstNameValue").innerHTML = firstNameInput;
  document.getElementById("lastNameValue").innerHTML = lastNameInput;
}

// When the user clicks 2nd "edit team" button, display 'confirmation modal'
editInputBtn.onclick = function() {

//  var teamNameInput = document.getElementById("editTeamNameInput").value;
//  var firstNameInput = document.getElementById"editFirstNameInput").value;
//  var lastNameInput = document.getElementById("editLastNameInput").value;

  editInputModal.style.display = "none";
  confirmModal.style.display = "block";

  document.getElementById("teamNameValue").innerHTML = teamNameInput;
  document.getElementById("firstNameValue").innerHTML = firstNameInput;
  document.getElementById("lastNameValue").innerHTML = lastNameInput;
}

// When the user clicks on (x), close the modal
createInputCloseBtn.onclick = function() {
  createInputModal.style.display = "none";
}
editInputCloseBtn.onclick = function() {
  editInputModal.style.display = "none";
}
confirmCloseBtn.onclick = function() {
  confirmModal.style.display = "none";
}