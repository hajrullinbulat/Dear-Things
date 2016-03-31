<#include "../templates/baseTemplate.ftl">
<@baseTemplate title="Корзина - DearThings"/>
<#macro m_body>

<div class="container things">
    <div class="row">
        <div class="container">

            <#if cart??>
                <h1 class="cart_title" align="center">А это Ваша корзина</h1>
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
                                <i class="hvr-icon-back count_change_arrows  js_changeCountBack"
                                   data-cart_to_change="${cart.id}"></i>
                                <input type="text" size="3" value="${cart.count}"
                                       class="js_changeCount"
                                       id="count_value${cart.id}"
                                       data-cart_to_change="${cart.id}"
                                       data-count="${cart.count}">
                                <i class="hvr-icon-forward count_change_arrows js_changeCountForward"
                                   data-cart_to_change="${cart.id}"></i>
                            </p>

                            <p><a class="cart_btn_del hvr-buzz-out js_deleteFromCart" data-cart="${cart.id}">
                                Удалить из корзины</a>
                            </p>
                            <div class="cart_product_description">
                            ${cart.goods.description}
                            </div>
                        </div>
                    </div>
                <#else>
                    <h1 class="cart_title" align="center">но сейчас она пуста :(</h1>
                </#list>
                <a href="/order" class="order btn_buy hvr-fade">
                    Оформить заказ
                </a>
            <#elseif cookiecart??>
                <#list cookiecart as goods>
                    <form action="/cart/deletefromcook?index=${goods?counter}" method="post">
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
                <#else>
                    <h1 class="cart_title" align="center">но сейчас она пуста :(</h1>
                </#list>
                <a href="/order" class="order btn_buy hvr-fade">
                    Оформить заказ
                </a>
            </#if>

        </div>
    </div>
</div>


</#macro>