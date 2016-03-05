$(document).on('click', '.js_addToCart', function () {
    event.preventDefault();
    var $this = $(this);
    $.ajax({
        type: 'POST',
        url: '/cart/add',
        data: {goodId: $this.data('id')},
        success: function (data) {
            if (data == 'ok') {
                alert("Добавлено");
            }
        },
        error: function () {
            alert('Приносим извинения.<br/>На сервере произошла ошибка');
        }
    });
});