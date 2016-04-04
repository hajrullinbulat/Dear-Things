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



