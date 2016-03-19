$(document).on('click', '.js_deleteFromCart', function () {
    event.preventDefault();
    var $this = $(this);
    var id = $this.data('cart');
    $.ajax({
        type: 'POST',
        url: '/cart/delete',
        data: {cartId: id},
        success: function (data) {
            if (data == 'ok') {
                $(".cart" + id).hide();
            }
        },
        error: function () {
            alert('Приносим извинения.<br/>На сервере произошла ошибка');
        }
    });
});

$(document).on('click', '.js_addToCart', function () {
    event.preventDefault();
    var $this = $(this);
    $.ajax({
        type: 'POST',
        url: '/cart/add',
        data: {goodId: $this.data('id')},
        error: function () {
            alert('Приносим извинения.<br/>На сервере произошла ошибка');
        }
    });
});

$(document).on('click', '.js_check', function () {
    event.preventDefault();
    var $this = $(this);
    var hasError = false;

    var user_name = $("#user_name").val();
    var user_email = $("#user_email").val();
    var user_pass = $("#user_pass").val();
    var user_pass_again = $("#user_pass_again").val();

    var email_reg = /^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$/;
    var name_reg = /^([A-Z][a-z]{1,15}\s[A-Z][a-z]{1,15})|([А-Я][а-я]{1,15}\s[А-Я][а-я]{1,15})$/;

    if (user_name == "") {
        hasError = true;
        $("#pre_name").text("Ячейка пуста");
    } else if (!name_reg.test(user_name)) {
        hasError = true;
        $("#pre_name").text("Формат: Костя Косточкин");
        $("#user_name").val("");
    } else {
        $("#pre_name").text("");
    }

    if (user_email == "") {
        hasError = true;
        $("#pre_email").text("Ячейка пуста");
    } else if (!email_reg.test(user_email)) {
        hasError = true;
        $("#pre_email").text("Введите корректный Email");
    } else {
        $("#pre_email").text("");
    }
    if (user_pass == "" || user_pass_again == "") {
        hasError = true;
        $("#pre_pass").text("Ячейка пуста");
    } else if (user_pass != user_pass_again) {
        hasError = true;
        $("#pre_pass").text("Пароли не совпадают");

        $("#user_pass").val("");
        $("#user_pass_again").val("");
    } else if (!/.{8,15}/.test(user_pass)) {
        $("#user_pass").val("");
        $("#user_pass_again").val("");
        hasError = true;
        $("#pre_pass").text("От 8 до 15 символов");
    } else {
        $("#pre_pass").text("");
    }

    if (!hasError) {
        $.ajax({
            type: 'POST',
            url: '/signup',
            data: {userName: user_name, userEmail: user_email, userPass: user_pass},
            success: function (data) {
                if (data == 'ok') {
                    alert("Вы успешно зарегестрированы");
                    document.location.href = 'http://localhost:8080/catalog/1';
                } else if (data == 'failed') {
                    $("#pre_email").text("Этот Email уже используется");
                    $("#user_email").val("");
                }
            },
            error: function () {
                alert('Приносим извинения.<br/>На сервере произошла ошибка');
            }
        });
    }
});

$(document).on('click', '.js_login', function () {
    event.preventDefault();
    var $this = $(this);
    var user_email = $("#log_email").val();
    var user_pass = $("#log_pass").val();
    var hasError = false;
    var email_reg = /^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$/;

    if (user_email == "") {
        hasError = true;
        $("#pre_log_email").text("Ячейка пуста");
    } else if (!email_reg.test(user_email)) {
        hasError = true;
        $("#pre_log_email").text("Введите корректный Email");
    } else {
        $("#pre_log_email").text("");
    }

    if (user_pass == "") {
        hasError = true;
        $("#pre_log_pass").text("Ячейка пуста");
    } else if (!/.{8,15}/.test(user_pass)) {
        $("#log_pass").val("");
        hasError = true;
        $("#pre_log_pass").text("От 8 до 15 символов");
    } else {
        $("#pre_log_pass").text("");
    }


    if (!hasError) {
        $.ajax({
            type: 'POST',
            url: '/login',
            data: {userEmail: user_email, userPass: user_pass},
            success: function (data) {
                if (data == 'ok') {
                    alert("Вы успешно вошли в ЛК");
                    document.location.href = 'http://localhost:8080/catalog/1';
                } else if (data == 'failed') {
                    $("#pre_log_email").text("Неправильный логин или пароль");
                    $("#log_email").val("");
                    $("#log_pass").val("");

                }
            },
            error: function () {
                alert('Приносим извинения.<br/>На сервере произошла ошибка');
            }
        });
    }
});


