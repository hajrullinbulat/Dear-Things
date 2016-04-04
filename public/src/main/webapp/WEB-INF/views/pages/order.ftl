<#include "../templates/baseTemplate.ftl">
<@baseTemplate title="Оформление заказа - DearThings"/>
<#macro m_body>

    <#include "../parts/userNavbar.ftl">

<div class="authWrapper"><h1 class="title-h1 centered">Итого ${sum!"0"} ₽</h1>
    <div class="form">
        <div id="pre_name" class="reg_error_info"></div>
        <fieldset class="form__group">
            <label class="form__label form__label__add">Имя и фамилия</label>
            <div class="form__field form__field_dis">${user.name}</div>
        </fieldset>
        <div id="pre_email" class="reg_error_info"></div>
        <fieldset class="form__group">
            <label class="form__label form__label__add">E-mail</label>
            <div class="form__field form__field_dis">${user.email}</div>
        </fieldset>
    </div>

    <div class="order_block">
        <div class="form__order">
            Контактный телефон:
            <div class="dropdown">
                <div type="button" id="telephone" data-toggle="dropdown"
                     aria-haspopup="true" aria-expanded="true">?</div>
                <ul class="dropdown-menu" aria-labelledby="telephone">
                    <#if telephones?has_content>
                        <#list telephones as telephone>
                            <li><a onclick="telephone(${telephone.telephones})">${telephone.telephones}</a></li>
                        </#list>
                    <#else>
                        <li><a href="/edit">Добавьте пожалуйста телефон</a></li>
                    </#if>
                </ul>
            </div>
        </div>
        <br>
        <div class="form__order">
            Адрес доставки:
            <div class="dropdown">
                <div type="button" id="address" data-toggle="dropdown"
                     aria-haspopup="true" aria-expanded="true">?</div>
                <ul class="dropdown-menu" aria-labelledby="address">
                    <#if addresses?has_content>
                        <#list addresses as address>
                            <li><a id="to${address.id}"
                                   onclick="address($('#to${address.id}').text())">${address.addresses}</a></li>
                        </#list>
                    <#else>
                        <li><a href="/edit">Добавьте пожалуйста адрес</a></li>
                    </#if>
                </ul>
            </div>
        </div>
        <br>
        <div class="form__order">
            Способ доставки:
            <div class="dropdown">
                <div type="button" id="delivery" data-toggle="dropdown"
                     aria-haspopup="true" aria-expanded="true">?</div>
                <ul class="dropdown-menu" aria-labelledby="delivery">
                    <li><a onclick="delivery('myself')">Самовывоз</a></li>
                    <li><a onclick="delivery('courier')">Курьер</a></li>
                    <li><a onclick="delivery('mail')">Почта</a></li>
                </ul>
            </div>
        </div>
        <br>
        <div class="form__order">
            Способ оплаты:
            <div class="dropdown">
                <div class="test" type="button" id="payment" data-toggle="dropdown"
                     aria-haspopup="true" aria-expanded="true">?</div>
                <ul class="dropdown-menu" aria-labelledby="payment">
                    <li><a onclick="payment('money')">При получении</a></li>
                    <li><a onclick="payment('cash')">Предоплата</a></li>
                </ul>
            </div>
        </div>
        <div class="order btn_buy hvr-fade js_order">
            Принять!
        </div>
    </div>
</div>


</#macro>