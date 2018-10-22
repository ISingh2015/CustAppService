
$(document).ready(function () {
    console.log('inderjitportal.js executing');
    window.onscroll = function () {
        scrollFunction();
    };
    $('[data-toggle="tooltip"]').tooltip();

    function scrollFunction() {
        if ($(this).scrollTop() > 50) {
            $('#scrolBtn').fadeIn();
//            $('#headermenu').addClass('shrink');
//            $('#headermenu').addClass('shrinkanimate');            
        } else {
            $('#scrolBtn').fadeOut();
//            $('#headermenu').removeClass('shrink');
//            $('#headermenu').removeClass('shrinkanimate');            
        }
    }
    var beepOne = $("#beep-one")[0];
    $("#aboutLink")
            .mouseenter(function () {
                beepOne.play();
            });


    $('#scrolBtn').click(function () {
        $('html, body').animate({scrollTop: 0}, 800);
        return false;
    });


    $("#registerCancel").click(function () {
        var contextPath = '/';
        location.href = contextPath;
    });

    $("#registerFromLogin").click(function () {
        var contextPath = '/register';
        location.href = contextPath;
    });

    $.each([1, 2, 3, 4, 5], function (index, value) {

        $("#feature" + index).click(function () {
            $("#featureDiv" + index).hide("slow");
            $("#featureText" + index).show("slow");
            console.log("feature " + index + " click");
        });

        $("#benefit" + index).click(function () {
            $("#benefitDiv" + index).hide("slow");
            $("#benefitText" + index).show("slow");
            console.log("benefit" + index + " click");
        });

    });

    $("input#registerFormUsername, input#loginUsername, input#forgotPasswordFormUsername").on({

        keydown: function (e) {
            console.log(e.which);
            if (e.which === 32 || e.which === 111 || (e.which >= 106 && e.which <= 109) || (e.which >= 219 && e.which <= 222) || (e.which >= 186 && e.which <= 192))
                return false;
        }
    });
    $("input#registerFormPassword, input#loginPassword,input#forgotPasswordFormPassword, input#forgotPasswordFormConfirmPassword").on({

        keydown: function (e) {
            console.log(e.which);
            if (e.which === 32 || e.which === 111 || (e.which >= 106 && e.which <= 109) || (e.which >= 219 && e.which <= 222) || (e.which >= 186 && e.which <= 188) || (e.which >= 190 && e.which <= 192))
                return false;
        }
    });

    $("input#registerFormUsername, input#loginUsername, input#registerFormPassword, input#loginPassword").bind("cut copy paste", function (e) {
        e.preventDefault();
    });
//    $("#loginBtn").click(function (e) {
//        $("#loginBtn").attr("disabled","disabled");
//        console.log("login btn clicked");
//        e.preventDefault();
//        $("#loginfrm").submit();
//        console.log("login frm submitted");        
//        $("#loginBtn").removeAttr("disabled");
//    });
//
    $("#forgotpasswordBtn").click(function () {
        var userLogin = $("#forgotPasswordFormUsername").val();
        var password = $("#forgotPasswordFormPassword").val();
        var confirmPassword = $("#forgotPasswordFormConfirmPassword").val();
        console.log(password + '' + confirmPassword);
        if (userLogin === '' || password === '' || confirmPassword === '') {
            displayMessage("User Login Name, Password & Confirm Password are required", "alert-info", "alert-danger");
            scrollToTop();
            return false;
        }
        if (password === '' || confirmPassword === '' || password != confirmPassword) {
            displayMessage("Passwords Do not match..", "alert-info", "alert-danger");
            scrollToTop();
            return false;
        }
        if (userLogin.length < 8) {
            displayMessage("User Name Should be minimum 8 Characters", "alert-info", "alert-danger");
            scrollToTop();
            return false;
        }
        if (password.length < 8) {
            displayMessage("Password Should be minimum 8 Characters", "alert-info", "alert-danger");
            scrollToTop();
            return false;
        }
        $("#forgotpasswordBtn").attr("disabled", "disabled");
        $.ajax({url: "forgotPassword", data: {"userLoginName": $("#forgotPasswordFormUsername").val(), "password": $("#forgotPasswordFormPassword").val()}, method: "POST"})
                .done(function (data) {
                    if (data === false) {
                        displayMessage("User Name not found ", "alert-info", "alert-danger");
                        scrollToTop();
                    } else {
                        displayMessage("Password reset and emailed sucessfully to your registered email Id ...", "alert-danger", "alert-info");
                    }
                }).fail(function () {
            displayMessage("Could not reset Password... Please try again", "alert-info", "alert-danger");
            scrollToTop();
        });
        $("#forgotpasswordBtn").removeAttr("disabled");
    });
    $("#dispPassword").hover(function () {
        var x = document.getElementById("password");
        if (x.value != "") {
            if (x.type === "password") {
                $(this).attr("data-original-title", "Show Password");
            } else {
                $(this).attr("data-original-title", "Hide Password");
            }
        } else {
            $(this).attr("data-original-title", "");
        }
    });
    $("#dispPassword").click(function () {
        var x = document.getElementById("password");
        if (x.type === "password") {
            x.type = "text";
            $(this).attr("data-original-title", "Hide Password");
        } else {
            x.type = "password";
            $(this).attr("data-original-title", "Show Password");
        }
    });

    $("#dispforgotPassword").hover(function () {
        var x = document.getElementById("forgotPasswordFormPassword");
        if (x.value != "") {
            if (x.type === "password") {
                $(this).attr("data-original-title", "Show Password");
            } else {
                $(this).attr("data-original-title", "Hide Password");
            }
        } else {
            $(this).attr("data-original-title", "");
        }
    });
    $("#dispforgotPassword").click(function () {
        console.log('within forgot password click');
        var x = document.getElementById("forgotPasswordFormPassword");
        if (x.type === "password") {
            x.type = "text";
            $(this).attr("data-original-title", "Hide Password");
        } else {
            x.type = "password";
            $(this).attr("data-original-title", "Show Password");
        }
    });
    $("#dispforgotConfirmPassword").hover(function () {
        var x = document.getElementById("forgotPasswordFormConfirmPassword");
        if (x.value != "") {
            if (x.type === "password") {
                $(this).attr("data-original-title", "Show Password");
            } else {
                $(this).attr("data-original-title", "Hide Password");
            }
        } else {
            $(this).attr("data-original-title", "");
        }
    });
    $("#dispforgotConfirmPassword").click(function () {
        var x = document.getElementById("forgotPasswordFormConfirmPassword");
        if (x.type === "password") {
            x.type = "text";
            $(this).attr("data-original-title", "Hide Password");
        } else {
            x.type = "password";
            $(this).attr("data-original-title", "Show Password");
        }
    });
    $("#contactFormSubmitBtn").click(function () {
        var cEmail = $("#contactformUseremail").val();
        var cMobile = $("#contactformUsermobileno").val();
        if (cEmail === '' || cMobile === '') {
            displayMessage("Email address and Mobile No is required", "alert-danger", "alert-info");
            scrollToTop();
            return false;
        }
        if (!validateEmail(cEmail)) {
            displayMessage("Email address you entered is invalid", "alert-danger", "alert-info");
            scrollToTop();
            return false;
        }

        $(this).attr("disabled", "disabled");
        $(this).text("Sending ... Please Wait");
        $.ajax({url: "contact", data: {"contactName": $("#contactformUsername").val(), "contactEmail": cEmail, "contactMobile": cMobile, "contactMessage": $("#contactformUsermessage").val()}, method: "POST"})
                .done(function (data) {
                    if (data === false) {
                        initContactForm();
                        displayMessage("Could not send message. Please retry in a few minutes ", "alert-info", "alert-danger");
                        scrollToTop();
                    } else {
                        initContactForm();
                        displayMessage("Thank you for your valid feedback.Some one will get to you shortly.", "alert-danger", "alert-info");
                        scrollToTop();
                    }
                }).fail(function () {
            displayMessage("Error Sending your message... Please try again later", "alert-info", "alert-danger");
            scrollToTop();
        });

    });
});
function displayMessage(message, removeClass, addClass) {
    var v = $("#dispMessage").is(":visible");
    if (!v)
        $("#dispMessage").fadeToggle("slow");
    $("#dispMessage").removeClass(removeClass).addClass(addClass);
    $("#dispMessage").html(message);
    return false;
}
function scrollToTop() {
    $("html, body").animate({scrollTop: 0}, "slow");
    return false;
}
function initContactForm() {
    $("#contactformUsername").val("");
    $("#contactformUseremail").val("");
    $("#contactformUsermobileno").val("");
    $("#contactformUsermessage").val("");
    $("#contactFormSubmitBtn").removeAttr("disabled");
    $("#contactFormSubmitBtn").text("Send Message");
    $("#human").val("");
    return false;
}
function validateEmail(sEmail) {
    var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    if (filter.test(sEmail)) {
        return true;
    }
    return false;
}

function downloadBtnClick() {
    $("#invdownloadbtn").attr("disabled", "disabled");
    $("#downloadform").submit();
    return false;
}
function poll() {
    var messageWindow = $("#messageModal").is(":visible");
    $.ajax({url: "/health"})    
//    $.ajax({url: "/inderjit-portal-inventory/health"})
            .done(function (data) {
                if (messageWindow)
                    $("#messageModal").modal('hide');
            })
            .fail(function () {
//                clearTimeout(pollvar);
                if (!messageWindow)
                    $("#messageModal").modal('show');
            });
}

var pollvar = setInterval(function () {
    poll();
}, 5000);

