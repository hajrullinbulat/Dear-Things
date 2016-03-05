<#macro item good>
<a href="/item/${good.id}">
    <div class="col-lg-3 hvr-grow">
        <div class="thumbnail">
            <img src="${good.image}_320x320.jpg">
            <div class="caption">
                <p>${good.name}</p>
                <div class="float_right">
                    <input type="submit" class="btn btn-default js_addToCart" data-id="${good.id}"
                           value=" ${good.price} P "
                           name="addToTrash">
                </div>
            </div>
        </div>
    </div>
</a>
</#macro>