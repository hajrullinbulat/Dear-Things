<#include "../templates/baseTemplate.ftl">
<@baseTemplate title="Оформление заказа - DearThings"/>
<#macro m_body>

    <#include "../parts/userNavbar.ftl">

<div class="authWrapper"><h1 class="title-h1 centered">Итого 11 товаров на сумму 12022 Р</h1>
    <div class="form">
        <div id="pre_name" class="reg_error_info"></div>
        <fieldset class="form__group">
            <label class="form__label form__label__add">Имя и фамилия</label>
            <input class="form__field" size="30" type="text" id="user_name" value="Булат Хайруллин">
        </fieldset>
        <div id="pre_email" class="reg_error_info"></div>
        <fieldset class="form__group">
            <label class="form__label form__label__add">E-mail</label>
            <input class="form__field" size="30" type="email" id="user_email" value="hajrullinbulat@gmail.com">
        </fieldset>
    </div>

    <div class="order_block">
        <div class="form__order">
            Контактный телефон:
            <div class="dropdown">
                <div type="button" id="dropdownMenu1" data-toggle="dropdown"
                     aria-haspopup="true" aria-expanded="true">
                    ?
                </div>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <li><a href="#">89178870436</a></li>
                    <li><a href="#">89178870437</a></li>
                    <li><a href="#">89178870438</a></li>
                </ul>
            </div>
        </div>
        <br>
        <div class="form__order">
            Адрес доставки:
            <div class="dropdown">
                <div type="button" id="dropdownMenu1" data-toggle="dropdown"
                     aria-haspopup="true" aria-expanded="true">
                    ?
                </div>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <li><a href="#">ФЫ фывфыв фыв фыв фывфыв фвф ывфв</a></li>
                    <li><a href="#">фыв фывфыв фыфывыыы ывфыв ыфв фыв фывфыв фвфы вфы в</a></li>
                    <li><a href="#">фывфывфывфы</a></li>
                </ul>
            </div>
        </div>
        <br>
        <div class="form__order">
            Способ доставки:
            <div class="dropdown">
                <div type="button" id="dropdownMenu1" data-toggle="dropdown"
                     aria-haspopup="true" aria-expanded="true">
                    ?
                </div>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <li><a href="#">Самовывоз</a></li>
                    <li><a href="#">Курьер</a></li>
                    <li><a href="#">Почта</a></li>
                </ul>
            </div>
        </div>
        <br>
        <div class="form__order">
            Способ оплаты:
            <div class="dropdown">
                <div class="test" type="button" id="dropdownMenu1" data-toggle="dropdown"
                     aria-haspopup="true" aria-expanded="true">
                    ?
                </div>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <li><a href="#">При получении</a></li>
                    <li><a href="#">Предоплата</a></li>
                </ul>
            </div>
        </div>
        <div class="order btn_buy hvr-fade">
            Принять!
        </div>
    </div>
</div>


</#macro>