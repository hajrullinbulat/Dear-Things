<#macro item good>
<a href="/item/${good.id}">
    <div class="col-lg-3 hvr-grow">
        <div class="thumbnail">
            <img src="${good.image}_320x320.jpg">
            <div class="caption">
                <p>${good.name}</p>
                <div>
                    <div class="company js_addToCart" data-id="${good.id}" name="addToTrash">
                        В корзину
                    </div>
                    <div class="price float_right">
                    ${good.price} ₽
                    </div>
                </div>
            </div>
        </div>
    </div>
</a>
</#macro>