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
            alert('Приносим извинения. На сервере произошла ошибка');
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
                    document.location.href = 'http://localhost:8080/edit';
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

$(document).on('click', '.js_edit', function () {
    event.preventDefault();
    var hasError = false;

    var user_edit_name = $("#user_edit_name").val();
    var user_edit_avatar = $("#user_edit_avatar").val();
    var user_edit_telephone = $("#user_edit_telephone").val();
    var user_edit_address = $("#user_edit_address").val();
    var user_edit_oldpass = $("#user_edit_oldpass").val();
    var user_edit_newpass = $("#user_edit_newpass").val();

    var name_reg = /^([A-Z][a-z]{1,15}\s[A-Z][a-z]{1,15})|([А-Я][а-я]{1,15}\s[А-Я][а-я]{1,15})$/;
    var telephone_reg = /^((8|\+7)[\- ]?)?(\(?\d{3}\)?[\- ]?)?[\d\- ]{7,10}$/;

    if (user_edit_name == "" && user_edit_avatar == "" && user_edit_telephone == "" &&
        user_edit_address == "" && user_edit_oldpass == "" && user_edit_newpass == "") {
        hasError = true;
    } else {
        if (user_edit_name != "") {
            if (!name_reg.test(user_edit_name)) {
                hasError = true;
                $("#pre_edit_name").text("Формат: Костя Косточкин");
                $("#user_edit_name").val("");
            } else {
                $("#pre_edit_name").text("");
            }
        }
        if (user_edit_telephone != "") {
            if (!telephone_reg.test(user_edit_telephone)) {
                hasError = true;
                $("#pre_edit_telephone").text("Введите корректный телефон");
                $("#user_edit_telephone").val("");
            } else {
                $("#pre_edit_telephone").text("");
            }
        }
        if (user_edit_oldpass == "" && user_edit_newpass != "") {
            $("#pre_edit_oldpass").text("Ячейка пуста")
        }
        if (user_edit_oldpass != "" && user_edit_newpass == "") {
            $("#pre_edit_newpass").text("Ячейка пуста")
        }
        if (user_edit_oldpass != "" && user_edit_newpass != "") {
            if (!/.{8,15}/.test(user_edit_oldpass)) {
                $("#user_edit_oldpass").val("");
                hasError = true;
                $("#pre_edit_oldpass").text("От 8 до 15 символов");
            } else {
                $("#pre_edit_oldpass").text("");
            }
            if (!/.{8,15}/.test(user_edit_newpass)) {
                $("#user_edit_newpass").val("");
                hasError = true;
                $("#pre_edit_newpass").text("От 8 до 15 символов");
            } else {
                $("#pre_edit_newpass").text("");
            }
        }
    }

    if (!hasError) {
        $.ajax({
            type: 'POST',
            url: '/edit',
            data: {
                userEditName: user_edit_name, userEditAvatar: user_edit_avatar,
                userEditTelephone: user_edit_telephone, userEditAddress: user_edit_address,
                userEditOldPass: user_edit_oldpass, userEditNewPass: user_edit_newpass
            },
            success: function (data) {
                if (data.indexOf('name') + 1) {
                    $("#pre_name_success").text("Имя и фамилия успешно изменены");
                }
                if (data.indexOf('avatar') + 1) {
                    $("#pre_avatar_success").text("Аватар успешно изменен");
                }
                if (data.indexOf('tel') + 1) {
                    $("#pre_tel_success").text("Телефон успешно добавлен");
                }
                if (data.indexOf('address') + 1) {
                    $("#pre_address_success").text("Адрес успешно добавлен");
                }
                if (data.indexOf('pass') + 1) {
                    $("#pre_pass_success").text("Пароль успешно изменен");
                }
                if (data.indexOf('fail') + 1) {
                    $("#pre_edit_oldpass").text("Пароль не совпал");
                }
            },
            error: function () {
                alert('Приносим извинения. На сервере произошла ошибка');
            }
        });
    }
});


$(document).on('blur', '.js_changeCount', function () {
    event.preventDefault();
    var $this = $(this);
    var cart_to_change = $this.data('cart_to_change');
    var count = $this.data('count');
    var change_count = $("#count_value" + cart_to_change).val();
    if (change_count >= 0) {
        $.ajax({
            type: 'POST',
            url: '/cart/change',
            data: {cartId: cart_to_change, count: change_count},
            success: function (data) {
                if (data == 'ok') {
                    $("#count_value" + cart_to_change).val(change_count);
                } else
                    $(".cart" + cart_to_change).hide();
            },
            error: function () {
                alert('Приносим извинения.<br/>На сервере произошла ошибка');
            }
        });
    } else {
        $("#count_value" + cart_to_change).val(count)
    }
});

$(document).on('click', '.js_changeCountForward', function () {
    event.preventDefault();
    var $this = $(this);
    var cart_to_change = $this.data('cart_to_change');
    var count = $("#count_value" + cart_to_change).val();
    $.ajax({
        type: 'POST',
        url: '/cart/change_forward',
        data: {cartId: cart_to_change, count: Number(count) + 1},
        success: function (data) {
            if (data == 'ok') {
                $("#count_value" + cart_to_change).val(Number(count) + 1);
            }
        },
        error: function () {
            alert('Приносим извинения.<br/>На сервере произошла ошибка');
        }
    });
});

$(document).on('click', '.js_changeCountBack', function () {
    event.preventDefault();
    var $this = $(this);
    var cart_to_change = $this.data('cart_to_change');
    var count = $("#count_value" + cart_to_change).val();
    $.ajax({
        type: 'POST',
        url: '/cart/change_forward',
        data: {cartId: cart_to_change, count: Number(count) - 1},
        success: function (data) {
            if (data == 'ok') {
                $("#count_value" + cart_to_change).val(Number(count) - 1);
            }
        },
        error: function () {
            alert('Приносим извинения.<br/>На сервере произошла ошибка');
        }
    });
});

