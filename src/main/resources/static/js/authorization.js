"use strict"

const headerSingIn = document.getElementById("signIn"),
      headerSignUp = document.getElementById("signUp"),
      form = document.getElementById("form"),
      email = document.getElementById("email"),
      login = document.getElementById("login"),
      password = document.getElementById("password"),
      submitButton = document.getElementById("sbm_btn");


//Change headers sides (swap headers)

function showEmail() {
    form.setAttribute('action', '/registration');
    email.classList.remove('hidden');
    email.required = true;
    submitButton.value = 'Sign up';
}

function hideEmail() {
    form.setAttribute('action', '/login');
    email.classList.add('hidden');
    email.required = false;
    submitButton.value = 'Sign in';
}

function changeActiveStatusClass(listActive, listNonActive) {
    listNonActive.add('active');
    listNonActive.remove('inactive', 'underlineHover');
    listActive.add('inactive', 'underlineHover');
    listActive.remove('active');
}

function changeActiveHeader() {
    headerSingIn.addEventListener('click', () => {
        changeActiveStatus(headerSignUp, headerSingIn);
        form.reset();
    });

    headerSignUp.addEventListener('click', () => {
        changeActiveStatus(headerSingIn, headerSignUp);
        form.reset();
    });

    function changeActiveStatus(activeElement, nonActiveElement) {
        if (nonActiveElement.id === 'signUp') {
            showEmail();
        } else {
            hideEmail();
        }
        changeActiveStatusClass(activeElement.classList, nonActiveElement.classList);
    }
}

changeActiveHeader();