<#macro item good>
<a href="/item/${good.id}">
    <div class="col-lg-3 hvr-grow">
        <div class="thumbnail">
            <img src="${good.image}_320x320.jpg">
            <div class="caption">
                <p>${good.name}</p>
                <div>
                    <div class="company">
                    ${good.company}
                    </div>
                    <button type="submit" class="btn btn-default js_addToCart float_right" data-id="${good.id}"
                            name="addToTrash"> ${good.price} ₽
                    </button>
                </div>
            </div>
        </div>
    </div>
</a>
</#macro>