$(document).ready(function () {
    $('.carousel').carousel({
        interval: 2500
    })
});

function telephone(tel) {
    $("#telephone").text(tel);
}

function address(add) {
    $("#address").text(add);
}

function delivery(del) {
    if (del == 'myself') {
        $("#delivery").text("Самовывоз");
    } else if (del == 'courier') {
        $("#delivery").text("Курьер");
    } else {
        $("#delivery").text("Почта");
    }
}

function payment(pay) {
    if (pay == 'money') {
        $("#payment").text("При получении");
    } else
        $("#payment").text("Предоплата")
}

function log_error() {
    swal({
        title: 'Введен неверный логин или пароль!',
        text: 'Или аккаунт еще не активирован',
        type: 'error',
        showConfirmButton: false,
        timer: 3000
    })
}

function error() {
    swal({
        title: 'Извините, произошла ошибка на сервере!',
        type: 'error',
        showConfirmButton: false,
        timer: 3000
    })
}





//$(window).scroll(function () {
//    if ($(window).scrollTop() + $(window).height() > $(document).height() - 100) {
//        alert("near bottom!");
//
//    }
//});

