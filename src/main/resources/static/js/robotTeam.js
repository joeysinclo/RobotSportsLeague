// Get the modal
var createInputModal = document.getElementById("createTeamInput");
var editInputModal = document.getElementById("editTeamInput");
var createConfirmModal = document.getElementById("createTeamConfirmation");
var editConfirmModal = document.getElementById("editTeamConfirmation");

// Get the buttons that opens the modal
var createTeamBtn = document.getElementById("createTeamButton");
var editTeamBtn = document.getElementsByClassName("editRowButton");

// Get the buttons that saves input provided by user
var createInputBtn = document.getElementById("createInputButton");
var editInputBtn = document.getElementById("editInputButton");

// Get the element that closes the modal
var createInputCloseBtn = document.getElementById("close_create_team_input_button");
var editInputCloseBtn = document.getElementById("close_edit_team_input_button");
var createConfirmCloseBtn = document.getElementById("close_create_confirmation_button");
var editConfirmCloseBtn = document.getElementById("close_edit_confirmation_button");

// Edit team inputs (id - good for reusing the same modal window and text boxes, just storing different values)
var editTeamNameInput = document.getElementById("editTeamNameInput");
var editOwnerFirstNameInput = document.getElementById("editFirstNameInput");
var editOwnerLastNameInput = document.getElementById("editLastNameInput");

// When the user clicks the "create team" button, open the 'create team' input modal
createTeamBtn.onclick = function() {
  createInputModal.style.display = "block";
}

// When the user clicks the edit button, open the 'edit team' input modal
var numOfRows = document.getElementById("tableBody").getElementsByTagName("tr");
for (editTeamBtn[i = 0]; i < numOfRows.length; i++) {

// Create unique id for each edit button
  if (editTeamBtn == document.getElementById("editTeamButton") || editTeamBtn.id != "editTeamButton" + i){
     editTeamBtn[i].id = "editTeamButton" + i;
  }
}

function edit(x){

    var teamNameCell = document.getElementsByClassName("tableRow")[x.rowIndex - 1].children[0].children[0].innerHTML;
    var ownerFirstNameCell = document.getElementsByClassName("tableRow")[x.rowIndex - 1].children[1].children[0].innerHTML;
    var ownerLastNameCell = document.getElementsByClassName("tableRow")[x.rowIndex - 1].children[1].children[1].innerHTML;

    editTeamNameInput.value = teamNameCell;
    editOwnerFirstNameInput.value = ownerFirstNameCell;
    editOwnerLastNameInput.value = ownerLastNameCell;

    editInputModal.style.display = "block";
}

// When the user clicks 2nd "create team" button, display 'confirmation modal'
createInputBtn.onclick = function() {

  var teamNameInput = document.getElementById("createTeamNameInput").value;
  var firstNameInput = document.getElementById("createFirstNameInput").value;
  var lastNameInput = document.getElementById("createLastNameInput").value;

  createInputModal.style.display = "none";
  createConfirmModal.style.display = "block";

  document.getElementById("createTeamNameValue").innerHTML = teamNameInput;
  document.getElementById("createFirstNameValue").innerHTML = firstNameInput;
  document.getElementById("createLastNameValue").innerHTML = lastNameInput;
}

// When the user clicks 2nd "edit team" button, display 'confirmation modal'
editInputBtn.onclick = function() {

  var teamNameInput = document.getElementById("editTeamNameInput").value;
  var firstNameInput = document.getElementById("editFirstNameInput").value;
  var lastNameInput = document.getElementById("editLastNameInput").value;

  editInputModal.style.display = "none";
  editConfirmModal.style.display = "block";

  document.getElementById("editTeamNameValue").innerHTML = teamNameInput;
  document.getElementById("editFirstNameValue").innerHTML = firstNameInput;
  document.getElementById("editLastNameValue").innerHTML = lastNameInput;
}

// When the user clicks on (x), close the modal
createInputCloseBtn.onclick = function() {
  createInputModal.style.display = "none";
}
editInputCloseBtn.onclick = function() {
  editInputModal.style.display = "none";
}
createConfirmCloseBtn.onclick = function() {
  createConfirmModal.style.display = "none";
}
editConfirmCloseBtn.onclick = function() {
  editConfirmModal.style.display = "none";
}