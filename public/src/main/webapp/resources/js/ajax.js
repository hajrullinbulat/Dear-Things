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
            swal({
                title: 'Извините, произошла ошибка на сервере!',
                type: 'error',
                showConfirmButton: false,
                timer: 3000
            })
        }
    });
});

$(document).on('click', '.js_order_cancel', function () {
    event.preventDefault();
    var $this = $(this);
    var id = $this.data('order');
    $.ajax({
        type: 'POST',
        url: '/order/delete',
        data: {orderId: id},
        success: function (data) {
            if (data == 'ok') {
                $("#order" + id).hide();
            }
        },
        error: function () {
            swal({
                title: 'Извините, произошла ошибка на сервере!',
                type: 'error',
                showConfirmButton: false,
                timer: 3000
            })
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
        success: function (data) {
            swal({
                title: 'Добавлено в корзину!',
                type: 'success',
                showConfirmButton: false,
                timer: 1000
            })
        },
        error: function () {
            swal({
                title: 'Извините, произошла ошибка на сервере!',
                type: 'error',
                showConfirmButton: false,
                timer: 3000
            })
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
                    swal({
                        title: 'Вы успешно зарегестрированы!',
                        type: 'success',
                        showConfirmButton: false,
                        timer: 2000
                    });
                    setTimeout("document.location.href='http://localhost:8080/'", 2000);
                } else if (data == 'failed') {
                    $("#pre_email").text("Этот Email уже используется");
                    $("#user_email").val("");
                }
            },
            error: function () {
                swal({
                    title: 'Извините, произошла ошибка на сервере!',
                    type: 'error',
                    showConfirmButton: false,
                    timer: 3000
                })
            }
        });
    }
});

$(document).on('blur', '.js_login_email', function () {
    var user_email = $("#log_email").val();
    var email_reg = /^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$/;

    if (user_email == "") {
        $("#pre_log_email").text("Ячейка пуста");
    } else if (!email_reg.test(user_email)) {
        $("#log_email").val("");
        $("#pre_log_email").text("Введите корректный Email");
    } else {
        $("#pre_log_email").text("");
    }
});

$(document).on('blur', '.js_login_pass', function () {
    var user_pass = $("#log_pass").val();

    if (user_pass == "") {
        $("#pre_log_pass").text("Ячейка пуста");
    } else if (!/.{8,15}/.test(user_pass)) {
        $("#log_pass").val("");
        $("#pre_log_pass").text("От 8 до 15 символов");
    } else {
        $("#pre_log_pass").text("");
    }
});


$(document).on('blur', '.js_edit_name', function () {
    event.preventDefault();
    var hasError = false;
    var user_edit_name = $("#user_edit_name").val();
    var name_reg = /^([A-Z][a-z]{1,15}\s[A-Z][a-z]{1,15})|([А-Я][а-я]{1,15}\s[А-Я][а-я]{1,15})$/;

    if (user_edit_name == "") {
        hasError = true;
    } else if (!name_reg.test(user_edit_name)) {
        hasError = true;
        $("#pre_edit_name").text("Формат: Костя Косточкин");
        $("#pre_name_success").text("");
        $("#user_edit_name").val("");
    } else {
        $("#pre_edit_name").text("");
    }

    if (!hasError) {
        $.ajax({
            type: 'POST',
            url: '/edit_name',
            data: {userEditName: user_edit_name},
            success: function (data) {
                $("#name").text(user_edit_name);
                $("#pre_name_success").text("Имя и фамилия успешно изменены");
            },
            error: function () {
                swal({
                    title: 'Извините, произошла ошибка на сервере!',
                    type: 'error',
                    showConfirmButton: false,
                    timer: 3000
                })
            }
        });
    }
});

$(document).on('blur', '.js_edit_avatar', function () {
    event.preventDefault();
    var hasError = false;
    var user_edit_avatar = $("#user_edit_avatar").val();
    if (user_edit_avatar != "") {
        $.ajax({
            type: 'POST',
            url: '/edit_avatar',
            data: {userEditAvatar: user_edit_avatar},
            success: function (data) {
                $("#pre_avatar_success").text("Аватар успешно изменен");
                $("#photo").text("");
            },
            error: function () {
                swal({
                    title: 'Извините, произошла ошибка на сервере!',
                    type: 'error',
                    showConfirmButton: false,
                    timer: 3000
                })
            }
        });
    }

});

$(document).on('blur', '.js_edit_telephone', function () {
    event.preventDefault();
    var hasError = false;
    var user_edit_telephone = $("#user_edit_telephone").val();
    var telephone_reg = /^((8|\+7)[\- ]?)?(\(?\d{3}\)?[\- ]?)?[\d\- ]{7,10}$/;

    if (user_edit_telephone == "") {
        hasError = true;
    } else if (!telephone_reg.test(user_edit_telephone)) {
        hasError = true;
        $("#pre_edit_telephone").text("Введите корректный телефон");
        $("#pre_tel_success").text("");
        $("#user_edit_telephone").val("");
    } else {
        $("#pre_edit_telephone").text("");
    }
    if (!hasError) {
        $.ajax({
            type: 'POST',
            url: '/edit_telephone',
            data: {userEditTelephone: user_edit_telephone},
            success: function (data) {
                $("#pre_tel_success").text("Телефон успешно добавлен");
            },
            error: function () {
                swal({
                    title: 'Извините, произошла ошибка на сервере!',
                    type: 'error',
                    showConfirmButton: false,
                    timer: 3000
                })
            }
        });
    }


});

$(document).on('blur', '.js_edit_address', function () {
    event.preventDefault();
    var hasError = false;
    var user_edit_address = $("#user_edit_address").val();

    if (user_edit_address != "") {
        $.ajax({
            type: 'POST',
            url: '/edit_address',
            data: {userEditAddress: user_edit_address},
            success: function (data) {
                $("#pre_address_success").text("Адрес успешно добавлен");
            },
            error: function () {
                swal({
                    title: 'Извините, произошла ошибка на сервере!',
                    type: 'error',
                    showConfirmButton: false,
                    timer: 3000
                })
            }
        });
    }
});

$(document).on('blur', '.js_edit_password', function () {
    event.preventDefault();
    var hasError = false;

    var user_edit_oldpass = $("#user_edit_oldpass").val();
    var user_edit_newpass = $("#user_edit_newpass").val();

    if (user_edit_oldpass == "" && user_edit_newpass == "") {
        hasError = true;
    } else {
        if (user_edit_oldpass == "" && user_edit_newpass != "") {
            $("#pre_edit_oldpass").text("Ячейка пуста");
            $("#pre_pass_success").text("");
            $("#user_edit_newpass").val("");
        }
        if (user_edit_oldpass != "" && user_edit_newpass == "") {
            $("#pre_edit_newpass").text("Ячейка пуста");
            $("#pre_pass_success").text("");
            $("#user_edit_oldpass").val("");

        }
        if (user_edit_oldpass != "" && user_edit_newpass != "") {
            if (!/.{8,15}/.test(user_edit_oldpass)) {
                $("#user_edit_oldpass").val("");
                $("#user_edit_newpass").val("");
                $("#pre_pass_success").text("");
                hasError = true;
                $("#pre_edit_oldpass").text("От 8 до 15 символов");
            } else {
                $("#pre_edit_oldpass").text("");
            }
            if (!/.{8,15}/.test(user_edit_newpass)) {
                $("#user_edit_newpass").val("");
                $("#user_edit_oldpass").val("");
                hasError = true;
                $("#pre_edit_newpass").text("От 8 до 15 символов");
                $("#pre_pass_success").text("");
            } else {
                $("#pre_edit_newpass").text("");
            }
        }
    }

    if (!hasError) {
        $.ajax({
            type: 'POST',
            url: '/edit_pass',
            data: {userEditOldPass: user_edit_oldpass, userEditNewPass: user_edit_newpass},
            success: function (data) {
                if (data == 'ok') {
                    $("#pre_pass_success").text("Пароль успешно изменен");
                } else {
                    $("#pre_edit_oldpass").text("Пароль не совпал");
                    $("#pre_pass_success").text("");
                }
                $("#user_edit_newpass").val("");
                $("#user_edit_oldpass").val("");
            },
            error: function () {
                swal({
                    title: 'Извините, произошла ошибка на сервере!',
                    type: 'error',
                    showConfirmButton: false,
                    timer: 3000
                })
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
                swal({
                    title: 'Извините, произошла ошибка на сервере!',
                    type: 'error',
                    showConfirmButton: false,
                    timer: 3000
                })
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
        url: '/cart/change',
        data: {cartId: cart_to_change, count: Number(count) + 1},
        success: function (data) {
            $("#count_value" + cart_to_change).val(Number(count) + 1);
        },
        error: function () {
            swal({
                title: 'Извините, произошла ошибка на сервере!',
                type: 'error',
                showConfirmButton: false,
                timer: 3000
            })
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
        url: '/cart/change',
        data: {cartId: cart_to_change, count: Number(count) - 1},
        success: function (data) {
            $("#count_value" + cart_to_change).val(Number(count) - 1);
            if (count == 1) {
                $(".cart" + cart_to_change).hide();
            }
        },
        error: function () {
            swal({
                title: 'Извините, произошла ошибка на сервере!',
                type: 'error',
                showConfirmButton: false,
                timer: 3000
            })
        }
    });
});

$(document).on('click', '.js_order', function () {
    event.preventDefault();
    var telephone = $("#telephone").text();
    var address = $("#address").text();
    var delivery = $("#delivery").text();
    var payment = $("#payment").text();
    if (telephone != '?' && address != '?' && delivery != '?' && payment != '?') {
        $.ajax({
            type: 'POST',
            url: '/order',
            data: {telephone: telephone, address: address, delivery: delivery, payment: payment},
            success: function (data) {
                swal({
                    title: 'Заказ оформлен!',
                    type: 'success',
                    showConfirmButton: false,
                    timer: 2000
                });
                setTimeout("document.location.href='http://localhost:8080/profile'", 2000);
            },
            error: function () {
                swal({
                    title: 'Извините, произошла ошибка на сервере!',
                    type: 'error',
                    showConfirmButton: false,
                    timer: 3000
                })
            }
        });
    } else {
        swal({
            title: 'Пожалуйста, заполните все поля :(',
            type: 'error',
            showConfirmButton: false,
            timer: 2000
        })
    }
});







