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
    var user_name = $("#user_name").val();
    var user_email = $("#user_email").val();
    var user_pass = $("#user_pass").val();
    var user_pass_again = $("#user_pass_again").val();
    $.ajax({
        type: 'POST',
        url: '/signup',
        data: {userName: user_name, userEmail: user_email, userPass: user_pass, userPassAgain: user_pass_again},
        success: function (data) {
            if (data == 'ok') {
                alert("ВСЕ ЗАЕБИСЬ");
            } else {
                if (data.indexOf('user_name null') + 1) {
                    ${"#pre_name"}.text("Ячейка пуста");
                }

            }
        },
        error: function () {
            alert('Приносим извинения.<br/>На сервере произошла ошибка');
        }
    });
});

