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