<#include "../templates/baseTemplate.ftl">
<@baseTemplate title="Коллекции - DearThings"/>
<#macro m_body>



<div class="category">
    <div class="l-center">
        <div class="title-h1">Коллекции</div>
        <div class="counter">${collections?size}</div>

        <ul class="categoriesList">
            <#list collections as c>
                <li class="categoryItem">
                    <div class="categoryItem__header">
                        <h2 class="categoryItem__title">
                            <a href="/catalog?category=${c.id}">${c.name}</a>
                        </h2>
                        <span class="counter">${c.goods?size}</span>
                        <span class="categoryItem__username">@Bulka</span>
                    </div>

                    <ul class="goodsList-mini">
                        <#list c.goods as good>
                            <#if 4 < good?index>
                                <#break>
                            </#if>
                            <li class="hvr-grow">
                                <a href="/item/${good.id}"><img src="${good.image}_320x320.jpg"></a></li>
                        </#list>
                    </ul>

                </li>
            </#list>

        </ul>
    </div>
</div>



</#macro>