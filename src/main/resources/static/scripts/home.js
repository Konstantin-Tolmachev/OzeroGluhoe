/* Функция для отодвигания меню на главной странице */
var element = document.getElementById('phone');
var maskOptions = {
    mask: '+7(000)000-00-00',
    lazy: false
}
var mask = new IMask(element, maskOptions);

/* Функция для отодвигания меню на главной странице */
function openMenu(){
    document.querySelector(".sidebar").classList.toggle('active');
}

/* Кнопка активная, если все поля заполнены */
function checkParams() {
    var fname = $('#fname').val();
    var lname = $('#lname').val();
    var pname = $('#pname').val();
    var phone = $('#phone').val();
    var dateIn = $('#dateIn').val();
    var dateOut = $('#dateOut').val();
    var korpus = $('#korpus').val();
    var myRoomId = $('#myRoomId').val();

    if( fname.length != 0 && lname.length != 0 && pname.length != 0 && phone.length == 16  &&
        dateIn.length != 0 && dateOut.length != 0 &&  korpus.length != 0 &&  myRoomId.length != 0) {

        $('#submit').removeAttr('disabled');
    } else {
        $('#submit').attr('disabled', 'disabled');
    }
}


var options = {
    era: 'long',
    year: 'numeric',
    month: 'numeric',
    day: 'numeric',
    weekday: 'long',
    timezone: 'Asia/Yekaterinburg',
    hour: 'numeric',
    minute: 'numeric',
    second: 'numeric'
};

var currentDate = new Date().toLocaleString("ru", options);
// console.log(currentDate)
var arrDate = currentDate.split(" ");
if (arrDate[2].length == 1)
{
    arrDate[2] = "0"+arrDate[2];
}
var today = arrDate[3].concat("-", arrDate[2], "-", arrDate[1]);
//var today = new Date().toISOString().split('T')[0];

document.getElementById("dateIn").setAttribute('min', today);

//var date = document.getElementById("dateIn").value;
//console.log(date);
//var today = new Date().toISOString().split('T')[0];
//document.getElementById("dateOut").setAttribute('min', date);

dateOut.onclick = function(){
    var dateIn = document.getElementById("dateIn").value;
    if (dateIn === "") {
        var today = new Date().toISOString().split('T')[0];
        document.getElementById("dateOut").setAttribute('min', today);
    }
    else
    {
        document.getElementById("dateOut").setAttribute('min', dateIn);
    }
}

function validate(evt) {
    var theEvent = evt || window.event;
    var key = theEvent.keyCode || theEvent.which;
    key = String.fromCharCode( key );
    var regex = /[1-2]|\./;
    if( !regex.test(key) && document.getElementById("korpus").value.length === 0 ) {
        theEvent.returnValue = false;
        if(theEvent.preventDefault) theEvent.preventDefault();
    }
    else if ((Number(document.getElementById("korpus").value) !== 1 || Number(document.getElementById("korpus").value) !== 2 ) && document.getElementById("korpus").value.length === 1) {
        document.getElementById("myRoomId").value = "";
    }
}

function validateRoom(evt) {
    var theEvent = evt || window.event;
    var key = theEvent.keyCode || theEvent.which;
    key = String.fromCharCode( key );
    var regex1 = /[2-4]|\./;
    var regex2 = /[0-1]|\./;
    var regex31 = /[0-9]|\./;
    var regex32 = /[0-4]|\./;
    var regex4 = /[1-3]|\./;
    var regex5 = /[0-2]|\./;
    var regex61 = /[0-9]|\./;
    var regex62 = /[0-2]|\./;
    //console.log(document.getElementById("myRoomId").value.length);
    if( !regex1.test(key) && document.getElementById("myRoomId").value.length === 0 && document.getElementById("korpus").value === "1") {
        theEvent.returnValue = false;
        if(theEvent.preventDefault) theEvent.preventDefault();
    }
    else if( !regex2.test(key) && document.getElementById("myRoomId").value.length === 1 && document.getElementById("korpus").value === "1") {
        theEvent.returnValue = false;
        if(theEvent.preventDefault) theEvent.preventDefault();
    }
    else if( !regex31.test(key) && document.getElementById("myRoomId").value.length === 2 && document.getElementById("myRoomId").value.indexOf("0") === 1 && document.getElementById("korpus").value === "1") {
        theEvent.returnValue = false;
        if(theEvent.preventDefault) theEvent.preventDefault();
    }
    else if( !regex32.test(key) && document.getElementById("myRoomId").value.length === 2 && document.getElementById("myRoomId").value.indexOf("1") === 1 && document.getElementById("korpus").value === "1") {
        theEvent.returnValue = false;
        if(theEvent.preventDefault) theEvent.preventDefault();
    }
    else if( !regex4.test(key) && document.getElementById("myRoomId").value.length === 0 && document.getElementById("korpus").value === "2") {
        theEvent.returnValue = false;
        if(theEvent.preventDefault) theEvent.preventDefault();
    }
    else if( !regex5.test(key) && document.getElementById("myRoomId").value.length === 1 && document.getElementById("korpus").value === "2") {
        theEvent.returnValue = false;
        if(theEvent.preventDefault) theEvent.preventDefault();
    }
    else if( !regex61.test(key) && document.getElementById("myRoomId").value.length === 2 && (document.getElementById("myRoomId").value.indexOf("0") === 1 || document.getElementById("myRoomId").value.indexOf("1") === 1) && document.getElementById("korpus").value === "2") {
        theEvent.returnValue = false;
        if(theEvent.preventDefault) theEvent.preventDefault();
    }
    else if( !regex62.test(key) && document.getElementById("myRoomId").value.length === 2 && document.getElementById("myRoomId").value.indexOf("2",1) === 1 && document.getElementById("korpus").value === "2") {
        theEvent.returnValue = false;
        if(theEvent.preventDefault) theEvent.preventDefault();
    }
    else if (document.getElementById("korpus").value === ""){
        theEvent.returnValue = false;
    }
}

/*По нажатию на корпус отркывается окошко*/
function toggle(elements) {

    var divElem = document.querySelectorAll(elements);
    divElem.forEach((e)=>{
        e.classList.toggle('closed')
    })
}




//
// var dateIn = document.getElementById("dateIn").value;
// var today = new Date().toISOString().split('T')[0];
// document.getElementById("dateIn").setAttribute('min', today);
//
// var dateOut = document.getElementById("dateOut").value;
// var today = new Date().toISOString().split('T')[0];
// document.getElementById("dateOut").setAttribute('min', today);
//
//
//
// var dateOut = document.getElementById("dateOut").value;
// var day = new Date().toISOString().split('T')[0];
//
// document.getElementById("dateOut").setAttribute('min', today);
// //
// function validate(evt) {
//     var theEvent = evt || window.event;
//     var key = theEvent.keyCode || theEvent.which;
//     key = String.fromCharCode( key );
//     var regex = /[1-2]|\./;
//     if( !regex.test(key) ) {
//         theEvent.returnValue = false;
//         if(theEvent.preventDefault) theEvent.preventDefault();
//     }
// }





    // function validateRoom(evtm) {
    //     var theEventRoom = evtm || window.event;
    //     var keyRoom = theEventRoom.keyCode || theEvent.which;
    //     key = String.fromCharCode( keyRoom );
    //     var regexRoom = /[1-500]|\./;
    //     if( !regexRoom.test(keyRoom) ) {
    //         theEventRoom.returnValue = false;
    //         if(theEventRoom.preventDefault) theEventRoom.preventDefault();
    //     }
    // }

//
// var dateOut = document.getElementById("dateOut").value;
// //var today = new Date().toISOString().split('T')[0];
// document.getElementById("dateOut").setAttribute('min', dateIn);



/*
function endAfterStart(start, end) {
    var DateIn = new Date(start);
    var DateOut   = new Date(end);

    return DateOut.getTime() >= DateIn.getTime();
}
if ($(window).width() > 700) {
    $('#DateIn, #contact-DateIn').datepicker({
        minDate: '0M',
        numberOfMonths: 2,
        dateFormat: 'dd M yy',
        onSelect: function (dateText, inst) {
            $('#DateOut, #contact-DateOut').datepicker("option", "minDate", dateText);
        }
    });
    $('#DateOut, #contact-DateOut').datepicker({
        numberOfMonths: 2,
        minDate: 0,
        dateFormat: 'dd M yy'
    });
}
else {
    $('#DateIn, #contact-DateIn').datepicker({
        minDate: '0M',
        numberOfMonths: 1,
        dateFormat: 'dd M yy',
        onSelect: function (dateText, inst) {
            $('#DateOut, #contact-DateOut').datepicker("option", "minDate", dateText);
        }
    });
    $('#DateOut, #contact-DateOut').datepicker({
        numberOfMonths: 1,
        minDate: 0,
        dateFormat: 'dd M yy'
    });
}
*/
