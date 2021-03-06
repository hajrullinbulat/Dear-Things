<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<#include "../templates/baseTemplate.ftl">
<@baseTemplate title="Корзина - DearThings"/>
<#macro m_body>

    <@sec.authorize access="isAuthenticated()">
        <#include "../parts/userNavbar.ftl">
    </@sec.authorize>

<div class="container things">
    <div class="row">
        <div class="container">
            <h1 class="cart_title" align="center">А это Ваша корзина</h1>
            <#if cart?has_content>
                <#list cart as cart>
                    <div class="container cart_product cart${cart.id}">
                        <div class="col-lg-3">
                            <div class="cart_product_image">
                                <img src="${cart.goods.image}_320x320.jpg">
                            </div>
                        </div>
                        <div class="col-lg-9">
                            <h1>${cart.goods.name}</h1>
                            <div class="cart_product_info">
                                <div class="cart_product_cost">${cart.goods.price} ₽</div>
                                <div class="cart_product_company">${cart.goods.company}</div>
                            </div>
                            <p class="count_change"> В количестве:
                                <i class="hvr-icon-back count_change_arrows js_changeCountBack"
                                   data-cart_to_change="${cart.id}"
                                   data-price="${cart.goods.price}"></i>
                                <input type="text" size="3" value="${cart.count}"
                                       class="js_changeCount"
                                       id="count_value${cart.id}"
                                       data-cart_to_change="${cart.id}"
                                       data-price="${cart.goods.price}">
                                <i class="hvr-icon-forward count_change_arrows js_changeCountForward"
                                   data-cart_to_change="${cart.id}"
                                   data-price="${cart.goods.price}"></i>
                            </p>

                            <p><a class="cart_btn_del hvr-buzz-out js_deleteFromCart"
                                  data-cart="${cart.id}"
                                  data-price="${cart.goods.price}">
                                Удалить из корзины</a>
                            </p>
                            <div class="cart_product_description">
                            ${cart.goods.description}
                            </div>
                        </div>
                    </div>
                </#list>
                <a href="/order" class="order btn_buy hvr-fade" id="cart_order">
                    Оформить заказ
                </a>
            <#elseif cookiecart?has_content>
                <#list cookiecart as goods>
                    <form action="/cart/deletefromcook?id=${goods.id}" method="post">
                        <div class="container cart_product cart${goods.id}">
                            <div class="col-lg-3">
                                <div class="cart_product_image">
                                    <img src="${goods.image}_320x320.jpg">
                                </div>
                            </div>
                            <div class="col-lg-9">
                                <h1>${goods.name}</h1>
                                <div class="cart_product_info">
                                    <div class="cart_product_cost">${goods.price} ₽</div>
                                    <div class="cart_product_company">${goods.company}</div>
                                </div>
                                <br>
                                <p>
                                    <input type="submit" class="cart_btn_del hvr-buzz-out" value="Удалить из корзины">
                                </p>
                                <div class="cart_product_description">
                                ${goods.description}
                                </div>
                            </div>
                        </div>
                    </form>
                </#list>
                <a class="order btn_buy hvr-fade" data-toggle="modal" data-target="#modal-1">
                    Оформить заказ
                </a>
            <#else>
                <h1 class="cart_title" align="center">но сейчас она пуста :(</h1>
            </#if>
            <h1 class="cart_title" align="center" id="cart_none"></h1>
        </div>
    </div>
</div>

</#macro>