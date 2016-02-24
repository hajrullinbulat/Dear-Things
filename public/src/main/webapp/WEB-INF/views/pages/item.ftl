<#include "../templates/itemTemplate.ftl">
<@itemTemplate />
<#macro m_body>
<div class="container">
    <ul class="breadcrumbs">
        <li><a href="#">Все категории</a></li>
        <li><a href="#">Для дома</a></li>
    </ul>
    <form action="post">
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
                <p><a href="#" class="btn_buy hvr-fade">
                    Добавить в корзину</a>
                </p>
                <div class="product_description">
                    ${item.description}
                </div>
            </div>
        </div>
    </form>
</div>

<div class="products_same">

    <h1 align="center">Похожие товары</h1>

    <#--<div class="container things">-->
        <#--<div class="row">-->
            <#--<div class="col-lg-3 hvr-grow ">-->
                <#--<div class="thumbnail">-->
                    <#--<img src="${good.image}_320x320.jpg">-->
                    <#--<div class="caption">-->
                        <#--<p>${good.name}</p>-->
                        <#--<div class="float_right">-->
                            <#--<input type="submit" class="btn btn-default" value=" ${good.price} P " name="addToTrash">-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
            <#---->
        <#--</div>-->
    <#--</div>-->
</div>
</#macro>