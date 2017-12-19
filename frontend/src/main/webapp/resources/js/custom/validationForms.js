$(document).ready(function () {

    function CustomValidation() {
        this.invalidities = [];
        this.validityChecks = [];
    }

    CustomValidation.prototype = {
        addInvalidity: function (message) {
            this.invalidities.push(message);
        },
        getInvalidities: function () {
            return this.invalidities.join('. \n');
        },
        checkValidity: function (input) {
            for (var i = 0; i < this.validityChecks.length; i++) {

                var isInvalid = this.validityChecks[i].isInvalid(input);
                if (isInvalid) {
                    this.addInvalidity(this.validityChecks[i].invalidityMessage);
                }

                var requirementElement = this.validityChecks[i].element;
                if (requirementElement) {
                    if (isInvalid) {
                        requirementElement.classList.add('invalid');
                        requirementElement.classList.remove('valid');
                    } else {
                        requirementElement.classList.remove('invalid');
                        requirementElement.classList.add('valid');
                    }

                } // end if requirementElement
            } // end for
        }
    };


    /* ----------------------------

     Validity Checks

     The arrays of validity checks for each input
     Comprised of three things
     1. isInvalid() - the function to determine if the input fulfills a particular requirement
     2. invalidityMessage - the error message to display if the field is invalid
     3. element - The element that states the requirement

     ---------------------------- */

    var usernameValidityChecks = [
        {
            isInvalid: function (input) {
                return input.value.length < 3;
            },
            invalidityMessage: 'This input needs to be at least 3 characters',
            element: document.querySelector('label[for="student_username"].input-requirements li:nth-child(1)')
        },
        {
            isInvalid: function (input) {
                var illegalCharacters = input.value.match(/[^a-zA-Z0-9]/g);
                return illegalCharacters ? true : false;
            },
            invalidityMessage: 'Only letters and numbers are allowed',
            element: document.querySelector('label[for="student_username"] .input-requirements li:nth-child(2)')
        }
    ];

    var passwordValidityChecks = [
        {
            isInvalid: function (input) {
                return input.value.length < 4 | input.value.length > 50;
            },
            invalidityMessage: 'This input needs to be between 4 and 50 characters',
            element: document.querySelector('label[for="student_password"].input-requirements li:nth-child(1)')
        }
    ];

    var passwordRepeatValidityChecks = [
        {
            isInvalid: function() {
                return passwordRepeatInput.value !== passwordInput.value;
            },
            invalidityMessage: 'This password needs to match the first one'
        }
    ];

    var firstNameValidityChecks = [
        {
            isInvalid: function (input) {
                return input.value.length < 2 | input.value.length > 50;
            },
            invalidityMessage: 'This input needs to be between 4 and 50 characters',
            element: document.querySelector('label[for="student_firstName"].input-requirements li:nth-child(1)')
        }
    ];

    var lastNameValidityChecks = [
        {
            isInvalid: function (input) {
                return input.value.length < 2 | input.value.length > 50;
            },
            invalidityMessage: 'This input needs to be between 2 and 50 characters',
            element: document.querySelector('label[for="student_lastName"].input-requirements li:nth-child(1)')
        }
    ];


    var emailValidityChecks = [
        {
            isInvalid: function (input) {
                var illegalCharacters = input.value.match(/^[0-9a-z-.]+@[0-9a-z-]{2,}\.[a-z]{2,}$/g);
                return illegalCharacters ? true : false;
            },
            invalidityMessage: 'Invalid email address',
            element: document.querySelector('label[for="student_email"] .input-requirements li:nth-child(1)')
        },
        {
            isInvalid: function (input) {
                return input.value.length < 5 | input.value.length > 100;
            },
            invalidityMessage: 'This input needs to be between 5 and 100 characters',
            element: document.querySelector('label[for="student_email"].input-requirements li:nth-child(2)')
        }
    ];

    var groupValidityChecks = [
        {
            isInvalid: function (input) {
                var illegalCharacters = input.value.match(/[^0-9]/g);
                return illegalCharacters ? true : false;
            },
            invalidityMessage: 'Only numbers are allowed',
            element: document.querySelector('label[for="student_groupNumber"] .input-requirements li:nth-child(1)')
        },
        {
            isInvalid: function (input) {
                return input.value.length < 2 | input.value.length > 10;
            },
            invalidityMessage: 'This input needs to be between 2 and 10 characters',
            element: document.querySelector('label[for="student_groupNumber"].input-requirements li:nth-child(2)')
        }
    ];


    /* ----------------------------

     Check this input

     Function to check this particular input
     If input is invalid, use setCustomValidity() to pass a message to be displayed

     ---------------------------- */

    function checkInput(input) {

        input.CustomValidation.invalidities = [];
        input.CustomValidation.checkValidity(input);

        if (input.CustomValidation.invalidities.length === 0 && input.value !== '') {
            input.setCustomValidity('');

            elements.studentRegSubmitBtn.click(function () {
                registrationStudent()
            });

        } else {
            var message = input.CustomValidation.getInvalidities();
            input.setCustomValidity(message);
        }
    }


    /* ----------------------------

     Setup CustomValidation

     Setup the CustomValidation prototype for each input
     Also sets which array of validity checks to use for that input

     ---------------------------- */

    var usernameInput = document.getElementById('student_username');
    var passwordInput = document.getElementById('student_password');
    var passwordRepeatInput = document.getElementById('password_repeat');
    var firstNameInput = document.getElementById('student_firstName');
    var lastNameInput = document.getElementById('student_lastName');
    var emailInput = document.getElementById('student_email');
    var groupInput = document.getElementById('student_groupNumber');


    usernameInput.CustomValidation = new CustomValidation();
    usernameInput.CustomValidation.validityChecks = usernameValidityChecks;

    passwordInput.CustomValidation = new CustomValidation();
    passwordInput.CustomValidation.validityChecks = passwordValidityChecks;

    passwordRepeatInput.CustomValidation = new CustomValidation();
    passwordRepeatInput.CustomValidation.validityChecks = passwordRepeatValidityChecks;

    firstNameInput.CustomValidation = new CustomValidation();
    firstNameInput.CustomValidation.validityChecks = firstNameValidityChecks;

    lastNameInput.CustomValidation = new CustomValidation();
    lastNameInput.CustomValidation.validityChecks = lastNameValidityChecks;

    emailInput.CustomValidation = new CustomValidation();
    emailInput.CustomValidation.validityChecks = emailValidityChecks;

    groupInput.CustomValidation = new CustomValidation();
    groupInput.CustomValidation.validityChecks = groupValidityChecks;


    /* ----------------------------

     Event Listeners

     ---------------------------- */

    var inputs = document.querySelectorAll('input:not([type="submit"])');
    var submit = document.querySelector('input[type="submit"');

    for (var i = 0; i < inputs.length; i++) {
        inputs[i].addEventListener('keyup', function () {
            checkInput(this);
        });
    }

    submit.addEventListener('click', function () {
        for (var i = 0; i < inputs.length; i++) {
            checkInput(inputs[i]);
        }
    });

});
