<#include "../templates/catalogTemplate.ftl">
<@catalogTemplate />
<#macro m_body>

<div class="navbar navbar-inverse navbar-static-top searchfield">
    <div class="container margin-top">
        <div class="mid">
            Покажите мне "Для дома" стоимостью 500-1000 .
        </div>
    </div>
</div>

<div>
    <div class="container">
        <div class="col-lg-3 headerthings">Для дома</div>
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