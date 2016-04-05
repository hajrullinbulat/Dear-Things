<#include "../templates/baseTemplate.ftl">
<@baseTemplate title="Личный кабинет - DearThings"/>
<#macro m_body>

    <#include "../parts/userNavbar.ftl">

<div class="container things">
    <div class="row">
        <div class="container">
            <#list orders as order>
                <div id="order${order.id}">
                    <h1 align="center">Ваш заказ № ${order.id}</h1>
                    <div class="container cart_product order_details">
                        <div class="col-lg-4 border_details">
                            <div class="order_detail">Дата заказа: ${order.create_time}</div>
                            <div class="order_detail">Адрес доставки: ${order.addresses.addresses}</div>
                            <div class="order_detail">Контактный телефон: ${order.telephones.telephones }</div>
                            <div class="order_detail">Способ доставки: ${order.delivery_type}</div>
                            <div class="order_detail">Способо оплаты: ${order.pay_type}</div>
                            <div class="order_detail">Итого ${order.total_sum} ₽</div>
                        </div>
                        <div class="col-lg-7">
                            <#list order.orderGoods as good>
                                <div class="order_details_right">
                                    <img class="order_image" src="${good.goods.image}_320x320.jpg">
                                    <div class="order_detail">${good.goods.name}</div>
                                    <div class="order_detail">${good.goods.price} ₽ x ${good.count}</div>
                                </div>
                            </#list>
                        </div>
                        <a class="order btn_cancel js_order_cancel" data-order="${order.id}">
                            Отменить заказ
                        </a>
                    </div>
                </div>
            </#list>
        </div>
    </div>
</div>
</#macro>