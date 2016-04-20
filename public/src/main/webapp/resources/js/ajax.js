$(document).ready(function () {

    $(document).on('click', '.js_deleteFromCart', function () {
        event.preventDefault();
        var $this = $(this);
        var id = $this.data('cart');
        var price = $this.data('price');
        var countOfItem = $('#count_value' + id).val();
        var sum_object = $("#sum");
        var count_object = $("#count");
        $.ajax({
            type: 'POST',
            url: '/cart/delete',
            data: {cartId: id},
            success: function (data) {
                $(".cart" + id).hide();
                var sum = sum_object.text();
                var count = count_object.text();
                var new_count = parseInt(count) - countOfItem;
                sum_object.text(parseInt(sum) - (price * countOfItem));
                count_object.text(new_count);
                if (new_count == 0) {
                    $("#cart_order").hide();
                    $("#cart_none").text("но сейчас она пуста :(");
                }
            },
            error: function () {
                error();
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
                error();
            }
        });
    });

//подтверждение на отмену заказа
    function order_cancel(order_id) {
        event.preventDefault();
        swal({
            title: 'Вы уверены?',
            text: "Операция необратима",
            type: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#F88B8B',
            cancelButtonColor: '#7FD57B',
            confirmButtonText: 'Да, удалить заказ!',
            cancelButtonText: 'Отменить!',
            confirmButtonClass: 'btn btn-success',
            cancelButtonClass: 'btn btn-danger',
            closeOnConfirm: false,
            closeOnCancel: false
        }).then(function (isConfirm) {
            if (isConfirm === true) {
                $.ajax({
                    type: 'POST',
                    url: '/order/delete',
                    data: {orderId: order_id},
                    success: function (data) {
                        $("#order" + order_id).hide();
                        swal({
                            title: 'Заказ удалён!',
                            type: 'success',
                            showConfirmButton: false,
                            timer: 1000
                        })
                    },
                    error: function () {
                        error();
                    }
                });
            } else if (isConfirm === false) {
                swal({
                    title: 'Отменено!',
                    type: 'error',
                    showConfirmButton: false,
                    timer: 1000
                });
            }
        });
    }

//больше товаров
    $(document).on('click', '#more', function () {
        var $this = $(this);
        var page = $this.data('page'),
            limit = $this.data('limit');
        $.ajax({
            type: "POST",
            url: "/catalog/more",
            data: {
                limit: limit,
                page: page
            }
        }).done(function (data) {
            if (data != '') {
                $("#itemsList").append(data);
                updateCounter();
            } else {
                $this.hide();
            }
        }).fail(function () {
            error();
        });
        //отображение числа оставшихся либо скрывание элемента "more"
        function updateCounter() {
            $this.data('page', page + 1);
            var $goodsCount = $('#goods_count');
            var goodsCount = parseInt($goodsCount.text());
            if (goodsCount > limit) {
                $goodsCount.text(goodsCount - limit);
                $('#goods_limit').text(Math.min(limit, goodsCount - limit))
            } else {
                $('.loader').hide();
            }
        }
    });

//проверка валидности при регистрации
    $(document).on('click', '.js_check', function () {
        event.preventDefault();
        var $this = $(this);
        var hasError = false;

        var user_name_object = $("#user_name");
        var user_pass_object = $("#user_pass");
        var user_pass_again_object = $("#user_pass_again");

        var user_name = user_name_object.val();
        var user_email = $("#user_email").val();
        var user_pass = user_pass_object.val();
        var user_pass_again = user_pass_again_object.val();

        var email_reg = /^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$/;
        var name_reg = /^([A-Z][a-z]{1,15}\s[A-Z][a-z]{1,15})|([А-Я][а-я]{1,15}\s[А-Я][а-я]{1,15})$/;

        if (user_name == "") {
            hasError = true;
            $("#pre_name").text("Ячейка пуста");
        } else if (!name_reg.test(user_name)) {
            hasError = true;
            $("#pre_name").text("Формат: Костя Косточкин");
            user_name_object.val("");
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
            user_pass_object.val("");
            user_pass_again_object.val("");
        } else if (!/.{8,15}/.test(user_pass)) {
            user_pass_object.val("");
            user_pass_again_object.val("");
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
                            text: 'Письмо, для подтверждения аккаунта, было выслано Вам на почту!',
                            type: 'success',
                            showConfirmButton: false,
                            timer: 3000
                        });
                        setTimeout("document.location.href='http://localhost:8080/'", 3000);
                    } else if (data == 'failed') {
                        $("#pre_email").text("Этот Email уже используется");
                        $("#user_email").val("");
                    }
                },
                error: function () {
                    error();
                }
            });
        }
    });

    $(document).on('blur', '.js_edit_name', function () {
        event.preventDefault();
        var hasError = false;
        var user_edit_name_object = $("#user_edit_name");
        var user_edit_name = user_edit_name_object.val();
        var name_reg = /^([A-Z][a-z]{1,15}\s[A-Z][a-z]{1,15})|([А-Я][а-я]{1,15}\s[А-Я][а-я]{1,15})$/;

        if (user_edit_name == "") {
            hasError = true;
        } else if (!name_reg.test(user_edit_name)) {
            hasError = true;
            $("#pre_edit_name").text("Формат: Костя Косточкин");
            $("#pre_name_success").text("");
            user_edit_name_object.val("");
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
                    $("#user_edit_name").val("");
                },
                error: function () {
                    error();
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
                    $("#user_edit_avatar").val();
                },
                error: function () {
                    error();
                }
            });
        }

    });

    $(document).on('blur', '.js_edit_telephone', function () {
        event.preventDefault();
        var hasError = false;
        var user_edit_tel_object = $("#user_edit_telephone");
        var user_edit_telephone = user_edit_tel_object.val();
        var telephone_reg = /^((8|\+7)[\- ]?)?(\(?\d{3}\)?[\- ]?)?[\d\- ]{7,10}$/;

        if (user_edit_telephone == "") {
            hasError = true;
        } else if (!telephone_reg.test(user_edit_telephone)) {
            hasError = true;
            $("#pre_edit_telephone").text("Введите корректный телефон");
            $("#pre_tel_success").text("");
            user_edit_tel_object.val("");
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
                    $("#user_edit_telephone").val("");
                },
                error: function () {
                    error();
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
                    $("#user_edit_address").val("");
                },
                error: function () {
                    error();
                }
            });
        }
    });

    $(document).on('blur', '.js_edit_password', function () {
        event.preventDefault();
        var hasError = false;

        var oldpass_object = $("#user_edit_oldpass");
        var newpass_object = $("#user_edit_newpass");

        var user_edit_oldpass = oldpass_object.val();
        var user_edit_newpass = newpass_object.val();

        if (user_edit_oldpass == "" && user_edit_newpass == "") {
            hasError = true;
        } else {
            if (user_edit_oldpass == "" && user_edit_newpass != "") {
                $("#pre_edit_oldpass").text("Ячейка пуста");
                $("#pre_pass_success").text("");
                newpass_object.val("");
            }
            if (user_edit_oldpass != "" && user_edit_newpass == "") {
                $("#pre_edit_newpass").text("Ячейка пуста");
                $("#pre_pass_success").text("");
                oldpass_object.val("");

            }
            if (user_edit_oldpass != "" && user_edit_newpass != "") {
                if (!/.{8,15}/.test(user_edit_oldpass)) {
                    oldpass_object.val("");
                    newpass_object.val("");
                    $("#pre_pass_success").text("");
                    hasError = true;
                    $("#pre_edit_oldpass").text("От 8 до 15 символов");
                } else {
                    $("#pre_edit_oldpass").text("");
                }
                if (!/.{8,15}/.test(user_edit_newpass)) {
                    newpass_object.val("");
                    oldpass_object.val("");
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
                    var new_pass_object = $("#user_edit_newpass");
                    var old_pass_object = $("#user_edit_oldpass");
                    if (data == 'ok') {
                        $("#pre_pass_success").text("Пароль успешно изменен");
                        new_pass_object.val("");
                        old_pass_object.val("");
                    } else {
                        $("#pre_edit_oldpass").text("Пароль не совпал");
                        $("#pre_pass_success").text("");
                    }
                    new_pass_object.val("");
                    old_pass_object.val("");
                },
                error: function () {
                    error();
                }
            });
        }
    });

//"забыли пароль"
    $(document).on('click', '.js_forgot', function () {
        event.preventDefault();
        var hasError = false;

        var user_email_forgot_object = $("#user_email_forgot");

        var user_email = user_email_forgot_object.val();
        var email_reg = /^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$/;

        if (user_email == "") {
            $("#pre_email_forgot").text("Ячейка пуста");
            hasError = true;
        } else if (!email_reg.test(user_email)) {
            user_email_forgot_object.val("");
            $("#pre_email_forgot").text("Введите корректный Email");
            hasError = true;
        } else {
            $("#pre_email_forgot").text("");
        }

        if (!hasError) {
            $.ajax({
                type: 'POST',
                url: '/forgot',
                data: {email: user_email},
                success: function (data) {
                    if (data == 'ok') {
                        swal({
                            title: 'Пароль был выслан на почту!',
                            type: 'success',
                            showConfirmButton: false,
                            timer: 2000
                        });
                        setTimeout("document.location.href='http://localhost:8080/'", 2000);
                    } else if (data == 'failed') {
                        swal({
                            title: 'Неверный email!',
                            type: 'error',
                            showConfirmButton: false,
                            timer: 2000
                        });
                    }
                },
                error: function () {
                    error();
                }
            });
        }
    });

//повторная отправка письма на почту, если оно не пришло
    $(document).on('click', '.js_activation', function () {
        event.preventDefault();
        var hasError = false;

        var user_pass_activ_object = $("#user_pass_activ");

        var user_email = $("#user_email_activ").val();
        var user_pass = user_pass_activ_object.val();
        var email_reg = /^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$/;

        if (user_email == "") {
            $("#pre_email_forgot").text("Ячейка пуста");
            hasError = true;
        } else if (!email_reg.test(user_email)) {
            $("#user_email_forgot").val("");
            $("#pre_email_forgot").text("Введите корректный Email");
            hasError = true;
        } else {
            $("#pre_email_forgot").text("");
        }

        if (user_pass == "") {
            $("#pre_pass_activ").text("Ячейка пуста");
            hasError = true;
        } else if (!/.{8,15}/.test(user_pass)) {
            user_pass_activ_object.val("");
            $("#pre_pass_activ").text("От 8 до 15 символов");
            hasError = true;
        } else {
            $("#pre_pass_activ").text("");
        }

        if (!hasError) {
            $.ajax({
                type: 'POST',
                url: '/activation',
                data: {email: user_email, pass: user_pass},
                success: function (data) {
                    if (data == 'ok') {
                        swal({
                            title: 'Проверьте почту!',
                            type: 'success',
                            showConfirmButton: false,
                            timer: 2000
                        });
                        setTimeout("document.location.href='http://localhost:8080/'", 2000);
                    } else if (data == 'failed') {
                        swal({
                            title: 'Неверный email или пароль!',
                            type: 'error',
                            showConfirmButton: false,
                            timer: 2000
                        });
                    }
                },
                error: function () {
                    error();
                }
            });
        }
    });

    var last_focused_element_count;

    $('.js_changeCount').focus(function () {
        var $this = $(this);
        last_focused_element_count = $this.val();
    });

//изменение кол-ва товара в корзине через инпут поле
    $(document).on('blur', '.js_changeCount', function () {
        event.preventDefault();
        var $this = $(this);
        var cart_to_change = $this.data('cart_to_change');
        var cart_object = $("#count_value" + cart_to_change);
        var change_count = cart_object.val();
        var price = $this.data('price');
        if (change_count >= 0) {
            $.ajax({
                type: 'POST',
                url: '/cart/change',
                data: {cartId: cart_to_change, count: change_count},
                success: function (data) {
                    var sum_object = $("#sum");
                    var count_object = $("#count");
                    var sum = sum_object.text();
                    var countField = count_object.text();
                    if (data == 'ok') {
                        cart_object.val(change_count);
                        var difference_between_counts = change_count - last_focused_element_count;
                        sum_object.text(parseInt(sum) + (price * difference_between_counts));
                        count_object.text(parseInt(countField) + difference_between_counts)
                    } else {
                        cart_object.hide();
                        sum_object.text(parseInt(sum) - (price * last_focused_element_count));
                        var new_count = parseInt(countField) - last_focused_element_count;
                        count_object.text(new_count);
                        //$this.data("count", 1);
                    }
                    if (new_count == 0) {
                        $("#cart_order").hide();
                        $("#cart_none").text("но сейчас она пуста :(");
                    }

                },
                error: function () {
                    error();
                }
            });
        } else {
            cart_object.val(last_focused_element_count)
        }
    });

//через стрелку вперед
    $(document).on('click', '.js_changeCountForward', function () {
        event.preventDefault();
        var $this = $(this);
        var cart_to_change = $this.data('cart_to_change');
        var count = $("#count_value" + cart_to_change).val();
        var price = $this.data('price');
        $.ajax({
            type: 'POST',
            url: '/cart/change',
            data: {cartId: cart_to_change, count: Number(count) + 1},
            success: function (data) {
                $("#count_value" + cart_to_change).val(Number(count) + 1);
                var sum_object = $("#sum");
                var count_object = $("#count");
                var sum = sum_object.text();
                var countField = count_object.text();
                sum_object.text(parseInt(sum) + price);
                count_object.text(parseInt(countField) + 1)
            },
            error: function () {
                error();
            }
        });
    });

//через стрелку назад
    $(document).on('click', '.js_changeCountBack', function () {
        event.preventDefault();
        var $this = $(this);
        var cart_to_change = $this.data('cart_to_change');
        var count = $("#count_value" + cart_to_change).val();
        var price = $this.data('price');
        $.ajax({
            type: 'POST',
            url: '/cart/change',
            data: {cartId: cart_to_change, count: Number(count) - 1},
            success: function (data) {
                $("#count_value" + cart_to_change).val(Number(count) - 1);
                if (count == 1) {
                    $(".cart" + cart_to_change).hide();
                }
                var sum_object = $("#sum");
                var count_object = $("#count");

                var sum = sum_object.text();
                var countField = count_object.text();
                sum_object.text(parseInt(sum) - price);
                var new_count = parseInt(countField) - 1;
                count_object.text(new_count);
                if (new_count == 0) {
                    $("#cart_order").hide();
                    $("#cart_none").text("но сейчас она пуста :(");
                }
            },
            error: function () {
                error();
            }
        });
    });

//заказ
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
                    error();
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
});






