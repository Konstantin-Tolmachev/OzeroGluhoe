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
    var tourId = $('#tourId').val();
    var myRoomId = $('#myRoomId').val();

    var days = $('#days').val();

    if( fname.length != 0 && lname.length != 0 && pname.length != 0 && phone.length == 16  &&
        tourId.length != 0 && myRoomId.length != 0 &&  days.length != 0) {

        $('#submit').removeAttr('disabled');
    } else {
        $('#submit').attr('disabled', 'disabled');
    }
}