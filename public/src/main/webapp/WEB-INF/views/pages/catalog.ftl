<#include "../templates/catalogTemplate.ftl">
<@catalogTemplate />
<#macro m_body>

<div class="navbar navbar-inverse navbar-static-top searchfield">
    <div class="container margin-top">
        <div class="mid">
            Покажите мне
            <div class="dropdown">
                <div class="" type="button" id="dropdownMenu1" data-toggle="dropdown"
                     aria-haspopup="true" aria-expanded="true">
                ${(cat.name)!"Все категории"}
                </div>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <li><a href="#">Все категории</a></li>
                    <li><a href="#">Новый год!</a></li>
                    <li><a href="#">Подарки</a></li>
                    <li><a href="#">Для детей</a></li>
                    <li><a href="#">Для дома</a></li>
                    <li><a href="#">Офис</a></li>
                    <li><a href="#">Гаджеты</a></li>
                    <li><a href="#">Лайфстайл</a></li>
                    <li><a href="#">Обед с собой</a></li>
                </ul>
            </div>
            стоимостью
            <div class="dropdown">
                <div class="" type="button" id="dropdownMenu2" data-toggle="dropdown"
                     aria-haspopup="true" aria-expanded="true">
                ${(price)!"Любая"}
                </div>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
                    <li><a href="#">Любая</a></li>
                    <li><a href="#">0 - 500 ₽</a></li>
                    <li><a href="#">500 - 1000 ₽</a></li>
                    <li><a href="#">1000 - 2000 ₽</a></li>
                    <li><a href="#">2000 - 5000 ₽</a></li>
                    <li><a href="#">5000+ ₽</a></li>
                </ul>
            </div>
            . Cортировать от
            <div class="dropdown">
                <div class="" type="button" id="dropdownMenu3" data-toggle="dropdown"
                     aria-haspopup="true" aria-expanded="true">
                ${(order)!"?"}
                </div>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu3">
                    <li><a href="#">?</a></li>
                    <li><a href="#">Минимальной цены</a></li>
                    <li><a href="#">Максиальной цены</a></li>
                </ul>
            </div>
            .
        </div>
    </div>
</div>

<div>
    <div class="container">
        <div class="col-lg-6 headerthings">${(cat.name)!"Все категории"}</div>
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

<div class="navbar">
    <div class="pagination">
        <div class="l-center pagination__nav">
            <ul class="nav navbar-nav">
                <li>1</li>
                <li>2</li>
                <li>3</li>
                <li>...</li>
                <li>9</li>
            </ul>
        </div>
    </div>
</div>



</#macro>