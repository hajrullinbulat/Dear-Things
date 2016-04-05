<#include "../templates/baseTemplate.ftl">
<@baseTemplate title="Каталог - DearThings"/>
<#macro m_body>

<div class="navbar navbar-inverse navbar-static-top searchfield">
    <div class="container margin-top">
        <form class="mid">
            Покажите мне
            <div class="dropdown">
                <div type="button" id="dropdownMenu1" data-toggle="dropdown"
                     aria-haspopup="true" aria-expanded="true">
                ${(filter.category.name)!"Все категории"}
                </div>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                <#--<#list categories as category>-->
                    <li><a href="/catalog?category=1">Все категории</a></li>
                    <li><a href="/catalog?category=2">Новый год </a></li>
                    <li><a href="/catalog?category=3">Подарки</a></li>
                    <li><a href="/catalog?category=4">Для детей</a></li>
                    <li><a href="/catalog?category=5">Для дома</a></li>
                    <li><a href="/catalog?category=6">Офис</a></li>
                    <li><a href="/catalog?category=7">Гаджеты</a></li>
                    <li><a href="/catalog?category=8">Лайфстайл</a></li>
                    <li><a href="/catalog?category=11">Украшения</a></li>
                <#--</#list>-->
                </ul>
            </div>
            стоимостью
            <div class="dropdown">
                <div type="button" id="dropdownMenu2" data-toggle="dropdown"
                     aria-haspopup="true" aria-expanded="true">
                    <#if !(filter.priceBegin)??>
                        <#if !(filter.priceEnd)??>
                            Любая
                        </#if>
                    <#elseif filter.priceBegin = 0 && filter.priceEnd = 0>
                        Любая
                    <#elseif filter.priceBegin != 5000>
                    ${filter.priceBegin} - ${filter.priceEnd} ₽
                    <#elseif filter.priceBegin == 5000>
                    ${filter.priceBegin}+ ₽
                    <#else >
                        Любая
                    </#if>

                </div>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
                    <li><a href="/catalog?price_begin=0&price_end=0">Любая</a></li>
                    <li><a href="/catalog?price_begin=0&price_end=500">0 - 500 ₽</a></li>
                    <li><a href="/catalog?price_begin=500&price_end=1000">500 - 1000 ₽</a></li>
                    <li><a href="/catalog?price_begin=1000&price_end=2000">1000 - 2000 ₽</a></li>
                    <li><a href="/catalog?price_begin=2000&price_end=5000">2000 - 5000 ₽</a></li>
                    <li><a href="/catalog?price_begin=5000&price_end=5001">5000+ ₽</a></li>
                </ul>
            </div>
            . Cортировать от
            <div class="dropdown">
                <div type="button" id="dropdownMenu3" data-toggle="dropdown"
                     aria-haspopup="true" aria-expanded="true">
                    <#if !(filter.sort)??>
                        ?
                    <#elseif (filter.sort) == 'min'>
                        Минимальной цены
                    <#elseif (filter.sort) == 'max'>
                        Максимальной цены
                    <#else>
                        ?
                    </#if>
                </div>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu3">
                    <li><a href="/catalog?sort=?">?</a></li>
                    <li><a href="/catalog?sort=min">Минимальной цены</a></li>
                    <li><a href="/catalog?sort=max">Максиальной цены</a></li>
                </ul>
            </div>
            .
        </form>
    </div>
</div>

<div>
    <div class="container">
        <div class="col-lg-6 headerthings">${(filter.category.name)!"Все категории"}</div>
    </div>
</div>


<div class="container things">
    <div class="row">
        <#include "../parts/item.ftl">
        <#list goods as good>
        <@item good=good />
    </#list>
    </div>
</div>

</#macro>