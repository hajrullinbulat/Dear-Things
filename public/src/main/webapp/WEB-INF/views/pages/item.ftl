<#include "../templates/baseTemplate.ftl">
<@baseTemplate title="${item.name}"/>
<#macro m_body>
<div class="container">
    <ul class="breadcrumbs">
        <#list category as c>
            <li><a href="#">${c.name}</a></li>
        </#list>
    </ul>
    <div class="container product">
        <div class="col-lg-6">
            <div class="product_image">
                <img src="${item.image}.jpg">
            </div>
        </div>
        <div class="col-lg-6">
            <h1>${item.name}</h1>

            <div class="product_info">
                <div class="product_cost">${item.price} Р</div>
                <div class="product_company"><a href="#">${item.company}</a></div>
            </div>
            <p><a href="#" class="btn_buy hvr-fade js_addToCart" data-id="${item.id}">
                Добавить в корзину</a>
            </p>
            <div class="product_description">
            ${item.description}
            </div>
        </div>
    </div>
</div>

<div class="products_same">

    <h1 align="center">Похожие товары</h1>

    <div class="container things">
        <div class="row">

            <#include "../parts/item.ftl">
            <#list like as like>
            <@item good=like />
        </#list>

        </div>
    </div>
</div>
</#macro>