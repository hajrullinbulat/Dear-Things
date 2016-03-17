<#include "../templates/baseTemplate.ftl">
<@baseTemplate title="Корзина - DearThings"/>
<#macro m_body>

<div class="container things">
    <div class="row">
        <div class="container">
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
                            <div class="cart_product_cost">${cart.goods.price} $</div>
                            <div class="cart_product_company">${cart.goods.company}</div>
                        </div>
                        <p><a class="cart_btn_del hvr-buzz-out js_deleteFromCart" data-cart="${cart.id}">
                            Удалить из корзины</a>
                        </p>
                        <div class="cart_product_description">
                        ${cart.goods.description}
                        </div>
                    </div>
                </div>
            </#list>


            <div class="order btn_buy hvr-fade">
                Оформить заказ
            </div>

        </div>
    </div>
</div>


</#macro>