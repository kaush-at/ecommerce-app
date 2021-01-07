const username = document.getElementById("username");
const email = document.getElementById("email");
const password = document.getElementById("password");
const password2 = document.getElementById("password2");
const form = document.getElementById("form");

function showError(input, message) {
  let formControl = input.parenElement;
  formControl.className = "form-control error";
  return input + " " + message;
}

function showSuccess(input) {
  let formControl = input.parenElement;
  formControl.className = "form-control success";
}

form.addEventListener("submit", function(e) {
  e.preventDefault();
  console.log("submitted");
});

// validate email
function validateEmail(email) {
  if (email === "") {
    showError(email, "Required");
  } else if (email !== "") {
    const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if (!re.test(String(email).toLowerCase())) {
      showError(email, "not in valid format");
    }
  } else {
    showSuccess(email);
  }
}

// validate username
function validateUsername(username) {
  if (username === "") {
    showError(username, " Required");
  } else {
    showSuccess(username);
  }
}

// validate password
function validatePassword(password) {
  const strongRegex = new RegExp(
    "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])(?=.{8,})"
  );
  if (strongRegex.test(password)) {
    showSuccess(password);
  } else {
    showError(password, "Does not meet the requirement");
  }
}
