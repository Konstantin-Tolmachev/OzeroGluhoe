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
//
// var dateIn = document.getElementById("dateIn").value;
// var today = new Date().toISOString().split('T')[0];
// document.getElementById("dateIn").setAttribute('min', today);
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
//     var regex = /[1-3]|\./;
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