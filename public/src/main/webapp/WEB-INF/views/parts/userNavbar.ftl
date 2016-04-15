<div class="navbar navbar-inverse navbar-static-top aboutfield">
    <div class="container margin-top">
        <div class="user_avatar">
        <#if (user.avatar)??>
            <img src="/resources/images/avatars/${user.avatar}">
        <#else>
            <img src="/resources/images/avatars/user.png">
        </#if>
        </div>
        <h1 id="name">${user.name}</h1>
        <a href="/logout"><i class="fa fa-user-times logout hvr-grow-shadow"> Выйти</i></a>
        <a href="/edit"><i class="fa fa-pencil edit hvr-grow-shadow"> Редактировать</i></a>
    <#if !(user.avatar)??>
        <a href="/edit" class="company" id="photo">
            Пожалуйста, поместите свою фотографию в профиль :)
        </a> <br>
    </#if>
        <a href="/edit" class="company">
            Укажите Ваш контактный телефон и адрес доставки,
            <br>
            для оформления заказов
        </a>

        <div class="count_sum">
            Кол-во элементов в корзине:
            <div id="count" class="count"> ${count}</div>
            , на сумму:
            <div id="sum" class="sum"> ${sum}</div>
            ₽
        </div>
    </div>
</div>

