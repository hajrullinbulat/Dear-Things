$(document).ready(function () {

//автоматическая прокрутка карусели
    $(document).ready(function () {
        $('.carousel').carousel({
            interval: 2500
        })
    });
//вставка текста в поле при нажатии на него
    function telephone(tel) {
        $("#telephone").text(tel);
    }

//вставка текста в поле при нажатии на него
    function address(add) {
        $("#address").text(add);
    }

//вставка текста в поле при нажатии на него
    function delivery(del) {
        if (del == 'myself') {
            $("#delivery").text("Самовывоз");
        } else if (del == 'courier') {
            $("#delivery").text("Курьер");
        } else {
            $("#delivery").text("Почта");
        }
    }

//вставка текста в поле при нажатии на него
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

//валидность пароля
    $(document).on('blur', '.js_login_pass', function () {
        var user_pass_object = $("#log_pass");
        var user_pass = user_pass_object.val();

        if (user_pass == "") {
            $("#pre_log_pass").text("Ячейка пуста");
        } else if (!/.{8,15}/.test(user_pass)) {
            user_pass_object.val("");
            $("#pre_log_pass").text("От 8 до 15 символов");
        } else {
            $("#pre_log_pass").text("");
        }
    });

//валидность логина
    $(document).on('blur', '.js_login_email', function () {
        var user_email_object = $("#log_email");
        var user_email = user_email_object.val();
        var email_reg = /^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$/;

        if (user_email == "") {
            $("#pre_log_email").text("Ячейка пуста");
        } else if (!email_reg.test(user_email)) {
            user_email_object.val("");
            $("#pre_log_email").text("Введите корректный Email");
        } else {
            $("#pre_log_email").text("");
        }
    });
});

