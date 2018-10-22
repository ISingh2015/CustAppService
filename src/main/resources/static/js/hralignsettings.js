
$(document).ready(function () {
    document.getElementById('defaultOpen').click();
    window.onscroll = function () {
        scrollFunction();
    };
    $('[data-toggle="tooltip"]').tooltip();

    $("#emailtextparent").hide();
    $("#emailsendparent").hide();
    $("#scheduleTime").hide();
    $("#scheduleBtn").hide();
    $("#resetSchedule").hide();

    $("#emailtestparent").click(function () {
        $("#emailtextparent").show();
        $("#emailsendparent").show();
    });
    $("#emailsendparent").click(function () {
        if ($("#emailtextparent").val() === "") {
            displayMessage("Please enter an Email ID", "alert-info", "alert-danger");
            scrollToTop();
            return;
        }
        var emailIDs = $("#emailtextparent").val().replace(",", ";").replace("  ", "").split(";");
        for (i = 0; i < emailIDs.length; i++) {
            if (!validateEmail(emailIDs[i])) {
                displayMessage("Invalid Email Ids or invalid Email Seperator ...", "alert-info", "alert-danger");
                scrollToTop();
                return;
            }
        }

        $("#emailtextparent").hide();
        $("#emailsendparent").hide();
        displayMessage("Email Sent to " + $("#emailtextparent").val(), "alert-danger", "alert-info");
        $("#emailtextparent").val("");
        scrollToTop();
    });

    $("#initialsettingsave").click(function () {
        console.log('within save');
        $.ajax({url: "savehrconfig", method: "GET"})
                .done(function (data) {
                    if (data === false) {
                        displayMessage("Saved Initial Section", "alert-danger", "alert-info");
                    } else {
                        displayMessage("Could not save", "alert-info", "alert-danger");
//                        $("#restartreq").hide();
//                        $("#restartlater").hide();
                    }
                }).fail(function () {
                        displayMessage("Could not save", "alert-info", "alert-danger");
        });
        scrollToTop();
    });

    $("#restartreq").click(function () {
        $.ajax({url: "restartTomcatNow", method: "GET"})
                .done(function (data) {
                    if (data === false) {
                        displayMessage("Could not schedule task", "alert-info", "alert-danger");
                    } else {
                        displayMessage("Task Schedule successfully...", "alert-danger", "alert-info");
                        $("#restartreq").hide();
                        $("#restartlater").hide();
                    }
                }).fail(function () {
            displayMessage("Could not schedule task", "alert-info", "alert-danger");
        });
        scrollToTop();
    });

    $("#restartlater").click(function () {
        getDateTime();
        $(this).attr("disabled", "disabled");
        $("#restartreq").hide();
        $("#scheduleTime").show();
        $("#scheduleBtn").show();
        $("#resetSchedule").show();
    });

    $("#resetSchedule").click(function () {
        $(this).hide()
        $("#restartreq").show();
        $("#restartlater").removeAttr("disabled");
        $("#scheduleTime").hide();
        $("#scheduleBtn").hide();
    });

    $("#scheduleBtn").click(function () {
        timeValue = $("#scheduleTime").val();
        if (timeValue === "") {
            displayMessage("Please provide a time to schedule Restart", "alert-info", "alert-danger");
            scrollToTop();
            return false;
        }
        timeValue = Date.parse(timeValue);
        $.ajax({url: "restartTomcatLater", data: {"scheduledDate": timeValue}, method: "GET"})
                .done(function (data) {
                    if (data === false) {
                        displayMessage("Could not schedule task", "alert-info", "alert-danger");
                    } else {
                        displayMessage("Task Schedule successfully for " + new Date(timeValue), "alert-danger", "alert-info");
                        $("#scheduleTime").attr("disabled", "disabled");
                        $("#scheduleBtn").attr("disabled", "disabled");
                    }
                }).fail(function () {
            displayMessage("Could not schedule task", "alert-info", "alert-danger");
        });
        scrollToTop();
    });
    $("#openSideNav").click(function () {
        console.log("within side nav");
        openNav();
    });
    $("#closeSideNav").click(function () {
        console.log("within close side nav");
        closeNav();
    });
    $('.clickable').on('click', function () {
        closeNav();
    });


});
function displayTabdata(evt, tabName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
}
function displayMessage(message, removeClass, addClass) {
    var v = $("#dispMessage").is(":visible");
    if (!v)
        $("#dispMessage").fadeToggle("slow");
    $("#dispMessage").removeClass(removeClass).addClass(addClass);
    $("#dispMessage").html(message);
    return false;
}
function validateEmail(sEmail) {
    var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    if (filter.test(sEmail)) {
        return true;
    }
    return false;
}

function scrollToTop() {
    $("html, body").animate({scrollTop: 0}, "slow");
    return false;
}
function scrollFunction() {
    if ($(this).scrollTop() > 50) {
        $('#scrolBtn').fadeIn();
    } else {
        $('#scrolBtn').fadeOut();
    }
}
function openNav() {
    document.getElementById("auditSideNav").style.width = "50%";
}

function closeNav() {
    document.getElementById("auditSideNav").style.width = "0";
}

function getDateTime() {
    var now = new Date();
    var day = ("0" + now.getDate()).slice(-2);
    var month = ("0" + (now.getMonth() + 1)).slice(-2);
    var time = ("0" + now.getHours()).slice(-2) + ":" + ("0" + now.getMinutes()).slice(-2);
    var today = now.getFullYear() + "-" + (month) + "-" + (day) + "T" + time;
    $('#scheduleTime').val(today);
}